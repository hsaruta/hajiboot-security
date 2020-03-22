package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    //@Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")
    //List<Customer> findAllOrderByName();

	//@Query("SELECT x FROM Customer x WHERE x.id >= 3")
	@Query("SELECT x FROM Customer x WHERE x.user.username LIKE '%user2%'")
	//@Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")
    List<Customer> findAllOrderByName();	   	
	
	@Query("select x from Customer x where x.user.username LIKE :value")
	public List<Customer> findUserValue(@Param("value") String value);
	
	
    @Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")
    Page<Customer> findAllOrderByName(Pageable pageable);
}

