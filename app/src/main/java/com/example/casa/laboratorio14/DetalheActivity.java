package com.example.casa.laboratorio14;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by casa on 10/12/2016.
 */
public class DetalheActivity extends Activity {

    private Tarefa tarefa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhe_layout);

        tarefa = (Tarefa) getIntent().getSerializableExtra("tarefa");

        ((TextView)findViewById(R.id.tarefaTextView))
                .setText(tarefa.getTarefa());
        ((TextView)findViewById(R.id.descricaoTextView))
                .setText(tarefa.getDescricao());
        ((CheckBox)findViewById(R.id.concluidoCheckBox))
                .setChecked(tarefa.isConcluida());

        findViewById(R.id.excluirButton) .setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TarefaNegocio.apagarTarefa(tarefa.getId(),DetalheActivity.this);
                finish();
            }
        });

        findViewById(R.id.concluirButton) .setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tarefa.setConcluida(true);
                TarefaNegocio.atualizarTarefa(tarefa,DetalheActivity.this);
                finish();
            }
        });

    }
}
