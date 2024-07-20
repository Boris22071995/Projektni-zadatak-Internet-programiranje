package org.unibl.program.IdClasses;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class AtributeValueId implements Serializable {
    private Integer idatributeValue;
    private Integer programIdProgram;
    private Integer atributeIdAttribute;
}
