package de.neuefische.productorderdi.db;

import de.neuefische.productorderdi.model.Product;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public class ProductDb {

    private final List<Product> productList = List.of(
            new Product("Tiger","1"),
            new Product("Cat","2"));

    public List<Product> getProductList(){
        return productList;
    }
}
