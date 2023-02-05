package com.xerotech.funcx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FuncXDataBaseFastGeneratorTests {
    @Value("${spring.datasource.url}")
    String jdbcUrl;
    @Value("${spring.datasource.username}")
    String dbUser;
    @Value("${spring.datasource.password}")
    String dbPassword;
    @Test
    public void genEntity() {

        List<String> ts = new ArrayList<>(Arrays.asList("user","user_login"));
        FastAutoGenerator
                .create(jdbcUrl,dbUser,dbPassword)
                .globalConfig(builder -> {
                    builder.author("XJC-git") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("src/main/java"); // 指定输出目录
                }).packageConfig(builder -> {
            builder.parent("com.xerotech") // 设置父包名
                    .moduleName("funcx") // 设置父包模块名
                    .pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                            "src/main/resources/mapper")); // 设置mapperXml生成路径
        }).strategyConfig(builder -> {
            builder.addInclude(ts);// 设置需要生成的表名;
                    //.addTablePrefix("t_"); // 设置过滤表前缀
        }).templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateConfig(builder -> builder.controller("")) // 不生成controller
                .execute();

    }
}
