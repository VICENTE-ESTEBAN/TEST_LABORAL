package com.ibermatica.pruebaandroid.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import com.ibermatica.pruebaandroid.R;

public class MainActivity extends AppCompatActivity {

    private EditText etOpA, etOpB, etNombre;
    private TextView tvNombre;
    private Button btCalcular;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        etOpA = findViewById(R.id.etOpA);
        etOpB = findViewById(R.id.etOpB);

        tvResultado = findViewById(R.id.tvResultado);
        tvNombre = findViewById(R.id.tvNombre);
        etNombre = findViewById(R.id.etNombre);
        btCalcular = findViewById(R.id.btCalculate);
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiplicar();
            }
        });
    }

    private void multiplicar(){
        try {
            int resultado = Integer.parseInt(etOpA.getText().toString()) * Integer.parseInt(etOpB.getText().toString());
            tvResultado.setText(String.valueOf(resultado));
        }catch (Exception ex)
        {
            tvResultado.setText(getResources().getText(R.string.number_format_error));
        }

    }

    public void showNombre(View view){
        tvNombre.setText(etNombre.getText().toString());
    }

    public void goNewActivity(View view) {
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);
    }
}
