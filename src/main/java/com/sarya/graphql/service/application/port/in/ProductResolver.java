package com.sarya.graphql.service.application.port.in;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.sarya.graphql.service.codegen.DgsConstants;
import com.sarya.graphql.service.codegen.types.Product;
import com.sarya.graphql.service.codegen.types.ProductStatus;
import com.sarya.graphql.service.codegen.types.ProductType;

import java.util.List;
import java.util.UUID;

@DgsComponent
public class ProductResolver {

    @DgsQuery(field = DgsConstants.QUERY.FetchProducts)
    public List<Product> fetchProducts() {
        return List.of(Product.newBuilder().productId(1)
                .productType(ProductType.BIKE)
                .productStatus(ProductStatus.AVAILABLE)
                .active(true)
                .shopId(UUID.randomUUID())
                .name("Honda")
                .build());
    }
}
