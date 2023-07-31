package threeoceans.fitness.ru.accounts.schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import threeoceans.fitness.ru.accounts.schedule.entities.ClubEvent;

@Repository
public interface ClubEventRepository extends JpaRepository<ClubEvent, Long> {
}
