package com.abhishek.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.store.Repository.StoreRepository;
import com.abhishek.store.entity.StoreEntity;

@Service
public class StoreService {
	
	@Autowired
	StoreRepository repo;
	
	

	public List<StoreEntity> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Optional<StoreEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	public StoreEntity save(StoreEntity product) {
		// TODO Auto-generated method stub
		return repo.save(product);
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

}
