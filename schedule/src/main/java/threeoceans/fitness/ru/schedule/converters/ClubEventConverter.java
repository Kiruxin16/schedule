package threeoceans.fitness.ru.schedule.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import threeoceans.fitness.ru.schedule.dto.ClubEventResponse;
import threeoceans.fitness.ru.schedule.entities.ClubEvent;

@Component
@RequiredArgsConstructor
public class ClubEventConverter {

    public ClubEventResponse ClubEventToResponce(ClubEvent event){
        return ClubEventResponse.builder()
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
