#  Users Service

### Contents
- [Dependencies](#dependencies)
- [Configuration](#configuration)
- [Installation](#installation)
- [Swagger URL](#swagger-url)


##  Dependencies
The following items should be installed in your system:
+  Java --version  jdk1.8
```shell
$ java -version
java version "1.8.0_201"
Java(TM) SE Runtime Environment (build 1.8.0_201-b09)
Java HotSpot(TM) 64-Bit Server VM (build 25.201-b09, mixed mode)
```

+  Maven -- version 3.5
```shell
$ mvn --version
Apache Maven 3.5.2 (138edd61fd100ec658bfa2d307c43b76940a5d7d; 2017-10-18T03:58:13-04:00)
Maven home: c:\maven\apache-maven-3.5.2\bin\..
Java version: 1.8.0_201, vendor: Oracle Corporation
Java home: C:\Program Files\Java\jdk1.8.0_201\jre
Default locale: es_ES, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```

+  Git tools ( https://help.github.com/articles/set-up-git )
```shell
$ git --version
git version 2.10.1 (NNNN Git-78)
```


## Configuration 
##### application.yml
   The location of the configuration file is:   
    
   `tis-users-service\users-servive\src\main\resorces\application.yml`
   + Default configuration.
   
   ```yaml
   erver:
     port: 8080
   
   spring:
     datasource:
       hikari:
         jdbcUrl: jdbc:mysql://localhost:3306/users?useSSL=false
         username: root
         password: root
         driverClassName: com.mysql.jdbc.Driver
         maximumPoolSize: 5
     jpa:
       properties:
         hibernate:
           dialect: org.hibernate.dialect.MySQL5InnoDBDialect
           transaction:
             flush_before_completion: true
           hbm2ddl:
             auto: create
           show_sql: true
   
   eureka:
     client:
       registerWithEureka: true
       fetchRegistry: true
       serviceUrl:
         defaultZone: http://localhost:8761/eureka/
   
   users.account.status: ACTIVATED_ALLOWED
   ```
##### bootstrap.yml
   The location of the configuration file is:   
    
   ``tis-users-service\users-servive\src\main\resorces\bootstrap.yml``
   
   + Default configuration.
   
   ```yaml
   spring:
       application:
           name: users-service
   ```

## Installation 
#### Steps:
+ __In the command line execute.__ 
```
git clone https://bitbucket.org/smzeballos/tis-users-service/src/master/
```

+ __For build the artifact  go to '\tis-users-service' folder and execute the console commands.__
```
cd tis-users-service
```

+ __Execute the following command to remove the target directory with all the build data before starting so that it is fresh.__ 
```
mvn clean
```

+ __Execute the following command to compile your application sources.__ 
```
mvn compile
```

+ __Execute the following command to make a JAR file of project.__
```
mvn package
```

## Run Artifacts

##### Execute the command: 
+ Run the project with default profile using port default 8761:

    `java -jar users-service/target/users-service.jar`   
+ Run the project with port assigned:

    `java -Dserver.port=7070 -jar users-service/target/users-service.jar`
 
## Swagger Url
The project browser is available on:
+ Service.name: `users-service`
+ Server.port: `8080`

```
http://localhost:8080/swagger-ui.html
```

