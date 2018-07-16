package com.cg.pwa.db;

import java.util.HashMap;

import com.cg.pwa.bean.Account;

public class AccountDb {
	private static HashMap<String,Account> accountDb=new HashMap<String, Account>();
	public static HashMap<String, Account> getAccountDb(){
		return accountDb;
	}
	static{
		accountDb.put("9740989654", new Account("Suma","9740989654", "suma97@gmail.com",5000));
		accountDb.put("9036453026", new Account("Sree","9036453026", "sree97@gmail.com",10000));
		accountDb.put("8050513321", new Account("Manu","8050513321", "manu97@gmail.com",8000));
		accountDb.put("9535597905", new Account("Sheela","9535597905", "sheela97@gmail.com",13000));
		accountDb.put("8050020351", new Account("Rohan","8050020351", "rohan97@gmail.com",13000));

	}
}
