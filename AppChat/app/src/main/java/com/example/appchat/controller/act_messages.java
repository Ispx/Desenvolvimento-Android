package com.example.appchat.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appchat.R;
import com.google.firebase.auth.FirebaseAuth;

public class act_messages extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_messages);

        verifyLoginUser();


    }

    private void verifyLoginUser() {


        if(FirebaseAuth.getInstance().getUid() == null) {
            Intent intent = new Intent(act_messages.this, act_login.class);

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

            Toast.makeText(this, "Usuário não logado", Toast.LENGTH_LONG);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.contatos_sair,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        
        switch (item.getItemId()){
            case R.id.menu_contatos:
                break;
            case R.id.menu_logout:

                FirebaseAuth.getInstance().signOut();
                verifyLoginUser();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
