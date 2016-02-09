import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class NumbersToWordsTest {
  @Test
  public void getWord_UserEnters4_ReturnsFour() {
    NumbersToWords testNumber = new NumbersToWords();
    assertEquals("four",testNumber.getWord(4));
  }
  @Test
  public void getWord_UserEnters24_ReturnsTwentyFour() {
    NumbersToWords testNumber = new NumbersToWords();
    assertEquals("twenty four",testNumber.getWord(24));
  }
}
