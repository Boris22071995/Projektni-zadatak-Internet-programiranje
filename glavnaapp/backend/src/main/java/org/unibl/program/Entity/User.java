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
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private Integer idUser;
    @Basic
    @Column(name = "userName")
    private String userName;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "firstName")
    private String firstName;
    @Basic
    @Column(name = "lastName")
    private String lastName;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "isActivated")
    private  Byte isActivated;
    @Basic
    @Column(name = "programIdProgram")
    private Integer programIdProgram;
    @Basic
    @Column(name = "pinCode")
    private Integer pinCode;


    public void setActivated(Byte active) {
        this.isActivated = active;
    }
}
