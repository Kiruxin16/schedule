package threeoceans.fitness.ru.schedule.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import threeoceans.fitness.ru.schedule.dto.ClubEventResponse;
import threeoceans.fitness.ru.schedule.dto.HallInfoResponse;
import threeoceans.fitness.ru.schedule.dto.HallMenuResponse;
import threeoceans.fitness.ru.schedule.dto.ScheduleFrontResponse;
import threeoceans.fitness.ru.schedule.services.ClubEventService;
import threeoceans.fitness.ru.schedule.services.ParticipantService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class ClubEventController {

    private final ClubEventService clubEventService;

    @GetMapping("/general")
    public ScheduleFrontResponse findAllEvents(){
        return clubEventService.makeAnWeekSchedule();
    }

    @GetMapping("/personal")
    public ScheduleFrontResponse findAllEventsForClient(@RequestHeader(name = "login")String login){
        return clubEventService.makeAnWeekScheduleForClient(login);
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

/*    @GetMapping("from-to")
    public List<ClubEventResponse> getEventsForAWeek(
            @RequestParam(name = "from")LocalDate start,
            @RequestParam(name ="to")LocalDate end
    ){
        return clubEventService.getEventsFromTo(start,end);

    }*/


    @PostMapping("/subscribe/{id}")
    public void subscribeAtEvent(@RequestHeader(name="login")String login,  @PathVariable(name="id")Long eventID){

         clubEventService.subscribeClient(login,eventID);

    }

    @PostMapping("/unsubscribe/{id}")
    public void unsubscribeAtEvent(@RequestHeader(name="login")String login, @PathVariable(name="id")Long eventID){

        try {
            clubEventService.unsubscribeClient(login,eventID);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @PostMapping("/confirm/{id}")
    public void confirmEvent(@PathVariable(name="id")Long eventID){
        clubEventService.confirmEvent(eventID);


    }
}
