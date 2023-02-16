package com.dkrucze.Restaurantor.Model;

import lombok.Data;

import java.util.Date;

@Data
public class Grade {
    private char grade;
    private int score;
    private Date date;
}
