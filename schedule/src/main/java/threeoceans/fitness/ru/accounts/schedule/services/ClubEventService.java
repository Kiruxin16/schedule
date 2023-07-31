package threeoceans.fitness.ru.accounts.schedule.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import threeoceans.fitness.ru.accounts.schedule.converters.ClubEventConverter;
import threeoceans.fitness.ru.accounts.schedule.dto.ClubEventResponce;
import threeoceans.fitness.ru.accounts.schedule.repositories.ClubEventRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClubEventService {

    private ClubEventRepository clubEventRepository;
    private ClubEventConverter clubEventConverter;

    public List<ClubEventResponce> findAllEvents(){
        return  clubEventRepository.findAll().stream()
                .map(clubEventConverter::ClubEventToResponce)
                .collect(Collectors.toList());
    }

}
