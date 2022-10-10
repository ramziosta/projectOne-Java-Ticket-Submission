package com.revature.controllers;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import io.javalin.http.Handler;

public class EmployeeController {
    EmployeeService service;

    public EmployeeController() {
        service = new EmployeeService();
    }

    public EmployeeController(EmployeeService emplyeeService) {
        service = emplyeeService;
    }

    // create
    public Handler createNewEmployee = context -> {

        Employee employee = context.bodyAsClass(Employee.class);
        int id = service.create(employee);

        if (id > 0) {
            employee.setId(id);
            context.json(employee).status(200);
        } else {
            context.result("Please choose a different email, or login to your account.").status(400);
        }
    };


    // get all Employees
    public Handler getAllEmployees = context -> {
        context.json(service.getAllEmployees());
    };

    
    // id
    public Handler getEmployeeById = context -> {
        String param = context.pathParam("id");
        try {
            int id = Integer.parseInt(param);
            Employee employee = service.getById(id);

            if (employee != null) {
                context.json(employee).status(200);
            } else {
                context.result("Employee not found").status(400);
            }
        } catch (NumberFormatException nFMException) {
            System.out.println(nFMException.getMessage());
        }

    };

    // update

    public Handler updateEmployee = context -> {

        Employee employee = context.bodyAsClass(Employee.class);
        employee = service.updateEmployee(employee);

        if (employee != null) {
            context.json(employee).status(200);
        } else {
            context.result("Employee not updated").status(400);
        }
    };

    // delete

    public Handler deleteEmployee = context -> {
        Employee employee = context.bodyAsClass(Employee.class);

        if (employee != null) {
            context.json(service.deleteEmployee(employee)).status(200);
        } else {
            context.result("could not delete employee").status(400);
        }
    };

    public Handler login = context -> {
        Employee employee = context.bodyAsClass(Employee.class);
        employee = service.login(employee);

        if (employee != null) {
            context.json(employee).status(200);
        } else {
            context.result("Log in failed, please check email or password").status(400);
        }
    };

}
