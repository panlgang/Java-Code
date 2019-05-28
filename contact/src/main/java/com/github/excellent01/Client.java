package com.github.excellent01;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import java.util.Scanner;

/**
 * @auther plg
 * @date 2019/5/26 17:55
 */
public class Client {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("E:\\dom4j\\src\\main\\resources\\contact.xml");
        Use use = new Use(reader,document);
        String select = null;
        while(true){
            menu();
            select = input.nextLine();
            switch (select){
                case "A" :
                    use.add();
                    break;
                case "B" :
                    use.delete();
                    break;
                case "C" :
                    use.modift();
                    break;
                case "D" :
                    System.out.println("所有人员信息：");
                    use.show();
                    break;
                case "Q" :
                    System.out.println("退出成功。");
                    System.exit(-1);
            }
        }
    }

    public static void menu() {
        System.out.println("************通讯录程序***********");
        System.out.println("***********A.添加联系人**********");
        System.out.println("***********B.删除联系人**********");
        System.out.println("***********C.修改联系人**********");
        System.out.println("***********D.显示联系人**********");
        System.out.println("**************Q.退出*************");
        System.out.println("请选择：");
    }
}
