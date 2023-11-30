package com.ecommerce.midterm.service;

import com.ecommerce.midterm.iservice.IProduct;
import com.ecommerce.midterm.model.Product;
import com.ecommerce.midterm.repository.ProductRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class ProductService implements IProduct {
    @Autowired
    private ProductRepos productRepos;
    private Iterable<? extends Product> allProduct;


    @Override
    public List<Product> selectAll() {
        return productRepos.findAll();
    }

    @Override
    public Page<Product> selectAll(Pageable pageable) {
        return productRepos.findAll(pageable);
    }

    @Override
    public Product selectById(Integer id) {
        return productRepos.findById(id).orElse(null);
    }

    @Override
    public Product insert(Product product) {
        return productRepos.save(product);
    }

    @Override
    public boolean deleteById(Integer id) {
        if (productRepos.existsById(id))
            productRepos.deleteById(id);
        return !productRepos.existsById(id);
    }

    @Override
    public Product update(Product productUpdate) {
        return productRepos.save(productUpdate);
    }

    @Override
    public List<Product> searchProductByKeyword(String keyword) {

        List<Product> products = new ArrayList<>();
        List<Product> searchProductsByString = productRepos.searchProductsByString(keyword);

        List<Product> searchByPrice = null;
        if (isDouble(keyword)) {
            double priceKey = Double.parseDouble(keyword);
            Double minPrice = priceKey - 20000;
            Double maxPrice = priceKey + 20000;
            searchByPrice = productRepos.findByPriceBetween(minPrice, maxPrice);
        }

        Product searchById = null;
        if (isInteger(keyword)) {
            Integer id = Integer.parseInt(keyword);
            searchById = selectById(id);
        }

        if (searchProductsByString != null && !searchProductsByString.isEmpty()) {
            products.addAll(searchProductsByString);
        }

        if (searchByPrice != null && !searchByPrice.isEmpty()) {
            products.addAll(searchByPrice);
        }

        if (searchById != null) {
            products.add(searchById);
        }

        return getProductsOnSale(products);
    }



    @Override
    public List<Product> findByPriceBetween(int index) {
        return switch (index) {
            case 1 -> productRepos.findByPriceBetween(0.0, 100000.0);
            case 2 -> productRepos.findByPriceBetween(100000.0, 300000.0);
            case 3 -> productRepos.findByPriceBetween(300000.0, 600000.0);
            default -> productRepos.findByPriceBetween(600000.0, 60000000.0);
        };
    }

    @Override
    public List<Product> getProductsOnSale(List<Product> productList) {
        List<Product> products = new ArrayList<>();
        if (allProduct != null) {
            for (Product product : allProduct) {
                if (product.getSale())
                    products.add(product);
            }
        }
        return products;
    }

    @Override
    public List<Product> searchProductByAuthor(UUID keyword) {
        List<Product> products = productRepos.searchProductsByString(id);
        return products;
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
