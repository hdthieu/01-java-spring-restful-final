package vn.hoidanit.jobhunter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//disable security
// @SpringBootApplication(exclude = { // bỏ qua các cấu hình mặc định của Spring Security (exclude)
// 		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
// 		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
// })

@SpringBootApplication
public class JobhunterApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobhunterApplication.class, args);
	}

}
