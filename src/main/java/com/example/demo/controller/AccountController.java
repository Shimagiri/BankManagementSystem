package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService service;
	
	@PostMapping("/create")
	public ResponseEntity<Account> CreateAccount(@RequestBody Account account) {
		Account createAccount =service.createAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
	}
	
	@GetMapping("/create/{accountNumber}")
	public Account getAccountByAccountNumber(@PathVariable Long accountNumber) {
		Account account=service.GetAccountDetailsByAccountNumber(accountNumber);
		return account;
	}
	
	@GetMapping("/create/getallaccount")
	public List<Account> getAllAccountDetails(){
	List<Account> allAccountsDetails=service.getAllAccountDetails();
	return allAccountsDetails;
	}
	
	@PutMapping("/deposit/{accountNumber}/{amount}")
	public Account depositAccount(@PathVariable Long accountNumber, @PathVariable Double amount) {
		Account account=service.depositAmount(accountNumber, amount);
		return account;
	}
	
	@PutMapping("/withdrwa/{accountNumber}/{amount}")
	public Account withdrwaAmount(@PathVariable Long accountNumber,@PathVariable Double amount) {
		
		Account account=service.withdrwaAmount(accountNumber, amount);
		return account;
	}
	
	@DeleteMapping("/delet/{accountNumber}")
	public ResponseEntity<String> closeAccount(@PathVariable Long accountNumber) {
		 service.closeAccount(accountNumber);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Account close");
	}
	
}
