package de.neuefische.productorderdi.controller;

import de.neuefische.productorderdi.db.ProductDb;
import de.neuefische.productorderdi.model.Product;
import de.neuefische.productorderdi.service.ProductService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("product")

public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getProducts(){
    return service.getProducts();

}
    @GetMapping ("search")
    public List<Product> search(@RequestParam String q) {
        List<Product> searchList = new ArrayList<>();

        for (int i = 0; i < getProducts().size(); i++) {

            if (getProducts().get(i).getName().contains(q)){
                searchList.add(getProducts().get(i));
            }
        }
 	 return searchList;
    }

}
