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
    assertEquals("twenty",testNumber.getWord(20));
  }
  @Test
  public void getWord_UserEnters519_ReturnsFiveHundredAndNineteen() {
    NumbersToWords testNumber = new NumbersToWords();
    assertEquals("five hundred and nineteen",testNumber.getWord(519));
  }
  @Test
  public void getWord_UserEnters2119_ReturnsTwoThousandOneHundredAndNineteen() {
    NumbersToWords testNumber = new NumbersToWords();
    assertEquals("two million two thousand one hundred and nineteen",testNumber.getWord(2002119));
  }
}
