package org.d3if0019.zakkmu.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if0019.zakkmu.model.HasilZakat

class HitungViewModel : ViewModel() {
    private val hasil = MutableLiveData<HasilZakat?>()
    fun hitungZakat (jiwa: Int, harga: Float) : HasilZakat {
        val person = jiwa.toInt()
        val zakat = jiwa.toInt() * (harga.toFloat()*2.5)
        val beras = jiwa.toInt() * 2.5.toFloat()
        return HasilZakat(zakat,beras)

    }
    fun getHasilZakat(): LiveData<HasilZakat?> = hasil
}