import java.util.HashMap;
import java.util.ArrayList;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class NumbersToWords {
  public static void main(String[] args) {}

  public String getWord(Integer number) {
    String finalWord = "";
    HashMap<Integer, String> findSmallWords = new HashMap<Integer, String>();
    HashMap<Integer, String> findTensWords = new HashMap<Integer, String>();
    HashMap<Integer, String> findHundredsWords = new HashMap<Integer, String>();
    String[] smallNumberWords = {"one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    String[] tensWords = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    findHundredsWords.put(0, "");
    for(Integer i = 1; i <= 19; i++) {
      findSmallWords.put(i, smallNumberWords[i-1]);
    }
    for(Integer i = 2; i <= 9; i++) {
      findTensWords.put(i, tensWords[i-2]);
    }
    for(Integer i = 1; i <= 9; i++) {
      findHundredsWords.put(i, (smallNumberWords[i-1] + " hundred"));
    } //END HASHMAP SETUP

    String stringNumber = Integer.toString(number);
    Integer numberScale = stringNumber.length();
    Integer numberGroups = numberScale / 3;
    Integer numberGroupsRemainder = numberScale % 3;
    if(numberGroupsRemainder > 0) {
      numberGroups += 1;
    }
    ArrayList<String> stringNumberArray = new ArrayList<String>();
    for(Integer i = 1; i <= numberGroups; i++) {
      if(stringNumber.length() - 3 < 0) {
        stringNumberArray.add(stringNumber);
      } else {
        stringNumberArray.add(stringNumber.substring(stringNumber.length()-3,stringNumber.length()));
        stringNumber = stringNumber.substring(0,stringNumber.length()-3);
      }
    }

    for(Integer i = numberGroups; i > 0; i--) {
      String tempStringNumber = stringNumberArray.get(i-1);
      Integer tempNumber = Integer.parseInt(tempStringNumber);
      Integer hundreds = tempNumber / 100;
      tempNumber = tempNumber % 100;
      Integer tens = tempNumber / 10;
      Integer remainder = tempNumber % 10;

      finalWord += findHundredsWords.get(hundreds);
      if (tempNumber > 0 && hundreds > 0) {
        finalWord += " and ";
      }
      if(tens >= 2) {
        finalWord = finalWord + findTensWords.get(tens);
        if(remainder > 0) {
          finalWord = finalWord + " " + findSmallWords.get(remainder);
        }
      } else if (tempNumber > 0){
        finalWord += findSmallWords.get(tempNumber);
      }

      if(i == 5) {
        finalWord += " trillion ";
      }
      if(i == 4) {
        finalWord += " billion ";
      }
      if(i == 3) {
        finalWord += " million ";
      }
      if(i == 2) {
        finalWord += " thousand ";
      }

    }
    return finalWord;



  }
}
