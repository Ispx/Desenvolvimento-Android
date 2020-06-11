package com.example.estruturarecyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;


//Extendendo a classe de compactação das activitys e implementando a interface criada para eventos de click
public class Activity_Click_RecyclerView extends AppCompatActivity implements AdaptadorDeConteúdos2.interfaceDeClick {
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
        AdaptadorDeConteúdos2 adaptadorDeConteúdos = new AdaptadorDeConteúdos2(usuarios,this);
        recyclerView.setAdapter(adaptadorDeConteúdos);
        recyclerView.setHasFixedSize(true);
        //Adicionado um divisor entre as views
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    @Override
    public void eventoDeClick(View view, int position) {
        Toast.makeText(this,"Posição do item: " + position,Toast.LENGTH_LONG).show();
    }
}

class AdaptadorDeConteúdos2 extends RecyclerView.Adapter<AdaptadorDeConteúdos2.AdapterViewHolder2> {
    private List<Lista> lista;

    //Objeto evento da interface de eventos de click
    private interfaceDeClick interfaceClick;

    //Deve-se criar um construtor para a classe para que se possa receber no construtor a lista de conteúdos
    // e o contexto da classe que alimentara  objeto da interface

    public AdaptadorDeConteúdos2(List<Lista> lista, interfaceDeClick interfaceClick){
        this.lista = lista;
        this.interfaceClick = interfaceClick;
    }

    //Metódo onCreateViewHolder retorna o construtor da  classe interna 'AdapterViewHolder',
    // neste retorno irá conter todas as views da activity especificada no parâmetro do método inflate;
    @NonNull
    @Override
    public AdapterViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_conteudos_lista,parent,false);
        return new AdapterViewHolder2(view);
    }


    //É através do método onBindViewHolder que se da valores as views,
    //E isso só é possível porque o mesmo recebe em seu parâmetro um objeto da classe interna 'AdapterViewHolder'
    //Que contém todas as views que foram infladas no método onCreateViewHolder.

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder2 holder, int position) {
        //Capturanto um elemento único da lista, utiliza-se o atributo position do parâmetro para auxilar.
        Lista elemento = lista.get(position);

        //Atribuindo valores as views através do objeto do tipo AdapterViewHolder
        holder.nome.setText(elemento.getNome());
        holder.buttonText.setText(elemento.getNome().substring(0,1));


    }

    //Criando interface para evento de click.
    public interface interfaceDeClick{

        //Criando método abstrato e determinado os valores que quero receeber no parâmetro através da classe viewHolder
        void eventoDeClick(View view, int position);
    }


    //Atribuindo tamanho da lista ou quantidade de elementos a ser listados
    @Override
    public int getItemCount() {
        return lista.size();
    }

    class AdapterViewHolder2 extends RecyclerView.ViewHolder {
        TextView nome;
        Button buttonText;

        //Acessando as views pela Id
        public AdapterViewHolder2(@NonNull final View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.nome);
            buttonText = itemView.findViewById(R.id.botao);

            //O evento de click é chamado através da view da classe interna viewHolder, pois é ela que carrega as views
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Carregando valores para os parâmetros do método
                    interfaceClick.eventoDeClick(itemView,getAdapterPosition());
                }
            });


        }
    }
}



