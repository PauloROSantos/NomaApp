package br.com.impacta.noma.nomaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by pR on 15/04/2018.
 */

public class SimplesAdapter extends BaseAdapter {

    public class Servico{
        public String nome;
        public String preço;

        public Servico(String nome, String preço){
            this.nome = nome;
            this.preço = preço;
        }
    }



    public Servico [] listaServicos = new Servico[] {
            new Servico("Corte Masculino","60"),
            new Servico("Corte Feminino","120"),
            new Servico("Tingir","250"),
            new Servico("Escova","150"),
            new Servico("Mão","45"),
            new Servico("Pé","75"),
            new Servico("Quimica","350"),
            new Servico("Penteado","120"),
            new Servico("Maquiagem","90")
    };

    Context contexto;

    public SimplesAdapter (Context contexto) {
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return listaServicos.length;
    }

    @Override
    public Object getItem(int i) {
        return listaServicos[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Servico servico = listaServicos[i];

        View viewText = LayoutInflater.from(contexto).inflate(R.layout.servico_itens, viewGroup, false);
        TextView nome = (TextView) viewText.findViewById(R.id.textItemList);
        nome.setText(servico.nome);

        TextView preço = (TextView) viewText.findViewById(R.id.textItemListPreco);
        preço.setText("preço: " + servico.preço);

        return viewText;
    }
}
