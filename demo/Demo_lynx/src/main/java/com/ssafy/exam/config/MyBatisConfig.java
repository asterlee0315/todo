package com.ssafy.exam.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.ssafy.lynx.model.dao")
@Configuration
public class MyBatisConfig {

}
