package com.example.casa.laboratorio14;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends ListActivity {

    private List<Tarefa> tarefas;
    private TarefaAdapter tarefaAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tarefas = TarefaNegocio.listarTarefa(this);
        tarefaAdapter = new TarefaAdapter(this,tarefas);
        setListAdapter(tarefaAdapter);

        findViewById(R.id.adicionarButton) .setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent novaTarefa = new Intent(MainActivity.this,NovaTarefaActivity.class);
                startActivity(novaTarefa);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        tarefas = TarefaNegocio.listarTarefa(this);
        tarefaAdapter.setTarefas(tarefas);
        tarefaAdapter.notifyDataSetChanged();
    }
}
