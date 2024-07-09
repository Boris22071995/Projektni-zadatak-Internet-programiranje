package org.unibl.program.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "test", schema = "fitnesscentar", catalog = "")
@Data
public class Contact {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idTest")
    private Integer idcontact;
    @Basic
    @Column(name = "name")
    private String name;


}
