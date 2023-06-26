package org.d3if0019.zakkmu

import androidx.lifecycle.ViewModel
import org.d3if0019.zakkmu.model.HasilZakat

class MainViewModel : ViewModel() {
    fun hitungZakatt (jiwa: Int, harga: Float) : HasilZakat {
        val person = jiwa.toInt()
        val zakat = jiwa.toInt() * (harga.toFloat()*2.5)
        val beras = jiwa.toInt() * 2.5.toFloat()
        return HasilZakat(zakat,beras)

    }
}