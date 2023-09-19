package threeoceans.fitness.ru.schedule.integrations;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import threeoceans.fitness.ru.schedule.dto.SubScheduleRequest;
import threeoceans.fitness.ru.schedule.dto.SubScheduleResponse;
import threeoceans.fitness.ru.schedule.errors.ReservationException;
import threeoceans.fitness.ru.schedule.errors.ResourceNotFoundException;


@Component
@RequiredArgsConstructor
public class AccountServiceIntegration {

    private final WebClient accountServiceWebClient;

    public SubScheduleResponse subscribeClient(SubScheduleRequest subRequest){
        return accountServiceWebClient.post()
                .uri("/api/v1/clients/subscriptions/subscribe")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(subRequest)
                .retrieve()
                .onStatus(httpStatusCode -> httpStatusCode.equals(HttpStatus.NOT_FOUND),
                        error -> Mono.error(new ResourceNotFoundException("У пользователя нет подходящего абонемента")))
                .onStatus(httpStatusCode -> httpStatusCode.equals(HttpStatus.BAD_REQUEST),
                        error -> Mono.error(new ReservationException("количество доступных тренировок не может быть меньше количества зарезервированных.")))
                .bodyToMono(SubScheduleResponse.class)
                .block();

    }


    public void unsubscribeClient(Long subId){
         accountServiceWebClient.post()
                .uri("/api/v1/clients/subscriptions/unsubscribe/"+subId)
                .retrieve()
                .toBodilessEntity()
                .block();

    }


    public void confirmEvent(Long subId){
        accountServiceWebClient.post()
                .uri("/api/v1/clients/subscriptions/confirm/"+subId)
                .retrieve()
                .toBodilessEntity()
                .block();

    }


}
