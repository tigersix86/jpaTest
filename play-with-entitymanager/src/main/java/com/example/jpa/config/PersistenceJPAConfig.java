package com.example.jpa.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.jpa.repository.ExtendedRepositoryImpl;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.jpa.repository", repositoryBaseClass = ExtendedRepositoryImpl.class)
@EnableJpaAuditing
@EnableTransactionManagement
public class PersistenceJPAConfig {

	@Bean
	public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

}
