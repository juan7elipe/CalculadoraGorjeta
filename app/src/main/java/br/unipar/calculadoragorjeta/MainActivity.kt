package br.unipar.calculadoragorjeta

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val inputConta = findViewById<EditText>(R.id.edConta)
        val inputGorjeta = findViewById<EditText>(R.id.edGorjeta)
        val botaoCalcular = findViewById<Button>(R.id.btnCalculo)
        val resultado = findViewById<TextView>(R.id.txtResultado)

        botaoCalcular.setOnClickListener {
            val contaString = inputConta.text.toString()
            val gorjetaString = inputGorjeta.text.toString()

            if (contaString.isNotEmpty() && gorjetaString.isNotEmpty()) {
                val gorjeta = gorjetaString.toInt()
                val conta = contaString.toInt()

                val total = conta * (gorjeta / 100)
                resultado.text = "Valor da gorjeta: $total"

                val resultadoTotal = conta + gorjeta
                resultado.text = "Valor Total: $resultadoTotal"

            } else {
                resultado.text = "Os campos estão vazios"
            }
        }
    }

    fun limparValores(view: View) {
        val resultado = findViewById<TextView>(R.id.txtResultado)
        val input = findViewById<EditText>(R.id.edConta)
        val input2 = findViewById<EditText>(R.id.edGorjeta)

        resultado.setText("")
        input.setText("")
        input2.setText("")
    }
}