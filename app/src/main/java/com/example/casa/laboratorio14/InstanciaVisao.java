package com.example.casa.laboratorio14;

import android.widget.CheckBox;
import android.widget.LinearLayout;

/**
 * Created by casa on 10/12/2016.
 */
public class InstanciaVisao {

    private CheckBox tarefaCheckBox;
    private LinearLayout celulaLayout;

    public CheckBox getTarefaCheckBox() {
        return tarefaCheckBox;
    }

    public void setTarefaCheckBox(CheckBox tarefaCheckBox) {
        this.tarefaCheckBox = tarefaCheckBox;
    }

    public LinearLayout getCelulaLayout() {
        return celulaLayout;
    }

    public void setCelulaLayout(LinearLayout celulaLayout) {
        this.celulaLayout = celulaLayout;
    }
}
