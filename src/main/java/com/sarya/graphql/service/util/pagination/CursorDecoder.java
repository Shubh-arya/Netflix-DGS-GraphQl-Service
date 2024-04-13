package com.sarya.graphql.service.util.pagination;

import com.google.common.base.Strings;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.function.BiFunction;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class CursorDecoder implements BiFunction<String, Integer, Integer> {

  @Override
  public Integer apply(String cursor, Integer defaultValue) {
    if (Strings.isNullOrEmpty(cursor)) {
      return defaultValue;
    }
    var hash = Base64.getDecoder().decode(cursor.getBytes(StandardCharsets.UTF_8));
    var cursorLiteral = StringUtils.newStringUtf8(hash);
    try {
      return (Integer.valueOf(cursorLiteral.substring(5)));
    } catch (NumberFormatException nfe) {
      throw new RuntimeException("unparsable cursor: {}" + cursor);
    }
  }
}
