package com.sarya.graphql.service.util.pagination;

import graphql.relay.Connection;
import graphql.relay.DefaultConnection;
import graphql.relay.DefaultConnectionCursor;
import graphql.relay.DefaultEdge;
import graphql.relay.DefaultPageInfo;
import graphql.relay.Edge;
import graphql.relay.PageInfo;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GenericConnection<T> implements DataFetcher<Connection<T>> {

  private final CursorEncoder cursorEncoder;

  private final List<T> data;
  private final int offset;

  @Override
  public Connection<T> get(DataFetchingEnvironment environment) {
    List<Edge<T>> edges = buildEdges();

    if (edges.size() == 0) {
      return emptyConnection();
    }

    var firstEdge = edges.get(0);
    var lastEdge = edges.get(edges.size() - 1);

    return new DefaultConnection<>(
        edges,
        new GenericPageInfo(firstEdge.getCursor(), lastEdge.getCursor(), false, false, edges.size())
    );
  }

  private Connection<T> emptyConnection() {
    PageInfo pageInfo = new DefaultPageInfo(null, null, false, false);
    return new DefaultConnection<>(List.of(), pageInfo);
  }

  private List<Edge<T>> buildEdges() {
    List<Edge<T>> edges = new ArrayList<>();
    int ix = 0;
    for (T object : data) {
      edges.add(
          new DefaultEdge<>(object, new DefaultConnectionCursor(cursorEncoder.apply(offset + ix++)))
      );
    }
    return edges;
  }

}
