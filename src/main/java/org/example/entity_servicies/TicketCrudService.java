package org.example.entity_servicies;

import org.example.dao.ClientDao;
import org.example.dao.TicketDao;
import org.example.hibernate_entities.Client;
import org.example.hibernate_entities.Ticket;

public class TicketCrudService {
    private TicketDao ticketDao = new TicketDao();

    public void saveTicket(Ticket ticket) {
        ticketDao.save(ticket);
    }

    public Ticket findTicketById(Long id) {
        return ticketDao.findById(id);
    }

    public void updateTicket(Ticket ticket) {
        ticketDao.update(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        ticketDao.delete(ticket);
    }
}
