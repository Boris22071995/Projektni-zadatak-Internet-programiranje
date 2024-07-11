package org.unibl.program.Entity.Requests;

import lombok.Data;

@Data
public class CategoryRequest {
    private Integer idcategory;
    private String name;
    @Override
    public String toString(){
        return idcategory + name;
    }
}
