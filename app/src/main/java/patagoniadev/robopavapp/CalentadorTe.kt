package patagoniadev.robopavapp

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CalentadorTe : Calentador{

    val temperatura = 80
    val pavaApi = ClienteRoboPava().getClienteRoboPava()

    private fun calentarLlamada(): Call<RoboPavaPOJO> {
        return pavaApi.calentar()
    }

    fun calentar() {
        val call = calentarLlamada()
        val response = call.enqueue(object : Callback<RoboPavaPOJO> {
            override fun onResponse(call : Call<RoboPavaPOJO>, response: Response<RoboPavaPOJO>){
                if (response == null || !response.isSuccessful) {
                    Log.e("pava", response.toString())
                    throw RuntimeException("No se pudo conectar")
                }

                val pava = response.body()
                Log.e("Pava", pava.toString())
            }

            override fun onFailure(call: Call<RoboPavaPOJO>?, t: Throwable?) {
                t!!.printStackTrace()
            }
        })
    }
}