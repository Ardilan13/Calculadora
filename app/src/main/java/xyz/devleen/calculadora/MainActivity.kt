package xyz.devleen.calculadora

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var num1: EditText? = null
    private var num2: EditText? = null
    private var resultado: TextView? = null
    private var x = 0
    private var y = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        num1 = findViewById<View>(R.id.Num1) as EditText
        num2 = findViewById<View>(R.id.Num2) as EditText
        resultado = findViewById<View>(R.id.Result) as TextView
    }

    fun Click(view: View) {
        x = num1!!.text.toString().toInt()
        y = num2!!.text.toString().toInt()
        when (view.id) {
            R.id.BtnSuma -> Sumar()
            R.id.BtnRes -> Restar()
            R.id.BtnMul -> Multiplicar()
            R.id.BtnDiv -> Dividir()
        }
    }

    private fun Sumar() {
        val suma = x + y
        resultado!!.text = "El resultado es: $suma"
    }

    private fun Restar() {
        val resta = x - y
        resultado!!.text = "El resultado es: $resta"
    }

    private fun Multiplicar() {
        val multiplicacion = x * y
        resultado!!.text = "El resultado es: $multiplicacion"
    }

    private fun Dividir() {
        if (y > 0) {
            val division = (x / y).toFloat()
            resultado!!.text = "El resultado es: $division"
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
            resultado!!.text = "El segundo numero debe ser mayor a 0."
        }
    }
}