package com.example.alcoolougasolina;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Activity_main extends AppCompatActivity {

    private TextInputEditText quilimetragem;
    private TextInputEditText valorAlcool;
    private TextInputEditText valorGasolina;
    private Button calcular;
    private TextView melhorOpcao;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quilimetragem = findViewById(R.id.quilometragem);
        valorAlcool = findViewById(R.id.precoalcool);
        valorGasolina = findViewById(R.id.precogasolina);
        calcular = findViewById(R.id.bt_calcular);
        melhorOpcao = findViewById(R.id.melhoropcao);


        calcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                melhorOpcao(valorGasolina,valorAlcool,quilimetragem, melhorOpcao);
            }
        });

    }


    public Double calculoGasolina(String gasolina, String quilometragem){
        if(gasolina != "" && quilometragem != "") {
            Double dValor = Double.parseDouble(gasolina);
            int km = Integer.parseInt(quilometragem);
            return (km / 9) * dValor;
        }
        return null;
    }

    public Double calculoAlcool(String alcool, String quilometragem){
        if(alcool != "" && quilometragem != "") {
            Double dValor = Double.parseDouble(alcool);
            int km = Integer.parseInt(quilometragem);
            return (km / 9) * dValor;
        }
        return null;
    }

    public void melhorOpcao(TextInputEditText gasolina, TextInputEditText alcool, TextInputEditText quilometragem, TextView view){

        if(
        calculoAlcool(alcool.getText().toString(),quilimetragem.getText().toString())
        <
        calculoGasolina(gasolina.getText().toString(),quilometragem.getText().toString()))
        {
            view.setText("Àlcool");

        }
        else {
            view.setText("Gasolina");
        }

    }




}
