package com.example.estruturarecyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class Activity_RecyclerView extends AppCompatActivity {
    private List<Lista> usuarios = Arrays.asList(new Lista("Isaque"),new Lista("Alessandra"), new Lista("José"));
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lista_recyclerview);
        recyclerView = findViewById(R.id.lista_recyclerView);


        //Configuração do contexto de  gerenciamento de layout
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Configuração de adaptação dos elementos no layout lista_recyclerView
        AdaptadorDeConteúdos adaptadorDeConteúdos = new AdaptadorDeConteúdos(usuarios);
        recyclerView.setAdapter(adaptadorDeConteúdos);
        recyclerView.setHasFixedSize(true);
    }
}

class AdaptadorDeConteúdos extends RecyclerView.Adapter<AdaptadorDeConteúdos.AdapterViewHolder>{
    private List<Lista> lista;


    //Deve-se criar um construtor para a classe para que se possa receber no construtor a lista de conteúdos.
    public AdaptadorDeConteúdos(List<Lista> lista){
        this.lista = lista;
    }

    //Metódo onCreateViewHolder retorna o construtor da  classe interna 'AdapterViewHolder',
    // neste retorno irá conter todas as views da activity especificada no parâmetro do método inflate;
    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_conteudos_lista,parent,false);
        return new AdapterViewHolder(view);
    }


    //É através do método onBindViewHolder que se da valores as views,
    //E isso só é possível porque o mesmo recebe em seu parâmetro um objeto da classe interna 'AdapterViewHolder'
    //Que contém todas as views que foram infladas no método onCreateViewHolder.

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        //Capturanto um elemento único da lista, utiliza-se o atributo position do parâmetro para auxilar.
        Lista elemento = lista.get(position);

        //Atribuindo valores as views através do objeto do tipo AdapterViewHolder
        holder.nome.setText(elemento.getNome());
        holder.buttonText.setText(elemento.getNome().substring(0,1));


    }

    //Atribuindo tamanho da lista ou quantidade de elementos a ser listados
    @Override
    public int getItemCount() {
        return lista.size();
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        TextView nome;
        Button buttonText;

      //Acessando as views pela Id
        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.nome);
            buttonText = itemView.findViewById(R.id.botao);

        }
    }
}

class Lista {

    private String nome;

    public Lista(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}


