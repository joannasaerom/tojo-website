import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;
import java.sql.Timestamp;

public class Sunglasses extends Item {

  public static final String TYPE = "sunglasses";


  public Sunglasses(String _name, String _imgURL, String _description, int _price) {
    this.name = _name;
    this.imgURL = _imgURL;
    this.description = _description;
    this.price = _price;
    this.inventory = MAX_INVENTORY;
    this.type = TYPE;
  }


  public static List<Sunglasses> all() {
    String sql = "SELECT * FROM items WHERE type = 'sunglasses';";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
      .throwOnMappingFailure(false)
      .executeAndFetch(Sunglasses.class);
    }
  }


  public static Sunglasses find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM items where id = :id;";
      Sunglasses sunglasses = con.createQuery(sql)
      .addParameter("id", id)
      .throwOnMappingFailure(false)
      .executeAndFetchFirst(Sunglasses.class);
      return sunglasses;
    }
  }


}
