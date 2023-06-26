package by.radevich.jstlexample.service;

import by.radevich.jstlexample.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> fiendAll();
    Product findById(String id);
    void save(Product product);
    void delete (String id);

  //  List<Product> fiendByPrice(int price);
}
