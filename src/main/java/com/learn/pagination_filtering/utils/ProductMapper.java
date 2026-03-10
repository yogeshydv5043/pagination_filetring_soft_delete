package com.learn.pagination_filtering.utils;

import com.learn.pagination_filtering.dtos.requests.ProductRequest;
import com.learn.pagination_filtering.dtos.responses.ProductDTO;
import com.learn.pagination_filtering.dtos.responses.ProductResponse;
import com.learn.pagination_filtering.dtos.responses.ProductResponseV2;
import com.learn.pagination_filtering.models.Product;

public interface ProductMapper {

    public Product productRequestToProduct(ProductRequest productRequest);

    public ProductResponse productToProductResponse(Product products);

    public ProductDTO productToProductDto(Product products);

    public ProductResponseV2 productToCategoryResponseV2(Product products);


}
