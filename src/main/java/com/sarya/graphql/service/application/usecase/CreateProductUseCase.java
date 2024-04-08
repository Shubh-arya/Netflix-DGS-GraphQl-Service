package com.sarya.graphql.service.application.usecase;

import com.sarya.graphql.service.codegen.types.Product;

@FunctionalInterface
public interface CreateProductUseCase {
  boolean execute(Product product);
}
