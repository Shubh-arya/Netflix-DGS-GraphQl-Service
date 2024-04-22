package com.sarya.graphql.service.application.port.in;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.sarya.graphql.service.codegen.types.Customer;
import com.sarya.graphql.service.codegen.types.PaginationInput;
import com.sarya.graphql.service.util.pagination.CursorDecoder;
import com.sarya.graphql.service.util.pagination.CursorEncoder;
import com.sarya.graphql.service.util.pagination.GenericConnection;
import graphql.relay.Connection;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@DgsComponent
@Slf4j
@AllArgsConstructor
public class CustomerResolver {

  private final CursorEncoder cursorEncoder;
  private final CursorDecoder cursorDecoder;

  @DgsQuery
  Connection<Customer> fetchCustomers(
      DataFetchingEnvironment dfe,
      @InputArgument PaginationInput paginationInput
  ) {
    log.info("pagination Input: {}", paginationInput);
    int offset = cursorDecoder.apply(paginationInput.getAfter(), 0);
    var customer = Customer.newBuilder().name("James").customerId(UUID.randomUUID())
        .email("james@email.com").build();
    return new GenericConnection<>(cursorEncoder, List.of(customer), offset).get(dfe);
  }
}
