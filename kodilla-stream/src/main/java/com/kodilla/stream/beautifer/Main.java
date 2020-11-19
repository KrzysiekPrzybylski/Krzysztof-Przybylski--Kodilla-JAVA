package com.kodilla.stream.beautifer;

public class Main {
    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Every text is good", (decorateText) -> "ABC" + decorateText + "ABC");
        poemBeautifier.beautify("Every text is good", (decorateText) -> decorateText.toUpperCase());
        poemBeautifier.beautify("Every text is good", (decorateText) -> decorateText.repeat(4));
        poemBeautifier.beautify("Every text is good", (decorateText) -> decorateText.replace("oo", "o"));
    }
}
