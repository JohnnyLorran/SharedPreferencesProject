package com.example.sharedpreferencesproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "App_SP";
    private static final String Pref_nome = "SharedPaste";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor dados;

    TextView txt1,txt2,txt3,txt4,txt5;

    String nomeProduto;
    int codigoProduto;
    float precoProduto;
    boolean estoque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.i(TAG,"OnCreate: rodando!");

        sharedPreferences = getSharedPreferences(Pref_nome, Context.MODE_PRIVATE);

        Log.i(TAG,"Pasta SharedPaste criada !");

        dados = sharedPreferences.edit();
        nomeProduto = "Computador";
        codigoProduto = 123;
        precoProduto = 2750.00f;
        estoque = true;

        Log.i(TAG,"Dados para serem salvos");
        Log.w(TAG,"Produto: "+nomeProduto);
        Log.w(TAG,"Código: "+codigoProduto);
        Log.w(TAG,"Preço: "+precoProduto);
        Log.w(TAG,"Estoque: "+estoque);

        dados.putString("nomeProduto",nomeProduto);
        dados.putInt("codigoProduto",codigoProduto);
        dados.putFloat("precoProduto",precoProduto);
        dados.putBoolean("estoque",estoque);

        dados.apply();
        //dados.clear(); Apagar tudo
        //dados.remove("estoque"); remove apenas o estoque

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);

        txt1.setText("Produto Recuperado !");
        txt2.setText("Nome do produto: " + sharedPreferences.getString("nomeProduto","Não encontrado"));
        txt3.setText("Código do produto: " + sharedPreferences.getInt("codigoProduto",0));
        txt4.setText("Preço R$: " + sharedPreferences.getFloat("precoProduto",0));
        if (sharedPreferences.getBoolean("estoque",false))
            txt5.setText("Estoque: Sim");
        else
            txt5.setText("Estoque: Não");




    }
}