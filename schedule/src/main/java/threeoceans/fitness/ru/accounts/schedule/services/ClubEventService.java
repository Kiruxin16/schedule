package threeoceans.fitness.ru.accounts.schedule.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import threeoceans.fitness.ru.accounts.schedule.converters.ClubEventConverter;
import threeoceans.fitness.ru.accounts.schedule.converters.HallConverter;
import threeoceans.fitness.ru.accounts.schedule.dto.ClubEventResponse;
import threeoceans.fitness.ru.accounts.schedule.dto.HallInfoResponse;
import threeoceans.fitness.ru.accounts.schedule.dto.HallMenuResponse;
import threeoceans.fitness.ru.accounts.schedule.repositories.ClubEventRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClubEventService {

    private final ClubEventRepository clubEventRepository;
    private final ClubEventConverter clubEventConverter;
    private final HallService hallService;
    private final HallConverter hallConverter;

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
}
