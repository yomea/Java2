oa_05:

1、添加数据初始化相关的类(InitSystemDatas.java)
2、初始化数据文件（init_datas.xml）

初始化数据的过程：
前提：当前类路径中已有init_datas.xml文件
1、首先drop数据库
2、运行InitSystemDatasTest.java即可


如果数据库不支持中文，会出现异常，解决方法是：
1、找到mysql的配置文件：my.ini
2、修改其中的编码设置为：default-character-set=gb2312
3、重启mysql
4、drop掉原来的数据库
5、create数据库
6、在运行初始化测试单元