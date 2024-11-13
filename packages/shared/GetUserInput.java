package packages.shared;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GetUserInput {
  public static String execute() {
    String userInput = "";
    try {
      System.out.println(
          "First param: (+, -, *, /), other params: numbers[] separated by space, example: + 1 2 3");
      System.err.print("Enter message: ");
      BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
      userInput = console.readLine();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return userInput;
  }
}
