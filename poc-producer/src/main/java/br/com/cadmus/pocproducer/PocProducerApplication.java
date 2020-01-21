package br.com.cadmus.pocproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan(basePackages="br.com.cadmus")
public class PocProducerApplication extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PocProducerApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(PocProducerApplication.class, args);
	}

}
