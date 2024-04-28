package com.example.tarea2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Adivina extends AppCompatActivity implements View.OnClickListener {

    EditText txtnum;
    TextView lblint;
    Button btn1, btn2, btn3;
    int ng, L, nume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adivina);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtnum = findViewById(R.id.v3etnum);
        lblint = findViewById(R.id.v3tvint);
        btn1 = findViewById(R.id.v3btnanalizar);
        btn2 = findViewById(R.id.v3btnretornar);
        btn3 = findViewById(R.id.v3btnJugarNuevo);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn2.setEnabled(false);
        btn3.setEnabled(false);

        ng = (int)(Math.random()*10+1);
        L = 1;
        lblint.setText(L + " intento ");
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.v3btnretornar){
            finish();
        }

        if(v.getId() == R.id.v3btnanalizar){
            if(txtnum.getText().toString().isEmpty()){
                Toast.makeText(this, "Falta el número", Toast.LENGTH_SHORT).show();
                txtnum.requestFocus();
            } else {

                if(nume <=10 && nume >=0){
                    if(ng == Integer.parseInt(txtnum.getText().toString())){
                        Toast.makeText(this, "¡Ganó!", Toast.LENGTH_SHORT).show();
                        txtnum.setEnabled(false);
                        btn1.setEnabled(false);
                        btn2.setEnabled(true);
                        btn3.setEnabled(true);
                    } else {
                        nume = Integer.parseInt(txtnum.getText().toString());
                        if(nume < ng){
                            Toast.makeText(this, "El numero a adivinar es mayor a "+nume, Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(this, "El numero a adivinar es menor a "+nume, Toast.LENGTH_SHORT).show();
                        }
                        L++;
                        if(L <= 5) {
                            lblint.setText(L + " intento");
                            Toast.makeText(this, "Error, no es el número", Toast.LENGTH_SHORT).show();

                            txtnum.setText("");
                            txtnum.requestFocus();
                        } else {
                            Toast.makeText(this, "¡Perdió!", Toast.LENGTH_SHORT).show();
                            txtnum.setEnabled(false);
                            btn1.setEnabled(false);
                            btn2.setEnabled(true);
                            btn3.setEnabled(true);
                        }
                    }
                }else {
                    Toast.makeText(this, "Ingrese un nuemro del 1 al 10", Toast.LENGTH_SHORT).show();
                }







            }
        }
    }
    public void playAgain(View v){
        // Habilitar la entrada de texto y los botones
        txtnum.setEnabled(true);
        btn1.setEnabled(true);
        btn2.setEnabled(false);
        btn3.setEnabled(false);

        // Generar un nuevo número aleatorio
        ng = (int)(Math.random() * 10 + 1);

        // Restablecer el contador de intentos a 1
        L = 1;
        lblint.setText(L + " intento");

        // Limpiar el campo de texto
        txtnum.setText("");
        txtnum.requestFocus();

        // Limpiar cualquier mensaje de tostada anterior
        Toast.makeText(this, "", Toast.LENGTH_SHORT).cancel();
    }
}
