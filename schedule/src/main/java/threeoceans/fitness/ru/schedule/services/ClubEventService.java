package threeoceans.fitness.ru.schedule.services;

import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import threeoceans.fitness.ru.schedule.converters.ClubEventConverter;
import threeoceans.fitness.ru.schedule.converters.HallConverter;
import threeoceans.fitness.ru.schedule.dto.*;
import threeoceans.fitness.ru.schedule.entities.ClubEvent;
import threeoceans.fitness.ru.schedule.entities.Participant;
import threeoceans.fitness.ru.schedule.errors.AppError;
import threeoceans.fitness.ru.schedule.integrations.AccountServiceIntegration;
import threeoceans.fitness.ru.schedule.repositories.ClubEventRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClubEventService {

    @Value("${strings.daysOfAWeek}")
    private List<String> daysOfAWeek;

    @Value("${strings.schedule}")
    private List<String> scheduleTimer;

    private final ClubEventRepository clubEventRepository;
    private final ClubEventConverter clubEventConverter;
    private final HallService hallService;
    private final HallConverter hallConverter;
    private final AccountServiceIntegration accountService;
    private final ParticipantService participantService;

    public List<ClubEventResponse> findAllEvents(){
        return  clubEventRepository.findAll().stream()
                .map(clubEventConverter::ClubEventToResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ClubEventResponse> findAllEventsInHall(Long id) throws Exception{
        return hallService.findById(id).getEvents().stream().map(clubEventConverter::ClubEventToResponse)
                .collect(Collectors.toList());

    }

    public List<HallMenuResponse> getAllHalls() {
        return hallService.findAll().stream().map(hallConverter::hallToMenuResponse)
                .collect(Collectors.toList());

    }

    public HallInfoResponse getHallInfo(Long hallId) throws Exception  {
        return hallConverter.hallToInfoResponse(hallService.findById(hallId));
    }


    public ResponseEntity<?> subscribeClient(String login, Long eventID) {

        ClubEvent event = clubEventRepository.findById(eventID).get();

        SubScheduleResponse subResponse = accountService
                .subscribeClient(new SubScheduleRequest(login, event.getDiscipline()));

        Participant participant =new Participant();
        participant.setClubEvent(event);
        participant.setLogin(login);
        participant.setName(subResponse.getUserName());
        participant.setSubscriptionID(subResponse.getSubId());

        participantService.save(participant);

        return ResponseEntity.ok("Вы успешно записались на занятие");



    }


    public void confirmEvent(Long eventId){
        List<Participant> participants = getAllParticipantsFromEvent(eventId);
        for (Participant p:participants) {
            accountService.confirmEvent(p.getSubscriptionID());
        }

    }

    @Transactional
    private List<Participant> getAllParticipantsFromEvent(Long eventId){
        return  clubEventRepository.findById(eventId).get().getParticipants();

    }



    public ResponseEntity<?> unsubscribeClient(String login,Long eventId) throws Exception  {
        ClubEvent event = clubEventRepository.findById(eventId).get();
        Participant temp = event.getParticipants().stream().filter(p->p.getLogin().equals(login))
                .findFirst().orElseThrow(Exception::new);
        event.getParticipants().clear();
        accountService.unsubscribeClient(temp.getSubscriptionID());
        participantService.deleteById(temp.getId());

        return ResponseEntity.ok("Вы выписались с занятия.");

    }


    public ScheduleFrontResponse makeAnWeekSchedule(){
        ScheduleFrontResponse scheduleFrontResponse =new ScheduleFrontResponse(hallService.findAll(),daysOfAWeek,scheduleTimer);
        LocalDate curDate = LocalDate.now();
        LocalDate startOfAWeek= curDate.minusDays(curDate.getDayOfWeek().getValue()-1);
        LocalDate endOfAWeek = curDate.plusDays(7-curDate.getDayOfWeek().getValue());

        List<ClubEvent> weekEvents =getEventsFromTo(startOfAWeek,endOfAWeek);
        scheduleFrontResponse.setEvents(sortEventsByDays(weekEvents));
        return scheduleFrontResponse;
    }





    public ScheduleFrontResponse makeAnWeekScheduleForClient(String login) {
        ScheduleFrontResponse scheduleFrontResponse =new ScheduleFrontResponse(hallService.findAll(),daysOfAWeek,scheduleTimer);
        LocalDate curDate = LocalDate.now();
        LocalDate startOfAWeek= curDate.minusDays(curDate.getDayOfWeek().getValue()-1);
        LocalDate endOfAWeek = curDate.plusDays(7-curDate.getDayOfWeek().getValue());
        List<ClubEvent> events = clubEventRepository.getEventsFromToByLogin(login,startOfAWeek,endOfAWeek);
        scheduleFrontResponse.setEvents(sortEventsByDays(events));
        return scheduleFrontResponse;

    }


    private List<ClubEvent> getEventsFromTo(LocalDate start, LocalDate end) {
        return clubEventRepository
                .getEventsFromTo(start,end);

    }

    private List<DayScheduleResponse> sortEventsByDays(List<ClubEvent> events){
        List<DayScheduleResponse> weekSchedule=new ArrayList<>();
        int iterator=1;
        for (String day: daysOfAWeek) {
            DayScheduleResponse dayResponse =new DayScheduleResponse();
            dayResponse.setDayOfWeek(day);
            dayResponse.setEventsOfADay(new ArrayList<>());
            for (ClubEvent ce: events) {
                if(ce.getEventDate().getDayOfWeek().getValue()==iterator){
                    dayResponse.getEventsOfADay().add(clubEventConverter.ClubEventToResponse(ce));
                }
            }
            weekSchedule.add(dayResponse);
            iterator++;
        }
        return weekSchedule;
    }
}
