package org.academico.springcloud.msvc.venta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// 1. @EnableJpaRepositories: Le dice a Spring Data JPA dónde encontrar tus interfaces
//    de repositorio (las que extienden JpaRepository).
@EnableJpaRepositories(basePackages = "org.academico.springcloud.msvc.venta.infrastructure.adapter.jpa.repository")

// 2. @EnableFeignClients: ¡LA CLAVE! Activa la maquinaria de Feign y le dice que busque
//    interfaces anotadas con @FeignClient en el paquete especificado.
@EnableFeignClients(basePackages = "org.academico.springcloud.msvc.venta.infrastructure.adapter.feign.client")
@SpringBootApplication
public class MsvcVentaApplication {
	public static void main(String[] args) {
		SpringApplication.run(MsvcVentaApplication.class, args);
	}
}
