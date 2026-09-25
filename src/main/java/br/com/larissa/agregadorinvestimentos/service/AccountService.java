package br.com.larissa.agregadorinvestimentos.service;

import br.com.larissa.agregadorinvestimentos.client.BrapiClient;
import br.com.larissa.agregadorinvestimentos.controller.dto.AccountStockResponseDto;
import br.com.larissa.agregadorinvestimentos.controller.dto.AssociateAccountStockDto;
import br.com.larissa.agregadorinvestimentos.entity.AccountStock;
import br.com.larissa.agregadorinvestimentos.entity.AccountStockId;
import br.com.larissa.agregadorinvestimentos.repository.AccountRepository;
import br.com.larissa.agregadorinvestimentos.repository.AccountStockRepository;
import br.com.larissa.agregadorinvestimentos.repository.StockRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    @Value("#{environment.TOKEN}")
    private String TOKEN;

    private AccountRepository accountRepository;

    private StockRepository stockRepository;

    private AccountStockRepository  accountStockRepository;

    private BrapiClient brapiClient;

    public AccountService(AccountRepository accountRepository, StockRepository stockRepository,
                          AccountStockRepository accountStockRepository, BrapiClient brapiClient) {
        this.accountRepository = accountRepository;
        this.stockRepository = stockRepository;
        this.accountStockRepository = accountStockRepository;
        this.brapiClient = brapiClient;
    }

    public void associateStock(String accountId, AssociateAccountStockDto dto) {

        var account = accountRepository.findById(UUID.fromString(accountId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        var stock = stockRepository.findById(dto.stockId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        //DTO -> ENTITY
        var id = new AccountStockId(account.getAccountId(), stock.getStockId());
        var entity = new AccountStock(
                id,
                account,
                stock,
                dto.quantity()
        );

        accountStockRepository.save(entity);
    }

    public List<AccountStockResponseDto> listStocks(String accountId) {

        var account = accountRepository.findById(UUID.fromString(accountId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return account.getAccountStocks()
                .stream()
                .map(as ->
                        new AccountStockResponseDto(
                                as.getStock().getStockId(),
                                as.getQuantity(),
                                getTotal(as.getQuantity(), as.getStock().getStockId())
                        ))
                .toList();
    }

    private double getTotal(Integer quantity, String stockId) {

        var response = brapiClient.getQuote(TOKEN, stockId);

        var price = response.results().getFirst().data().regularMarketPrice();

        return quantity * price;
    }

}
