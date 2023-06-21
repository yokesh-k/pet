package com.itvedant.petstore.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.itvedant.petstore.entities.Product;

@Service
public class ProductService {
    private Map<Integer, Product> products = new HashMap<>();
    private AtomicInteger atomic = new AtomicInteger();

    public ProductService(){
        Product p1 = new Product();
        p1.setId(atomic.incrementAndGet());
        p1.setName("Super Fun Toy Flavored Paw Print Rubber Bone Dog Toy");
        p1.setPrice(194.00);
        p1.setManufacturer("Super");
        p1.setDescription("Super Fun Toy Flavored Paw Print Rubber Bone Dog Toy");

        Product p2 = new Product();
        p2.setId(atomic.incrementAndGet());
        p2.setName("Pedigree Biscrok Biscuits With Chicken");
        p2.setPrice(281.90);
        p2.setManufacturer("Pedigree");
        p2.setDescription("Pedigree Biscrok Biscuits With Chicken is complementary pet food for adult dogs. It is fantastically crunchy biscuit with chicken flavour.");

        products.put(p1.getId(), p1);
        products.put(p2.getId(), p2);
    }

    public Collection<Product> getAllProducts(){
        return products.values();
    }

    public Product getProductById(Integer id){
        return products.get(id);
    }

    public Product addProduct(Product product){
        product.setId(atomic.incrementAndGet());
        products.put(product.getId(),product);
        return product;
    }

    public String deleteProduct(Integer id){
        Product productExists = products.get(id);
        if(productExists != null){
            products.remove(id);
            return "product deleted successfully";
        }
        else{
            return "no such product exists";
        }
    }

    public String updateProduct(Integer id, Product product){
        Product productExists = products.get(id);
        if(productExists != null){
            product.setId(id);
            products.put(id, product);
            return "product updated successfully";
        }
        else{
            return "no such product exists";
        }
    }
}
