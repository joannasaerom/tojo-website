import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;
import java.sql.Timestamp;

public class Sunglasses {
  private String name;
  private String imgURL;
  private String description;
  private int price;
  private int id;
  private int customerId;
  private int inventory;
  private Timestamp purchaseDate;

  public static final int MIN_INVENTORY = 0;
  public static final int MAX_INVENTORY = 10;

  public Sunglasses(String _name, String _imgURL, String _description, int _price) {
    this.name = _name;
    this.imgURL = _imgURL;
    this.description = _description;
    this.price = _price;
    this.inventory = MAX_INVENTORY;
  }

  public String getName() {
    return this.name;
  }

  public Timestamp getPurchaseDate() {
    return this.purchaseDate;
  }

  public String getImgUrl() {
    return this.imgURL;
  }

  public String getDescription() {
    return this.description;
  }

  public int getPrice() {
    return this.price;
  }

  public int getId() {
    return id;
  }

  public int getCustomerId(){
    return customerId;
  }

  public int getInventory() {
    return inventory;
  }

  public void setName(String _name) {
    this.name = _name;
  }

  public void setImgUrl(String _imgURL) {
    this.imgURL = _imgURL;
  }

  public void setPrice(int _price) {
    this.price = _price;
  }

  public void setDescription(String _description) {
    this.description = _description;
  }

  public void setCustomerId(int _customerId) {
    this.customerId = _customerId;
  }


  @Override
  public boolean equals(Object otherSunglasses) {
    if(!(otherSunglasses instanceof Sunglasses)) {
      return false;
    } else {
      Sunglasses newSunglasses = (Sunglasses) otherSunglasses;
      return this.getName().equals(newSunglasses.getName()) &&
       this.getImgUrl().equals(newSunglasses.getImgUrl()) &&
       this.getDescription().equals(newSunglasses.getDescription()) &&
       this.getPrice() == newSunglasses.getPrice() &&
       this.getId() == newSunglasses.getId() &&
       this.getCustomerId() == newSunglasses.getCustomerId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO sunglasses (name, description, imgURL, price) VALUES (:name, :description, :imgURL, :price);";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("description", this.description)
        .addParameter("imgURL", this.imgURL)
        .addParameter("price", this.price)
        .executeUpdate()
        .getKey();
    }
  }

  public void update() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE sunglasses SET (name, description, imgURL, price) = (:name, :description, :imgURL, :price) WHERE id = :id;";
      con.createQuery(sql)
      .addParameter("name", this.name)
      .addParameter("description", this.description)
      .addParameter("imgURL", this.imgURL)
      .addParameter("price", this.price)
      .addParameter("id", this.id)
      .executeUpdate();
    }
  }

  public static List<Sunglasses> all() {
    String sql = "SELECT * FROM sunglasses;";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Sunglasses.class);
    }
  }

  public static Sunglasses find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sunglasses where id = :id;";
      Sunglasses sunglasses = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Sunglasses.class);
      return sunglasses;
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM sunglasses WHERE id = :id;";
      con.createQuery(sql)
      .addParameter("id", this.id)
      .executeUpdate();
    }
  }

  public void purchase() {
    if (inventory <= MIN_INVENTORY) {
      throw new UnsupportedOperationException("Sorry these are out of stock");
    } else {

      try(Connection con = DB.sql2o.open()) {
        String sql = "UPDATE sunglasses SET (purchaseDate, customerId) = (now(), :customerId) WHERE id = :id;";
          con.createQuery(sql)
            .addParameter("id", this.id)
            .addParameter("customerId", this.customerId)
            .executeUpdate();
      }
    inventory--;
    }
  }

}
