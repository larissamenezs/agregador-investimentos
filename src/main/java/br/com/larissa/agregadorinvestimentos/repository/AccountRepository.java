package br.com.larissa.agregadorinvestimentos.repository;

import br.com.larissa.agregadorinvestimentos.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
}
