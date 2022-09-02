package com.example.examennormastransitocol

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val IntroBoton: Button = findViewById(R.id.Ingreso1)
        //val resultTextView: TextView = findViewById(R.id.TextCC)
        val contrase: EditText = findViewById(R.id.ccID)
        val spinner: Spinner = findViewById(R.id.spinner)

        val listaspin = arrayOf("UdeM","Otro")
        val listEtudient = arrayOf("123456")

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaspin)
        spinner.adapter = arrayAdapter

        IntroBoton.setOnClickListener {
            val datano = (contrase.text).toString()

            if(listEtudient.contains(datano)){
                val popUp1 = Toast.makeText(this, " Accediendo ", Toast.LENGTH_SHORT)
                popUp1.show()
                Thread.sleep(1000)
                val examen = Intent(applicationContext, test_start::class.java)
                startActivity(examen)
            } else{
                val popUp1 = Toast.makeText(this, " Usuario no registrado ", Toast.LENGTH_SHORT)
                popUp1.show()

            }

        }
        }
    }





class test_start : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_start)
        val bot1: Button = findViewById(R.id.button)
        val bot2: Button = findViewById(R.id.button2)
        val bot3: Button = findViewById(R.id.button3)
        val bot4: Button = findViewById(R.id.button4)
        val questiontext: TextView = findViewById(R.id.preguntaT)
        var respodado = asignacion_preguntas(bot1,bot2,bot3,bot4,questiontext)

        bot1.setOnClickListener {
            val retorno = chequeo_resp(bot1.text.toString(),respodado,questiontext)
            if(retorno){respodado = asignacion_preguntas(bot1,bot2,bot3,bot4,questiontext)}
        }
        bot2.setOnClickListener {
            val retorno = chequeo_resp(bot2.text.toString(),respodado,questiontext)
            if(retorno){respodado = asignacion_preguntas(bot1,bot2,bot3,bot4,questiontext)}
        }
        bot3.setOnClickListener {
            val retorno = chequeo_resp(bot3.text.toString(),respodado,questiontext)
            if(retorno){respodado = asignacion_preguntas(bot1,bot2,bot3,bot4,questiontext)}
        }
        bot4.setOnClickListener {
            val retorno = chequeo_resp(bot4.text.toString(),respodado,questiontext)
            if(retorno){respodado = asignacion_preguntas(bot1,bot2,bot3,bot4,questiontext)}
        }
    }
}
