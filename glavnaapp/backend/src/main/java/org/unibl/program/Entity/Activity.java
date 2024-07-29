package org.unibl.program.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
@Table(name = "activity")
public class Activity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idActivity")
    private Integer idActivity;
    @Column(name = "diaryidDiary")
    private Integer diaryidDiary;
    @Basic
    @Column(name = "excersise")
    private String excersise;
    @Basic
    @Column(name = "weight")
    private Integer weight;
    @Basic
    @Column(name = "intensity")
    private Integer intesity;
    @Basic
    @Column(name = "duration")
    private Integer duration;
    @Basic
    @Column(name = "date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date date;
    @Basic
    @Column(name = "result")
    private Integer result;

}
