package packages.shared;

public class GetCalculatorParams {
  public static CalculatorDTO execute(String clientMessage) {
    String[] params = clientMessage.split(" ");
    String operator = params[0];
    float[] numberParams = new float[params.length - 1];

    for (int i = 1; i < params.length; i++)
      numberParams[i - 1] = Float.parseFloat(params[i]);

    return new CalculatorDTO(operator, numberParams);
  }
}
