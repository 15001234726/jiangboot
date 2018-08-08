package com.jyh.jiangboot.cyLunch.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    private int id;
    private String name;

    private int count;    //吃的次数
    private int distance; //距离


}
