package com.example.fragments.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fragments.R;
import java.util.Arrays;
import java.util.List;


//Extender a classe Fragment
public class ContatosFragment extends Fragment {

    private RecyclerView _recyclerView;
    private RecyclerView.LayoutManager _recyclerManager;


    //Chamar o método onCreateView
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Capturar todas as view do layout do tipo FrameLayout através do método inflate que recebe um layout, uma viewGroup e um booleano
        View view = inflater.inflate(R.layout.framelayout_contatos, container,false );

        //Através da view inflada pode-se capturar uma view especifica através do método findViewById e fazer as manipulações necessárias
        _recyclerView = view.findViewById(R.id.list_recyclerView);
        _recyclerManager = new LinearLayoutManager(getContext());
        _recyclerView.setLayoutManager(_recyclerManager);


        ContatosAdapter contatosAdapter= new ContatosAdapter();

        _recyclerView.setAdapter(contatosAdapter);
        _recyclerView.setHasFixedSize(true);

        return view;
    }
}
class ContatosAdapter extends RecyclerView.Adapter<ContatosAdapter.ContatosViewHolder>{
    private List<Contatos> _listaDeContatos = Arrays.asList(new Contatos("Isaque Santos"), new Contatos("Maria Joana"), new Contatos( "Luiz Carlos"), new Contatos("Marta Merces"),new Contatos( "Christina Silva"),
            new Contatos("Mauro Moura"), new Contatos( "Mariana Matias"), new Contatos("Matheus Vaz"), new Contatos("Lucas Viana"),new Contatos( "José da Silva"), new Contatos( "Gabriela Nunes"), new Contatos("Gisele Pereira"), new Contatos( "Ana Santos"),
            new Contatos("Henrique Luiz"));


    class ContatosViewHolder extends RecyclerView.ViewHolder{
        public TextView contatoNome;
        public ContatosViewHolder(@NonNull View itemView) {
            super(itemView);

            contatoNome = itemView.findViewById(R.id.contatoName);
        }
    }

    @NonNull
    @Override
    public ContatosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_contatos,parent,false);

        return new ContatosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContatosViewHolder holder, int position) {
        Contatos contato = _listaDeContatos.get(position);

        holder.contatoNome.setText(contato.getNome());
    }

    @Override
    public int getItemCount() {
        return _listaDeContatos.size();
    }
}

class Contatos {
    private String _nome;
    public Contatos(String _nome){this._nome = _nome;}
    public String getNome() {
        return _nome;
    }
}


