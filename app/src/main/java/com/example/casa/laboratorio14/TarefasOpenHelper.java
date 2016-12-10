package com.example.casa.laboratorio14;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.StringBuilderPrinter;

/**
 * Created by casa on 09/12/2016.
 */
public class TarefasOpenHelper extends SQLiteOpenHelper {

    private static final String Banco1 ="TarefasBancoDados";
    private static final int Versao=1;

    private Context contexto;


    public TarefasOpenHelper(Context context) {
        super(context, Banco1, null, Versao);
        this.contexto = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql= "CREATE TABLE tarefas "+
                    "(_id integer PRIMARY KEY "+
                    " AUTOINCREMENT, "+
                    " tarefa text, " +
                    " descricao text, " +
                    " concluida boolean)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if (oldVersion ==1 && newVersion ==3){
            String sql= "CREATE TABLE aluno "+
                        "(_id integer PRIMARY KEY "+
                        " AUTOINCREMENT, "+
                        " nome text, " +
                        " matricula text, " +
                        " email text)";
            sqLiteDatabase.execSQL(sql);
        }

    }
}
