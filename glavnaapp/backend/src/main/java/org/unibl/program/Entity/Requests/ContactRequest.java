package org.unibl.program.Entity.Requests;

import lombok.Data;

@Data
public class ContactRequest {
    private String name;
    private  Integer idcontact;
    public String getName() {
        return name;
    }
    public Integer getId() {return idcontact;}

}
