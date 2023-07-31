package threeoceans.fitness.ru.accounts.schedule.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import threeoceans.fitness.ru.accounts.schedule.dto.ClubEventResponce;
import threeoceans.fitness.ru.accounts.schedule.entities.ClubEvent;

@Component
@RequiredArgsConstructor
public class ClubEventConverter {

    public ClubEventResponce ClubEventToResponce(ClubEvent event){
        return ClubEventResponce.builder()
                .id(event.getId())
                .discipline(event.getDiscipline())
                .coachName(event.getCoachName())
                .eventDate(event.getEventDate())
                .startTime(event.getStartTime())
                .finishTime(event.getFinishTime())
                .hall(event.getHall().getName())
                .comments(event.getComments())
                .build();
    }
}
