package patagoniadev.robopavapp

import android.util.Log
import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.converter.gson.GsonConverterFactory

class CalentadorMate : Calentador{

    val temperatura = 80
    val jsonRoboPava = Gson().toJson(RoboPavaPOJO(temperatura = temperatura))
    val request = RequestBody.create(MediaType.parse("application/json"),jsonRoboPava)

    fun calentar() {
        val response = ClienteRoboPava().apiRoboPava.calentar(request)
        Log.d("Respuesta Servidor", response.toString())
    }

}