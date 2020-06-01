# muti-datasource
springboot配置多数据源
支持多数据源操作,注意要排除springboot自身datasource检测

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
