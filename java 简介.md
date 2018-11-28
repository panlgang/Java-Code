#### java 简介

1.java是一门半编译半解释性语言。

编译命令  ：javac

使用javac将.java文件（源文件）编译为.class文件

class文件为与**平台无关的**的二进制文件，提供给JVM（Java虚拟机）,JVM是Java平台的核心。

**可移植性**：（.class文件可以在任何含有Java虚拟机的电子设备上 运行）

解释命令：java

使用java命令实际上启动了JVM虚拟机进程（软件）来将二进制class文件翻译为与平台无关的可执行文件并安全兼容的执行。.class文件又称为“机器码”或“字节码”。

主方法中字符数组传值

使用Java命令解释二进制class文件时传值，eg：

java Day2 hello world

表示运行Day1文件并将 hello world传值给主参数，hello是args[0],world是args[i].

##### 如果只给只给args[0]传值，则字符串中间不能加空格，否则只会args[0]的值只是空格前的字符串。



主方法一定要包含在主类中，（public class）中定义，主类名称与源文件名称保持一致，一个源文件有且只有一个主类。

源文件若有中文，编译时使用如下命令   

javac -encoding UTF-8 源文件名称



#### Java数据类型和运算符

a.单行注释//

b.多行注释（forget）/*  */

c.文档注释 /**   /

##### java标识符（变量名 ，常量，数组名，类名，方法名，文件名等的名称）

标识符要求

标识符有字母数字下划线 组成，其中不能以数字开头，不能使用Java中的关键字

命名规范 ：驼峰命名法

大驼峰：对于类名，类名是以大写字母开头的单词；如果类名由多个单词构成，则每个单词的首字母大写。

eg： class Demo

class First Demo

小驼峰：对于变量，函数名称，如果只含有一个单词全部小写；如果该变量又多个单词组成 ，则从第二个单词开始，每个单词的首字母大写（包括第二个单词）。

eg： int value

int firstValue

常量命名：单词全部大写，多个单词以_分割。

eg：final int MY_INT_VALUE  = 10;

如果是包名，所有单词的所有字母小写。

#### 数据类型

数值型（byte .short ,int ,long,float,double ）

字符型(char )(2个字节)

布尔型(boolean)（true，false）默认为false;



