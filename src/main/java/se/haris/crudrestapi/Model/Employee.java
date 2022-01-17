package se.haris.crudrestapi.Model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_Name",nullable = false)
    private String firstName;

    @Column(name = "last_Name",nullable = false)
    private String lastName;

    @Column(name = "email",nullable = false)
    private String email;
}
