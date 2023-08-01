package threeoceans.fitness.ru.schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import threeoceans.fitness.ru.schedule.entities.Hall;

import java.util.Optional;

@Repository
public interface HallRepository extends JpaRepository<Hall,Long> {

    Optional<Hall> findByName(String name);

}
