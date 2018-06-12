package patagoniadev.robopavapp

import android.util.Log
import com.google.gson.Gson
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import java.util.logging.Logger

class CalentadorTe : Calentador{

    val temperatura = 90
    val jsonRoboPava = Gson().toJson(RoboPavaPOJO(temperatura = temperatura))
    val request = RequestBody.create(MediaType.parse("application/json"),jsonRoboPava)

    fun calentar() {
        val response = ClienteRoboPava().apiRoboPava.calentar(request)
        Log.d("Respuesta Servidor", response.toString())
    }
}