package br.com.impacta.noma.nomaapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by pR on 25/03/2018.
 */

public class DebugActivity extends AppCompatActivity {


    private String getClassName(){
        String s = getClass().getName();
        return s.substring(s.lastIndexOf("."));
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("NomaApp  ", ".onStart() chamado");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("NomaApp",getClassName()+ ".onRestart() chamado");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("NomaApp",getClassName()+ ".onResume() chamado");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("NomaApp",getClassName()+ ".onPause() chamado");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("NomaApp",getClassName()+ ".onStop() chamado");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("NomaApp",getClassName()+ ".onDestroy() chamado");
    }

}
