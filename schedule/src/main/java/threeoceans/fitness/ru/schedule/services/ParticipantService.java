package threeoceans.fitness.ru.schedule.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import threeoceans.fitness.ru.schedule.entities.Participant;
import threeoceans.fitness.ru.schedule.repositories.ParticipantRepository;
@Slf4j
@Service
@RequiredArgsConstructor
public class ParticipantService {

    private final ParticipantRepository participantRepository;

    public void save(Participant participant){
        participantRepository.save(participant);

    }

    public  void delete(Participant participant){
        participantRepository.delete(participant);
    }


    public void deleteById(Long id){
        log.info("Удаляйся, тварь!");
        participantRepository.deleteById(id);
    }
}
