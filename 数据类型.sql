MySql中的数据类型
------  Java有8种基本数据类型

1. 整数类型

   - tinyint  (一个字节)  byte
   - smallint (两个字节)  short
   - mediumint(三个字节)  
   - int      (四个字节)  int
   - bigint   （八个字节）long 

2.浮点数与定点数

   - float  
   - double
   - decimal

3.日期和时间类型
  
   - year      
   单字节      表示年份          范围 1901 -- 2155  
   4位字符串或者4位数字 
   00 --  69               转换为 2000 -- 2069
   70 --  99               转换为 1970 -- 1999

   - date  yyyy-mm-dd    或者  yyyymmdd

   - time 类型   三个字节     格式： hh:mm:ss    或者   hhmmss
   当没有：时，MySQL假定最后的两位为秒。

   - datetime
   yyyy-mm-dd hh:mm:ss   或者 yyyymmddhhmmss

   - timestarp  
   时间戳

   字符串类型(String)  65535  最大
   - char    格式  char(10);     10个字节   定长    eg: null   10   个字节
   - varchar 格式  varchar(20);  变长字符串         eg：null    1   个字节
   varchar   比   char      省空间
   char      比   varchar   查询速度快
   二进制类型
   binary   varbinary
   blob 
   text    存储大文本

   枚举类型   格式  enum  (值1，值2)
   
   set 类型   格式  set (值1，值2)

   bit 类型  bit(1)  表示1位二进制数可以表示0和1



   
        



