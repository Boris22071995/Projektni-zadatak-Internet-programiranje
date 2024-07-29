package org.unibl.program.Entity.Requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserHasProgramRequest {
    private Integer idUserHasProgram;
    private Integer userIdUser;
    private Integer programIdProgram;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date date;
    private String paymentMethod;
    private Double pay;
}
