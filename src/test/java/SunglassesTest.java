import org.junit.*;
import static org.junit.Assert.*;

public class SunglassesTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Sunglasses_instantiatesCorrectly_true() {
    Sunglasses mySunglasses = new Sunglasses("Gigi", "www.example.com", "hot", 10);
    assertEquals(true, mySunglasses instanceof Sunglasses);
  }

  @Test
  public void getName_instantiatesWithName_String() {
    Sunglasses mySunglasses = new Sunglasses("Gigi", "www.example.com", "hot", 10);
    assertEquals("Gigi", mySunglasses.getName());
  }

  @Test
  public void getImgUrl_instantiatesWithImgURL_String() {
    Sunglasses mySunglasses = new Sunglasses("Gigi", "www.example.com", "hot", 10);
    assertEquals("www.example.com", mySunglasses.getImgUrl());
  }

  @Test
  public void getDescription_instantiatesWithDescription_String() {
    Sunglasses mySunglasses = new Sunglasses("Gigi", "www.example.com", "hot", 10);
    assertEquals("hot", mySunglasses.getDescription());
  }

  @Test
  public void getPrice_instantiatesWithPrice_10() {
    Sunglasses mySunglasses = new Sunglasses("Gigi", "www.example.com", "hot", 10);
    assertEquals(10, mySunglasses.getPrice());
  }

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Sunglasses firstSunglasses = new Sunglasses("Gigi", "www.example.com", "hot", 10);
    Sunglasses secondSunglasses = new Sunglasses("Gigi", "www.example.com", "hot", 10);
    assertTrue(firstSunglasses.equals(secondSunglasses));
  }

  @Test
  public void save_insertsObjectIntoDatabase_Sunglasses() {
    Sunglasses mySunglasses = new Sunglasses("Gigi", "www.example.com", "hot", 10);
    mySunglasses.save();
    assertTrue(Sunglasses.all().get(0).equals(mySunglasses));
  }

  @Test
  public void all_returnsAllInstancesOfSunglasses_true() {
    Sunglasses firstSunglasses = new Sunglasses("Gigi", "www.example.com", "hot", 10);
    firstSunglasses.save();
    Sunglasses secondSunglasses = new Sunglasses("Dash", "www.example.com", "fierce", 50);
    secondSunglasses.save();
    assertEquals(true, Sunglasses.all().get(0).equals(firstSunglasses));
    assertEquals(true, Sunglasses.all().get(1).equals(secondSunglasses));
  }

  @Test
  public void save_assignsIdToObject() {
    Sunglasses testSunglasses = new Sunglasses("Gigi", "www.example.com", "hot", 10);
    testSunglasses.save();
    Sunglasses savedSunglasses = Sunglasses.all().get(0);
    assertEquals(testSunglasses.getId(), savedSunglasses.getId());
  }

  @Test
  public void find_returnsSunglassesWithSameId_secondSunglasses() {
    Sunglasses firstSunglasses = new Sunglasses("Gigi", "www.example.com", "hot", 10);
    firstSunglasses.save();
    Sunglasses secondSunglasses = new Sunglasses("Dash", "www.example.com", "fierce", 50);
    secondSunglasses.save();
    assertEquals(Sunglasses.find(secondSunglasses.getId()), secondSunglasses);
  }
}
