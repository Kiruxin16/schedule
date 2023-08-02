package threeoceans.fitness.ru.schedule.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import threeoceans.fitness.ru.schedule.entities.Participant;
import threeoceans.fitness.ru.schedule.repositories.ParticipantRepository;

@Service
@RequiredArgsConstructor
public class ParticipantService {

    private final ParticipantRepository participantRepository

    public void save(Participant participant){
        participantRepository.save(participant);

    }

    public  void delete(Participant participant){
        participantRepository.delete(participant);
    }
}
