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
}
