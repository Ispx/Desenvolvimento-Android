package com.example.calculadoradegorjeta;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class activity_home extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView porcent_gojeta;
    private TextInputEditText valorMesa;
    private TextView valorGorjeta;
    private TextView valorTotal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        seekBar = findViewById(R.id.seelbar_gorjeta);
        porcent_gojeta = findViewById(R.id.textView_porcentagem_gorjeta);
        valorMesa = findViewById(R.id.valor_da_mesa);
        valorGorjeta = findViewById(R.id.text_valor_gorjeta);
        valorTotal = findViewById(R.id.text_valor_total);
        seekbar();
    }


    public void seekbar(){
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcent_gojeta.setText(" " + progress + "%");

                setValorGorjetaTotal(valorMesa, progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void setValorGorjetaTotal(TextView valorMesa, int progress) {


        if (valorMesa != null && valorMesa.getText() != "" && valorMesa.getContext() != null && valorMesa.getText() != null) {

            Double varGorjeta = Double.parseDouble(String.valueOf(valorMesa.getText())) * progress/100;
            Double varTotal = Double.parseDouble(String.valueOf(valorMesa.getText())) + varGorjeta;

            valorGorjeta.setText(" R$ " + varGorjeta);
            valorTotal.setText(" R$ " + varTotal);
        }
    }





}
