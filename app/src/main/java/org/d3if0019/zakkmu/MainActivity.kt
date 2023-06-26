package org.d3if0019.zakkmu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import org.d3if0019.zakkmu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { hitungZakat() }
    }
    private fun hitungZakat(){
       val jiwa = binding.beratEditText.text.toString()
        if (TextUtils.isEmpty(jiwa)) {
            Toast.makeText(this, R.string.jiwa_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val harga =  binding.tinggiEditText.text.toString()
        if (TextUtils.isEmpty(harga)) {
            Toast.makeText(this, R.string.harga_invalid, Toast.LENGTH_LONG).show()
            return
        }
       val zakat = jiwa.toInt() * harga.toFloat()
        val beras = jiwa.toInt() * 2.5.toFloat()

        binding.bmiTextView.text = getString(R.string.zakat_x,zakat)
        binding.beras.text = getString(R.string.beras_x,beras)
    }
}