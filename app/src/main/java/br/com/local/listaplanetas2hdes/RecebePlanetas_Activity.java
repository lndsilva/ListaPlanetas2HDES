package br.com.local.listaplanetas2hdes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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
        int imagem = intent.getIntExtra("imagem_planeta", 0);

        //os objetos recebendo os valores
        txtRecebeNomePlanetas.setText(nome);
        imgRecebePlanetas.setImageResource(imagem);

        //inserindo a seta na appBar da activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //Para fazer o clique da seta home voltar para a outra activity
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
}