package threeoceans.fitness.ru.schedule.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import threeoceans.fitness.ru.schedule.dto.ClubEventResponse;
import threeoceans.fitness.ru.schedule.entities.ClubEvent;

@Component
@RequiredArgsConstructor
public class ClubEventConverter {

    public ClubEventResponse ClubEventToResponse(ClubEvent event){
        String correctTime=event.getStartTime().toString().startsWith("0")?
                event.getStartTime().toString().substring(1,5): event.getStartTime().toString().substring(0,5);
        return ClubEventResponse.builder()
                .id(event.getId())
                .discipline(event.getDiscipline())
                .coachName(event.getCoachName())
                .eventDate(event.getEventDate().toString())
                .startTime(correctTime)
                .duration(event.getDuration())
                .hall(event.getHall().getTrigger())
                .comments(event.getComments())
                .build();
    }
}
