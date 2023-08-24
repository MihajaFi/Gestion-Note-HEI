package com.hei.noteheidemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Student {
    private int id  ;
    private String last_name ;
    private String first_name ;
    private String student_number ;
    private int group_id ;
}
