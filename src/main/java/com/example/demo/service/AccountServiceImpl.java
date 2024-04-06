package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountServiceImpl  implements AccountService{

	@Autowired
	AccountRepository repo;
	
	
	@Override
	public Account createAccount(Account account) {
		Account account_save=repo.save(account);
		return account_save;
	}

	@Override
	public Account GetAccountDetailsByAccountNumber(Long accountNumber) {
		Optional<Account> account=repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account not present");
		}
		Account account_found=account.get();
		return account_found;
	} 

	@Override
	public List<Account> getAllAccountDetails() {
		List<Account> lostofAccounts=repo.findAll();
		return lostofAccounts;
	}

	@Override
	public Account depositAmount(Long accountNumber, Double amount) {
		Optional<Account> account=repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not present");
		}
		Account accountpresent=account.get();
		Double totalBalance=accountpresent.getAccount_balance()+amount;
		accountpresent.setAccount_balance(totalBalance);
		repo.save(accountpresent);
		
		return accountpresent;
	}

	@Override
	public Account withdrwaAmount(long accountNumber, Double amount) {
		
		Optional<Account> account =repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new NullPointerException("account is not present");
		}
		Account accountPresent=account.get();
		Double accountBalance=accountPresent.getAccount_balance()-amount;
		accountPresent.setAccount_balance(accountBalance);
		repo.save(accountPresent);
		return accountPresent;
	}

	@Override
	public void closeAccount(Long accountNumber) {
		GetAccountDetailsByAccountNumber(accountNumber);
		repo.deleteById(accountNumber);
		
	}

}
