package org.unibl.program.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.unibl.program.IdClasses.AtributeValueId;

import javax.persistence.*;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
@Table(name = "atributeValue")
@IdClass(AtributeValueId.class)
public class AtributeValue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idatributeValue")
    private Integer idatributeValue;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "programIdProgram")
    private Integer programIdProgram;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attributeIdAttribute")
    private Integer atributeIdAttribute;
    @Basic
    @Column(name = "value")
    private String value;
}
