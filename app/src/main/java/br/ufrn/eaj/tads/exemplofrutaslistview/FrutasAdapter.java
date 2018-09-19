package br.ufrn.eaj.tads.exemplofrutaslistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.ufrn.eaj.tads.exemplofrutaslistview.banco.Fruta;

/**
 * Created by Taniro on 14/09/2016 and updated on 18/08/2018.
 */

public class FrutasAdapter extends BaseAdapter {

    Context context;
    List<Fruta>  frutas;

    public FrutasAdapter (Context context, List<Fruta> frutas){
        super();
        this.context = context;
        this.frutas = frutas;
    }

    @Override
    public int getCount() {
        return frutas != null ? frutas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return frutas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //Infla a View
        View v = LayoutInflater.from(context).inflate(R.layout.fruta_inflater, viewGroup, false);
        TextView t = v.findViewById(R.id.nomeFruta);
        ImageView img = v.findViewById(R.id.imgFruta);

        //obtem a fruta da lista
        Fruta fruta = frutas.get(i);

        //Atribui as informações da fruta na View
        t.setText(fruta.getNome());
        img.setImageResource(fruta.getImagem());

        //retorna a View
        return v;
    }
}
