package ch.zli.m223.models;

import io.quarkus.arc.impl.Identified;
import jakarta.persistence.*;

@Entity
@Table(name = "status")

public class Status() {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

}
