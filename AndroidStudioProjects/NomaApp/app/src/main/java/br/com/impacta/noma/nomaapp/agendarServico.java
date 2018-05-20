package br.com.impacta.noma.nomaapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class agendarServico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_agendar_servico);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Agendamento");

        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_agendamento, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home) {
            Intent it = new Intent(agendarServico.this,logado.class);
            startActivity(it);
            return true;
        }
        return false;
    }

    public void enviarAgendamento (View view) {
        Intent it = new Intent(agendarServico.this,logado.class);

        EditText agendamentoProfissional = (EditText) findViewById(R.id.agendar_profissionalDado);
        String strAgendamentoPro = agendamentoProfissional.getText().toString();

        EditText agendamentoServico = (EditText) findViewById(R.id.agendar_servicoDado);
        String strAgendamentoServico = agendamentoServico.getText().toString();

        EditText agendamentoHorario = (EditText) findViewById(R.id.agendar_horarioDado);
        String strAgendamentoHorario = agendamentoHorario.getText().toString();

        it.putExtra("profissional",strAgendamentoPro);
        it.putExtra("servico",strAgendamentoServico);
        it.putExtra("horario",strAgendamentoHorario);

        startActivity(it);



    }
}
