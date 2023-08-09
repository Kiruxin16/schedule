package threeoceans.fitness.ru.schedule.configs;


import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;
import threeoceans.fitness.ru.schedule.properties.AccountServiceIntegrationProperties;
import threeoceans.fitness.ru.schedule.properties.SubscriptionServiceIntegrationProperties;


import java.util.concurrent.TimeUnit;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties({AccountServiceIntegrationProperties.class, SubscriptionServiceIntegrationProperties.class})
public class WebServicesConfig {

    private  final AccountServiceIntegrationProperties accountServiceIntegrationProperties;
    private  final SubscriptionServiceIntegrationProperties subscriptionServiceIntegrationProperties;

    @Bean
    public WebClient accountServiceWebClient(){
        TcpClient tcpClient =TcpClient
                .create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, accountServiceIntegrationProperties.getConnectionTimeout())
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(accountServiceIntegrationProperties.getReadTimeout(), TimeUnit.MILLISECONDS));
                    connection.addHandlerLast(new WriteTimeoutHandler(accountServiceIntegrationProperties.getWriteTimeout(), TimeUnit.MILLISECONDS));
                });
        return WebClient
                .builder()
                .baseUrl(accountServiceIntegrationProperties.getUrl())
                .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
                .build();
    }


    @Bean
    public WebClient subscriptionServiceWebClient(){
        TcpClient tcpClient =TcpClient
                .create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, subscriptionServiceIntegrationProperties.getConnectionTimeout())
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(subscriptionServiceIntegrationProperties.getReadTimeout(), TimeUnit.MILLISECONDS));
                    connection.addHandlerLast(new WriteTimeoutHandler(subscriptionServiceIntegrationProperties.getWriteTimeout(), TimeUnit.MILLISECONDS));
                });
        return WebClient
                .builder()
                .baseUrl(subscriptionServiceIntegrationProperties.getUrl())
                .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
                .build();
    }
}
