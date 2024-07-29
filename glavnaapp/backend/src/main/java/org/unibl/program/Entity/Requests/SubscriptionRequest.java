package org.unibl.program.Entity.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionRequest {
    private Integer idSubscription;
    private Integer category_idCategory;
    private Integer user_idUser;
    private Date date;
}
