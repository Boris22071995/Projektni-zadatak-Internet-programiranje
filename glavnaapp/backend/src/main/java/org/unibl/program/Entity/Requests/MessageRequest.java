package org.unibl.program.Entity.Requests;

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
    private Date dateAndTime;
    private boolean isRead;
    private String reciver;
    private Integer useridUser;
}
