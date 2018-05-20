package br.com.impacta.noma.nomaapp;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class logado extends DebugActivity {

    String[] servicos = {"Corte Masculino","Corte Feminino","Pinturas em geral","Manicure"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_logado);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Logado");

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String profissional = bundle.getString("profissional");
            String servico = bundle.getString("servico");
            String horario = bundle.getString("horario");

            String teste = "teste";

            TextView bemVindo = (TextView) findViewById(R.id.bemVindo);
            bemVindo.setText("Agendamento feito com o "+profissional+" para fazer "+servico+" as "+horario);
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Buscar
        MenuItem item = menu.findItem(R.id.action_procurar);
        SearchView searchView = (SearchView)item.getActionView();
        searchView.setOnQueryTextListener(onSearch());

        // Compartilhar
        MenuItem shareItem = menu.findItem(R.id.action_share);
        ShareActionProvider share = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
        share.setShareIntent(getDefautIntent());

        return true;
    }

    private Intent getDefautIntent() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        intent.putExtra(Intent.EXTRA_TEXT, Arrays.toString(servicos));
        return intent;
    }


    private SearchView.OnQueryTextListener onSearch () {
        return new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(logado.this,"teste1",Toast.LENGTH_SHORT).show();
                return false;
                // Adicionar o codigo de quando o botão de buscar é clicado
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(logado.this,"teste2",Toast.LENGTH_SHORT).show();
                return false;
                // adicionar o codigo de quando o usuario está escrevendo
            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_agendar) {
            agendar();
        } else if (id == R.id.action_calendario) {
            Toast.makeText(logado.this,"Calendario",Toast.LENGTH_SHORT).show();
        } else if ( id == R.id.action_config) {
            Toast.makeText(logado.this,"Config",Toast.LENGTH_SHORT).show();
        } else if ( id == R.id.action_sair) {
            sair();
        } else if ( id == R.id.action_servicos) {
            servicos();
        } else if ( id == R.id.action_config) {
            preferencias();
        }
        return super.onOptionsItemSelected(item);
    }

    private void preferencias() {
        Intent it = new Intent(logado.this,ConfiguracoesActivity.class);
        startActivity(it);
    }

    public void servicos () {
        Intent it = new Intent(logado.this,ServicosActivity.class);
        startActivity(it);
    }

    public void agendar () {
        Intent it = new Intent(logado.this,agendarServico.class);
        startActivity(it);
    }

    public void sair () {
        Intent it = new Intent(logado.this,MainActivity.class);
        startActivity(it);
    }


}
