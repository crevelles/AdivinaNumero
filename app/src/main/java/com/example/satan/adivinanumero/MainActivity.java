package com.example.satan.adivinanumero;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Cristóbal Revelles de la peña

    TextView textoIntentos;
    TextView textoPista;
    TextView numSec;
    EditText  numero;
    Button botonComparaNumero;
    Button nuevaPartida;
    int numeroAzar;
    int contador;
    RelativeLayout fondo;
    int verde;
    int rojo;
    int amarillo; ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.numeroAzar = (int) (Math.random()*10) + 1;
        this.textoIntentos = (TextView) findViewById(R.id.textIntentos);
        this.textoPista = (TextView) findViewById(R.id.textPista);
        this.numero = (EditText) findViewById(R.id.textNumero);
        this.botonComparaNumero = (Button) findViewById(R.id.comparaNumero);
        this.contador = 5;
        this.numSec = (TextView) findViewById(R.id.numSecreto);
        //this.numSec.setText(numeroAzar+"");
        this.fondo = (RelativeLayout) findViewById(R.id.layout);
        this.verde = Color.parseColor("#FF57FF2C");
        this.rojo = Color.parseColor("#FFFF342B");
        this.amarillo = Color.parseColor("#fff644");
        this.nuevaPartida  = (Button) findViewById(R.id.btnNuevaPartida);
        this.nuevaPartida.setEnabled(false);
    }


    public void jugarNuevaPartida(View view){
            contador = 5;
            comprobar(view);
            this.nuevaPartida.setEnabled(false);
            this.botonComparaNumero.setEnabled(true);
            this.botonComparaNumero.setText("COMPROBAR NUMERO");
            this.fondo.setBackgroundColor(amarillo);
            this.numSec.setText("");
            this.textoPista.setText("Debes adivinar el número secreto entre 1 y 100. \n Tienes 5 intentos");
             this.numero.setText("");
    }

    public void comprobar(View view){
        this.nuevaPartida.setEnabled(false);
        this.botonComparaNumero.setEnabled(true);
        this.botonComparaNumero.setText("COMPROBAR NUMERO");
        this.fondo.setBackgroundColor(amarillo);
        if(contador <= 1){
            this.textoPista.setText("Has agotado todos los intentos");
            this.fondo.setBackgroundColor(rojo);
            this.botonComparaNumero.setText("JUEGO TERMINADO");
            this.botonComparaNumero.setEnabled(false);
            this.numSec.setText("El número secreto era: "+numeroAzar+"");
            this.textoIntentos.setText("");
            this.nuevaPartida.setEnabled(true);
             this.numero.setText("");
        } else {
            if(this.numero.getText().toString().isEmpty() ){
                this.textoPista.setText("no puede quedar el campo vacio");
            } else {
                if(Integer.parseInt(this.numero.getText().toString()) == numeroAzar){
                    contador--;

                    this.textoPista.setText("HAS ACERTADO ");
                    this.textoIntentos.setText("");
                    this.botonComparaNumero.setEnabled(false);
                    this.fondo.setBackgroundColor(verde);
                    this.botonComparaNumero.setText("JUEGO TERMINADO");
                    this.botonComparaNumero.setEnabled(false);
                    this.numSec.setText("El número secreto era: "+numeroAzar+" \nNúmero introducido" +
                            ": " + this.numero.getText());
                    this.nuevaPartida.setEnabled(true);
                    this.numero.setText("");

                } else{
                    if(Integer.parseInt(this.numero.getText().toString()) > numeroAzar){
                        contador--;
                        this.textoPista.setText("EL número introducido es mayor");
                        this.textoIntentos.setText("Le quedan " + contador + " intentos");
                        this.numero.setText("");
                    } else {
                        contador--;
                        this.textoIntentos.setText("Le quedan " + contador + " intentos");
                        this.textoPista.setText("EL número introducido es menor");
                        this.numero.setText("");
                    }
                }
            }
        }



    }


}
