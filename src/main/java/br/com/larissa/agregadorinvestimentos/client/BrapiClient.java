package br.com.larissa.agregadorinvestimentos.client;

import br.com.larissa.agregadorinvestimentos.client.dto.BrapiResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "BrapiClient",
        url = "https://brapi.dev"
)
public interface BrapiClient {

    @GetMapping("/api/v2/stocks/quote")
    BrapiResponseDto getQuote(
            @RequestParam("token") String token,
            @RequestParam("symbols") String stockId
    );
}