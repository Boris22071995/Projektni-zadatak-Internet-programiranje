package org.unibl.program.Entity.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramRequest {
    private Integer idProgram;
    private String name;
    private String description;
    private Double price;
    private String intensityLevel;
    private Integer duration;
    private String contactPerson;
    private String picture;
    private String locationName;
    private String locationAdress;
    private Integer instructorIdinstructor;
    private Integer categoryIdCategory;
}
