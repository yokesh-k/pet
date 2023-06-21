package com.itvedant.petstore.controllers;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.petstore.entities.Product;
import com.itvedant.petstore.services.ProductService;

@RestController
public class ProductController {
    //For accessing this api we need to provide
    //the endpoint ===> URL
    // @RequestMapping("/")
    // //This function is your api
    // public String getName(){
    //     return "my name is ekwinder";
    // }

    // @RequestMapping("/score")
    // public int getScore(){
    //     return 90;
    // }

    // @RequestMapping("/colors")
    // public List<String> getColors(){
    //     List<String> colors = Arrays.asList("red","blue","green","pink","yellow");
    //     return colors;
    // }

    @Autowired
    private ProductService productService;

    //@RequestMapping(path="/products", method = RequestMethod.GET)
    @GetMapping("/products")
    public Collection<Product> getProducts(){
        return this.productService.getAllProducts();
    }

    //@RequestMapping(path="/products/{id}", method = RequestMethod.GET)
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Integer id){
        return this.productService.getProductById(id);
    }

    //@RequestMapping(path="/products", method = RequestMethod.POST)
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        return this.productService.addProduct(product);
    }

    //@RequestMapping(path="/products/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable Integer id){
        return this.productService.deleteProduct(id);
    }

    //@RequestMapping(path="/products/{id}", method = RequestMethod.PUT)
    @PutMapping("/products/{id}")
    public String updateProduct(@PathVariable Integer id, 
                                    @RequestBody Product product){
        return this.productService.updateProduct(id, product);
    }
}
