package threeoceans.fitness.ru.schedule.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import threeoceans.fitness.ru.schedule.dto.HallInfoResponse;
import threeoceans.fitness.ru.schedule.dto.HallMenuResponse;
import threeoceans.fitness.ru.schedule.entities.Hall;

@Component
@RequiredArgsConstructor
public class HallConverter {

    public HallMenuResponse hallToMenuResponse(Hall hall){
        HallMenuResponse value = new HallMenuResponse();
        value.setId(hall.getId());
        value.setName(hall.getName());
        return value;
    }

    public HallInfoResponse hallToInfoResponse(Hall hall){
        HallInfoResponse value = new HallInfoResponse();
        value.setName(hall.getName());
        value.setAddress(hall.getAddress());
        value.setDescription(hall.getDescription());
        return value;
    }
}
