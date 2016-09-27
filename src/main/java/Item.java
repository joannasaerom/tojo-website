import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;
import java.sql.Timestamp;

public abstract class Item {
  public String name;
  public String imgURL;
  public String description;
  public int price;
  public int id;
  public int customerId;
  public int inventory;
  public String type;
  public Timestamp purchaseDate;

  public static final int MIN_INVENTORY = 0;
  public static final int MAX_INVENTORY = 10;

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
  public boolean equals(Object otherItem) {
    if(!(otherItem instanceof Item)) {
      return false;
    } else {
      Item newItem = (Item) otherItem;
      return this.getName().equals(newItem.getName()) &&
       this.getImgUrl().equals(newItem.getImgUrl()) &&
       this.getDescription().equals(newItem.getDescription()) &&
       this.getPrice() == newItem.getPrice() &&
       this.getId() == newItem.getId() &&
       this.getCustomerId() == newItem.getCustomerId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO item (name, description, imgURL, price) VALUES (:name, :description, :imgURL, :price);";
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
      String sql = "UPDATE item SET (name, description, imgURL, price) = (:name, :description, :imgURL, :price) WHERE id = :id;";
      con.createQuery(sql)
      .addParameter("name", this.name)
      .addParameter("description", this.description)
      .addParameter("imgURL", this.imgURL)
      .addParameter("price", this.price)
      .addParameter("id", this.id)
      .executeUpdate();
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM item WHERE id = :id;";
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
        String sql = "INSERT INTO user_purchases (customerId, itemId, purchaseDate, type) VALUES (:customerId, :itemId, now(),:type);";
          con.createQuery(sql)
            .addParameter("customerId", this.customerId)
            .addParameter("itemId", this.id)
            .addParameter("type", this.type)
            .executeUpdate();
      }
    inventory--;
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE items SET (inventory) = (:inventory) WHERE id = :id;";
        con.createQuery(sql)
          .addParameter("id", this.id)
          .addParameter("inventory", this.inventory)
          .executeUpdate();
        }
    }
  }

  

}
