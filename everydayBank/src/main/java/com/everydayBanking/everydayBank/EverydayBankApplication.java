package com.everydayBanking.everydayBank;

import com.everydayBanking.everydayBank.controller.AccountController;
import com.everydayBanking.everydayBank.controller.CustomerController;
import com.everydayBanking.everydayBank.controller.TransactionController;
import com.everydayBanking.everydayBank.model.*;
import com.everydayBanking.everydayBank.service.AccountService;
import com.everydayBanking.everydayBank.service.CustomerService;
import com.everydayBanking.everydayBank.service.TransactionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class EverydayBankApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(EverydayBankApplication.class, args);
		CustomerController customerController = (CustomerController) context.getBean(CustomerController.class);
		CustomerService cosService = (CustomerService) context.getBean(CustomerService.class);
		AccountService accountService = (AccountService) context.getBean(AccountService.class);
		TransactionService tServ = (TransactionService) context.getBean(TransactionService.class);
		Customer newUser = context.getBean(Customer.class);
		LoginObject loginObject = context.getBean(LoginObject.class);
		AccountController accControl = context.getBean(AccountController.class);
		TransactionController transControl = context.getBean(TransactionController.class);
//		newUser.setFirstName("john");
//		newUser.setLastname("doe");
//		newUser.setUsername("bumbum");
//		newUser.setPassword("peterpan");
//		newUser.setEmail("jid@gmail.com");
//		newUser.setPhone("6099126364");
//		newUser.setAddress("chorkor");
//		newUser.setCreation_date(LocalDateTime.now());

//		Customer newUser1 = context.getBean(Customer.class);
//		newUser1.setFirstName("job");
//		newUser1.setLastname("dickson");
//		newUser1.setUsername("kyekyeku");
//		newUser1.setPassword("petpan");
//		newUser1.setEmail("mjid@gil.co");
//		newUser1.setPhone("6099126364");
//		newUser1.setAddress("Kalabule");
//		newUser1.setCreation_date(LocalDateTime.now());

//		Customer newUser3 = context.getBean(Customer.class);
//		newUser3.setFirstName("preter");
//		newUser3.setLastname("parker");
//		newUser3.setUsername("spiderman");
//		newUser3.setPassword("petpan");
//		newUser3.setEmail("spidermyass@gmail.com");
//		newUser3.setPhone("6099126364");
//		newUser3.setAddress("Kalabule");
//		newUser3.setCreation_date(LocalDateTime.now());


//		------------------------------------------------Login Customer----------------------------------------------------------
//		loginObject.setUsername("spiderman");
//		loginObject.setPassword("petpan");
//		DashboardObject dashboardObject = customerController.loginCustomer(loginObject);
//
//		System.out.println(dashboardObject);

//		--------------------------------------------- Creating new account for customer----------------------------------------
//		Account newAccount = accControl.createAccount(9);
//		System.out.println(newAccount);

//--------------------------------------------------------------------------------------------------------------------------------

// -----------------------------------------------------Updating an Account ------------------------------------------------------
//		Account upAccount = accControl.updateAccount(11, "checking");
//		System.out.println(upAccount);
//		--------------------------------------------------------------------------------------------------------------------------

//		------------------------------------------------Delete Account------------------------------------------------------------
//		Account account = accControl.deleteAccount(8);
//		System.out.println(account);
//		--------------------------------------------------------------------------------------------------------------------------
//		--------------------------------------------------- Get All Accounts of a Customer----------------------------------------
//		List<Account> accounts = accControl.getAllAccounts(9);
//		System.out.println(accounts);
//		--------------------------------------------------------------------------------------------------------------------------

//		----------------------------------------------------Transactions----------------------------------------------------------
//		----------------------------------------------------Deposit---------------------------------------------------------------
//		boolean transaction = transControl.depositMoney(7, 7000d);
//		System.out.println(transaction);


//		---------------------------------------------------------------------------------------------------------------------------
//		------------------------------------------------------ Withdrawal----------------------------------------------------------
//		boolean transaction = transControl.withdrawMoney(7, 89d);
//		System.out.println(transaction);

//		---------------------------------------------------------------------------------------------------------------------------
//		--------------------------------------------------------- Transfer Money --------------------------------------------------
//		boolean transaction = transControl.transferMoney(7, 5, 100d);
//		System.out.println(transaction);

//		--------------------------------------------------------GetAllTransactionsById---------------------------------------------
//		List<Transaction> transactions = transControl.allTransactionsGivenAccountId(7);
//		System.out.println(transactions);

//		---------------------------------------------------------------------------------------------------------------------------
//		---------------------------------------------------------DeleteTransactionByID---------------------------------------------
//		transControl.deleteTransactionGivenTransactionId(1);

//		---------------------------------------------------------------------------------------------------------------------------

//		Customer newUser2 = context.getBean(Customer.class);
//		newUser2.setFirstName("jo");
//		newUser2.setLastname("d");
//		newUser2.setUsername("jibhg4");
//		newUser2.setPassword("petpan");
//		newUser2.setEmail("jid4@gil.com");
//		newUser2.setPhone("6099126364");
//		newUser2.setAddress("thh dye jte");
//		newUser2.setCreation_date(LocalDateTime.now());
//{
//    "firstName": "jason",
//    "lastname": " bourne",
//    "userName": "jasonbourne",
//    "password": "peterpan",
//    "email": "jbourn",
//    "phone": "6099126364",
//    "address": "6099126364",
//    "creation_date": "2024-09-13T14:28:15",
//    "deletion_date": "2024-09-13T14:28:15"
//
//}
//		DashboardObject dashboardObject= cosService.signUp(newUser3);
//		System.out.println(dashboardObject);

//		List<Account> accounts = accountService.getCustomerAccountsById(10);
////		System.out.println(accounts);
//		Account account = accountService.getAccountById(4);
//		System.out.println(account);
//		System.out.println(accountService.getAccountById(5));
//		System.out.println(tServ.withdrawMoney(4, 1500.0));
//		System.out.println(tServ.transferMoney(5,4, 200d));
//		System.out.println(accountService.getAccountById(4));
//		System.out.println(accountService.getAccountById(5));
//	     tServ.deleteTransactionByTransactionId(15);


//		System.out.println(cosService.signUp(newUser2));
//		LoginObject loginObject = new LoginObject("kyekyeku", "petpan");
//		System.out.println(cosService.login(loginObject));

	}

}
