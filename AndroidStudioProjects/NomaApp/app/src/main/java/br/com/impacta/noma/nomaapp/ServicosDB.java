package br.com.impacta.noma.nomaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pR on 29/04/2018.
 */

public class ServicosDB extends SQLiteOpenHelper {

    // Nome do BD
    public static final String NOME_BANCO = "Nomaapp.sqlite";

    // Versao do BD
    public static final int VERSAO_BANCO = 1;

    public ServicosDB(Context context){
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // método para executar quando a o BD for criado

        db.execSQL("create table if not exists servicos (" +
                "_id integer primary key autoincrement, " +
                "nome text, " +
                "tempo_estimado integer, " +
                "tempo_aplicacao integer, preco real);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int versaoNova) {
        // método para executar quando a versão do BD for alterasa

        if (versaoAntiga == 1 && versaoNova == 2) {
            db.execSQL("alter table servico add column produto text;");
        }

    }

    public long save(Servico servico) {
        long id = servico.id;
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("nome",servico.nome);
            values.put("tempo_estimado",servico.tempo_estimado);
            values.put("tempo_aplicacao",servico.tempo_aplicacao);
            values.put("preco",servico.preço);
            if(id != 0){
                String _id = String.valueOf(id);
                String [] argsFiltro = new String[]{_id};
                // cirar update servicos set values =... where _id= ?
                int count = db.update("servicos", values,"_id=?",argsFiltro);
                return count;
            } else {
                //criar insert into servicos values (...)
                id = db.insert("servicos","",values);
                return id;
            }
        } finally {
            db.close();
        }
    }

    public List<Servico> findAll() {
        SQLiteDatabase db = getWritableDatabase();
        try {
            // criar select * from servicos
            Cursor c = db.query("servicos",null,null,null,null,null,null,null);
            return toList(c);
        } finally {
            db.close();
        }
    }

    private List<Servico> toList(Cursor c) {
        List<Servico> servicos = new ArrayList<Servico>();
        if (c.moveToFirst()) {
            do{
                Servico servico = new Servico(c.getString(c.getColumnIndex("nome")),
                        c.getInt(c.getColumnIndex("tempo_estimado")), c.getInt(c.getColumnIndex("tempo_aplicacao")), c.getDouble(c.getColumnIndex("preco")));
                servico.id = c.getLong(c.getColumnIndex("_id"));
                servicos.add(servico);
            } while (c.moveToNext());
        }
        return servicos;
    }
}
