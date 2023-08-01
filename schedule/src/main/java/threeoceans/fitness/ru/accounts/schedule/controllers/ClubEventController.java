package threeoceans.fitness.ru.accounts.schedule.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import threeoceans.fitness.ru.accounts.schedule.dto.ClubEventResponse;
import threeoceans.fitness.ru.accounts.schedule.dto.HallInfoResponse;
import threeoceans.fitness.ru.accounts.schedule.dto.HallMenuResponse;
import threeoceans.fitness.ru.accounts.schedule.services.ClubEventService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class ClubEventController {

    private final ClubEventService clubEventService;

    @GetMapping
    public List<ClubEventResponse> findAllEvents(){
        return clubEventService.findAllEvents();
    }

    @GetMapping("/halls")
    public List<HallMenuResponse> getAllHalls(){
        return clubEventService.getAllHalls();
    }


    @GetMapping("/halls/{id}")
    public List<ClubEventResponse> findAllEventsInHall(@PathVariable(name = "id")Long hallId){

        try{
            return clubEventService.findAllEventsInHall(hallId);
        }catch (Exception e){
            return null;
        }

    }

    @GetMapping("/halls/{id}/info")
    public HallInfoResponse getHallInfo(@PathVariable(name="id")Long hallId){

        try {
            return clubEventService.getHallInfo(hallId);
        }catch (Exception e){
            return null;
        }

    }

    @PostMapping("/subscribe/{id}")
    public void subscribeAtEvent(@PathVariable(name="id")Long eventID){

    }

    @PostMapping("/unsubscribe/{id}")
    public void usubscribeAtEvent(@PathVariable(name="id")Long eventID){

    }

    @PostMapping("/confirm/{id}")
    public void confirmEvent(@PathVariable(name="id")Long eventID){

    }
}
