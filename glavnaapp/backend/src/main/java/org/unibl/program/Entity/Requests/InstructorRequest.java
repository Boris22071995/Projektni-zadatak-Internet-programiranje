package org.unibl.program.Entity.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorRequest {
    private Integer idinstructor;
    private String firstName;
    private String lastName;
    private Integer age;
    private String expirience;
}
