package br.com.local.listaplanetas2hdes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RecebePlanetas_Activity extends AppCompatActivity {

    TextView txtRecebeNomePlanetas;
    ImageView imgRecebePlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recebe_planetas_layout);

        txtRecebeNomePlanetas = findViewById(R.id.txtRecebeNomePlaneta);
        imgRecebePlanetas = findViewById(R.id.imgRecebePlaneta);

        //Intent que receberá os dados da ourta activity
        Intent intent = getIntent();

        //Declarar as variáveis para receber os valores do mesmo tipo

        String nome = intent.getStringExtra("nome_planeta");
        int imagem = intent.getIntExtra("imagem_planeta",0);

        //os objetos recebendo os valores
        txtRecebeNomePlanetas.setText(nome);
        imgRecebePlanetas.setImageResource(imagem);

        

    }
}