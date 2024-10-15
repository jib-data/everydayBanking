package com.everydayBanking.everydayBank.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Component
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    @JsonIgnore
    private String password;
    @Column(name = "email")
    private String email;
    @JsonIgnore
    @Column(name = "address")
    private String address;
    @JsonIgnore
    @Column(name = "phone_number")
    private String phone;
    private LocalDateTime creation_date;
    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts = new ArrayList<>();

    public Customer() {
    }

    public Customer(String firstName, String lastName, String username, String password, String passwordCopy, String email, String phone, String address, LocalDateTime creation_date, LocalDateTime deletion_date) {
        this.firstName = firstName;
        this.lastname = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.creation_date = creation_date;

    }
    public Customer(String firstName, String lastName, String username, String password, String email, String address, LocalDateTime creation_date, LocalDateTime deletion_date) {
        this.firstName = firstName;
        this.lastname = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.creation_date = creation_date;

    }

    public Customer(int customerId, String firstName, String lastName, String username, String password, String email, String address, LocalDateTime creation_date, LocalDateTime deletion_date) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastname = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.creation_date = creation_date;

    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void addAccounts(Account account){
        account.setCustomer(this);
        this.accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId && Objects.equals(firstName, customer.firstName) && Objects.equals(lastname, customer.lastname) && Objects.equals(username, customer.username) && Objects.equals(password, customer.password) && Objects.equals(email, customer.email) && Objects.equals(address, customer.address) && Objects.equals(creation_date, customer.creation_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, firstName, lastname, username, password, email, address, creation_date);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", creation_date=" + creation_date +
                '}';
    }

}
