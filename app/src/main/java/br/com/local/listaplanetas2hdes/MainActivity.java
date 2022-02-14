package br.com.local.listaplanetas2hdes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] nomePlanetas = {"Jupiter", "Lua", "Marte", "Mercurio", "Netuno",
            "Plutão", "Saturno", "Sol", "Terra", "Urano", "Venus"};
    int[] imagemPlanetas = {R.drawable.jupiter, R.drawable.lua, R.drawable.marte,
            R.drawable.mercurio, R.drawable.netuno, R.drawable.plutao, R.drawable.saturno,
            R.drawable.sol, R.drawable.terra, R.drawable.urano, R.drawable.venus};

    //Declarar a variavel global da lista
    ListView listaPlanetas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaPlanetas = findViewById(R.id.listaPlanetas);
        //Instanciando o adaptador
        MyAdapter adapter = new MyAdapter();
        //criando a lista com os itens do modelo
        listaPlanetas.setAdapter(adapter);

        //Passar a imagem e o nome do planeta para outra tela conforme o clique
        listaPlanetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), RecebePlanetas_Activity.class);

                //metodo putExtra() - passa o valor ou objeto de uma janela para outra
                intent.putExtra("nome_planeta", nomePlanetas[position]);
                intent.putExtra("imagem_planeta", imagemPlanetas[position]);

                //irá abrir a janela e mandar os conteudos.
                startActivity(intent);
            }
        });
    }

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imagemPlanetas.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            TextView nomePlaneta;
            ImageView imgPlaneta;

            //Criando o meu layout no adaptador para ser inflado (instanciado)
            View view = getLayoutInflater().inflate(R.layout.modelo_planeta, null);

            nomePlaneta = view.findViewById(R.id.txtNomePlaneta);
            imgPlaneta = view.findViewById(R.id.imgPlaneta);

            nomePlaneta.setText(nomePlanetas[position]);
            imgPlaneta.setImageResource(imagemPlanetas[position]);

            return view;
        }
    }
}