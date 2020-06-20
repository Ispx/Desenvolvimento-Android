package com.example.fragments.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragments.Fragment.ContatosFragment;
import com.example.fragments.Fragment.ChamadasFragment;
import com.example.fragments.R;

public class Main extends AppCompatActivity {

    private ChamadasFragment _chamadasFragment;
    private ContatosFragment _contatosFragment;
    private FragmentTransaction _fragmentTransaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _contatosFragment = new ContatosFragment();
        _chamadasFragment = new ChamadasFragment();

        _fragmentTransaction = getSupportFragmentManager().beginTransaction();
        _fragmentTransaction.replace(R.id.visualzarFragment, _contatosFragment);
        _fragmentTransaction.commit();

    }

    @SuppressLint("ResourceType")
    public void eventChamadas(View view){
        RecyclerView recyclerView;
        _fragmentTransaction = getSupportFragmentManager().beginTransaction();
        _fragmentTransaction.replace(R.id.visualzarFragment, _chamadasFragment);

        _fragmentTransaction.commit();

    }

    @SuppressLint("ResourceType")
    public void eventContatos(View view){

        _fragmentTransaction = getSupportFragmentManager().beginTransaction();
        _fragmentTransaction.replace(R.id.visualzarFragment,_contatosFragment);
        _fragmentTransaction.commit();

    }


}
