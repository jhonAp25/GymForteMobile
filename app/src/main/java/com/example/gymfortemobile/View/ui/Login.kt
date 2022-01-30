package com.example.gymfortemobile.View.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.example.gymfortemobile.databinding.ActivityLoginBinding
import org.json.JSONException

import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.Volley


import org.json.JSONObject
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import android.content.SharedPreferences
import android.view.inputmethod.InputMethodManager
import com.google.android.material.snackbar.Snackbar


class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var queue: RequestQueue
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)


        setContentView(binding.root)
        supportActionBar?.hide()
        queue = Volley.newRequestQueue(getApplicationContext());

        val user = binding.txtUsuario.text
        val password = binding.txtPassword.text






        binding.btnLogin.setOnClickListener {
            val imm: InputMethodManager =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.txtPassword.getWindowToken(), 0)
            Login(user.toString().trim() , password.toString().trim() )

        }


    }


    private fun Login(usuario: String, password: String) {
        try {
            val json = JSONObject(
                "{"
                        + "\"usuario\": " + usuario
                        + ", \"contrasena\": " + password + " }"
            )
            val request = JsonObjectRequest(Request.Method.POST, "https://idat-gym.herokuapp.com/usuario/login", json,
                { response ->

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    val jsonObject: JSONObject = response.getJSONObject("Usuario")
                    val jsonCliente : JSONObject =  jsonObject.getJSONObject("cliente")

                    guardarUsuario( jsonCliente.getString("nombre") ,
                                    jsonCliente.getString("foto"),
                                    jsonCliente.getString("apellido"),
                                    jsonCliente.getString("id"));


                }) { error ->
                showSnackbar("Credenciales Incorrectas")
                Log.d("jhon", error.toString())
            }
            queue.add(request)
        } catch (e: JSONException) {

        }
    }

    fun guardarUsuario(nombre: String? , imgPerfil: String?, apellido: String?, idCliente: String?) {
        val shared = applicationContext.getSharedPreferences("usuario", Context.MODE_PRIVATE)
        val editor = shared.edit()
        editor.putString("nombre", nombre)
        editor.putString("apellido", apellido)
        editor.putString("imgPerfil", imgPerfil)
        editor.putString("id" , idCliente)
        editor.commit()
    }


    private fun showSnackbar(msg:String){
        Snackbar.make(  binding.root ,msg, Snackbar.LENGTH_SHORT).show()
    }

}