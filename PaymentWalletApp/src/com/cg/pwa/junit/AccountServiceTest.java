package com.cg.pwa.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.pwa.bean.Account;
import com.cg.pwa.exception.AccountException;
import com.cg.pwa.service.AccountService;

public class AccountServiceTest {

	@Test
	public void testCreateAccountName() {
		AccountService accountService = new AccountService();
		Account acc = new Account("suma", "9740989654", "suma97@gmail.com",
				5000);

		try {
			accountService.createAccount(acc);

		} catch (AccountException e) {

			assertEquals("name should start with capital letter",
					e.getMessage());
		}
	}

	@Test
	public void testCreateAccountPhoneNum() {
		AccountService accountService = new AccountService();
		Account acc = new Account("Suma", "974099654", "suma97@gmail.com", 5000);

		try {
			accountService.createAccount(acc);

		} catch (AccountException e) {
			assertEquals("phone num should contain 10 digits", e.getMessage());

		}
	}

	@Test
	public void testCreateAccountEmail() {
		AccountService accountService = new AccountService();
		Account acc = new Account("Suma", "9740989654", "", 5000);

		try {
			accountService.createAccount(acc);

		} catch (AccountException e) {

			assertEquals("enter valid email id", e.getMessage());
		}
	}

	@Test
	public void testCreateAccountBalance() {
		AccountService accountService = new AccountService();
		Account acc = new Account("Suma", "9740989654", "suma97@gmail.com", 0);

		try {
			accountService.createAccount(acc);

		} catch (AccountException e) {
			assertEquals("minimum balance should be greater than 0",
					e.getMessage());
		}
	}

	@Test
	public void testCreateAccount() {
		AccountService accountService = new AccountService();
		Account acc = new Account("Suma", "9740989654", "suma97@gmail.com",
				50000);

		try {
			accountService.createAccount(acc);

		} catch (AccountException e) {
			assertEquals("The account already exist", e.getMessage());
		}
	}

	// mob num validity
	@Test
	public void testShowBalanceMobNo() {
		AccountService accountService = new AccountService();
		Account acc = new Account();

		acc.setMobileNum("903645302");

		double amt = 0;
		try {
			amt = accountService.showBalance(acc.getMobileNum());
		} catch (AccountException e) {
			assertEquals("phone num should contain 10 digits", e.getMessage());

		}

	}

	@Test
	public void testShowBalanceAccount() {
		AccountService accountService = new AccountService();
		Account acc = new Account();

		acc.setMobileNum("9036452026");

		double amt = 0;
		try {
			amt = accountService.showBalance(acc.getMobileNum());
		} catch (AccountException e) {
			assertEquals("the mobile Number entered is invalid", e.getMessage());

		}

	}

	@Test
	public void testShowBalance() {
		AccountService accountService = new AccountService();
		Account acc = new Account();

		acc.setMobileNum("9036453026");

		double amt = 0;
		try {
			amt = accountService.showBalance(acc.getMobileNum());
			assertEquals(10000, amt, 0.00);

		} catch (AccountException e) {
			System.out.println(e.getMessage());

		}

	}

	@Test
	public void testDepositMobNo() {
		AccountService accountService = new AccountService();
		Account acc = new Account();

		acc.setMobileNum("974059654");
		double amount = 1000;
		double amt = 0;
		try {
			amt = accountService.deposit(acc.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("phone num should contain 10 digits", e.getMessage());

		}

	}

	@Test
	public void testDepositAccount() {
		AccountService accountService = new AccountService();
		Account acc = new Account();

		acc.setMobileNum("9740959654");
		double amount = 1000;
		double bal = 0;
		try {
			bal = accountService.deposit(acc.getMobileNum(), amount);

		} catch (AccountException e) {
			assertEquals("the mobile Number entered is invalid", e.getMessage());

		}

	}

	@Test
	public void testDepositAmount() {
		AccountService accountService = new AccountService();
		Account acc = new Account();

		acc.setMobileNum("9740989654");
		double amount = 0;
		double bal = 0;
		try {
			bal = accountService.deposit(acc.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("amount should be greater than 0", e.getMessage());

		}

	}

	@Test
	public void testDeposit() {
		AccountService accountService = new AccountService();
		Account acc = new Account();

		acc.setMobileNum("9740989654");
		double amount = 8000;
		double bal = 0;
		try {
			bal = accountService.deposit(acc.getMobileNum(), amount);
			assertEquals(13000, bal, 0.0);
		} catch (AccountException e) {
			System.out.println(e.getMessage());

		}

	}

	@Test
	public void testWithdrawMobNo() {
		AccountService accountService = new AccountService();
		Account acc = new Account();

		acc.setMobileNum("805051332");
		double amount = 1000;
		double amt = 0;
		try {
			amt = accountService.withdraw(acc.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("phone num should contain 10 digits", e.getMessage());

		}

	}

	@Test
	public void testWithdrawAccount() {

		AccountService accountService = new AccountService();
		Account acc = new Account();

		acc.setMobileNum("8050512321");
		double amount = 1000;
		double bal = 0;
		try {
			bal = accountService.withdraw(acc.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("the mobile Number entered is invalid", e.getMessage());

		}

	}

	@Test
	public void testWithdrawAmount() {
		AccountService accountService = new AccountService();
		Account acc = new Account();

		acc.setMobileNum("8050513321");
		double amount = 0;
		double bal = 0;
		try {
			bal = accountService.withdraw(acc.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("amount should be greater than 0", e.getMessage());

		}

	}

	@Test
	public void testWithdrawBalance() {
		AccountService accountService = new AccountService();
		Account acc = new Account();

		acc.setMobileNum("8050513321");
		double amount = 50000;
		double bal = 0;
		try {
			bal = accountService.withdraw(acc.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("the amount entered should be less than balance",
					e.getMessage());

		}

	}

	@Test
	public void testWithdraw() {
		AccountService accountService = new AccountService();
		Account acc = new Account();

		acc.setMobileNum("8050513321");
		double amount = 500;
		double bal = 0;
		try {
			bal = accountService.withdraw(acc.getMobileNum(), amount);
			assertEquals(7500, bal, 0.00);

		} catch (AccountException e) {
			System.out.println(e.getMessage());

		}

	}

	@Test
	public void testFundTransferSrcMobNo() {
		AccountService accountService = new AccountService();
		Account acc1 = new Account();
		Account acc2 = new Account();
		acc1.setMobileNum("953559790");
		acc2.setMobileNum("8050020351");
		double amount = 1000;
		double bal = 0;
		try {
			bal = accountService.fundTransfer(acc1.getMobileNum(),
					acc2.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("phone num should contain 10 digits", e.getMessage());

		}

	}

	@Test
	public void testFundTransferDestMobNo() {
		AccountService accountService = new AccountService();
		Account acc1 = new Account();
		Account acc2 = new Account();
		acc1.setMobileNum("9535597905");
		acc2.setMobileNum("805002035");
		double amount = 1000;
		double bal = 0;
		try {
			bal = accountService.fundTransfer(acc1.getMobileNum(),
					acc2.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("phone num should contain 10 digits", e.getMessage());

		}

	}

	@Test
	public void testFundTransferSrcAccount() {
		AccountService accountService = new AccountService();
		Account acc1 = new Account();
		Account acc2 = new Account();
		acc1.setMobileNum("9535596905");
		acc2.setMobileNum("8050020351");
		double amount = 1000;
		double bal = 0;
		try {
			bal = accountService.fundTransfer(acc1.getMobileNum(),
					acc2.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("the source mobile number is invalid", e.getMessage());

		}

	}

	@Test
	public void testFundTransferDestAccount() {
		AccountService accountService = new AccountService();
		Account acc1 = new Account();
		Account acc2 = new Account();
		acc1.setMobileNum("9535597905");
		acc2.setMobileNum("8050010351");
		double amount = 1000;
		double bal = 0;
		try {
			bal = accountService.fundTransfer(acc1.getMobileNum(),
					acc2.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("the destination mobile number is invalid",
					e.getMessage());

		}

	}

	@Test
	public void testFundTransferAmountBalance() {
		AccountService accountService = new AccountService();
		Account acc1 = new Account();
		Account acc2 = new Account();
		acc1.setMobileNum("9535597905");
		acc2.setMobileNum("8050020351");
		double amount = 50000;
		double bal = 0;
		try {
			bal = accountService.fundTransfer(acc1.getMobileNum(),
					acc2.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("the amount entered should be less than balance",
					e.getMessage());

		}

	}

	@Test
	public void testFundTransferAmount() {
		AccountService accountService = new AccountService();
		Account acc1 = new Account();
		Account acc2 = new Account();
		acc1.setMobileNum("9535597905");
		acc2.setMobileNum("8050020351");
		double amount = 0;
		double bal = 0;
		try {
			bal = accountService.fundTransfer(acc1.getMobileNum(),
					acc2.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("amount should be greater than 0", e.getMessage());

		}

	}

	@Test
	public void testFundTransfer() {
		AccountService accountService = new AccountService();
		Account acc1 = new Account();
		Account acc2 = new Account();
		acc1.setMobileNum("9535597905");
		acc2.setMobileNum("8050020351");
		double amount = 5000;
		double bal = 0;
		try {
			bal = accountService.fundTransfer(acc1.getMobileNum(),
					acc2.getMobileNum(), amount);
			assertEquals(8000, bal, 0.00);
		} catch (AccountException e) {
			System.out.println(e.getMessage());

		}

	}

	@Test
	public void testPrintTransactionMobValidate() {
		AccountService accountService = new AccountService();
		Account acc = new Account();

		acc.setMobileNum("805053321");
		try {
			accountService.printTransaction(acc.getMobileNum());

		} catch (AccountException e) {

			assertEquals("phone num should contain 10 digits", e.getMessage());

		}
	}

	@Test
	public void testPrintTransactionAccountValidate() {
		AccountService accountService = new AccountService();
		Account acc = new Account();

		acc.setMobileNum("8050523321");
		try {
			accountService.printTransaction(acc.getMobileNum());

		} catch (AccountException e) {

			assertEquals("the source mobile number 8050523321is invalid",
					e.getMessage());

		}
	}

	@Test
	public void testPrintTransaction() {
		AccountService accountService = new AccountService();
		Account acc = new Account();

		acc.setMobileNum("8050513321");
		try {
			acc = accountService.printTransaction(acc.getMobileNum());
			assertNotNull("", acc);

		} catch (AccountException e) {
			System.out.println(e.getMessage());

		}
	}

	@Test
	public void testPrintTransactionName() {
		AccountService accountService = new AccountService();
		Account acc = new Account();

		acc.setMobileNum("8050513321");
		try {
			acc = accountService.printTransaction(acc.getMobileNum());
			assertSame("Manu", acc.getCustomerName());

		} catch (AccountException e) {
			System.out.println(e.getMessage());

		}
	}

	@Test
	public void testPrintTransactionBalance() {
		AccountService accountService = new AccountService();
		Account acc = new Account();

		acc.setMobileNum("8050513321");
		try {
			acc = accountService.printTransaction(acc.getMobileNum());
			assertEquals(7500, acc.getBalance(), 0.00);

		} catch (AccountException e) {
			System.out.println(e.getMessage());

		}
	}

	@Test
	public void testPrintTransactionEmail() {
		AccountService accountService = new AccountService();
		Account acc = new Account();

		acc.setMobileNum("8050513321");
		try {
			acc = accountService.printTransaction(acc.getMobileNum());
			assertSame("manu97@gmail.com", acc.getEmailId());

		} catch (AccountException e) {
			System.out.println(e.getMessage());

		}
	}

}
