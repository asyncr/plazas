package com.example.plazapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.plazapp.databinding.ActivityMainBinding

/**
 * PROBLEMA
 * Realizar una aplicación móvil que integre sentencias de control selectivas y repetitivas.
 *
 * El presidente de Santa Cruz Xoxocotlán requiere una aplicación móvil que le permita  obtener el
 * área de pasto que necesita plantar en cada una de las diferentes plazas circulares que existen
 * en _todo el municipio.
 * Las plazas comprenden un radio entre 100 y 300 metros y además dentro de
 * cada una de ellas hay 7 farolas cuyas bases son círculos de 1 metro de radio.
 *
 * Realice una aplicación en Android considerando los criterios anteriores.
 */



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.supportActionBar?.hide()
        Toast.makeText(this,"Bienvenido",Toast.LENGTH_SHORT).show()
        binding.imageView.requestFocus()
        enviarDatos()
    }

    fun enviarDatos(){
        binding.btnCalcular.setOnClickListener {
            hideKeyboard()
            var n = binding.edtPlazas.text
            if(n.isNotEmpty()){
                var number = n.toString().toInt()
                if (estaEnrango(number)){
                    binding.tvMil.text= "Area  >>  ${enviarArea(number).toString()} m2"
                }else{
                    Toast.makeText(this,"Ingresa un radio entre 100m y 300m", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun estaEnrango(radius: Int): Boolean = radius in 100..300

    fun enviarArea(radius: Int):Double = (area(radius) - area(1)*7)

    fun area(radius:Int) = constants.PI * (radius * radius)

    fun usodeMath(){
        var base: Int = 2
        var numeroaElevar: Int = 10
        Math.pow(base.toDouble(), numeroaElevar.toDouble())

        //Val es una variable que se declara una vez, algo parecido a las constantes.

    }

    object constants { const val PI = 3.1416 }

    fun hideKeyboard(){
        val imM: InputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imM.hideSoftInputFromWindow(binding.mainact.windowToken,0)
    }
}