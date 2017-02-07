package br.com.softplan.sajadv.service;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import javax.annotation.Resource;
import javax.ejb.Startup;
import javax.ejb.Singleton;
import org.flywaydb.core.Flyway;

@Startup
@Singleton
public class MigrateService {

  private static final Logger LOG = Logger.getAnonymousLogger();

  @Resource
  private DataSource ds;

  @PostConstruct
  @SuppressWarnings("unused")
  private void migrate() {
    // https://flywaydb.org/documentation/migration/sql
    // https://flywaydb.org/documentation/api/
    LOG.info("Rodando migrate de banco");
    Flyway flyway = new Flyway();
    flyway.setDataSource(ds);
    flyway.clean(); // comente esta linha para deixarmos de resetar os dados de teste
    flyway.migrate();
  }

}
