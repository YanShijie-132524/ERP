# ERP

企业进销存系统后端示例，基于 Java 21 和 Spring Boot 3 实现。

## 运行方式

项目使用 Gradle 进行构建，确保本地安装 JDK 21 后执行：

```bash
gradle bootRun
```

默认使用 H2 内存数据库，可通过 `http://localhost:8080/h2-console` 访问数据库控制台。
