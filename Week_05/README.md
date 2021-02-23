## 一、Spring Bean 装配
1、自动装配注解@Component

2、自动装配扫描注解 @ComponentScan("ass5")

3、自动装配 xml 扫描 applicationContext.xml  
```xml
    <context:component-scan base-package="ass5"/>
```

4、@Autowired注解

5、显式装配注解 @Bean + @Configuration

6、XML显式装配

## 二、自动配置和 Starter
starter: school-spring-boot-starter
应用配置：SpringBean / application.yml

## 三、JDBC和连接池
jdbc-demo