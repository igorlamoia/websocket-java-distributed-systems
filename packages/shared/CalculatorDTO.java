package packages.shared;

public class CalculatorDTO {
  private String operator;
  private float[] numberParams;

  public CalculatorDTO(String operator, float[] numberParams) {
    this.operator = operator;
    this.numberParams = numberParams;
  }

  public String getOperator() {
    return operator;
  }

  public float[] getNumberParams() {
    return numberParams;
  }
}
