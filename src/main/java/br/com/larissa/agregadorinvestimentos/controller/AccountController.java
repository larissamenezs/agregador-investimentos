package br.com.larissa.agregadorinvestimentos.controller;

import br.com.larissa.agregadorinvestimentos.controller.dto.AccountResponseDto;
import br.com.larissa.agregadorinvestimentos.controller.dto.AccountStockResponseDto;
import br.com.larissa.agregadorinvestimentos.controller.dto.AssociateAccountStockDto;
import br.com.larissa.agregadorinvestimentos.controller.dto.CreateAccountDto;
import br.com.larissa.agregadorinvestimentos.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v1/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/{accountId}/stocks")
    public ResponseEntity<Void> associateStock(@PathVariable("accountId") String accountId,
                                               @RequestBody AssociateAccountStockDto dto) {
        accountService.associateStock(accountId, dto);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{accountId}/stocks")
    public ResponseEntity<List<AccountStockResponseDto>> associateStock(@PathVariable("accountId") String accountId) {

        var stocks = accountService.listStocks(accountId);

        return ResponseEntity.ok(stocks);
    }
}
