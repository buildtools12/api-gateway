package api_gateway_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayServcieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayServcieApplication.class, args);
	}
	
	
	@Bean
	public RestTemplate getRestTemplate() {
		
		return new RestTemplate();
		
	}

}
