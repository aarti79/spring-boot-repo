package com.example.autoconfig;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@AutoConfigureAfter({ WebMvcAutoConfiguration.class })
@RestController
public class MyCustomAutoConfig {
	
	@RequestMapping({ "/autoConfigure" })
	String sayHey() {
	return "Hey I've been auto discovered!! ";
	}


}
