package com.popokis.popok.service.db;

import com.popokis.popok.data.Database;
import com.popokis.popok.data.query.BasicRepository;
import com.popokis.popok.service.Service;

public final class InsertDBService<T> implements Service<T, Long> {

  private final Database db;
  private final BasicRepository<T> repository;

  public InsertDBService(BasicRepository<T> repository) {
    db = Database.getInstance();
    this.repository = repository;
  }

  @Override
  public Long call(T model) {
    return db.executeInsert(repository.save(model));
  }
}