package org.example.hibernate_entities;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Table(name = "ticket")
@Data
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name="created_at", nullable = false)
    public LocalDate created;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    public Client client;

    @ManyToOne
    @JoinColumn(name = "from_planet_id", nullable = false)
    public Planet fromPlanet;

    @ManyToOne
    @JoinColumn(name = "to_planet_id", nullable = false)
    public Planet toPlanet;

}
