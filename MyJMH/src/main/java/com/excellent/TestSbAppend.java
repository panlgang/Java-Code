package com.excellent;

import com.BencherMark;
import com.Parameter;
import com.Test;

/**
 * @auther plg
 * @date 2019/7/13 21:50
 */
@Parameter(times = 1000,groups = 10)
public class TestSbAppend implements Test {
    @BencherMark
    @Parameter(times = 1000,groups = 5)
    public String SBAppend(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++){
            sb.append(i);
        }
        return sb.toString();
    }
}
