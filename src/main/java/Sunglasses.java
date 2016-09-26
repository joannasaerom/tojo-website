import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;
// import java.sql.Date;

public class Sunglasses {
  private String name;
  private String imgURL;
  private String description;
  private int price;
  private int id;
  private int customerId;
  // private Date purchaseDate;

  public Sunglasses(String _name, String _imgURL, String _description, int _price) {
    this.name = _name;
    this.imgURL = _imgURL;
    this.description = _description;
    this.price = _price;
  }

  public String getName() {
    return this.name;
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

  // public void setName(String _name) {
  //   this.name = _name;
  // }
  //
  // public void setImgUrl(String _imgURL) {
  //   this.imgURL = _imgURL;
  // }
  //
  // public void setPrice(int _price) {
  //   this.price = _price;
  // }

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

  public static List<Sunglasses> all() {
    String sql = "SELECT * FROM sunglasses;";
    try (Connection con = DB.sql2o.open()) {
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
}
