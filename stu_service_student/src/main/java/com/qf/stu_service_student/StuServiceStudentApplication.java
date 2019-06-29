package com.qf.stu_service_student;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qf")
@MapperScan("com.qf.dao")
@DubboComponentScan("com.qf.service")
public class StuServiceStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StuServiceStudentApplication.class, args);
    }

}
