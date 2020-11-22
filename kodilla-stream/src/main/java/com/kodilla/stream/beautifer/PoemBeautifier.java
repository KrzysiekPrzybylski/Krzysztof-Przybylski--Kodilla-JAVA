package com.kodilla.stream.beautifer;;

public class PoemBeautifier {

    public void beautify(String decorateText, PoemDecorator beautifier) {
        String result = beautifier.decorate(decorateText);
        System.out.println("Text much beautifier: " + result);
        System.out.println("decorateText = " + decorateText + ", beautifier = " + beautifier);
        System.out.println("PoemBeautifier.beautify");
        System.out.println("result = " + result);
    }
}

