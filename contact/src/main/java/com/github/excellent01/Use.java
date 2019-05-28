package com.github.excellent01;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @auther plg
 * @date 2019/5/26 18:07
 */
public class Use{
    Scanner in = new Scanner(System.in);
    private SAXReader reader = null;
    private Document document = null;
    private List<Contacts> list = new ArrayList<>();
    public Use(SAXReader reader, Document document) {
        this.reader = reader;
        this.document = document;
    }
    private void input(){
        System.out.println("请输入姓名：");
        String name = in.nextLine();
        System.out.println("请输入id：");
        String id = in.nextLine();
        System.out.println("请输入性别：");
        String gender = in.nextLine();
        System.out.println("请输入电话号码：");
        String phone = in.nextLine();
        System.out.println("请输入email：");
        String email = in.nextLine();
        System.out.println("请输入地址：");
        String adders = in.nextLine();
    }
    // 添加
    public void add() throws IOException {
        //Document document = DocumentHelper.createDocument();
        Element element = document.getRootElement();
        // 在root下添加标签，在标签中添加text。
        Element contactElem = element.addElement("contact");
        Element nameElem = contactElem.addElement("name");
        Element genderElem = contactElem.addElement("gender");
        Element phoneElem = contactElem.addElement("phone");
        Element addressElem = contactElem.addElement("address");
        Element emailElem = contactElem.addElement("email");
        System.out.println("请输入姓名：");
        String name = in.nextLine();
        System.out.println("请输入id：");
        String id = in.nextLine();
        System.out.println("请输入性别：");
        String gender = in.nextLine();
        System.out.println("请输入电话号码：");
        String phone = in.nextLine();
        System.out.println("请输入email：");
        String email = in.nextLine();
        System.out.println("请输入地址：");
        String adders = in.nextLine();
        nameElem.addText(name);
        genderElem.addText(gender);
        phoneElem.addText(phone);
        emailElem.addText(email);
        addressElem.addText(adders);
        // 添加属性同时设置属性值
        contactElem.addAttribute("id",id);
        save();
    }
    // 将信息存入集合中，toString()显示出来
    public  void show() {
        this.list = new ArrayList<>();
        setList();
        for(Contacts contacts : list){
            System.out.println(contacts);
        }

    }
    // 根据id删除
    public  void delete() throws IOException {
        System.out.println("根据id删除，请输入id");
        String id = in.nextLine();
        List<Element> listElem = document.getRootElement().elements("contact");
        Iterator<Element> iterator = listElem.iterator();
        while(iterator.hasNext()){
            Element element = iterator.next();
            if(id.equals(element.attributeValue("id"))){
                iterator.remove();
            }
        }
        save();
        setList();
        show();
    }
    public  void modift() throws IOException {
        System.out.println("根据id修改，输入要修改人员的id");
        Scanner in = new Scanner(System.in);
        String id = in.nextLine();
        Element rootElem = document.getRootElement();
        List<Element> conList = rootElem.elements("contact");
        for(Element element : conList){
            if(element.attributeValue("id").equals(id)){
                Element nameElm = element.element("name");
                System.out.println("请输入姓名：");
                String name = in.nextLine();
                nameElm.setText(name);
                System.out.println("请输入性别：");
                String gender = in.nextLine();
                Element genderElem = element.element("gender");
                genderElem.setText(gender);
                System.out.println("请输入电话号码：");
                String phone = in.nextLine();
                Element phoneElem = element.element("phone");
                phoneElem.setText(phone);
                System.out.println("请输入email：");
                String email = in.nextLine();
                Element emailElem = element.element("email");
                emailElem.setText(email);
                System.out.println("请输入地址：");
                String adders = in.nextLine();
                Element addElem = element.element("address");
                addElem.setText(adders);
                setList();
                show();
                save();

            }
        }

    }
    private void setList() {
        List<Element> conElem = document.getRootElement().elements("contact");
        //System.out.println(conElem.size());
        //遍历List<Element>获取每一个contact标签对象
        for (Element elem : conElem) {
            Contacts contact = new Contacts();
            //attributeValue  获取属性值
            contact.setId(elem.attributeValue("id"));
            // 获取文本值elementText -- 根据父亲标签
            contact.setName(elem.elementText("name"));
            contact.setGender(elem.elementText("gender"));
            contact.setPhone(elem.elementText("phone"));
            contact.setEmail(elem.elementText("email"));
            contact.setAdders(elem.elementText("address"));
            list.add(contact);
        }
    }
    private void save() throws IOException{
        OutputStream out = new FileOutputStream("E:\\dom4j\\src\\main\\resources\\contact.xml") ;
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        // 格式化输出
        XMLWriter writer = new XMLWriter(out,format) ;
        writer.write(document);
        writer.close();
    }
}
