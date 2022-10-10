package com.revature;

import com.revature.controllers.TicketController;
import com.revature.controllers.EmployeeController;
import com.revature.services.TicketService;
import com.revature.services.EmployeeService;
import io.javalin.Javalin;


public class Driver {
    public static void main(String[] args) {

        Javalin app = Javalin.create().start(8081);
        EmployeeService employeeService = new EmployeeService();
        EmployeeController employeeController = new EmployeeController(employeeService);

       TicketService ticketService = new TicketService();
       TicketController ticketController = new TicketController(ticketService);

        app.get("employees", employeeController.getAllEmployees);
        app.get("/employee/{id}", employeeController.getEmployeeById);
        app.post("/employee", employeeController.createNewEmployee);
        app.put("/employee", employeeController.updateEmployee);
        app.delete("/employee", employeeController.deleteEmployee);
        app.put("/login",employeeController.login);

        app.get("tickets", ticketController.getAllTickets);
        app.get("/ticket/{id}", ticketController.getTicketById);
        app.post("/ticket", ticketController.createNewTicket);
        app.put("/ticket", ticketController.updateTicket);
        app.delete("/ticket", ticketController.deleteTicket);
    }
}