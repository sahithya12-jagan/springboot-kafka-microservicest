package org.example.servicediscovery_feb2026;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServiceDiscoveryFeb2026Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDiscoveryFeb2026Application.class, args);
    }

}
