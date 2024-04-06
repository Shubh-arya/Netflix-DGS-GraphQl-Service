package com.sarya.graphql.service.application.port.in;

import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductConsumer {

  @KafkaListener(topics = {"create-product"}, groupId = "sample-service-group")
  public void consumeProducts(GenericRecord event) {
    log.info("message: {}", event);
  }
}
