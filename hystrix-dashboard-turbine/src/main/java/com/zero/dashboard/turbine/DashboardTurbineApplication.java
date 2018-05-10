package com.zero.dashboard.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * http://localhost:8001/hystrix 监控页面
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
public class DashboardTurbineApplication {

	public static void main(String[] args) {
        SpringApplication.run(DashboardTurbineApplication.class, args);
	}

}