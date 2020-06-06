package com.example.estruturalistview;

import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.List;

public class simple_activity extends AppCompatActivity {
    private List<String> listaDeUsuários = Arrays.asList("Isaque","Maria","Joana","Fabiana","Ana","Lucas","Paulo","Pedro","Vitor","Marcelo");
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_listview);

        listView = findViewById(R.id.listview);

        adaptarConteudosNaLista(listaDeUsuários);
    }

    public void adaptarConteudosNaLista(List<String> lista){
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,lista));
        /* Tipos de layouts de listagem para implementar

        public static final int simple_list_item_checked = 17367045; Listagem com icone de checked (top)
        public static final int select_dialog_multichoice = 17367059; Listagem com espacamento interno e caixa de checkbox (bacana)
        public static final int select_dialog_singlechoice = 17367058; Listagem com espacamento interno e caixa de checkbox oval (bacana)
        public static final int simple_list_item_multiple_choice = 17367056; Listagem com caixa de checkbox (bacana)
        public static final int simple_list_item_single_choice = 17367055; Listagem com caixa de checkbox oval (bacana)
        public static final int browser_link_context_header = 17367054; Linhas de texto (simples, mas bacana)


        public static final int simple_selectable_list_item = 17367061; Listagem com espacamento interno (simples)
        public static final int simple_list_item_1 = 17367043; Listagem simples
        public static final int simple_spinner_dropdown_item = 17367049; Listagem simples
        public static final int simple_spinner_item = 17367048; Listagem simples
        public static final int test_list_item = 17367052; Listagem simples
        public static final int simple_list_item_activated_1 = 17367062; Linham simples
        public static final int simple_expandable_list_item_1 = 17367046; Listagem com espacamento interno e lateral esquerdo (simples)
        public static final int simple_dropdown_item_1line = 17367050; Listagem com espacamento interno (simples)
        public static final int select_dialog_item = 17367057; Listagem com espacamento interno (simples)
        public static final int preference_category = 17367042; Muito simples
        public static final int activity_list_item = 17367040; Linhas de texto (simples)


        public static final int expandable_list_content = 17367041; not run
        public static final int list_content = 17367060; not run
        public static final int simple_expandable_list_item_2 = 17367047; not run
        public static final int simple_gallery_item = 17367051;
        public static final int simple_list_item_2 = 17367044; not run
        public static final int simple_list_item_activated_2 = 17367063; not run
        public static final int two_line_list_item = 17367053; not run
        */


    }





}
