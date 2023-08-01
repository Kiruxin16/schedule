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

    @Transactional
    public void subscribeUser(String login, Long eventID) {

        ClubEvent event = clubEventRepository.findById(eventID).get();

        SubScheduleResponse subResponse = accountService
                .subscribeUser(new SubScheduleRequest(login, event.getDiscipline()));

        Participant participant =new Participant();
        participant.setClubEvent(event);
        participant.setLogin(login);
        participant.setName(subResponse.getUserName());
        participant.setSubscriptionID(subResponse.getSubId());

        participantService.save(participant);


    }
}
