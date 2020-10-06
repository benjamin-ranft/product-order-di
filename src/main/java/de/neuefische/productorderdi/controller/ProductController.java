package de.neuefische.productorderdi.controller;

import de.neuefische.productorderdi.db.ProductDb;
import de.neuefische.productorderdi.model.Product;
import de.neuefische.productorderdi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}

