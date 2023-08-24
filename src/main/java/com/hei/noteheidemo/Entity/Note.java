package com.hei.noteheidemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Note {
    private int id ;
    private int subject_id ;
    private int student_id ;
    private float note ;
}
