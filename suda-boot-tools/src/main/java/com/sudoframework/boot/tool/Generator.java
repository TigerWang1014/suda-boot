package com.sudoframework.boot.tool;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * mybatis-plus 代码生成器
 */
public class Generator {

    //private static final String USERNAME = System.getenv().get("USER");
    private static final String USERNAME = "wangxinmin";

    /**
     * 项目信息
     */
    //private static final String PROJECT_PATH = System.getProperty("user.dir");

    private static final String PROJECT_PATH = "/Users/wangxinmin/IdeaProjects/suda-boot/suda-boot-service";
    private static final String JAVA_PATH = "/src/main/java";
    private static final String RESOURCE_PATH = "/src/main/resources";
    private static final String BASE_PACKAGE = "com.suda";

    /**
     * 数据库信息
     */
    private static final String DATABASE_IP = "127.0.0.1"; //IP
    private static final String DATABASE_PORT = "3310"; //端口
    private static final String DATABASE_USERNAME = "root"; //用户名
    private static final String DATABASE_PASSWORD = "123456"; //密码
    private static final String DATABASE_NAME = "suda_boot"; //库名


    public static void main(String[] args) {
        // 传入需要生成的表名，多个用英文逗号分隔，所有用 all 表示
        genCode("user_id_info");

    }


    /**
     * 代码生成
     */
    private static void genCode(String tables) {

        // 全局配置
        FastAutoGenerator.create(String.format("jdbc:mysql://%s:%s/%s?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false&serverTimezone=Asia/Shanghai", DATABASE_IP, DATABASE_PORT, DATABASE_NAME), DATABASE_USERNAME, DATABASE_PASSWORD)
                .globalConfig(builder -> {
                    builder.author(USERNAME) // 设置作者
                            .fileOverride()
                            // kotlin
                            //.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .commentDate("yyyy/MM/dd")
                            .outputDir(PROJECT_PATH + JAVA_PATH); // 指定输出目录
                })
                // 包配置
                .packageConfig(builder -> builder.parent(BASE_PACKAGE) // 设置父包名
                        .entity("po")
                        .mapper("mapper")
                        .service("service")
                        .serviceImpl("service.impl")
                        .controller("controller")
                        .pathInfo(Collections.singletonMap(OutputFile.mapperXml, PROJECT_PATH + RESOURCE_PATH + "/mapper")))// 设置mapperXml生成路径
                // 模版配置
                //.templateConfig(builder -> builder.disable(TemplateType.SERVICE) //禁用service
                //        .disable(TemplateType.SERVICEIMPL) //禁用service.impl
                //        .disable(TemplateType.CONTROLLER)) //禁用controller
                // 策略配置
                .strategyConfig(
                        builder -> builder.addInclude(getTables(tables)) // 设置需要生成的表名
                                //Controller策略配置
                                .controllerBuilder()
                                .enableRestStyle() //开启 restful风格,开启生成@RestController 控制器
                                .build()

                                //Service策略配置
                                .serviceBuilder()
                                .formatServiceFileName("%sService")
                                .formatServiceImplFileName("%sServiceImpl")
                                .build()

                                //Entity策略配置
                                .entityBuilder()
                                .enableLombok() //开启Lombok
                                .enableTableFieldAnnotation()//开启生成实体时生成字段注解
                                .build()

                                //Mapper策略配置
                                .mapperBuilder()
                                //.enableMapperAnnotation() // 开启 @Mapper 注解
                                .build()


                )
                //.templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }

    /**
     * 处理 all 和多表情况
     */
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }

}
