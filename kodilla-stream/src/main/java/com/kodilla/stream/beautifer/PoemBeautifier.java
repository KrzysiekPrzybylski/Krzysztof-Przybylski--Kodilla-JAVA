package com.kodilla.stream.beautifer;;

public class PoemBeautifier {

    public void beautify(String decorateText, PoemDecorator beautifier) {
        String result = beautifier.decorate(decorateText);
        System.out.println("Text much beautifier: " + result);
    }
}

