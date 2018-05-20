package br.com.impacta.noma.nomaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Android on 14/05/2018.
 */

public class ServicoAdapter extends BaseAdapter {

    private final Context context;
    private final List<Servico> listaServicos;

    public ServicoAdapter(Context context, List<Servico> listaServicos ) {
        this.context = context;
        this.listaServicos = listaServicos;
    }


    @Override
    public int getCount() {
        return listaServicos != null? listaServicos.size():0;
    }

    @Override
    public Object getItem(int posicao) {
        return listaServicos.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return posicao;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {

        View viewText = LayoutInflater.from(context).inflate(R.layout.activity_listar_servicos, viewGroup, false);

        TextView t = (TextView) viewText.findViewById(R.id.textItemList);


        Servico servico = listaServicos.get(posicao);
        t.setText(servico.nome);

        return viewText;
    }
}
