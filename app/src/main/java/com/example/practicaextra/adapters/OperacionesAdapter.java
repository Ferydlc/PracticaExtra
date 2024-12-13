package com.example.practicaextra.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.practicaextra.R;
import com.example.practicaextra.Splash;
import com.example.practicaextra.models.Operacion;
import com.example.practicaextra.views.MainActivity;
import com.example.practicaextra.views.ResultadoActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OperacionesAdapter extends RecyclerView.Adapter<OperacionesAdapter.ViewHolder> {
    private List<Operacion> localDataSet;

    public OperacionesAdapter (List<Operacion> localDataSet){
        this.localDataSet = localDataSet;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewOperacion;
        private ImageView imgViewOperacion;
        private EditText editTextOperacion1, editTextOperacion2;
        public ViewHolder(View view) {
            super(view);
            textViewOperacion = view.findViewById(R.id.textViewOperacion);
            imgViewOperacion = view.findViewById(R.id.imageView);
            editTextOperacion1 = view.findViewById(R.id.editTextNumber);
            editTextOperacion2 = view.findViewById(R.id.editTextNumber2);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_operacion, viewGroup, false);

        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Operacion operacion = localDataSet.get(position);
        viewHolder.textViewOperacion.setText(operacion.getNombre());
        viewHolder.imgViewOperacion.setOnClickListener(v -> {
            String num1 = viewHolder.editTextOperacion1.getText().toString();
            String num2 = viewHolder.editTextOperacion2.getText().toString();
            if (num1.isEmpty()){
                Toast.makeText(v.getContext(),"OH! Esta vacío el primer número ≡(▔﹏▔)≡",Toast.LENGTH_SHORT).show();
                return;
            }
            if (num2.isEmpty()){
                Toast.makeText(v.getContext(),"OH! Esta vacío el segundo número ≡(▔﹏▔)≡",Toast.LENGTH_SHORT).show();
                return;
            }
            if(num2.isEmpty() && num1.isEmpty()) {
                Toast.makeText(v.getContext(),"OH! Dejaste los campos vacíos ≡(▔﹏▔)≡",Toast.LENGTH_SHORT).show();
                return;
            }
            Double num1double = Double.parseDouble(num1); //parsear valores
            Double num2double = Double.parseDouble(num2);
            operacion.setNumero1(num1double);
            operacion.setNumero2(num2double);
            int ImagenId;
            switch (operacion.getNombre()){
                case "Suma":
                    operacion.suma();
                    ImagenId = R.drawable.plus;
                    break;
                case "Resta":
                    operacion.resta();
                    ImagenId = R.drawable.menos;
                    break;
                case "Multiplicacion":
                    operacion.multiplicacion();
                    ImagenId = R.drawable.multiplicacion;
                    break;
                case "Division":
                    if (num2double == 0){
                        Toast.makeText(v.getContext(), "No se puede dividir entre 0!!(ﾟヮﾟ)",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    operacion.division();
                    ImagenId = R.drawable.division;
                    break;
                default:
                    ImagenId = R.drawable.ic_launcher_foreground;
                    break;
            }
            Picasso.get()
                    .load("android.resource://" + v.getContext().getPackageName() + "/" + ImagenId)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_background)
                    .into(viewHolder.imgViewOperacion);
            Intent intent=new Intent(v.getContext(), ResultadoActivity.class);
            intent.putExtra("Resultado",operacion.getResultado());
            intent.putExtra("Operacion", operacion.getNombre());
            v.getContext().startActivity(intent);
        });
    }
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
