import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class User {
  private String name;
  private int creditCardNum;
  private String phone;
  private String email;
  private String street;
  private String city;
  private String state;
  private int zipcode;
  private int id;

  public User(String _name, int _ccNum, String _phone, String _email, String _street, String _city, String _state, int _zipcode) {
    this.name = _name;
    this.creditCardNum = _ccNum;
    this.phone = _phone;
    this.email = _email;
    this.street = _street;
    this.city = _city;
    this.state = _state;
    this.zipcode = _zipcode;
  }

  public String getName() {
    return this.name;
  }

  public int getCreditCardNum() {
    return this.creditCardNum;
  }

  public String getPhone() {
    return this.phone;
  }

  public String getEmail() {
    return this.email;
  }

  public String getStreet() {
    return this.street;
  }

  public String getCity() {
    return this.city;
  }

  public String getState() {
    return this.state;
  }

  public int getZipcode() {
    return this.zipcode;
  }

  public int getId() {
    return this.id;
  }

  // public void setName(String _name) {
  //   this.name = _name;
  // }
  //
  // public void setCreditCardNum(int _ccInfo) {
  //   this.creditCardNum = _ccInfo;
  // }
  //
  // public void setPhone(String _phone) {
  //   this.phone = _phone;
  // }
  //
  // public void setEmail(String _email) {
  //   this.email = _email;
  // }
  //
  // public void setStreet(String _street) {
  //   this.street = _street;
  // }
  //
  // public void setCity(String _city) {
  //   this.city = _city;
  // }
  //
  // public void setState(String _state) {
  //   this.state = _state;
  // }
  //
  // public void setZipcode(int _zipcode) {
  //   this.zipcode = _zipcode;
  // }


  @Override
  public boolean equals(Object otherUser) {
    if (!(otherUser instanceof User)) {
      return false;
    } else {
      User newUser = (User) otherUser;
      return this.getName().equals(newUser.getName()) &&
      this.getCreditCardNum() == newUser.getCreditCardNum() &&
      this.getPhone().equals(newUser.getPhone()) &&
      this.getEmail().equals(newUser.getEmail()) &&
      this.getStreet().equals(newUser.getStreet()) &&
      this.getCity().equals(newUser.getCity()) &&
      this.getState().equals(newUser.getState()) &&
      this.getZipcode() == newUser.getZipcode() &&
      this.getId() == newUser.getId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO users (name, creditCardNum, phone, email, street, city, state, zipcode) VALUES (:name, :creditCardNum, :phone, :email, :street, :city, :state, :zipcode);";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("creditCardNum", this.creditCardNum)
      .addParameter("phone", this.phone)
      .addParameter("email", this.email)
      .addParameter("street", this.street)
      .addParameter("city", this.city)
      .addParameter("state", this.state)
      .addParameter("zipcode", this.zipcode)
      .executeUpdate()
      .getKey();
    }
  }

  public void update() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE users SET (name, creditCardNum, phone, email, street, city, state, zipcode) = (:name, :creditCardNum, :phone, :email, :street, :city, :state, :zipcode) WHERE id = :id;";
      con.createQuery(sql)
      .addParameter("name", this.name)
      .addParameter("creditCardNum", this.creditCardNum)
      .addParameter("phone", this.phone)
      .addParameter("email", this.email)
      .addParameter("street", this.street)
      .addParameter("city", this.city)
      .addParameter("state", this.state)
      .addParameter("zipcode", this.zipcode)
      .addParameter("id", this.id)
      .executeUpdate();
    }
  }


  public static List<User> all() {
    String sql = "SELECT * FROM users;";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(User.class);
    }
  }

  public static User find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM users where id = :id;";
      User user = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(User.class);
      return user;
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM users WHERE id = :id;";
      con.createQuery(sql)
      .addParameter("id", this.id)
      .executeUpdate();
    }
  }
}
