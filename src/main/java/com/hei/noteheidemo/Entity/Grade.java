package com.hei.noteheidemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Grade {
    private int id ;
    private String subject ;
    private Float score ;
    private int student_id ;
    private int evaluations_id ;
}
