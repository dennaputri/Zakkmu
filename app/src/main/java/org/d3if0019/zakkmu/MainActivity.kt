package org.d3if0019.zakkmu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import org.d3if0019.zakkmu.databinding.ActivityMainBinding
import org.d3if0019.zakkmu.model.HasilZakat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

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

        val result = viewModel.hitungZakatt(
            jiwa.toInt(),
            harga.toFloat(),
        )
        showResult(result)
    }

    private fun showResult(result: HasilZakat){
        binding.bmiTextView.text=getString(R.string.zakat_x,result.zakat)
        binding.beras.text =getString(R.string.beras_x,result.beras )
    }

}