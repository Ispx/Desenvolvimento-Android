package com.example.appchat.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appchat.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class act_login extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private TextView textRegister;
    private Button btLogin;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);

        this.email = findViewById(R.id.edt_login_email);
        this.password = findViewById(R.id.edt_login_password);
        this.textRegister = findViewById(R.id.text_register);
        this.btLogin = findViewById(R.id.btn_login);

    }

    public void textRegister(View view) {
        startActivity(new Intent(act_login.this,act_register.class));
    }

    public void onLogin(View view){
        String email = this.email.getText().toString();
        String password = this.password.getText().toString();

        if(email == null && email.isEmpty() && password == null && password.isEmpty()){

            Toast.makeText(getApplicationContext(),"E-mail e senha devem ser preenchidos",Toast.LENGTH_LONG).show();

            return;
        }
        
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).
        addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
            Intent intent = new Intent(act_login.this,act_messages.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(intent);

            Toast.makeText(getApplicationContext(),"Logado com Sucesso",Toast.LENGTH_LONG).show();

            }
        }).
        addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            Intent intent = new Intent(act_login.this,act_register.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

            Toast.makeText(getApplicationContext(),"Não cadastrado",Toast.LENGTH_SHORT).show();

            startActivity(intent);

            }
        });

    }
}
