package org.unibl.program.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
@Table(name = "program")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProgram")
    private Integer idProgram;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "price")
    private Double price;
    @Basic
    @Column(name = "intensityLevel")
    private String intensityLevel;
    @Basic
    @Column(name = "duration")
    private Integer duration;
    @Basic
    @Column(name = "contactPerson")
    private String contactPerson;
    @Basic
    @Column(name = "picture")
    private String picture;
    @Basic
    @Column(name = "locationName")
    private String locationName;
    @Basic
    @Column(name = "locationAdress")
    private String locationAdress;
    @Basic
    @Column(name = "instructorIdinstructor")
    private Integer instructorIdinstructor;
    @Basic
    @Column(name = "categoryIdCategory")
    private Integer categoryIdCategory;
}
