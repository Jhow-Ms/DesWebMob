package br.com.john.servicedeskccp3anbua;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ChamadosAdapter extends ArrayAdapter<Chamado> {

    private List<Chamado> chamados;
    private Context context;

    public ChamadosAdapter (List<Chamado> chamados, Context context){
        super(context, -1, chamados);
        this.chamados = chamados;
        this.context = context;
    }

    @Override
    public int getCount() {
        return chamados.size();
    }

    @Override
    public Chamado getItem(int position) {
        return chamados.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        Chamado deInteresse = chamados.get(position);
        TextView filaDoItemTextView;
        TextView descricaoDoItemTextView;
        ViewHolder viewHolder;

        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            filaDoItemTextView = convertView.findViewById(R.id.filaDoItemTextView);
            descricaoDoItemTextView = convertView.findViewById(R.id.descricaoDoItemTextView);
            viewHolder = new ViewHolder();
            viewHolder.filaDoItemTextView = filaDoItemTextView;
            viewHolder.descricaoDoItemTextView = descricaoDoItemTextView;
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();

        viewHolder.filaDoItemTextView.setText(deInteresse.getFila());
        viewHolder.descricaoDoItemTextView.setText(deInteresse.getDescricao());

        return convertView;


    }

    private class ViewHolder{
        TextView filaDoItemTextView;
        TextView descricaoDoItemTextView;
    }
}