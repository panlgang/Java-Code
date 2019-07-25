package com.xust.excellent;
import lombok.Data;

/**
 * @auther plg
 * @date 2019/7/25 20:54
 */

@Data
public class HelloSpring {
    private String name;
    private Integer id;
    String[] arr;
    public String printMessage(String message){
        return message;
    }
}
