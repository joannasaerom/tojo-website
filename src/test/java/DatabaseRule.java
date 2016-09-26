import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  @Override
  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/tojo_test", null, null);
  }

  @Override
  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String deleteUserQuery = "DELETE FROM users *;";
      String deleteSunglassesQuery = "DELETE FROM sunglasses *;";
      con.createQuery(deleteSunglassesQuery).executeUpdate();
      con.createQuery(deleteUserQuery).executeUpdate();
    }
  }
}
