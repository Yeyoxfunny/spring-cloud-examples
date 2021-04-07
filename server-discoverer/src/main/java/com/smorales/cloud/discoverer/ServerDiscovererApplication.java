package com.smorales.cloud.discoverer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServerDiscovererApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerDiscovererApplication.class, args);
    }

}
