package com.itvedant.petstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itvedant.petstore.entities.Product;

@Repository
public interface ProductRepository 
    extends JpaRepository<Product, Integer>{

        //CrudRepository ===> CRUD method
        //PagingAndSortingRepository ===> 
        //extends CrudRepository with added capability of paging and sorting
        //JpaRepository ===> extends PagingAndSortingRepository
    
}
