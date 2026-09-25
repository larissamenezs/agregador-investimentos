package br.com.larissa.agregadorinvestimentos.service;

import br.com.larissa.agregadorinvestimentos.controller.dto.CreateStockDto;
import br.com.larissa.agregadorinvestimentos.entity.Stock;
import br.com.larissa.agregadorinvestimentos.repository.StockRepository;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public void createStock(CreateStockDto createStockDto) {

        // DTO -> ENTITY
        var stock = new Stock(
                createStockDto.stockId(),
                createStockDto.description()
        );

        stockRepository.save(stock);
    }
}
