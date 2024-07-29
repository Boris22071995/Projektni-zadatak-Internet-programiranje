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
@Table(name = "subscription")
public class Subscription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSubscription")
    private Integer idSubscription;

    @Column(name = "category_idCategory")
    private Integer category_idCategory;

    @Column(name = "user_idUser")
    private Integer user_idUser;
    @Basic
    @Column(name = "date")
    private Date date;

}
