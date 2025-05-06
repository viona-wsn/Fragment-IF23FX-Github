package com.uti.fragment_if23fx

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.uti.fragment_if23fx.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//          definisikan "binding"
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//         panggil fungsi "openFragment1"
        openFragment1()

//         event menu satu
        binding.imgMenu1.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.frm_content,Menu1Fragment()).commit()

        }
//        event menu dua
        binding.imgMenu2.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.frm_content,Menu2Fragment()).addToBackStack(null).commit()
        }
//        event menu tiga
        binding.imgMenu3.setOnClickListener{
//          buat variabel fragment
          val fragment = Menu3Fragment()
//          buat variabel bundle
          val bundle = Bundle()
//          kirim parameter bundle
          bundle.putString("content3","Ini contoh Fragment 3")
          fragment.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.frm_content,fragment).commit()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

//      buat fungsi untuk buka "Menu1Fragment"
fun openFragment1() {
    supportFragmentManager.beginTransaction().replace(R.id.frm_content,Menu1Fragment()).commit()

    }
}