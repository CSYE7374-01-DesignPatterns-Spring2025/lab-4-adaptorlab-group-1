package edu.neu.csye7374;

import java.util.List;

public class CalculatorClassAdapter extends Calculator implements AccumulatableAPI {

    private double sum;

    public CalculatorClassAdapter() {
        this.sum = 0;
    }

    @Override
    public double accumulation(List<Double> prices) {
        sum = 0;
        for (Double price : prices) {
            sum = operation(CalculatableAPI.OPERATION.ADD, sum, price);
        }
        return sum;
    }

    @Override
    public double payment(double cash) {
        return operation(CalculatableAPI.OPERATION.SUB, cash, sum);
    }
}
