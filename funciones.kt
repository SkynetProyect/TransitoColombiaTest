package com.example.examennormastransitocol

import android.renderscript.Sampler
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random


//val horas: Int = 0
//val minutos: Int = 60
var total: Double = 0.0
var contRes = 0.0
var entradaAuxI: Int = 0

var usados = arrayListOf<Int>()
var listDatExam = arrayOf(

    arrayOf("Nombre por donde caminan los peatones", "Se deben consumir sustancias al manejar?", "Cambio del auto o moto para arrancar", "Lenin debe presentar el examen", "Numero de ley del codigo nacional de transito " ),

    arrayOf("Zebra","No","Primera","No","Ley 769 de 2002"),

    arrayOf("Caballo","si","segunda","Si","Ley 1801 del 29 Jul, 2016"),

    arrayOf("rotonda","solo cerveza","tercera","Si","DIH segun ONU" ),

    arrayOf("resalto","solo si nadie me ve","cuarta","Si","Ley 1407 del 2010" )
)


fun chequeo_resp(respuesta: String, entradai: Int, texto: TextView ): Boolean{

    println("inicio funcion chequeo_preguntas")
    println("--------------------------------")

    val Auxt: String
    val confirmacion: Boolean

    val respuestaAux = listDatExam[1][entradaAuxI]

    println("respuesta $respuesta en la pos $entradai correcta $respuestaAux")

    if(usados.size != 5){

        println("numero de preguntas No alcanzado")
        println(" ")
        if( respuesta == listDatExam[1][entradai]){ contRes += 1 }
        confirmacion = true

    }else{
        if( respuesta == listDatExam[1][entradai]){ contRes += 1 }
        total = (contRes/5)*100

        println("numero de preguntas alcanzado")
        println(" ")

        if(total >= 60){ Auxt = "    Aprovaste"
        }else{ Auxt = "    Fallaste"}
        val texto1 = "Usted tuvo $total % de aciertos \n $Auxt"
        texto.text = texto1
        confirmacion = false


    }

    println("fin funcion chequeo preguntas")
    println("--------------------------------")

    return confirmacion
}




fun asignacion_preguntas(bot1: Button, bot2: Button, bot3: Button, bot4: Button, texto: TextView): Int {


    println("Iniciada funcion asignacion_preguntas")
    println("***********************************")
    println("aciertos actuales $contRes")
    println("preguntas respondidas ${usados.size}")
    println("***********************************")

    entradaAuxI = (0..4).random()
    while (entradaAuxI in usados){ entradaAuxI = (0..4).random()
    }

        println("Numero de pregunta obtenido == $entradaAuxI")

        val preguntaAux = listDatExam[0][entradaAuxI]
        val respuestaAux = listDatExam[1][entradaAuxI]
        val listaAuxiliar = arrayOf(
            listDatExam[1][entradaAuxI],
            listDatExam[2][entradaAuxI],
            listDatExam[3][entradaAuxI],
            listDatExam[4][entradaAuxI]
        )
        val botones = arrayListOf(bot3, bot2, bot1, bot4)
        texto.text = preguntaAux

        var j = 0
        for (i in botones) {
            i.text = listaAuxiliar[j]; j += 1
        }


        println("pregunta dada  $preguntaAux")

        println("respuesta esperada  $respuestaAux")
        println("--------------------------------")
        usados.add(entradaAuxI)
        println("Codigo y app por lenin Ospina. UdeM")
        println("Fin funcion asignadora de preguntas")
        println("--------------------------------")

    return entradaAuxI
}
