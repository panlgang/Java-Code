package com.excellent;

import com.BencherMark;
import com.Parameter;
import com.Test;

/**
 * @auther plg
 * @date 2019/7/13 21:49
 */
@Parameter(times = 1000,groups = 10)
public class TestStringAdd implements Test {
    @Parameter(times = 1000,groups = 5)
    @BencherMark
    public String stringAdd(){
        String str = "";
        for(int i = 0; i < 10; i++){
            str += i;
        }
        return str;
    }
}
