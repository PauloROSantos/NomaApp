package br.com.impacta.noma.nomaapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class agendarServico extends AppCompatActivity {

    private String[] servicos = new String[]{"Corte masculino","Corte Feminino","Pintura","Escova"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_agendar_servico);


        Spinner spinner = findViewById(R.id.spinner2);
        ServicosDB servicosDB = new ServicosDB(agendarServico.this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,servicos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //spinner.setAdapter(new ServicoAdapter(agendarServico.this, servicosDB.findAll()));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //EditText agendamentoServico = (EditText) findViewById(R.id.agendar_servicoDado);
                //agendamentoServico.setText(view.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

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
        //String strAgendamentoServico = agendamentoServico.getText().toString();
        Spinner sp = (Spinner) findViewById(R.id.spinner2);
        String strAgendamentoServico = sp.getSelectedItem().toString();

        EditText agendamentoHorario = (EditText) findViewById(R.id.agendar_horarioDado);
        String strAgendamentoHorario = agendamentoHorario.getText().toString();

        it.putExtra("profissional",strAgendamentoPro);
        it.putExtra("servico",strAgendamentoServico);
        it.putExtra("horario",strAgendamentoHorario);

        startActivity(it);



    }
}
