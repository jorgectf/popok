package com.popokis.popok.util.query.schema;

import com.popokis.popok.data.query.Query;

import java.sql.PreparedStatement;

public final class DropCompanyTableQuery implements Query {
  @Override
  public String query() {
    return "DROP TABLE IF EXISTS company";
  }

  @Override
  public void parameters(PreparedStatement stm) {

  }
}
