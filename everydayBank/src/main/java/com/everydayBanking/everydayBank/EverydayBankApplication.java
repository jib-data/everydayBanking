package com.everydayBanking.everydayBank;

import com.everydayBanking.everydayBank.controller.CustomerController;
import com.everydayBanking.everydayBank.model.Customer;
import com.everydayBanking.everydayBank.model.DashboardObject;
import com.everydayBanking.everydayBank.service.AccountService;
import com.everydayBanking.everydayBank.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EverydayBankApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(EverydayBankApplication.class, args);
		CustomerController customerController = (CustomerController) context.getBean(CustomerController.class);
		CustomerService cosService = (CustomerService) context.getBean(CustomerService.class);
		AccountService accountService = (AccountService) context.getBean(AccountService.class);
		Customer newUser = context.getBean(Customer.class);
		newUser.setFirstName("john");
		newUser.setLastname("doe");
		newUser.setUsername("jib");
		newUser.setPassword("peterpan");
		newUser.setEmail("jid@gmail.com");
		newUser.setPhone("6099126364");
		newUser.setAddress("6099126364");

		Customer newUser1 = context.getBean(Customer.class);
		newUser1.setFirstName("jo");
		newUser1.setLastname("d");
		newUser1.setUsername("jibhg");
		newUser1.setPassword("petpan");
		newUser1.setEmail("jid@gil.com");
		newUser1.setPhone("6099126364");
		newUser1.setAddress("thh dye jte");

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
//		DashboardObject dashboardObject= customerController.signUpCustomer(newUser);
//		System.out.println(dashboardObject);
		System.out.println(cosService.createCustomer(newUser));

	}

}
