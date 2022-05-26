package com.example.examen_3eval

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs


import com.example.examen_3eval.databinding.FragmentInfoBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class InfoFragment : Fragment() {
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!
    /** navArgs devuelve un Lazy delegate para acceder a los argumentos recividos por el Fragment */
    private val args: InfoFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
       var texto=args.info.toString()
        val strs=texto.split("/").toTypedArray()
        binding.textView4.setText(strs[0]+"-"+strs[1])
        var id2=strs[2].toInt()
        var id1=strs[3].toInt()
        binding.imageView.setImageResource(id2)

        binding.textView5.setText(resources.getText(id1))


        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}