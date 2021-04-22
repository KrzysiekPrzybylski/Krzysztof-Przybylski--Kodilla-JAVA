package com.kodilla.testing.osobiste;

public class Zliczanie {

    public int czyPoliczone(int liczba) {
        if(liczba<=1) {
            return 1;
        } else {
            return liczba + czyPoliczone(liczba - 1);

        }
    }
}
