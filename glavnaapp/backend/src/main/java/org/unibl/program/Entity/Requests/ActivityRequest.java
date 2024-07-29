package org.unibl.program.Entity.Requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityRequest {
    private Integer idActivity;
    private Integer diaryidDiary;
    private String excersise;
    private Integer weight;
    private Integer intesity;
    private Integer duration;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date date;
    private Integer result;

    @Override
    public String toString(){
        return idActivity + diaryidDiary + excersise + weight + intesity + duration + date +result;
    }
}
