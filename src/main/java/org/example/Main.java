package org.example;

import org.example.config.HibernateConfig;
import org.example.entity_servicies.ClientCrudService;
import org.example.entity_servicies.PlanetCrudService;
import org.example.entity_servicies.TicketCrudService;
import org.example.hibernate_entities.Client;
import org.example.hibernate_entities.Planet;
import org.example.hibernate_entities.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Migration.getInstance().repair();
        Migration.getInstance().clean();
        Migration.getInstance().migrate();

        ClientCrudService clientCrudService = new ClientCrudService();
        Client client = clientCrudService.findClientById(1L);

        PlanetCrudService planetCrudService = new PlanetCrudService();
        Planet planetFrom = planetCrudService.findPlanetById("MARS");
        Planet planetTo = planetCrudService.findPlanetById("SUN1");

        TicketCrudService ticketCrudService = new TicketCrudService();

        Ticket ticket = new Ticket();
        ticket.setCreated(LocalDate.parse("2024-01-02"));
        ticket.setClient(client);
        ticket.setFromPlanet(planetFrom);
        ticket.setToPlanet(planetTo);
        ticketCrudService.saveTicket(ticket);
        System.out.println(ticketCrudService.findTicketById(11L).getId());

        ticket.setClient(new Client());
        try {
            ticketCrudService.updateTicket(ticket);
        }catch (Exception e){
            System.out.println("Client does not exist");
        }
        ticket.setClient(client);
        ticket.setToPlanet(new Planet());
        try {
            ticketCrudService.updateTicket(ticket);
        }catch (Exception e){
            System.out.println("Planet does not exist");
        }
        ticket.setToPlanet(planetTo);
        ticketCrudService.deleteTicket(ticket);

        try {
            ticketCrudService.findTicketById(11L).getId();
        }catch (Exception e){
            System.out.println("Ticket is deleted");
        }


    }
}