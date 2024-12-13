package com.example.practicaextra.views;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practicaextra.R;
import com.example.practicaextra.adapters.OperacionesAdapter;
import com.example.practicaextra.models.Operacion;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycleOperaciones);
        List<Operacion> operacionList = new ArrayList<>();
        operacionList.add(new Operacion("Suma"));
        operacionList.add(new Operacion("Resta"));
        operacionList.add(new Operacion("Multiplicacion"));
        operacionList.add(new Operacion("Division"));
        OperacionesAdapter customAdapter = new OperacionesAdapter(operacionList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customAdapter);
    }
}