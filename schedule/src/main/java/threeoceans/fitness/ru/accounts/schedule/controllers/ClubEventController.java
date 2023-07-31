package threeoceans.fitness.ru.accounts.schedule.controllers;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import threeoceans.fitness.ru.accounts.schedule.dto.ClubEventResponce;
import threeoceans.fitness.ru.accounts.schedule.services.ClubEventService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class ClubEventController {

    private final ClubEventService clubEventService;

    @GetMapping
    public List<ClubEventResponce> findAllEvents(){
        return clubEventService.findAllEvents();
    }
}
