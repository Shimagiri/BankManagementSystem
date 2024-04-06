package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Account {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long account_number;
	private String account_houlder_name;
	private Double account_balance;
	public long getAccount_number() {
		return account_number;
	}
	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}
	public String getAccount_houlder_name() {
		return account_houlder_name;
	}
	public void setAccount_houlder_name(String account_houlder_name) {
		this.account_houlder_name = account_houlder_name;
	}
	public Double getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(Double account_balance) {
		this.account_balance = account_balance;
	}
	public Account(long account_number, String account_houlder_name, Double account_balance) {
		super();
		this.account_number = account_number;
		this.account_houlder_name = account_houlder_name;
		this.account_balance = account_balance;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Account [account_number=" + account_number + ", account_houlder_name=" + account_houlder_name
				+ ", account_balance=" + account_balance + ", getAccount_number()=" + getAccount_number()
				+ ", getAccount_houlder_name()=" + getAccount_houlder_name() + ", getAccount_balance()="
				+ getAccount_balance() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}	
}
