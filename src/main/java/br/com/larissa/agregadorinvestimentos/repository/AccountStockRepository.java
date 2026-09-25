package br.com.larissa.agregadorinvestimentos.repository;

import br.com.larissa.agregadorinvestimentos.entity.AccountStock;
import br.com.larissa.agregadorinvestimentos.entity.AccountStockId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountStockRepository extends JpaRepository<AccountStock, AccountStockId> {
}
