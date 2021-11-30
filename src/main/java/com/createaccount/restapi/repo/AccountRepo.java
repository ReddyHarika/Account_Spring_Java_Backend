package com.createaccount.restapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.createaccount.restapi.model.Account;


@Repository
public interface AccountRepo extends JpaRepository<Account, Long>{

}
