package org.unibl.program.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "contact", schema = "fitnesscentar", catalog = "")
@Data
public class Contact {

    @Id
    @Column(name = "idcontact")
    private Integer idcontact = 2;
    @Column(name = "name")
    private String name;


}
