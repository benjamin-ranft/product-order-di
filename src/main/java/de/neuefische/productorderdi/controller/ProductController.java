package de.neuefische.productorderdi.controller;

import de.neuefische.productorderdi.db.ProductDb;
import de.neuefische.productorderdi.model.Product;
import de.neuefische.productorderdi.service.ProductService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("product")

public class ProductController {

    private final ProductService service;
    private final ProductDb productDb;

    @Autowired
    public ProductController(ProductService service, ProductDb productDb) {
        this.service = service;
        this.productDb = productDb;
    }

    @GetMapping
    public List<Product> search(@RequestParam(required = false) String q){
        if (q == null || q.isBlank()){
            return productDb.getProductList();
        }
        return productDb.search(q);
    }


    /*@GetMapping (path="{q}")
    public List<Product> searchAlt(@PathVariable String q) {
        List<Product> searchList = new ArrayList<>();

        for (int i = 0; i < getProducts().size(); i++) {

            if (getProducts().get(i).getName().contains(q)){
                searchList.add(getProducts().get(i));
            }
        }
        return searchList;

}*/
}

