# springboot-mybatis

一个基于Spring Boot & MyBatis的项目，用于快速构建中小型API、RESTful API项目，该项目稳定、简单、快速，使我们摆脱那些重复劳动，专注于业务代码的编写。还涉及到MyBatisb通用Mapper插件、MyBatis PageHelper分页插件以及Fastjson等，若不清楚可以去查看相应的官网文档。

## 快速开始

*   克隆项目；
*   对test包内的代码生成器CodeGenerator进行配置，主要是JDBC，因为要根据表名来生成代码；
*   输入表名，运行CodeGenerator.main()方法，生成基础代码（可能需要刷新项目目录才会出来）；
*   根据业务在基础代码上进行扩展；
*   对开发环境配置文件application-dev.properties进行配置，启动项目。
#### PS：本案例中已有t_user表的案例，若不需要可以删除dao,model,service,web以及resource下的mapper目录!

<<<<<<< HEAD
## 集成了swagger-ui

*  直接运行项目即可
=======
## 项目端口,我给指定的默认 
    server.port=8999
>>>>>>> de7da596aa570b3cf9f489e87f13d85c9f4fa380
