package org.unibl.program.Entity.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtributeValueRequest implements Serializable {
    private Integer idatributeValue;
    private Integer programIdProgram;
    private Integer atributeIdAttribute;
    private String value;
}
