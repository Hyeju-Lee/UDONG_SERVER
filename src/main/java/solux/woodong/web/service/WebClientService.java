package solux.woodong.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;

//@RequiredArgsConstructor
@Service
public class WebClientService {
    private final WebClient webClient;

    public WebClientService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://oauth2.googleapis.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_UTF8_VALUE)
                .build();
    }

    public String getUser(String idToken) {
        String response =
                this.webClient.get().uri(uriBuilder -> uriBuilder.path("/tokeninfo")
                        .queryParam("id_token", idToken).build())
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .acceptCharset(Charset.forName("UTF-8"))
                        .retrieve().bodyToMono(String.class)
                        .block();
        return response;
    }
}
