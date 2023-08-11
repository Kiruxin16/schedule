package threeoceans.fitness.ru.schedule.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import threeoceans.fitness.ru.schedule.dto.*;
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
    public List<Long> findAllEventsForClient(@RequestHeader(name = "login")String login){
        return clubEventService.makeAnWeekScheduleForClient(login);
    }

    @GetMapping("/halls")
    public List<HallMenuResponse> getAllHalls(){
        return clubEventService.getAllHalls();
    }

    @GetMapping("/test")
    public DisciplineResponse getResp(@RequestParam(name = "discId")String discId){
        return clubEventService.getDiscipline(discId);
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


    @GetMapping("/{id}/info")
    public EventInfoResponse getEventInfo(@PathVariable(name ="id")Long eventId){
        return clubEventService.getEventInfo(eventId);

    }


    @PostMapping("/subscribe/{id}")
    public ResponseEntity<?> subscribeAtEvent(@RequestHeader(name="login")String login, @PathVariable(name="id")Long eventID){

        return clubEventService.subscribeClient(login,eventID);

    }

    @PostMapping("/unsubscribe/{id}")
    public ResponseEntity<?> unsubscribeAtEvent(@RequestHeader(name="login")String login, @PathVariable(name="id")Long eventID){


        return clubEventService.unsubscribeClient(login,eventID);




    }

    @PostMapping("/confirm/{id}")
    public void confirmEvent(@PathVariable(name="id")Long eventID){
        clubEventService.confirmEvent(eventID);


    }
}
