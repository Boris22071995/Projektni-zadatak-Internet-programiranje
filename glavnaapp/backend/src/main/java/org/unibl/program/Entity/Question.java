package org.unibl.program.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
@Table(name = "question")
public class Question implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idQuestion")
    private Integer idQuestion;
    @Column(name = "userIdUser")
    private Integer userIdUser;
    @Column(name = "programIdProgram")
    private Integer programIdProgram;
    @Basic
    @Column(name = "text")
    private String text;

}
