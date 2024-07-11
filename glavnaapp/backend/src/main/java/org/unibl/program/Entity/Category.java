package org.unibl.program.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcategory")
    private Integer idcategory;
    @Column(name = "name")
    private String name;
}
