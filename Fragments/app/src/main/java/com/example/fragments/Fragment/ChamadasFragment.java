package com.example.fragments.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragments.R;


//Extender a classe Fragment
public class ChamadasFragment extends Fragment {

    private TextView _conversaText;

    //Chamar a classe onCreateView
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Atribuindo todas as views referente ao layout do tipo frame através do método inflate  que recebe um layout, uma viewGroup e um booleano
        View view = inflater.inflate(R.layout.framelayout_chamadas,container,false);

        //Com as views atribuidas pode-se capturar uma view especifica através do método findViewById e fazer as manipulações desejadas
        _conversaText = view.findViewById(R.id.textFragmentChamadas);
        _conversaText.setText("Nenhuma chamada");

        //Por fim, retornando a view inflada
        return view;
    }
}
