package threeoceans.fitness.ru.schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import threeoceans.fitness.ru.schedule.entities.ClubEvent;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClubEventRepository extends JpaRepository<ClubEvent, Long> {

    @Query("select event from ClubEvent event where event.eventDate >= :fromDate and event.eventDate <= :toDate")
    List<ClubEvent> getEventsFromTo(LocalDate fromDate,LocalDate toDate);

    @Query("select event from ClubEvent event " +
            "left join Participant p on p.clubEvent.id= event.id " +
            "where p.login= :login " +
            "and event.eventDate >= :fromDate and event.eventDate <= :toDate")
    List<ClubEvent> getEventsFromToByLogin(String login,LocalDate fromDate,LocalDate toDate);


}
