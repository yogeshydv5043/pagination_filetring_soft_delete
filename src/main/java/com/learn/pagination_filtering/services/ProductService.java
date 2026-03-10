package com.learn.pagination_filtering.services;

import com.learn.pagination_filtering.dtos.requests.ProductRequest;
import com.learn.pagination_filtering.dtos.responses.ProductDTO;
import com.learn.pagination_filtering.dtos.responses.ProductResponse;
import com.learn.pagination_filtering.dtos.responses.ProductResponseV2;

import java.util.List;

public interface ProductService {

    ProductDTO createProduct(ProductRequest request);

    ProductResponse getProduct(Long id);

    List<ProductResponseV2> getAllProducts();

    ProductResponse updateProduct(Long id, ProductRequest request);

    void deleteProduct(Long id);

}