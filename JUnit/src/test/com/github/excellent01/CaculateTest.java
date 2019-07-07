package test.com.github.excellent01;

import org.junit.Assert;
import org.junit.Test;

import main.com.github.excellent01.Caculate;

/**
 * @auther plg
 * @date 2019/7/7 13:46
 */
public class CaculateTest {

    @Test
    public void Testadd(){
        Caculate caculate = new Caculate();
        Assert.assertEquals(3,caculate.add(1,2));
    }

    @Test
    public void TestSub(){
        Caculate caculate = new Caculate();
        Assert.assertEquals(1,caculate.add(1,2));
    }
}
