package org.unibl.program.Entity.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private Integer idUser;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private boolean isActivated;
    private Integer programIdProgram;
}
