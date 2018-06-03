package com.popokis.popok.util.http;

import com.popokis.popok.data.access.Database;
import com.popokis.popok.data.access.HikariConnectionPool;
import com.popokis.popok.http.extractor.IdExtractor;
import com.popokis.popok.http.handler.BasicHandlerFactory;
import com.popokis.popok.http.handler.DataBaseHandler;
import com.popokis.popok.util.data.mapper.CompanyMapper;
import com.popokis.popok.util.data.mapper.EmployeeMapper;
import com.popokis.popok.util.data.model.Company;
import com.popokis.popok.util.data.model.Employee;
import com.popokis.popok.util.query.CompanyRepository;
import com.popokis.popok.util.query.EmployeeRepository;
import com.popokis.popok.util.service.CompanyEmployeeService;
import com.popokis.popok.util.validator.BasicValidator;
import com.popokis.popok.util.validator.IdValidator;
import io.undertow.server.HttpHandler;

public final class CompanyHandlerFactory {

  private CompanyHandlerFactory() {}

  public static BasicHandlerFactory<Company> crudCompany() {
    return new BasicHandlerFactory<>(
        new BasicValidator<>(),
        new BasicValidator<>(),
        "company",
        Company.class,
        new CompanyRepository(),
        new CompanyMapper(),
        new Database(HikariConnectionPool.getInstance()));
  }

  public static BasicHandlerFactory<Employee> crudEmployee() {
    return new BasicHandlerFactory<>(
        new BasicValidator<>(),
        new BasicValidator<>(),
        "company",
        Employee.class,
        new EmployeeRepository(),
        new EmployeeMapper(),
        new Database(HikariConnectionPool.getInstance()));
  }

  public static HttpHandler companyEmployee() {
    return new DataBaseHandler<>(
        new IdExtractor(),
        "company",
        Long::parseLong,
        new IdValidator(new BasicValidator<>()),
        new CompanyEmployeeService());
  }
}
