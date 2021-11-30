package com.createaccount.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createaccount.restapi.model.Account;
import com.createaccount.restapi.repo.AccountRepo;

@CrossOrigin("*")
@RestController
@RequestMapping("accountapi")
public class AccountRestController {

	@Autowired
	private AccountRepo repo;
	
	@GetMapping("/accounts")
	public List<Account> getAccounts() {
		return repo.findAll();

	}
	@PostMapping("/accounts")
	public Account addAccount(@RequestBody Account acc) {

		Account returnValue  = repo.save(acc);
		return returnValue;
	}
	@GetMapping("/accounts/{id}")
	public Account getAccountById(@PathVariable Long id) {
		return repo.findById(id).get();
	}
	@PutMapping("/accounts")
	public Account updateAccountDetails(@RequestBody Account account) {
		return repo.save(account);
	}
	@DeleteMapping("/accounts/{id}")
	public ResponseEntity<HttpStatus> deleteAccount(@PathVariable Long id) {
		
			repo.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}

}
