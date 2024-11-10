package packages.shared;

public class Calculator {
    String operator;

    public Calculator(String operator) {
        this.operator = operator;
    }

    private float sum(float[] numbers) {
        float result = 0;
        for (float number : numbers)
            result += number;

        return result;
    }

    private float subtract(float[] numbers) {
        float result = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            result -= numbers[i];

        return result;
    }

    private float multiply(float[] numbers) {
        float result = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            result *= numbers[i];

        return result;
    }

    private float divide(float[] numbers) {
        if (numbers.length < 2)
            throw new IllegalArgumentException("erro: argumentos insuficientes");

        float result = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            result /= numbers[i];

        return result;
    }

    public float run(float[] numbers) {
        if (operator.equals("+"))
            return this.sum(numbers);
        if (operator.equals("-"))
            return this.subtract(numbers);
        if (operator.equals("*"))
            return this.multiply(numbers);
        if (operator.equals("/"))
            return this.divide(numbers);
        return 0;
    }
}
