package com.epy.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epy.main.entity.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
	
	

}
