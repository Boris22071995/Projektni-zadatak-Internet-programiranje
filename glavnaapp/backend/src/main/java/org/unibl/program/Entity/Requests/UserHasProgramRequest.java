package org.unibl.program.Entity.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserHasProgramRequest {
    private Integer userIdUser;
    private Integer programIdProgram;
    private Date date;
    private String paymentMethod;
    private Double pay;
}
