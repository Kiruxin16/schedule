package threeoceans.fitness.ru.schedule.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
public class ScheduleFrontResponse {

    private HashMap<String,String> halls;


    private List<String> daysOFWeek;

    private List<String> trainingStartTime;

    private List<DayScheduleResponse> events;

}
