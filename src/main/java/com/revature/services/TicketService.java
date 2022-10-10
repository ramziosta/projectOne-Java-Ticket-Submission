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
    public int createTicket(Ticket ticket) {

        return ticketRepo.create(ticket);

    }

    // read all tickets
   
    public List<Ticket> getAllTickets() {
        return ticketRepo.getAll();
    }


    public List<Ticket> getAllPendingTickets() {
        return ticketRepo.getAllPending();
    }


    // todo get tickets by employee_id
    public List<Ticket> getTicketsById(int id) {
        return ticketRepo.getAllById(id);
    }

    // update
     public Ticket updateTicket(Ticket ticket) {
     return ticketRepo.update(ticket);
     }

    // > update
    // todo updates the status
    public Ticket updateTicketStatus(Ticket ticket) {
        return ticketRepo.update(ticket);
    }

    // Approve or deny the ticket
    // sets the status to Approve or deny
    // public Ticket approveOrDenyTicket(Ticket ticket) {
    // return ticketRepo.approveOrDeny(ticket);
    // }

    // delete

    public boolean deleteTicketById(int id) {
        return ticketRepo.deleteById(id);
    }

    public boolean deleteTicket(Ticket ticket) {
        return ticketRepo.delete(ticket);
    }

}
