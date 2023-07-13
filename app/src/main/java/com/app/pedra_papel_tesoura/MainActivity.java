package com.app.pedra_papel_tesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");

    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");

    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");

    }

    public void opcaoSelecionada(String escolhaUsuario){
        ImageView imagemResultado = findViewById(R.id.ImageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        int numero = new Random(). nextInt(3);
        String[] opcoes = {"pedra","papel","tesoura"};
        String escolhaApp = opcoes[numero];
        System.out.println("Item selecionado: " + escolhaApp);
        switch (escolhaApp){
            case "pedra" :
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
        }

        if(
                (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
                        (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                        (escolhaApp == "pedra" && escolhaUsuario == "tesoura")
        ){ //App ganhador
            textoResultado.setText("Você perdeu! :(");
        }else if(
                (escolhaApp == "tesoura" && escolhaUsuario == "pedra") ||
                        (escolhaApp == "papel" && escolhaUsuario == "tesoura") ||
                        (escolhaApp == "pedra" && escolhaUsuario == "papel")
        ){ //Usuario ganhador
            textoResultado.setText("Você ganhou! :)");
        }else { //Empate
            textoResultado.setText("Empatamos! ;)");
        }

    }
}