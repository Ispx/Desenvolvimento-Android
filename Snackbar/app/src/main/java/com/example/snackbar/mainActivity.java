package com.example.snackbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


//Dependencia necessária
import com.google.android.material.snackbar.Snackbar;


public class mainActivity extends AppCompatActivity {
    private Button _button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        _button = findViewById(R.id.botao);

        _button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v,"Botão clicado",Snackbar.LENGTH_LONG)
                        //Evento de click no snackbar
                        .setAction("Alterar nome botao", new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                _button.setText("Nome alterado");
                            }
                        })
                        //Mostrar snackbar
                        .show();

            }
        });



    }
}
