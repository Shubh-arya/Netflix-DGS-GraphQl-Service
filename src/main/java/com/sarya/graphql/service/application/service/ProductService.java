package com.sarya.graphql.service.application.service;

import com.sarya.graphql.service.ProductCreatedEvent;
import com.sarya.graphql.service.ProductStatus;
import com.sarya.graphql.service.ProductType;
import com.sarya.graphql.service.application.adapter.ProductCreatedMessageAdapter;
import com.sarya.graphql.service.application.usecase.CreateProductUseCase;
import com.sarya.graphql.service.codegen.types.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService implements CreateProductUseCase {

  private final ProductCreatedMessageAdapter adapter;

  @Override
  public boolean execute(Product product) {
    log.info("incoming message: {}", product);
    var productCreatedEvent = ProductCreatedEvent.newBuilder()
        .setProductId(product.getProductId().toString()).setName(product.getName())
        .setProductStatus(ProductStatus.valueOf(product.getProductStatus().toString()))
        .setProductType(ProductType.valueOf(product.getProductType().toString()))
        .setActive(product.getActive()).build();
    return adapter.sendProductCreatedMessage(productCreatedEvent);
  }
}
