package threeoceans.fitness.ru.schedule.integrations;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import threeoceans.fitness.ru.schedule.dto.DisciplineResponse;
import threeoceans.fitness.ru.schedule.dto.SubScheduleRequest;
import threeoceans.fitness.ru.schedule.dto.SubScheduleResponse;
import threeoceans.fitness.ru.schedule.errors.ReservationException;
import threeoceans.fitness.ru.schedule.errors.ResourceNotFoundException;


@Component
@RequiredArgsConstructor
public class SubscriptionServiceIntegration {

    private final WebClient subscriptionServiceWebClient;

    public DisciplineResponse getDisciplineInfo(String disciplineName){
        return subscriptionServiceWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/v1/subscriptions/discipline")
                        .queryParam("discName",disciplineName)
                        .build())
                .retrieve()
                .bodyToMono(DisciplineResponse.class)
                .block();

    }


}
