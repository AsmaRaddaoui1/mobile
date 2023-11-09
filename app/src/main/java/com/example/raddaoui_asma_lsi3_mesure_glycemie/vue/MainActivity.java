package com.example.raddaoui_asma_lsi3_mesure_glycemie.vue;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.util.Log;

import com.example.raddaoui_asma_lsi3_mesure_glycemie.R;
import com.example.raddaoui_asma_lsi3_mesure_glycemie.controller.Controller;

public class MainActivity extends AppCompatActivity {
    private Controller controller;
    private TextView tvResult;
    private TextView tvAge;
    private SeekBar sbAge;

    private RadioButton rbtOui, rbtNon;
    private EditText edtValeurGlycemie;
    private Button btnConsulter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = Controller.getInstance();

        init();

        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("information", "onProgressChanged " + i);
                tvAge.setText("Votre âge : " + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculer(view);
            }
        });
    }

    public void calculer(View view) {
        int age = sbAge.getProgress();
        double glucoseLevel = Double.parseDouble(edtValeurGlycemie.getText().toString());
        boolean isJeune = rbtOui.isChecked();

        // Perform the blood glucose level check
        String result = checkBloodGlucose(age, glucoseLevel, isJeune);
        tvResult.setText(result);

        // Utilisez le contrôleur pour créer un patient et obtenir la réponse
        controller.createPatient(age, glucoseLevel, isJeune);
        String controllerResult = controller.getResponse();
        // Utilisez le résultat du contrôleur si nécessaire
    }

    private String checkBloodGlucose(int age, double glucoseLevel, boolean isJeune) {
        if (isJeune || age < 6) {
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

    private void init() {
        tvAge = findViewById(R.id.tvAge);
        sbAge = findViewById(R.id.sbAge);
        tvResult = findViewById(R.id.tvResult);
        rbtOui = findViewById(R.id.rbtOui);
        rbtNon = findViewById(R.id.rbtNon);
        edtValeurGlycemie = findViewById(R.id.edtValeurGlycemie);
        btnConsulter = findViewById(R.id.btnConsulter);
    }
}
