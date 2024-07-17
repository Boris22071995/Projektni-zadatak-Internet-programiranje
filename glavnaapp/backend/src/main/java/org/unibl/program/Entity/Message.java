package org.unibl.program.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMessage")
    private Integer idMessage;
    @Basic
    @Column(name = "textMessage")
    private String textMessage;
    @Basic
    @Column(name = "dateAndTime")
    private Date dateAndTime;
    @Basic
    @Column(name = "isRead")
    private boolean isRead;
    @Basic
    @Column(name = "reciver")
    private String reciver;
    @Basic
    @Column(name = "useridUser")
    private Integer useridUser;

}