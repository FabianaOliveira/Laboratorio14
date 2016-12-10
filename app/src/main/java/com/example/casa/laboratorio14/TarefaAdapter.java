package com.example.casa.laboratorio14;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by casa on 10/12/2016.
 */
public class TarefaAdapter extends BaseAdapter {

    private List<Tarefa> tarefas;
    private Context contexto;
    private InstanciaVisao instanciaVisao;

    public TarefaAdapter(Context contextoParam, List<Tarefa> arrayTarefas){

        contexto = contextoParam;
        tarefas = arrayTarefas;
    }

    @Override
    public int getCount() {
        return tarefas.size();
    }

    @Override
    public Object getItem(int i) {
        return tarefas.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null){
            LayoutInflater inflador = (LayoutInflater)
                    contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflador.inflate(R.layout.celula_tarefa,null);
            instanciaVisao = new InstanciaVisao();
            instanciaVisao.setTarefaCheckBox((CheckBox) view.findViewById(R.id.tarefaCheckBox));
            instanciaVisao.setCelulaLayout((LinearLayout) view.findViewById(R.id.celulaTarefaLayout));
            view.setTag(instanciaVisao);

        }else{

            instanciaVisao = (InstanciaVisao) view.getTag();

        }
        final Tarefa t = tarefas.get(i);
        instanciaVisao.getTarefaCheckBox().setText(t.getTarefa());
        instanciaVisao.getTarefaCheckBox().setChecked(t.isConcluida());

        instanciaVisao.getCelulaLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contexto, DetalheActivity.class);
                intent.putExtra("tarefa",t);
                contexto.startActivity(intent);
            }
        });
        return view;
    }

    public void setTarefas(List<Tarefa> tarefas) {
    }
}
