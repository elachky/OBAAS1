package net.javaguides.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import net.javaguides.springboot.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
