package threeoceans.fitness.ru.schedule.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventInfoResponse {

    private HallInfoResponse hall;
    private TrainerResponse trainer;
    private DisciplineResponse discipline;
    private String date;
    private String startTime;
    private String duration;
    private String comment;

}
