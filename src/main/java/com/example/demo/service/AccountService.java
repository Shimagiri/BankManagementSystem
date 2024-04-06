package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Account;

public interface AccountService {

	
	public Account createAccount(Account account);
	
	public Account GetAccountDetailsByAccountNumber(Long accountNumber);
	
	public List<Account> getAllAccountDetails();
	
	public Account depositAmount(Long accountNumber, Double amount);
	
	public Account withdrwaAmount(long accountNumber,Double amount);
	
	public void closeAccount(Long accountNumber);
	
	
}
