package com.example.gymfortemobile.View.ui.perfil

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.Fragment
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

import com.example.gymfortemobile.databinding.FragmentPerfilBinding
import com.squareup.picasso.Picasso


class PerfilFragment : Fragment() {


    private lateinit var  binding : FragmentPerfilBinding
    private lateinit var queue: RequestQueue
    var img : Uri?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentPerfilBinding.inflate(inflater,container,false)
        queue = Volley.newRequestQueue(context);



        binding.btnCamera.setOnClickListener {

            val g = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(g, 1001)

        }

        binding.btnEditar.setOnClickListener {


        }




//      ********************************** SHARED-PREFERENCES  *************/
        val shared = context?.getSharedPreferences("usuario", Context.MODE_PRIVATE)

        val datos = shared?.getString("nombre", "XXXXX ") +", " + shared?.getString("apellido", "XXXXXX ")
        val dni= shared?.getString("dni", "XXXXXX ")
        val telefono= shared?.getString("telefono", "XXXXXX ")
        val correo= shared?.getString("correo", "XXXXXX ")
        val imgPerfil = shared?.getString("imgPerfil", "https://i.imgur.com/bUXrPc1.jpg")

        binding.txtnombre.setText(datos)
        Picasso.get().load(imgPerfil).into(binding.imgUser)

        if (imgPerfil.equals("null") ){
            Picasso.get().load("https://i.imgur.com/bUXrPc1.jpg").into(binding.imgUser)
        }else{
            Picasso.get().load(imgPerfil).into(binding.imgUser)
        }

        binding.txtCorreo.setText(correo)
        binding.txtTelefono.setText(telefono)
        binding.txtDni.setText(dni)


        return binding.root
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== AppCompatActivity.RESULT_OK && requestCode== 1001){
            Log.d("jhon", data.toString())
            img=data?.data
            binding.imgUser.setImageURI(img)


        }
    }

//
}


