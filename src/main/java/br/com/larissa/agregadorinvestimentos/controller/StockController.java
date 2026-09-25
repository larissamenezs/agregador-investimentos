package br.com.larissa.agregadorinvestimentos.controller;

import br.com.larissa.agregadorinvestimentos.controller.dto.CreateStockDto;
import br.com.larissa.agregadorinvestimentos.controller.dto.CreateUserDto;
import br.com.larissa.agregadorinvestimentos.entity.User;
import br.com.larissa.agregadorinvestimentos.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/v1/stocks")
public class StockController {

    private StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    public ResponseEntity<Void> createStock(@RequestBody CreateStockDto createStockDto) {

        stockService.createStock(createStockDto);

        return ResponseEntity.ok().build();
    }
}
