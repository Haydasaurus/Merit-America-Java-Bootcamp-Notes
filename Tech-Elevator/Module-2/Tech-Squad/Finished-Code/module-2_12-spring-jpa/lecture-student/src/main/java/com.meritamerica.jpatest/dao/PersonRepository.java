package com.meritamerica.jpatest.dao;

import java.util.List;

import com.meritamerica.jpatest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

//@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends JpaRepository<Person, Long> {

	List<Person> findByLastName(@Param("name") String name);


}