package threeoceans.fitness.ru.schedule.integrations;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import threeoceans.fitness.ru.schedule.dto.SubScheduleRequest;
import threeoceans.fitness.ru.schedule.dto.SubScheduleResponse;


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
                .uri("/api/v1/clients/accounts/subscriptions/confirm/"+subId)
                .retrieve()
                .toBodilessEntity()
                .block();

    }


}
