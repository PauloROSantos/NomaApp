package br.com.impacta.noma.nomaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by pR on 20/05/2018.
 */

public class CadastrarServico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cadastrar_servico);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Cadastrar Serviços");

        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_servicos, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home) {
            Intent it = new Intent(CadastrarServico.this,ServicosActivity.class);
            startActivity(it);
            return true;
        }
        return false;
    }
    public void CadastrarServicoFn(View view) {
        EditText nomeServico = (EditText) findViewById(R.id.cadNomeServicoDado);
        EditText tempoEstimadoServico = (EditText) findViewById(R.id.cadTempoEstimadoServicoDado);
        EditText tempoAplicacaoServico = (EditText) findViewById(R.id.cadTempoAplicacaoServicoDado);
        EditText precoServico = (EditText) findViewById(R.id.cadPreçoServicoDado);

        String nome = nomeServico.getText().toString();
        Integer tempoEstimado = Integer.parseInt(tempoEstimadoServico.getText().toString());
        Integer tempoAplicacao = Integer.parseInt(tempoAplicacaoServico.getText().toString());
        Double preco = Double.parseDouble(precoServico.getText().toString());

        Servico servico = new Servico(nome,tempoEstimado,tempoAplicacao,preco);
        ServicosDB dbServicos = new ServicosDB(CadastrarServico.this);
        dbServicos.save(servico);
        limpar();
    }

    private void limpar() {
        EditText nomeServico = (EditText) findViewById(R.id.cadNomeServicoDado);
        EditText tempoEstimadoServico = (EditText) findViewById(R.id.cadTempoEstimadoServicoDado);
        EditText tempoAplicacaoServico = (EditText) findViewById(R.id.cadTempoAplicacaoServicoDado);
        EditText precoServico = (EditText) findViewById(R.id.cadPreçoServicoDado);

        nomeServico.setText("");
        tempoEstimadoServico.setText("");
        tempoAplicacaoServico.setText("");
        precoServico.setText("");
    }
}
