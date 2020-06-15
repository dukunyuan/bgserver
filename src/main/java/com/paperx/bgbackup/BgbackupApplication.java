package com.paperx.bgbackup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.paperx.bgbackup.mapper")//使用MapperScan批量扫描所有的Mapper接口；
public class BgbackupApplication {

	public static void main(String[] args) {
		SpringApplication.run(BgbackupApplication.class, args);
	}

}
