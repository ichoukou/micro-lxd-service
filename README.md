# micro-lxd-service
spring-cloud 微服务组件demo

<table>
<tbody><tr>
<td>**工程名**</td>  <td>**描述**</td>  <td>**端口**</td>
</tr>
<tr>
<td>config-server</td>  <td>配置管理中心</td>  <td>7200</td>
</tr>
<tr>
<td>eureka-server</td>  <td>服务发现与注册中心 </td>  <td>7100</td>
</tr>

<tr>
<td>eureka-server</td>  <td>服务发现与注册中心 </td>  <td>7100</td>
</tr>

<tr>
<td>web-lovehome</td>  <td>房Web lovehome </td>  <td>8100</td>
</tr>


<tr>
<td>service-housing</td>  <td>房源服务 lovehome </td>  <td>8200</td>
</tr>

<tr>
<td>ervice-customer</td>  <td>客源服务 lovehome </td>  <td>8300</td>
</tr>
  

<tr>1、list copy； 2、eureka 红色告警; 3、mybatis官网看看;4、分布式启动；5、负载均衡测试；6、注册中心高可用命令启动;
7、微服务架构事务怎么控制; 8、OGNL表达式、Spring EL  ; 9、html5（HTML5规范要求⽤户⾃定义属性以data-前缀开头）    ； 10、java Bean、EJB、POJO；11、PO； 12、VO、13、DTO；13、xmls</tr>

<tr>阿里云不挂断运行命令 nohup java -jar XXX.jar & </tr>
<tr>1. 查看端口号占用情况：netstat -apn|grep 80  (ESTABLISHED6426/lighttpd)</tr>
<tr>2. 确定进程号: ps -aux|grep <进程号> </tr>
<tr>3. 3. 杀掉该进程 : kill -9 <pid></tr>

<tr>mvn package</tr>
<tr>spring boot启动命令：java -jar hello-service-0.0.1-SNAPSHOT.jar --server.port=8081</tr>
</tbody></table>
