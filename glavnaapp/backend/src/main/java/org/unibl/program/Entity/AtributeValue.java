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
@Table(name = "atributeValue")

public class AtributeValue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idatributeValue")
    private Integer idatributeValue;
    @Column(name = "programIdProgram")
    private Integer programIdProgram;
    @Column(name = "attributeIdAttribute")
    private Integer atributeIdAttribute;
    @Basic
    @Column(name = "value")
    private String value;
}
