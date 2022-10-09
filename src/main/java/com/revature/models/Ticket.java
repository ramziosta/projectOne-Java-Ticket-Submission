package com.revature.models;

public class Ticket {
    int id;
    double amount;
    String date;
    int employee_id;
    String status;

    // > no args constructor
    public Ticket() {
    }

    // > no args constructor with no id as it is auto generated in DB
    public Ticket(double amount, String date, int employee_id) {

        this.amount = amount;
        this.date = date;
        this.employee_id = employee_id;
    }

    // > all args constructor with id as it is auto generated in DB
    public Ticket(int id, double amount, String date, int employee_id, String status) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.employee_id = employee_id;
        this.status = status;
    }

    // < Getter & Setter ID
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // < Getter & Setter AMOUNT
    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // < Getter & Setter DATE
    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // < Getter & Setter EMPLOYEE_ID
    public int getEmployee_id() {
        return this.employee_id;
    }

    public void setEmployee_id(int newEmployee_id) {
        this.employee_id = newEmployee_id;
    }

    public String toString() {
        return "Ticket{id=" + this.id + ", amount='" + this.amount + '\'' + ", date='" + this.date + '\''
                + ", employee_id=" + this.employee_id + ", status=" + this.status + '}';
    }
}