库操作

create database data_01;   创建数据库
drop database data_01;     删除数据库
show databases       查看当前可用的数据库
alter database       修改数据库
表操作：

创建表(增加表)
create table employe(          
    id int,
    name varchar(10),
    job varchar(20),
    salary int(10)
);
删除表
drop table 表名1，表名2；
查看表结构
describe employe;

修改表
alter table employe
添加字段
add column age int; 
修改数据类型
modify id tinyint；
删除字段
drop id;
修改字段名称
change job  work varchar(20);
修改表名(有问题)
employe rename to 新表名


表的数据操作

添加数据

insert into employe
values(1,'张飞','打手','998.00'),
(2,'关羽','财神','99800.00')，
(3,'刘备','老大','100000.00');



修改数据

update employe
set id = 10 where name = '张飞';

删除数据
delete from employe 
where id = 10;

整表删除
delete from employe;
truncate employe;       效率高


表查询

查看表中所有内容
select * from employe;

查看某一列的内容

select name from employe;

去重查看

select distinct name from employe;

表达式查看

select salary + 100 from employe;  // 薪水加100，底层不变

筛选查看(逗号很重要，若没有逗号则成了别名)

select id,name from employe;

别名查看   
select name 姓名, salary 薪水 from employe;   // 别名不需要加单引号

在某个集合中
select * from employe where id in (1,2,3);

模糊查询
（%通配符 代指任意数量）
（_通配符，代指一个字符）
select * from employe where name like '张%'

排序查询

select math,name from student order by math asc | desc  (升序与降序)默认升序 

select name 姓名 , math + english + chines 总分  from student order by  desc   全班成绩排序




聚合函数
count()      统计行数
先查然后用count将*包起来
select count(*) from student;                    统计全班人数

select count(*) from studnet where math > 90     统计数学成绩高于90的人数

sum()        计算某列的和值

select sum(math) from student                     统计数学总分

select sum(math) 数学总分 from student            使用别名

avg()       计算平均值

select avg(chinese + math + english) from student     计算平均分

max()     计算最大值
min()     计算最小值

select max(chines) from student     语文最高分