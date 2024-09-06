package com.everydayBanking.everydayBank.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int customer_id;
    String firstName;
    String lastname;
    String username;
    String password;
    String passwordCopy;
    String email;
    String address;
    String phone;
    LocalDateTime creation_date;
    LocalDateTime deletion_date;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String username, String password, String passwordCopy, String email, String phone, String address, LocalDateTime creation_date, LocalDateTime deletion_date) {
        this.firstName = firstName;
        this.lastname = lastName;
        this.username = username;
        this.password = password;
        this.passwordCopy = passwordCopy;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.creation_date = creation_date;
        this.deletion_date = deletion_date;
    }
    public Customer(String firstName, String lastName, String username, String password, String email, String address, LocalDateTime creation_date, LocalDateTime deletion_date) {
        this.firstName = firstName;
        this.lastname = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.creation_date = creation_date;
        this.deletion_date = deletion_date;
    }

    public Customer(int customer_id, String firstName, String lastName, String username, String password, String email, String address, LocalDateTime creation_date, LocalDateTime deletion_date) {
        this.customer_id = customer_id;
        this.firstName = firstName;
        this.lastname = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.creation_date = creation_date;
        this.deletion_date = deletion_date;
    }


    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
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

    public LocalDateTime getDeletion_date() {
        return deletion_date;
    }

    public void setDeletion_date(LocalDateTime deletion_date) {
        this.deletion_date = deletion_date;
    }
    public String getPasswordCopy() {
        return passwordCopy;
    }

    public void setPasswordCopy(String passwordCopy) {
        this.passwordCopy = passwordCopy;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customer_id == customer.customer_id && Objects.equals(firstName, customer.firstName) && Objects.equals(lastname, customer.lastname) && Objects.equals(username, customer.username) && Objects.equals(password, customer.password) && Objects.equals(email, customer.email) && Objects.equals(address, customer.address) && Objects.equals(creation_date, customer.creation_date) && Objects.equals(deletion_date, customer.deletion_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer_id, firstName, lastname, username, password, email, address, creation_date, deletion_date);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", creation_date=" + creation_date +
                ", deletion_date=" + deletion_date +
                '}';
    }


}
