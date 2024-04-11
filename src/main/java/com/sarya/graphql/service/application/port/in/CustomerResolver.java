package com.sarya.graphql.service.application.port.in;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.sarya.graphql.service.codegen.types.Customer;
import com.sarya.graphql.service.codegen.types.PaginationInput;
import graphql.relay.Connection;
import graphql.relay.SimpleListConnection;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;

@DgsComponent
@Slf4j
public class CustomerResolver {
  @DgsQuery
  Connection<Customer> fetchCustomers(
      DataFetchingEnvironment dfe,
      @InputArgument PaginationInput paginationInput
  ) {
    log.info("pagination Input: {}", paginationInput);
    var customer = Customer.newBuilder().name("James").customerId(UUID.randomUUID())
        .email("james@email.com").build();
    return new SimpleListConnection<>(List.of(customer)).get(dfe);
  }
}
