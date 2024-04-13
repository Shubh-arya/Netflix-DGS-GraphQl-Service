package com.sarya.graphql.service.util.pagination;

import graphql.relay.ConnectionCursor;
import graphql.relay.DefaultPageInfo;
import lombok.ToString;

@ToString
public class GenericPageInfo extends DefaultPageInfo {

  private final long totalCount;

  public GenericPageInfo(
      ConnectionCursor startCursor,
      ConnectionCursor endCursor,
      boolean hasPreviousPage,
      boolean hasNextPage,
      long totalCount
  ) {
    super(startCursor, endCursor, hasPreviousPage, hasNextPage);
    this.totalCount = totalCount;
  }
}
