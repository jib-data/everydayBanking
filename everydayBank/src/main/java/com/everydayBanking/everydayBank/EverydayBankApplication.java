package com.everydayBanking.everydayBank;

import com.everydayBanking.everydayBank.controller.CustomerController;
import com.everydayBanking.everydayBank.model.Account;
import com.everydayBanking.everydayBank.model.Customer;
import com.everydayBanking.everydayBank.model.DashboardObject;
import com.everydayBanking.everydayBank.model.LoginObject;
import com.everydayBanking.everydayBank.service.AccountService;
import com.everydayBanking.everydayBank.service.CustomerService;
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
		Customer newUser = context.getBean(Customer.class);
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

		Customer newUser3 = context.getBean(Customer.class);
		newUser3.setFirstName("preter");
		newUser3.setLastname("parker");
		newUser3.setUsername("spiderman");
		newUser3.setPassword("petpan");
		newUser3.setEmail("spidermyass@gmail.com");
		newUser3.setPhone("6099126364");
		newUser3.setAddress("Kalabule");
		newUser3.setCreation_date(LocalDateTime.now());

//		Customer newUser2 = context.getBean(Customer.class);
//		newUser2.setFirstName("jo");
//		newUser2.setLastname("d");
//		newUser2.setUsername("jibhg");
//		newUser2.setPassword("petpan");
//		newUser2.setEmail("jid@gil.com");
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

		List<Account> accounts = accountService.getCustomerAccountsById(11);
		System.out.println(accounts);

//		System.out.println(cosService.signUp(newUser1));
//		LoginObject loginObject = new LoginObject("kyekyeku", "petpan");
//		System.out.println(cosService.login(loginObject));

	}

}
