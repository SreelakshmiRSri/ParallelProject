package com.cg.pwa.dao;

import java.util.HashMap;

import com.cg.pwa.bean.Account;
import com.cg.pwa.db.AccountDb;
import com.cg.pwa.exception.AccountException;

public class AccountDao implements IAccountDao {
	static HashMap<String, Account> accountMap = AccountDb.getAccountDb();

	@Override
	public Account createAccount(Account acc) throws AccountException {
		Account ac=accountMap.get(acc.getMobileNum());
		if(ac!=null){
			throw new AccountException("The account already exist");
		}
		accountMap.put(acc.getMobileNum(), acc);
		return acc;
	}

	@Override
	public double showBalance(String mobNo) throws AccountException {
		Account acc = accountMap.get(mobNo);
		if (acc == null) {
			throw new AccountException("the mobile Number entered is invalid");
		}
		return acc.getBalance();
	}

	@Override
	public double deposit(String mobNo, double amount) throws AccountException {
		Account acc = accountMap.get(mobNo);
		if (acc == null) {
			throw new AccountException("the mobile Number entered is invalid");
		}
		double totalBalance = acc.getBalance() + amount;
		return totalBalance;
	}

	@Override
	public double withdraw(String mobNo, double amount) throws AccountException {
		Account acc = accountMap.get(mobNo);
		if (acc == null) {
			throw new AccountException("the mobile Number entered is invalid");
		}
		if (amount < acc.getBalance()) {
			double remainBalance = acc.getBalance() - amount;
			acc.setBalance(remainBalance);
			return acc.getBalance();
		}
		throw new AccountException(
				"the amount entered should be less than balance");
	}

	@Override
	public double fundTransfer(String srcMobNo, String destMobNo, double amount)
			throws AccountException {
		Account acc1 = accountMap.get(srcMobNo);
		Account acc2 = accountMap.get(destMobNo);
		if (acc1 == null) {
			throw new AccountException("the source mobile number is invalid");
		}
		if (acc2 == null) {
			throw new AccountException(
					"the destination mobile number is invalid");
		}
		/*
		 * if(amount<acc1.getBalance()){ double bal1=acc1.getBalance()-amount;
		 * acc1.setBalance(bal1); double bal2=acc2.getBalance()+amount;
		 * acc2.setBalance(bal2); return acc1.getBalance(); } throw new
		 * AccountException("Amount entered should be less than balance");
		 */

		withdraw(srcMobNo, amount);
		//acc1.setBalance(bal1);
		deposit(destMobNo, amount);
		//acc2.setBalance(bal2);
		return acc1.getBalance();

	}

	@Override
	public Account printTransaction(String mobNo) throws AccountException {
		Account acc=accountMap.get(mobNo);
		if(acc==null){
			throw new AccountException("the source mobile number "+mobNo +"is invalid");

		}
		return acc;
	}

}
