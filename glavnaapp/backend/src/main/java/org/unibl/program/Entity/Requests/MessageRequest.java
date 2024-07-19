package org.unibl.program.Entity.Requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {
    private Integer idMessage;
    private String textMessage;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date dateAndTime;
    private boolean isRead;
    private String reciver;
    private Integer useridUser;
}
