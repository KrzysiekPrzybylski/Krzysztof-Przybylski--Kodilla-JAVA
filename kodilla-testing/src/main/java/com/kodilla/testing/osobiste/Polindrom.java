package com.kodilla.testing.osobiste;

public class Polindrom {
    private char[] slowo;
    private int p;
    private int k;

    public Polindrom(char[] slowo, int p, int k) {
        this.slowo = slowo;
        this.p = p;
        this.k = k;
    }

    public Polindrom() {
    }

    public char[] getSlowo() {
        return slowo;
    }

    public int getP() {
        return p;
    }

    public int getK() {
        return k;
    }

    public boolean czyPolindrom(char[] slowo, int p, int k) {
        if(k<=p) {
            return true;
        } else if (slowo [p]!= slowo [k]) {
            return false;
        } else {
            return czyPolindrom(slowo, p+1, k-1);
        }
    }

}
