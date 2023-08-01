package threeoceans.fitness.ru.schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import threeoceans.fitness.ru.schedule.entities.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant,Long> {
}
