package org.d3if0019.zakkmu.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3if0019.zakkmu.databinding.FragmentMahzabBinding

class MahzabFragment : Fragment() {
    private lateinit var binding: FragmentMahzabBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentMahzabBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}
