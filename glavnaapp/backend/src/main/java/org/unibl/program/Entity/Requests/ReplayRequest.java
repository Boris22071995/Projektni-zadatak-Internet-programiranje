package org.unibl.program.Entity.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplayRequest {
    private Integer idReplay;
    private Integer questionidQuestion;
    private Integer questionUserIdUser;
    private Integer questionProgramIdProgram;
}
