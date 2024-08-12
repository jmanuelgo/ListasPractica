package com.example.listasjiji;


import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorPaciente extends ArrayAdapter<Paciente> {
    private Context context;
    private List<Paciente> pacientes;

    public AdaptadorPaciente(Context context, List<Paciente> pacientes) {
        super(context, 0, pacientes);
        this.context = context;
        this.pacientes = pacientes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listviewpersonalizado, parent, false);
        }

        Paciente paciente = pacientes.get(position);

        // Acceder al TextView en el diseño XML
        TextView tvPacienteInfo = convertView.findViewById(R.id.textLista);

        // Aquí puedes asignar el texto que desees desde Java
        String textoPaciente ="<b>"+paciente.getCodigoPaciente() + "</b><br>" +paciente.getNombre() + " " + paciente.getApellido1() + " " + paciente.getApellido2();
        tvPacienteInfo.setText(Html.fromHtml(textoPaciente));

        return convertView;
    }
}

