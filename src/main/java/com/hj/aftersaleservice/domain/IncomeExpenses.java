package com.hj.aftersaleservice.domain;

import java.math.BigDecimal;

public class IncomeExpenses {
    private String transactionPerson; //交易方
    private BigDecimal credit; //收入金额
    private BigDecimal debit; //支出金额
    private String transactor; //经办人
    private String transactionDate; //交易日期

    public String getTransactionPerson() {
        return transactionPerson;
    }

    public void setTransactionPerson(String transactionPerson) {
        this.transactionPerson = transactionPerson;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public BigDecimal getDebit() {
        return debit;
    }

    public void setDebit(BigDecimal debit) {
        this.debit = debit;
    }

    public String getTransactor() {
        return transactor;
    }

    public void setTransactor(String transactor) {
        this.transactor = transactor;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
}
