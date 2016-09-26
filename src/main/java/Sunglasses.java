public class Sunglasses {
  private String name;
  private String imgURL;
  private String description;
  private int price;
  private int id;
  private int customerId;

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
}
