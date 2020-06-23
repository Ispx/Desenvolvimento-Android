package com.example.estruturalistview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class multiplo_activity extends AppCompatActivity {
    private ListView listView;
    private List<Contato> contatoList = Arrays.asList(new Contato("Isaque","31 9999-9999"), new Contato("Maria","21 8888-8888"));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_simple_listview);
        listView = findViewById(R.id.listview);


        AdapterClass adapterClass = new AdapterClass(this,contatoList);
        listView.setAdapter(adapterClass);



        //Evento de click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contato conta = contatoList.get(position);

                Toast.makeText(multiplo_activity.this,conta.getNome(),Toast.LENGTH_LONG).show();

            }
        });
    }

}

class AdapterClass extends ArrayAdapter<Contato>{
    private Context context;
    private ImageView imageView;
    private TextView nome;
    private TextView numero;
    private List<Contato> contatos;

    //Passando parâmetros de contexto para a classe que irá implementa-lá e objeto de listagem;
    public AdapterClass(Context context,List<Contato> lista){
        super(context,R.layout.meu_estilo_layout, lista);

        this.context = context;
        contatos = lista;

    }

    /*
    Através do método getView que atribui valores aos views do layout
    Para isso nós instanciamos o objeto do contrutor View através do LayoutInflater passando o contexto como parametro e inflando
    o layout dos itens, é este objeto (convertView) que ira receber todos os elementos do layout para atribuição de valores.

    Após isso criamos um objeto principal referente ao arraylist que recebera uma posição da listagem que será instanciada no parametro.

    Com isso, atribuimos valores dentro de cada view.


     */


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            //Capturando um unico objeto da lista através do parâmetro position e atribuindo a um objeto especifico
            Contato contato = this.contatos.get(position);

            //Atribuindo as Views do meu_estilo_layout para o objeto convertView
            convertView = LayoutInflater.from(context).inflate(R.layout.meu_estilo_layout,null);


            //Inicializando os objetivos de cada view do layout por intermédio do convertView
            imageView = convertView.findViewById(R.id.imagem);
            nome = convertView.findViewById(R.id.nome);
            numero = convertView.findViewById(R.id.numero);

            //Setando valores as Views
            nome.setText(contato.getNome());
            numero.setText(contato.getNumero());

        return convertView;
    }
}
class Contato{
    private String nome;
    private String numero;

    public Contato(String nome, String numero){
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }
}