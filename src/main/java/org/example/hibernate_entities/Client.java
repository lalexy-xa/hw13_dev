package org.example.hibernate_entities;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "client")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name="name")
    public String name;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    public List<Ticket> tickets;
}
