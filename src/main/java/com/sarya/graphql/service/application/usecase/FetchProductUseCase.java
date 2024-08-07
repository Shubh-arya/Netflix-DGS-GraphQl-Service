package com.sarya.graphql.service.application.usecase;

import com.sarya.graphql.service.codegen.types.Product;
import java.util.List;

@FunctionalInterface
public interface FetchProductUseCase {
  List<Product> execute();
}
