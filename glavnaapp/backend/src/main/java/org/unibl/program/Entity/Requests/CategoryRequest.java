package org.unibl.program.Entity.Requests;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {
    private Integer idCategory;
    private String name;
    @Override
    public String toString(){
        return idCategory + name;
    }
}
