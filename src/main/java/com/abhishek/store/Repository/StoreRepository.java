package com.abhishek.store.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhishek.store.entity.StoreEntity;

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, Long> {

}
