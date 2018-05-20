package br.com.impacta.noma.nomaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends DebugActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

        EditText loginDado = (EditText) findViewById(R.id.login_dado);
        EditText senhaDado = (EditText) findViewById(R.id.senha_dado);
        CheckBox checkLembrar = (CheckBox) findViewById(R.id.checkLembrar);

        String login = Prefs.getString(MainActivity.this,"login");
        String senha = Prefs.getString(MainActivity.this,"senha");
        boolean lembrar = Prefs.getBoolean(MainActivity.this,"lembrar");

        loginDado.setText(login);
        senhaDado.setText(senha);
        checkLembrar.setChecked(lembrar);


    }

    public void logar(View view){
        Intent it = new Intent(MainActivity.this,logado.class);

        ProgressBar loading = (ProgressBar) findViewById(R.id.progressBar_login);
        loading.setVisibility(view.VISIBLE);

        Button logar = (Button) findViewById(R.id.button_login);
        logar.setVisibility(view.INVISIBLE);

        EditText loginDado = (EditText) findViewById(R.id.login_dado);
        String login = loginDado.getText().toString();

        EditText senhaDado = (EditText) findViewById(R.id.senha_dado);
        String senha = senhaDado.getText().toString();

        CheckBox checkLembrar = (CheckBox) findViewById(R.id.checkLembrar);
        boolean lembrar = checkLembrar.isChecked();

        if(lembrar){
            Prefs.setBoolean(MainActivity.this,"lembrar",lembrar);
            Prefs.setString(MainActivity.this,"login",login);
            Prefs.setString(MainActivity.this,"senha",senha);
        } else{
            Prefs.setBoolean(MainActivity.this,"lembrar",false);
            Prefs.setString(MainActivity.this,"login","");
            Prefs.setString(MainActivity.this,"senha","");
        }

        startActivity(it);
    }

}
