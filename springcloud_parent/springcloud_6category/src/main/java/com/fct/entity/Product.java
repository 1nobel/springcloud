package com.fct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Integer id;

    private String name;

    private Double price;

    private Date date;


}
