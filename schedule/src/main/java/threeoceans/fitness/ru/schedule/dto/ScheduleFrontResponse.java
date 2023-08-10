package threeoceans.fitness.ru.schedule.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import threeoceans.fitness.ru.schedule.entities.Hall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
public class ScheduleFrontResponse {

    private HashMap<String,String> halls;


    private List<String> daysOFWeek;

    private List<String> trainingStartTime;

    private List<DayScheduleResponse> events;



    public ScheduleFrontResponse(List<Hall> halls,List<String> daysOfAWeek,List<String> scheduleTimer){
        this.halls=new HashMap<>();
        halls.forEach(h -> this.halls.put(h.getTrigger(), h.getName()));
        this.daysOFWeek=new ArrayList<>(daysOfAWeek);
        this.trainingStartTime=new ArrayList<>(scheduleTimer);
    }

}
