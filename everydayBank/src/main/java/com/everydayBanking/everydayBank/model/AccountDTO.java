package com.everydayBanking.everydayBank.model;

public class AccountDTO {
    private int accountId;
    private String accountNumber;
    private Double accountBalance;
    private String accountType;

    public AccountDTO(Account account){
        this.accountId = account.accountId;
        this.accountNumber = account.getAccountNumber();
        this.accountBalance = account.getAccountBalance();
        this.accountType = account.getAccountType();
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "accountId=" + accountId +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountBalance=" + accountBalance +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
