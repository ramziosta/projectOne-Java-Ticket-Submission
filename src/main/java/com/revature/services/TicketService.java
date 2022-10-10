package com.revature.services;

import com.revature.models.Ticket;
import com.revature.repos.TicketsRepo;
import java.util.List;

public class TicketService {

    private final TicketsRepo ticketRepo;

    public TicketService() {
        ticketRepo = new TicketsRepo();
    }

    public TicketService(TicketsRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    // create a ticket
    //todo submit ticket amount, date, employee-Id, description
    public int createTicket(Ticket ticket) {

        return ticketRepo.create(ticket);

    }

    // read all tickets
    //todo veiw all reimbursements
    public List<Ticket> getAllTickets() {
        return ticketRepo.getAll();
    }

    // read byID change to status
    //todo get ticket by employee_id
    public Ticket getTicketById(int id) {
        return ticketRepo.getById(id);
    }
    //todo get ticket by status pending/denied
    public Ticket getTicketByStatus(String status) {
        return ticketRepo.getByStatus(status);
    }

    // update
    //todo updates the amount
    public Ticket updateTicket(Ticket ticket) {
        return ticketRepo.update(ticket);
    }
    // update
    //todo updates the status
    public Ticket updateTicketStatus(Ticket ticket) {
        return ticketRepo.update(ticket);
    }

    // todo Approve or deny the ticket
    //> sets the status to Approve or deny
//    public Ticket approveOrDenyTicket(Ticket ticket) {
//        return ticketRepo.approveOrDeny(ticket);
//    }

    // delete
    
    public boolean deleteTicketById(int id) {
        return ticketRepo.deleteById(id);
    }

     public boolean deleteTicket(Ticket ticket) {
         return ticketRepo.delete(ticket);
     }

}
