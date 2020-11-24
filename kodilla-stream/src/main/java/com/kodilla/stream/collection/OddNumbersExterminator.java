package com.kodilla.stream.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

        public List<Integer> exterminate(List<Integer> numbers) {
            List<Integer> evens = new ArrayList<>();
            for (Integer number : numbers) {
                if (number % 2 == 0) {
                    evens.add(number);
                }
            }
            return evens;
        }
    }

