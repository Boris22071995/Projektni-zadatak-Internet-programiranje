package org.unibl.program.Entity.Requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ContactRequest {
@NotBlank
    private  Integer idTest;
@NotBlank
    private String name;

    @Override
    public String toString(){
        return idTest + name;
    }

}
