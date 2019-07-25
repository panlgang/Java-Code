package com.xust.excellent.injection;

import lombok.Data;

import java.util.*;

/**
 * @auther plg
 * @date 2019/7/25 21:58
 */

@Data
public class Bean1 {
    private int num;
    private String name;
    private String[] arr;
    private List list;
    private Set set;
    private Map map;
    private UserInfor user;
    public Bean1(){

    }
}