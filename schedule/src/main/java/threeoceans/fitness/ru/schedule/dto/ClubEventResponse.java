package threeoceans.fitness.ru.schedule.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClubEventResponse {

    private Long id;

    private String discipline;

    private String coachName;

    private String eventDate;

    private String startTime;

    private String duration;


    private String hall;//trigger

    private String comments;

}
