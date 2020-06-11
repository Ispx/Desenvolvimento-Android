package com.example.udemyapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_main extends AppCompatActivity {
    private String rbSelecionados;
    private Button botao;
    private RadioGroup radioGroup;
    private Switch aSwitch;
    private ToggleButton toggleButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aSwitch = findViewById(R.id.switchi);
        radioGroup = findViewById(R.id.radiogroup);
        botao = findViewById(R.id.botao);
        toggleButton = findViewById(R.id.toggleb);
        Button btAlert = findViewById(R.id.bt_alert);

        setToggleButton();
        bottom();
        btAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAlert(v);
            }
        });

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setToggleButton();
            }
        });


        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ligadoDesligado();
            }
        });

    }



    public String validaRB(int i){
        RadioButton radioButton = findViewById(i);
        if (radioButton.getText().toString().equalsIgnoreCase("homem")){
            rbSelecionados = rbSelecionados + ", " + radioButton.getText().toString();
        }else if(radioButton.getText().toString().equalsIgnoreCase("mulher")){
            rbSelecionados = rbSelecionados + ", " + radioButton.getText().toString();
        }
        return rbSelecionados;
    }

    public void bottom(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                Toast.makeText(Activity_main.this,validaRB(group.getCheckedRadioButtonId()),Toast.LENGTH_LONG).show();
            }
        });
    }

    public void ligadoDesligado(){

        if(aSwitch.isChecked()){

            Toast.makeText(Activity_main.this,"Ligado",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(Activity_main.this, "Desligado", Toast.LENGTH_LONG).show();
        }

    }

    public void setToggleButton(){
        if(toggleButton.isChecked()){
            aSwitch.setChecked(true);
        }
        else {
            aSwitch.setChecked(false);
        }
    }

    public void dialogAlert(View view){

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        alertDialog.setMessage("Esta é uma mensagem");
        alertDialog.setView(R.layout.activity_popout);
        alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(Activity_main.this,"Sim",Toast.LENGTH_SHORT).show();

            }
        });

        alertDialog.create();
        alertDialog.show();


    }





}
