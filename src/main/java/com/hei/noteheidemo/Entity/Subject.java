package com.hei.noteheidemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Subject {
    private int id  ;
    private String subject_code ;
    private int coef_subject ;
}
