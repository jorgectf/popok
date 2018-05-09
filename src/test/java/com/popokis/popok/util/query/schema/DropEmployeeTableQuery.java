package com.popokis.popok.util.query.schema;

import com.popokis.popok.data.Query;

import java.sql.PreparedStatement;

public final class DropEmployeeTableQuery implements Query {
  @Override
  public String query() {
    return "DROP TABLE IF EXISTS employee";
  }

  @Override
  public void parameters(PreparedStatement stm) {

  }
}
