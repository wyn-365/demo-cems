1.工程结构：
  java包
    com.wang.client  ----主窗口类 UdpClientFrame
    com.wang.entity  ----数据实体类
    com.wang.server  ----模拟服务器类
    com.wang.utils   ----工具类

  resources包
    db.properties:数据库配置
    protocol.properties:通讯协议配置

  * 软件采用读取properties的方式读取配置。
  * 本软件采用动态连接服务器ip,port，无需在配置文件中指定 。

2.本软件前台采用动态查询数据库表，制定好数据库后，自动显示数据表。
  后台目前只写死了historydata1，MinutesTable这两个数据表
  由于未知数据表，没有做其他表的查询逻辑【待优化】。

3.软件技术
  开发工具：IDEA【2019版/2020版】
  编程语言：Java【JDK1.8 及其以上】
  项目构建：maven【3.6/3.7 自行开发可根据idea版本进行集成】

4.打包部署
  mvn:clean
  mvn:compile
  mvn:package 或 mvn:assembly

5.服务器端运行测试
  找到项目路径下的target目录下打包好的jar文件，运行如下：
  java -jar demo-cems-1.0-SNAPSHOT-jar-with-dependencies.jar

6.开发者提示
  略



