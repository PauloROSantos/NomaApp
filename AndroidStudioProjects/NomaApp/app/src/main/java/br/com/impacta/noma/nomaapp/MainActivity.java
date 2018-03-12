package br.com.impacta.noma.nomaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }
    public void telaLogin(View view){
        setContentView(R.layout.login);
    }

    public void logar(View view){
        Intent it = new Intent(MainActivity.this,logado.class);

        EditText loginDado = (EditText) findViewById(R.id.login_dado);
        String login = loginDado.getText().toString();

        EditText senhaDado = (EditText) findViewById(R.id.senha_dado);
        String senha = senhaDado.getText().toString();

        it.putExtra("login",login );
        it.putExtra("senha",senha );
        startActivity(it);
    }

}
