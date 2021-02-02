package net.javaguides.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import net.javaguides.springboot.model.Account;
import net.javaguides.springboot.model.User;

public interface AccountRepository extends CrudRepository<Account, Long> {
	Account findByAccountNumber(int accountNumber);
}
