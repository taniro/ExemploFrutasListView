package br.ufrn.eaj.tads.exemplofrutaslistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.eaj.tads.exemplofrutaslistview.banco.AppDatabase;
import br.ufrn.eaj.tads.exemplofrutaslistview.banco.Fruta;
import br.ufrn.eaj.tads.exemplofrutaslistview.banco.FrutaDao;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;
    FrutaDao myFrutaDao;

    List<Fruta> frutas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getDatabase(this);
        myFrutaDao = db.frutaDao();

        frutas = myFrutaDao.listAllInList();

        ListView lista = findViewById(R.id.minhalista);
        //GridView lista = findViewById(R.id.minhalista);
        lista.setAdapter(new FrutasAdapter(this, frutas));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fruta  f =  frutas.get(i);
                Toast.makeText(getApplicationContext(), "Fruta selecionada: "+ f.getNome() + ", posicao: " + i, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
