package com.kodilla.stream1.array;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperation {

    static double getAverage(int[] numbers) {
        IntStream.range(0, numbers.length)
                .map(n->numbers[n])
                .forEach(System.out::println);
        OptionalDouble average = IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average();
        return average.getAsDouble();

    }

    }

