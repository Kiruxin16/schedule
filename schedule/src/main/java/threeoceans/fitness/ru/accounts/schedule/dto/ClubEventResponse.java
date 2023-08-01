package threeoceans.fitness.ru.accounts.schedule.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClubEventResponse {

    private Long id;

    private String discipline;

    private String coachName;

    private LocalDate eventDate;

    private LocalTime startTime;

    private LocalTime finishTime;

    private String hall;

    private String comments;

}
