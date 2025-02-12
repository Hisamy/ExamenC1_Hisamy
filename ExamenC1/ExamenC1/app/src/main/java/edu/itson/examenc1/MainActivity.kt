package edu.itson.examenc1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tPoliza = findViewById<EditText>(R.id.tipoPoliza)
        var costoPoliza:Double
        val costo =findViewById<TextView>(R.id.costo)
        val pagar = findViewById<TextView>(R.id.pagar)
        val anios = findViewById<EditText>(R.id.anio)
        var costoTotal:Double
        val calcular = findViewById<Button>(R.id.calcular)

        fun calcularTotalPagar(tipoPoliza:Double, anio:TextView):Double{
            var a = anios.toString().toDouble()
            return tipoPoliza*a

        }

        calcular.setOnClickListener {
            costoPoliza = 0.0
            val tp = tPoliza.toString()
            if (tp == "Autos Sedan")      {
                costoPoliza = 500.0
                costoTotal = calcularTotalPagar(costoPoliza, anios)
                costo.setText(String.format(costoPoliza.toString()))
                pagar.setText(String.format(costoTotal.toString()))
            }else if(tp == "Camionetas"){
                costoPoliza = 700.0
                costoTotal = calcularTotalPagar(costoPoliza, anios)
                costo.setText(String.format(costoPoliza.toString()))
                pagar.setText(String.format(costoTotal.toString()))
            } else if(tp == "Autos Deportivos"){
                costoPoliza = 1200.0
                costoTotal = calcularTotalPagar(costoPoliza, anios)
                costo.setText(String.format(costoPoliza.toString()))
                pagar.setText(String.format(costoTotal.toString()))
            }else{
                costo.setText("Error")
                pagar.setText("Error")
            }
        }



    }
}