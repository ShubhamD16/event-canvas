package com.app.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Client;


public interface ClientDao extends JpaRepository<Client,Long>{
	
	public Optional<Client> findByEmailAndPassword(String email,String password);
	public void deleteById(Long id);
}
