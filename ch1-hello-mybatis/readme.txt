ch01-hello-mybatis: First entry level example

Steps:
1. 新建student表
2. 加入maven的mybatis坐标，mysql驱动的坐标
3. 创建实体类，Student -- 保存表中的一行数据
4. 创建持久层的dao接口，定义操作数据库的方法
5. 创建一个mybatis使用的配置文件
    叫做sql映射文件：写sql语句的。一般一个表一个sql映射文件。这个文件是xml文件。
    1.在接口所在的目录中
    2.文件名称和接口保持一致