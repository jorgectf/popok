package com.popokis.popok.dummy;

import com.popokis.popok.data.Query;

import java.sql.PreparedStatement;

public final class CreateTableQuery implements Query {
  @Override
  public String query() {
    return "CREATE TABLE IF NOT EXISTS test (id INT UNSIGNED NOT NULL AUTO_INCREMENT, name VARCHAR(255), PRIMARY KEY (id))";
  }

  @Override
  public void parameters(PreparedStatement stm) {

  }
}
