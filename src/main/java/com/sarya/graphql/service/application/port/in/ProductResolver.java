package com.sarya.graphql.service.application.port.in;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.sarya.graphql.service.application.usecase.CreateProductUseCase;
import com.sarya.graphql.service.application.usecase.FetchProductUseCase;
import com.sarya.graphql.service.codegen.types.CreateProductInput;
import com.sarya.graphql.service.codegen.types.Product;
import com.sarya.graphql.service.codegen.types.ProductStatus;
import com.sarya.graphql.service.codegen.types.ProductType;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

@DgsComponent
@Slf4j
@AllArgsConstructor
public class ProductResolver {
  private final FetchProductUseCase fetchProductUseCase = () -> List.of(
      Product.newBuilder().productId(UUID.randomUUID()).productType(ProductType.BIKE)
          .productStatus(ProductStatus.AVAILABLE).active(true).shopId(UUID.randomUUID())
          .name("Honda").build()
  );

  private final CreateProductUseCase createProductUseCase;

  @DgsQuery
  public List<Product> fetchProducts() {
    return fetchProductUseCase.execute();
  }

  @DgsMutation
  public boolean createProduct(@InputArgument CreateProductInput input) {
    log.info("incoming message: {}", input);
    Product output = new Product();
    BeanUtils.copyProperties(input, output, Product.class);
    output.setProductId(UUID.randomUUID());
    createProductUseCase.execute(output);
    return true;
  }
}
