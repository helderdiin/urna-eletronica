package helder.com.br.urnaeletronica.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import helder.com.br.urnaeletronica.R;
import helder.com.br.urnaeletronica.adapter.ListaAdapter;
import helder.com.br.urnaeletronica.api.APIClient;
import helder.com.br.urnaeletronica.models.Candidato;
import helder.com.br.urnaeletronica.api.APIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListActivity extends AppCompatActivity {
    private APIInterface APIInterface;
    private ProgressDialog progressMainActivity = null;
    private ListView lista;
    private ListaAdapter adapter;
    private List<Candidato> candidatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id) {
                Intent intent = new Intent(ListActivity.this, DetalheActivity.class);
                intent.putExtra("id", candidatos.get(posicao).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getCandidatos();
    }



    private void getCandidatos() {
        progressMainActivity = ProgressDialog.show(ListActivity.this,
                "Aguarde ...", "Recebendo informações da web", true, true);
        APIInterface = APIClient.getClient().create(APIInterface.class);

        Call<List<Candidato>> call = APIInterface.findAllCandidatos("application/json");
        call.enqueue(new Callback<List<Candidato>>() {
            @Override
            public void onResponse(Call<List<Candidato>> call, Response<List<Candidato>> response) {
                if (response.isSuccessful()) {
                    candidatos = response.body();
                    updateList();
                    progressMainActivity.dismiss();
                } else {
                    progressMainActivity.dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<Candidato>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void updateList() {
        adapter = new ListaAdapter(getApplicationContext(), candidatos);
        lista.setAdapter(adapter);
    }
}
