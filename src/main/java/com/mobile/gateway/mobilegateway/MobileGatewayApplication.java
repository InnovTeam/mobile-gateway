package com.mobile.gateway.mobilegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class MobileGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileGatewayApplication.class, args);
	}
	
	@LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        RestTemplate template = new RestTemplate();
       /* List interceptors = template.getInterceptors();
        if (interceptors == null) {
            template.setInterceptors(Collections.singletonList(new UserContextInterceptor()));
        } else {
            interceptors.add(new UserContextInterceptor());
            template.setInterceptors(interceptors);
        }*/

        return template;
    }
}
