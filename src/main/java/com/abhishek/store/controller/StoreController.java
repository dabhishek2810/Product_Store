package com.abhishek.store.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.store.entity.StoreEntity;
import com.abhishek.store.service.StoreService;

@RestController
@RequestMapping("/product")
public class StoreController {
	
	@Autowired
	StoreService service;
	
	@GetMapping("/getAll")
	public List<StoreEntity> getAllProducts(){
		return service.getAll();
	}
	
	 @GetMapping("/{id}")
	    public ResponseEntity<StoreEntity> getProductById(@PathVariable Long id) {
	        Optional<StoreEntity> product = service.findById(id);
			return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	 }
	 
	 @PostMapping
	 public StoreEntity createPrduct(@RequestBody StoreEntity product ) {
		 
		 return service.save(product);
	 }
	 
	 @PutMapping("/{id}")
	 ResponseEntity<StoreEntity> updateProduct(@PathVariable Long id,@RequestBody StoreEntity productDetails){
		 Optional<StoreEntity> product = service.findById(id);
		 if(product.isPresent()) {
			 StoreEntity entity = product.get();
			 entity.setCategory(productDetails.getCategory());
			 entity.setDescription(productDetails.getDescription());
			 entity.setImage(productDetails.getImage());
			 entity.setPrice(productDetails.getPrice());
			 entity.setTitle(productDetails.getTitle());
			 return ResponseEntity.ok(service.save(entity));
		 }
		 else {
			 return ResponseEntity.notFound().build();
		 }
	 }
	 
	 @DeleteMapping("/{id}")
	 ResponseEntity<StoreEntity> deleteProduct(@PathVariable Long id){
		 service.deleteById(id);
		 return ResponseEntity.noContent().build();
	 }
}
