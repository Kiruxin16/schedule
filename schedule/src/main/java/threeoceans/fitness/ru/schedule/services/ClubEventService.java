package threeoceans.fitness.ru.schedule.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import threeoceans.fitness.ru.schedule.converters.ClubEventConverter;
import threeoceans.fitness.ru.schedule.converters.HallConverter;
import threeoceans.fitness.ru.schedule.dto.*;
import threeoceans.fitness.ru.schedule.entities.ClubEvent;
import threeoceans.fitness.ru.schedule.entities.Participant;
import threeoceans.fitness.ru.schedule.integrations.AccountServiceIntegration;
import threeoceans.fitness.ru.schedule.repositories.ClubEventRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClubEventService {

    private final ClubEventRepository clubEventRepository;
    private final ClubEventConverter clubEventConverter;
    private final HallService hallService;
    private final HallConverter hallConverter;
    private final AccountServiceIntegration accountService;
    private final ParticipantService participantService;

    public List<ClubEventResponse> findAllEvents(){
        return  clubEventRepository.findAll().stream()
                .map(clubEventConverter::ClubEventToResponce)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ClubEventResponse> findAllEventsInHall(Long id) throws Exception{
        return hallService.findById(id).getEvents().stream().map(clubEventConverter::ClubEventToResponce)
                .collect(Collectors.toList());

    }

    public List<HallMenuResponse> getAllHalls() {
        return hallService.findAll().stream().map(hallConverter::hallToMenuResponse)
                .collect(Collectors.toList());
    }

    public HallInfoResponse getHallInfo(Long hallId) throws Exception  {
        return hallConverter.hallToInfoResponse(hallService.findById(hallId));
    }


    public void subscribeClient(String login, Long eventID) {

        ClubEvent event = clubEventRepository.findById(eventID).get();

        SubScheduleResponse subResponse = accountService
                .subscribeClient(new SubScheduleRequest(login, event.getDiscipline()));

        Participant participant =new Participant();
        participant.setClubEvent(event);
        participant.setLogin(login);
        participant.setName(subResponse.getUserName());
        participant.setSubscriptionID(subResponse.getSubId());

        participantService.save(participant);



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


    public void unsubscribeClient(String login,Long eventId) throws Exception {

        Participant participant = getParticipantFromEvent(login,eventId);

        accountService.unsubscribeClient(participant.getSubscriptionID());

        participantService.delete(participant);
    }
    @Transactional
    private Participant getParticipantFromEvent(String login,Long eventId) throws Exception{
        ClubEvent event = clubEventRepository.findById(eventId).get();
        return event.getParticipants().stream().filter(p->p.getLogin().equals(login))
                .findFirst().orElseThrow(Exception::new);
    }






}
