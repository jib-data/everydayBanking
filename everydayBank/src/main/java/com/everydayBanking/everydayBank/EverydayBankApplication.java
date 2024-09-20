package com.everydayBanking.everydayBank;

import com.everydayBanking.everydayBank.controller.CustomerController;
import com.everydayBanking.everydayBank.model.Customer;
import com.everydayBanking.everydayBank.model.DashboardObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EverydayBankApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(EverydayBankApplication.class, args);
		CustomerController customerController = (CustomerController) context.getBean(CustomerController.class);
		Customer newUser = context.getBean(Customer.class);
		newUser.setFirstName("john");
		newUser.setLastname("doe");
		newUser.setUsername("jib");
		newUser.setPassword("peterpan");
		newUser.setEmail("jid@gmail.com");
		newUser.setPhone("6099126364");
		newUser.setAddress("6099126364");
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
	}

}
