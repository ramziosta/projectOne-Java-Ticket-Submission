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

   // create
   public int createTicket(Ticket ticket) {

       return ticketRepo.create(ticket);

   }

   // read all
   public List<Ticket> getAllTickets() {
       return ticketRepo.getAll();
   }

   // read byID

   public Ticket getTicketById(int id) {
       return ticketRepo.getById(id);
   }

   // update

   public Ticket updateTicket(Ticket ticket) {
       return ticketRepo.update(ticket);
   }

   // delete
   public boolean deleteTicket(Ticket ticket) {
       return ticketRepo.delete(ticket);
   }

   public boolean deleteTicketById(int id) {
       return ticketRepo.deleteById(id);
   }

}
