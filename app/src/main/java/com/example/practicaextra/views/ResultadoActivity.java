package com.example.practicaextra.views;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practicaextra.R;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        TextView textViewResultado = findViewById(R.id.textViewResultado);
        TextView textViewOperacion = findViewById(R.id.textViewOperacion);
        Double resultado = getIntent().getDoubleExtra("Resultado",0);
        String operacion = getIntent().getStringExtra("Operacion");
        textViewResultado.setText(resultado.toString());
        textViewOperacion.setText(operacion);
    }
}