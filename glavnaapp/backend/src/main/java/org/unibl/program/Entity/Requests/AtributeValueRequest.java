package org.unibl.program.Entity.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtributeValueRequest {
    private Integer idatributeValue;
    private Integer programIdProgram;
    private Integer atributeIdAttribute;
    private String value;
}
