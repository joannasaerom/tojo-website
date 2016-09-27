import org.junit.*;
import static org.junit.Assert.*;

public class UserTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void User_instantiatesCorrectly_true() {
    User newUser = new User("Joanna", 12345, "(312)542-1532", "test@gmail.com", "123 Main Street", "Portland", "OR", 97215);
    assertTrue(newUser instanceof User);
  }

  @Test
  public void getName_instantiatesWithName_String() {
    User newUser = new User("Joanna", 12345, "(312)542-1532", "test@gmail.com", "123 Main Street", "Portland", "OR", 97215);
    assertEquals("Joanna", newUser.getName());
  }

  @Test
  public void getCreditCardNum_instantiatesWithCCNum_int() {
    User newUser = new User("Joanna", 12345, "(312)542-1532", "test@gmail.com", "123 Main Street", "Portland", "OR", 97215);
    assertEquals(12345, newUser.getCreditCardNum());
  }

  @Test
  public void getPhone_instantiatesWithPhone_String() {
    User newUser = new User("Joanna", 12345, "(312)542-1532", "test@gmail.com", "123 Main Street", "Portland", "OR", 97215);
    assertEquals("(312)542-1532", newUser.getPhone());
  }

  @Test
  public void getEmail_instantiatesWithEmail_String() {
    User newUser = new User("Joanna", 12345, "(312)542-1532", "test@gmail.com", "123 Main Street", "Portland", "OR", 97215);
    assertEquals("test@gmail.com", newUser.getEmail());
  }

  @Test
  public void getStreet_instantiatesWithStreet_String() {
    User newUser = new User("Joanna", 12345, "(312)542-1532", "test@gmail.com", "123 Main Street", "Portland", "OR", 97215);
    assertEquals("123 Main Street", newUser.getStreet());
  }

  @Test
  public void getCity_instantiatesWithCity_String() {
    User newUser = new User("Joanna", 12345, "(312)542-1532", "test@gmail.com", "123 Main Street", "Portland", "OR", 97215);
    assertEquals("Portland", newUser.getCity());
  }

  @Test
  public void getState_instantiatesWithState_String() {
    User newUser = new User("Joanna", 12345, "(312)542-1532", "test@gmail.com", "123 Main Street", "Portland", "OR", 97215);
    assertEquals("OR", newUser.getState());
  }

  @Test
  public void getZipcode_instantiatesWithZipcode_int() {
    User newUser = new User("Joanna", 12345, "(312)542-1532", "test@gmail.com", "123 Main Street", "Portland", "OR", 97215);
    assertEquals(97215, newUser.getZipcode());
  }

  @Test
  public void save_savesObject_true() {
    User newUser = new User("Joanna", 12345, "(312)542-1532", "test@gmail.com", "123 Main Street", "Portland", "OR", 97215);
    newUser.save();
    assertTrue(User.all().get(0).equals(newUser));
  }

  @Test
  public void find_returnsUserWithSameId_user1() {
    User newUser1 = new User("Joanna", 12345, "(312)542-1532", "test@gmail.com", "123 Main Street", "Portland", "OR", 97215);
    newUser1.save();
    User newUser2 = new User("Thomas", 12345, "(312)542-1532", "test@gmail.com", "123 Main Street", "Portland", "OR", 97215);
    newUser2.save();
    assertEquals(User.find(newUser1.getId()), newUser1);
  }
}
