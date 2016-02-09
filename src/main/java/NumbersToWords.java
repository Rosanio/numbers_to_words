import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class NumbersToWords {
  public static void main(String[] args) {

  }

  public String getWord(Integer number) {
    String finalWord = "";
    HashMap<Integer, String> findSmallWords = new HashMap<Integer, String>();
    HashMap<Integer, String> findTensWords = new HashMap<Integer, String>();
    String[] smallNumberWords = {"one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    String[] tensWords = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    for(Integer i = 1; i <= 19; i++) {
      findSmallWords.put(i, smallNumberWords[i-1]);
    }
    for(Integer i = 2; i <= 9; i++) {
      findTensWords.put(i, tensWords[i-2]);
    }
    Integer tens = number / 10;
    Integer remainder = number % 10;
    if(tens >= 2) {
      finalWord = finalWord + findTensWords.get(tens);
      finalWord = finalWord + " " + findSmallWords.get(remainder);
    } else {
      finalWord = findSmallWords.get(number);
    }
    return finalWord;
  }
}
