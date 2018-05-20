package com.popokis.popok.util.query;

import com.popokis.popok.data.query.BasicRepository;
import com.popokis.popok.data.query.DefaultAllQuery;
import com.popokis.popok.data.query.DefaultDeleteQuery;
import com.popokis.popok.data.query.DefaultFindQuery;
import com.popokis.popok.data.query.Query;
import com.popokis.popok.data.query.QueryGenerator;
import com.popokis.popok.util.data.model.Company;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class CompanyRepository implements BasicRepository<Company> {

  private final String tableName;
  private final QueryGenerator queryGenerator;

  public CompanyRepository() {
    tableName = "company";
    queryGenerator = new QueryGenerator("c_");
  }

  @Override
  public Query save(Company company) {
    return new Query() {
      @Override
      public String query() {
        return "INSERT INTO " + tableName + " (" + queryGenerator.putPrefix("name") + ") VALUES(?)";
      }

      @Override
      public void parameters(PreparedStatement stm) {
        try {
          stm.setString(1, company.name());
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
      }
    };
  }

  @Override
  public Query modify(Company company) {
    return new Query() {
      @Override
      public String query() {
        return "UPDATE " + tableName + " SET " + queryGenerator.putQuestionMark("name") + " WHERE " +
            queryGenerator.putQuestionMark("id");
      }

      @Override
      public void parameters(PreparedStatement stm) {
        try {
          stm.setString(1, company.name());
          stm.setLong(2, company.id());
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
      }
    };
  }

  @Override
  public Query find(long id) {
    return new DefaultFindQuery(id, tableName, queryGenerator);
  }

  @Override
  public Query remove(long id) {
    return new DefaultDeleteQuery(id, tableName, queryGenerator);
  }

  @Override
  public Query all() {
    return new DefaultAllQuery(tableName);
  }
}
