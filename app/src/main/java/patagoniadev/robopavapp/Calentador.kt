package patagoniadev.robopavapp

import android.widget.Toast

interface Calentador{

    fun calentar(temperatura: Int){
        // Realiza POST al servidor de la RoboPava
        // para calentar a la temperatura @temperatura
    }

    fun mostrarMensaje(){

    }

}
