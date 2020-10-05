package de.neuefische.productorderdi.service;

import de.neuefische.productorderdi.db.ProductDb;
import de.neuefische.productorderdi.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductDb productDb;

    public ProductService(ProductDb productDb) {
        this.productDb = productDb;
    }

    public List<Product> getProducts() {
        return productDb.getProductList();
    }

}
