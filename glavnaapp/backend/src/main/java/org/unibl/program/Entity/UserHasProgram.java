package org.unibl.program.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
@Table(name = "user_has_program")
public class UserHasProgram implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userIdUser")
    private Integer userIdUser;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "programIdProgram")
    private Integer programIdProgram;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "paymentMethod")
    private String paymentMethod;
    @Basic
    @Column(name = "pay")
    private Double pay;
}
