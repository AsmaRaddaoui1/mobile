package com.example.raddaoui_asma_lsi3_mesure_glycemie.model;

public class Patient {
    private int age;
    private double glucoseLevel;
    private boolean isFasting;

    public Patient(int age, double glucoseLevel, boolean isFasting) {
        this.age = age;
        this.glucoseLevel = glucoseLevel;
        this.isFasting = isFasting;
    }

    public int getAge() {
        return age;
    }

    public double getGlucoseLevel() {
        return glucoseLevel;
    }

    public boolean isFasting() {
        return isFasting;
    }

    public String calculate() {
        if (isFasting || age < 6) {
            if (glucoseLevel >= 5.5 && glucoseLevel <= 10.0) {
                return "Le niveau de glycémie est normal.";
            } else if (glucoseLevel < 5.5) {
                return "Le niveau de glycémie est trop bas.";
            } else {
                return "Le niveau de glycémie est trop élevé.";
            }
        } else if (age >= 6 && age <= 12) {
            if (glucoseLevel >= 5.0 && glucoseLevel <= 10.0) {
                return "Le niveau de glycémie est normal.";
            } else if (glucoseLevel < 5.0) {
                return "Le niveau de glycémie est trop bas.";
            } else {
                return "Le niveau de glycémie est trop élevé.";
            }
        } else {
            if (glucoseLevel >= 5.0 && glucoseLevel <= 7.2) {
                return "Le niveau de glycémie est normal.";
            } else if (glucoseLevel < 5.0) {
                return "Le niveau de glycémie est trop bas.";
            } else {
                return "Le niveau de glycémie est trop élevé.";
            }
        }
    }
}
