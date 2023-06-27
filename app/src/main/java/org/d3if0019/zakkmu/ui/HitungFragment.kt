package org.d3if0019.zakkmu.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import org.d3if0019.zakkmu.R
import org.d3if0019.zakkmu.databinding.FragmentHitungBinding
import org.d3if0019.zakkmu.model.HasilZakat

class HitungFragment : Fragment() {

    private lateinit var binding: FragmentHitungBinding
    private val viewModel: HitungViewModel by lazy {
        ViewModelProvider(requireActivity())[HitungViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        binding = FragmentHitungBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_about) {
            findNavController().navigate(
                R.id.action_hitungFragment_to_aboutFragment)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener { hitungZakat() }
        binding.mahzabButton.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_hitungFragment_to_mahzabFragment
            )
        }
        viewModel.getHasilZakat().observe(requireActivity()) {
            if (it != null) {
                showResult(it)
            }
        }
    }


    private fun hitungZakat(){
       val jiwa = binding.beratEditText.text.toString()
        if (TextUtils.isEmpty(jiwa)) {
            Toast.makeText(context, R.string.jiwa_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val harga =  binding.tinggiEditText.text.toString()
        if (TextUtils.isEmpty(harga)) {
            Toast.makeText(context, R.string.harga_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val result = viewModel.hitungZakat(
            jiwa.toInt(),
            harga.toFloat(),
        )
        showResult(result)
    }

    private fun showResult(result: HasilZakat){
        binding.bmiTextView.text=getString(R.string.zakat_x,result.zakat)
        binding.beras.text =getString(R.string.beras_x,result.beras )
        binding.mahzabButton.visibility = View.VISIBLE

    }

}