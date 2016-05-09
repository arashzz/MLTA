package com.example.repositories;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.Visit;

@Transactional
@EnableJpaRepositories
@EntityScan(basePackages = {"com.example.entities"})
public interface IVisitRepository extends CrudRepository<Visit, Integer> {
	
	//@Query(value="select v from Visit v where v.visitDate >= ?1 and v.visitDate <=?2 and ")
	public List<Visit> findByVisitDateBetween(Date fromDate, Date toDate);
}
