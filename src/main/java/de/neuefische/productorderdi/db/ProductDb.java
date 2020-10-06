package de.neuefische.productorderdi.db;

import de.neuefische.productorderdi.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDb {

    private final List<Product> productList = List.of(
            new Product("Tiger","1"),
            new Product("Cat","2"));

    public List<Product> getProductList(){
        return productList;
    }

    public List<Product> search(String q) {
        List<Product> searchList = new ArrayList<>();
        String lowerCaseQ = q.toLowerCase();

        for (Product product : productList) {

            if (product.getName().toLowerCase().contains(lowerCaseQ)) {
                searchList.add(product);
            }
        }
        return searchList;}
}
