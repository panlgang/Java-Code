package com.github;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Text;
import org.dom4j.io.DOMReader;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.List;

/**
 * @auther plg
 * @date 2019/5/27 15:11
 */
public class Test {
    public static void main(String[] args) throws Exception {
//        TestElement();
//        TestAttribute();
//        TestText();
//        TestWrite();
         //TestDelete();
        TestXpath();
    }

    // 获取标签对象练习
    public static void TestElement ()throws Exception {
        // 获取标签对象
        SAXReader reader = new SAXReader();
        Document document = reader.read(Test.class.getClassLoader().getResource("contact.xml"));
        System.out.println(document.getName());   // 文本名称（路径）
        Element rootElem =  document.getRootElement();  // 获取根标签对象
        // System.out.println(rootElem.getName());  //   输出根标签的名称
        List<Element> list  = rootElem.elements("contact");
        // 获取同一个名称的所有标签  elements()方法  ，element(String s) 获取指定名称的标签默认第一个
        for(Element element : list){
            System.out.println(element);
        }
        Element childElem = rootElem.element("contact");  // qname 标签名称 或者String s
        Element sunElem = childElem.element("name");   //  孙标签对象
        System.out.println(sunElem.getName());

        List<Element> list1 = childElem.elements();
        // 获取所有孙标签对象，不指定名称
        for(Element element : list1){
            System.out.println(element.getName());
        }
    }
    // 获取标签属性对象练习
    // 获取属性，得先获取属性所处得标签得标签得标签得标签对象
    public static void TestAttribute() throws Exception{
        SAXReader reader = new SAXReader();
        Document document = reader.read(Test.class.getClassLoader().getResource("contact.xml"));
        Element rootElem = document.getRootElement();
        Element conElem = rootElem.element("contact");  // 获取到标签对象
        // 1.通过属性名称获取值
        String value = conElem.attributeValue("id");  // 获取属性值
        System.out.println(value);
        // 2.通过属性对象获取属性值
        Attribute attribute = conElem.attribute("id");  // 根据名称获取属性对象
        Attribute attribute1 = conElem.attribute(0);    // 根据属性顺序获取属性，默认从0开始
        System.out.println(attribute1.getData());

        // setValue  和  setData的区别

        attribute.setValue("002");
       // System.out.println(attribute1.getData());
        attribute.setData("005");
       // System.out.println(attribute1.getData());





    }
    /**
     * 获取文本对象
     * 首先获取到文本所处的标签对象，再获取到文本对象
     * 进而操纵文本内容
     * @throws Exception
     */
    public static void TestText() throws Exception{
        SAXReader reader = new SAXReader();
        Document document = reader.read(Test.class.getClassLoader().getResource("contact.xml"));
        Element rootElem = document.getRootElement();
        Element conElem = rootElem.element("contact");  // 获取到标签对象
        Element nameElem = conElem.element("name");
        String name = conElem.getText();      // 文本只有一个不需要传参数,包括空格换行都能回去到
        //System.out.println(name);
        String text = conElem.getTextTrim();  // 去除空格换行
        //System.out.println(text);
        System.out.println(nameElem.getText());
        // 通过父标签对象获取子结点内容
        String nameText = conElem.elementText("name");
        System.out.println(nameText);
        // 设置文本值，设置完需要重新写回硬盘，输出到文件
        conElem.setText("Jack");
    }

    /**
     * 用修改后的文件覆盖之前的文件
     * 将document对象输出到硬盘即可
     * @throws Exception
     */
    public static void  TestWrite() throws  Exception{
        SAXReader reader = new SAXReader();
        Document document = reader.read(Test.class.getClassLoader().getResource("contact.xml"));
        // 不设是格式默认是优雅格式测试用的

        OutputFormat format = OutputFormat.createPrettyPrint();   // 优雅格式
        OutputFormat format1 = OutputFormat.createCompactFormat();  // 紧凑格式,变成一行

        OutputFormat format2 = new OutputFormat();   // 无参构造未知

        format1.setEncoding("utf-8");

        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("E:\\test.xml"),format2);
        xmlWriter.write(document);
        xmlWriter.close();
    }

    public static void TestDelete() throws  Exception{
        SAXReader reader = new SAXReader();
        Document document = reader.read(Test.class.getClassLoader().getResource("contact.xml"));
        Element rootElem = document.getRootElement();
        List<Element> list = rootElem.elements("contact");
        for(Element element : list){
            if(element.attributeValue("id").equals("001")){
                element.detach();
            }
        }
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("E:\\test.xml"));
        xmlWriter.write(document);
        xmlWriter.close();

    }

    public static void TestXpath() throws Exception{
        SAXReader reader = new SAXReader();
        Document document = reader.read(Test.class.getClassLoader().getResource("contact.xml"));
        Element rootElem = document.getRootElement();
       Element element = (Element) document.selectSingleNode("//contact[@id='002']");
       element.detach();
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("E:\\test.xml"));
        xmlWriter.write(document);
        xmlWriter.close();
    }
}
