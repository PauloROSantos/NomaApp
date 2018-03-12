package br.com.impacta.noma.nomaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class logado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_logado);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String login = bundle.getString("login");
            String senha = bundle.getString("senha");

            TextView bemVindo = (TextView) findViewById(R.id.bemVindo);
            bemVindo.setText("Bem vindo "+login+" sua senha é "+senha);
        }

    }
}
