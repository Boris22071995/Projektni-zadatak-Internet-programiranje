package org.unibl.program.Entity.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest {
    private Integer idQuestion;
    private Integer userIdUser;
    private Integer programIdProgram;
    private String text;
}
