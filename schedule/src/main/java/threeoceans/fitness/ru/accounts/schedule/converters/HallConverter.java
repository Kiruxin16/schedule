package threeoceans.fitness.ru.accounts.schedule.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import threeoceans.fitness.ru.accounts.schedule.dto.HallInfoResponse;
import threeoceans.fitness.ru.accounts.schedule.dto.HallMenuResponse;
import threeoceans.fitness.ru.accounts.schedule.entities.Hall;

@Component
@RequiredArgsConstructor
public class HallConverter {

    public HallMenuResponse hallToMenuResponse(Hall hall){
        HallMenuResponse vallue = new HallMenuResponse();
        vallue.setId(hall.getId());
        vallue.setName(hall.getName());
        return vallue;
    }

    public HallInfoResponse hallToInfoResponse(Hall hall){
        HallInfoResponse value = new HallInfoResponse();
        value.setName(hall.getName());
        value.setAddress(hall.getAddress());
        value.setDescription(hall.getDescription());
        return value;
    }
}
