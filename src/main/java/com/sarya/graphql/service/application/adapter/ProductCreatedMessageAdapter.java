package com.sarya.graphql.service.application.adapter;

import com.sarya.graphql.service.ProductCreatedEvent;

public interface ProductCreatedMessageAdapter {
  boolean sendProductCreatedMessage(ProductCreatedEvent event);
}
