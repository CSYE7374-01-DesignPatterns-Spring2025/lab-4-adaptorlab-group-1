package edu.neu.csye7374;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class POSClient {
    public static void runAdapterDemo() {
        AccumulatableAPI objectAdapter = new CalculatorAdapter(new Calculator());
        AccumulatableAPI classAdapter = new CalculatorClassAdapter();

        List<Double> prices = Arrays.asList(15.99, 5.95, 8.50);
        double cash = 50.00;

        System.out.println("=== Object Adapter Test ===");
        processTransaction(objectAdapter, prices, cash);

        System.out.println("\n=== Class Adapter Test ===");
        processTransaction(classAdapter, prices, cash);
    }

    private static void processTransaction(AccumulatableAPI adapter,
                                           List<Double> prices,
                                           double cash) {
        double total = adapter.accumulation(prices);
        double change = adapter.payment(cash);

        System.out.println("Item prices: " +
                prices.stream()
                        .map(p -> String.format("$%.2f", p))
                        .collect(Collectors.joining(" + ")));
        System.out.printf("Total: $%.2f%n", total);
        System.out.printf("Cash received: $%.2f%n", cash);
        System.out.printf("Change due: $%.2f%n", change);
    }
}
