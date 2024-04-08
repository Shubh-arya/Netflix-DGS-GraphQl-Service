package com.sarya.graphql.service.adapter.message.out;

import com.sarya.graphql.service.ProductCreatedEvent;
import com.sarya.graphql.service.application.adapter.ProductCreatedMessageAdapter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class CreateProductProducer implements ProductCreatedMessageAdapter {

  private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

  @Override
  public boolean sendProductCreatedMessage(ProductCreatedEvent event) {
    var result = kafkaTemplate.send((new GenericMessage<>(event)));
    return result.isDone();
  }
}
