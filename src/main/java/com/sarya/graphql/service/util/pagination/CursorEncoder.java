package com.sarya.graphql.service.util.pagination;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class CursorEncoder implements Function<Integer, String> {

  @Override
  public String apply(Integer offset) {
    byte[] bytes = ("prefix" + offset).getBytes(StandardCharsets.UTF_8);
    return Base64.getEncoder().encodeToString(bytes);
  }
}
