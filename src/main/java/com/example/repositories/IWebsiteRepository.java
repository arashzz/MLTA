package com.example.repositories;

import javax.transaction.Transactional;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.example.entities.Website;

@Transactional
@EnableJpaRepositories
@EntityScan(basePackages = {"com.example.entities"})
public interface IWebsiteRepository extends CrudRepository<Website, Integer>{

	public Website findByUrl(String url);
}
