package com.example.raddaoui_asma_lsi3_mesure_glycemie.controller;
import com.example.raddaoui_asma_lsi3_mesure_glycemie.model.Patient;

public class Controller {
    private Patient patient;

    // Attribut statique pour l'instance unique (Singleton)
    private static Controller instance = null;

    // Constructeur privé pour empêcher l'instanciation depuis l'extérieur
    private Controller() {
        // Initialisez le modèle patient avec des valeurs par défaut ou laissez-le vide pour le moment.
        patient = new Patient(0, 0.0, false);
    }

    // Méthode statique et finale pour obtenir l'instance unique du contrôleur
    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void createPatient(int age, double glucoseLevel, boolean isFasting) {
        // Créez une nouvelle instance de Patient avec les données fournies
        patient = new Patient(age, glucoseLevel, isFasting);
    }

    public String getResponse() {
        // Obtenez la réponse à partir de la méthode calculate() du modèle Patient
        return patient.calculate();
    }
}
