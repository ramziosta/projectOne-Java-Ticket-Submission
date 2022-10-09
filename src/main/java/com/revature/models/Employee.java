package com.revature.models;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isManager;

    // > no args constructor
    public Employee() {
    }

    // > constructor For MANAGER with no id as it's generated from DB
    public Employee(String firstName, String lastName, String email, String password, boolean isManager) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isManager = true;
    }

    // > constructor for EMPLOYEE with no id as it's generated from DB
    public Employee(String firstName, String lastName, String email, String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isManager = false;
    }

    // > All args constructor, HR can issue ID and Manager status
    public Employee(int id, String firstName, String lastName, String email, String password, boolean isManager) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isManager = isManager;
    }

    // ! METHODS

    // < Getter & Setter ID
    public int getId() {
        return id;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    // < Getter & Setter FIRSTNAME
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    // < Getter & Setter LASTNAME
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    // < Getter & Setter EMAIL
    public String getEmail() {
        return email;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    // < Getter & Setter PASSWORD
    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    // < Getter & Setter IS_MANAGER

    public boolean getIsManager() {
        return isManager;
    }

    public void setIsManager(boolean isNewManager) {
        this.isManager = isNewManager;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isManager='" + isManager + '\'' + '}';
    }
}
