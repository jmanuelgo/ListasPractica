package com.example.listasjiji;


import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
        ImageView ivPacienteImage= convertView.findViewById(R.id.imagePaciente);


        // Aquí puedes asignar el texto que desees desde Java
        String textoPaciente ="<b>"+paciente.getCodigoPaciente() + "</b><br>" +paciente.getNombre() + " " + paciente.getApellido1() + " " + paciente.getApellido2();
        tvPacienteInfo.setText(Html.fromHtml(textoPaciente));

        if ("masculino".equalsIgnoreCase(paciente.getSexo())) {
            ivPacienteImage.setImageResource(R.drawable.hombre1); // Asegúrate de tener este recurso
        } else if ("femenino".equalsIgnoreCase(paciente.getSexo())) {
            ivPacienteImage.setImageResource(R.drawable.hombre); // Asegúrate de tener este recurso
        } else {
            ivPacienteImage.setImageResource(R.drawable.hombre); // Imagen genérica para otros casos
        }

        return convertView;
    }
}

