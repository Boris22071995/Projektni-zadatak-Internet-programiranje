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
@Table(name = "replay")
public class Replay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReplay")
    private Integer idReplay;
    @Basic
    @Column(name = "questionidQuestion")
    private Integer questionidQuestion;
    @Basic
    @Column(name = "questionUserIdUser")
    private Integer questionUserIdUser;
    @Basic
    @Column(name = "questionProgramIdProgram")
    private Integer questionProgramIdProgram;

}
