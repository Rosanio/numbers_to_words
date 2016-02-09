import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class NumbersToWords {
  public static void main(String[] args) {

  }

  public String getWord(Integer number) {
    HashMap<Integer, String> findWords = new HashMap<Integer, String>();
    String[] numberWords = {"one","two","three","four","five","six","seven","eight","nine"};
    for(Integer i = 1; i <= 9; i++) {
      findWords.put(i, numberWords[i-1]);
    }
    return findWords.get(number);
  }
}
