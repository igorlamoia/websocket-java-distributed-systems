package packages.shared;

public class Calculator {
    String operator;
    
    public Calculator(String operator){
        this.operator = operator;
    }

    public float sun(float[] numbers) {
        float result = 0;
        for(float number: numbers)
            result += number;
        return result;
    }

    public float run(float[] numbers){
        if(operator == "+") return sun(numbers);
        return 0;
    }
}
