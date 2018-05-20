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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by pR on 15/04/2018.
 */

public class ServicosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listar_servicos);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Serviços");

        actionBar.setDisplayHomeAsUpEnabled(true);

        ListView lista = (ListView) findViewById(R.id.listaServicos);

        ServicosDB servicosDB = new ServicosDB(ServicosActivity.this);

        lista.setAdapter(new ServicoAdapter(ServicosActivity.this, servicosDB.findAll()));

        lista.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long l) {
                Toast.makeText(ServicosActivity.this,"Clicou: "+ i, Toast.LENGTH_LONG).show();
            }
        });
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
            Intent it = new Intent(ServicosActivity.this,logado.class);
            startActivity(it);
            return true;
        } else if ( id == R.id.action_cadastrar_servico) {
            cadastrarServico2();
        }
        return false;
    }

    public void cadastrarServico () {
        setContentView(R.layout.activity_cadastrar_servico);
    }

    public void cadastrarServico2 () {
        Intent it = new Intent(ServicosActivity.this,CadastrarServico.class);
        startActivity(it);
    }
}
