package com.hei.noteheidemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Evaluations {
    private int id ;
    private LocalDate date ;
    private String subject ;
}
