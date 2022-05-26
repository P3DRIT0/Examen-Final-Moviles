package com.example.examen_3eval

import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_3eval.databinding.ElementoexBinding

import com.example.examen_3eval.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {
    val canciones: MutableList<Canciones> = ArrayList()
    private val adaptador= Custom3Adapter(canciones)
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    /** navArgs devuelve un Lazy delegate para acceder a los argumentos recividos por el Fragment */
    private val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        with(binding.recyclerex) {
            println(args)
            adapter = adaptador
            layoutManager = LinearLayoutManager(requireContext())
        }
        return binding.root

    }

    class Custom3Adapter(private val listadoDatos: MutableList<Canciones>) :
        RecyclerView.Adapter<Custom3Adapter.ViewHolder>() {

        /** Clase que describe la vista de cada elemento de la lista y su posición en esta. */
        class ViewHolder(binding:ElementoexBinding) : RecyclerView.ViewHolder(binding.root) {
            val mView = binding.root
            val img=binding.imageView2
            val textViewnombre = binding.textView2
            val textViewautor = binding.textView3
            init {
            }




        }

        /** Método al que se llama cada vez que se crea uno de los elementos de la lista. */
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            ElementoexBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )


        /** Método que vincula en cada elemento, según su posición, los datos correspondientes a
         * cada elemento */
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.textViewnombre.text = listadoDatos[position].titulo
            holder.textViewautor.text=listadoDatos[position].autor
            holder.img.setImageResource(listadoDatos[position].idImagen)
            holder.mView.setOnClickListener {
              var info= info(position)
                holder.itemView.findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToInfoFragment(info))
            }


            with(holder) {
                    mView.setBackgroundColor(Color.CYAN)
                    textViewnombre.setTextColor(Color.BLACK)
                    textViewautor.setTextColor(Color.BLACK)
            }
        }

        private fun info(position: Int): Info {
            val info= Info(
                listadoDatos[position].titulo,
                listadoDatos[position].autor,
                listadoDatos[position].idImagen,
                listadoDatos[position].des

            )
            return info


        }


        override fun getItemCount() = listadoDatos.size

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        println(args.genero)
        var genero=(args.genero).toString();
        if (genero=="Rock"){
            canciones.add(Canciones("Abbey Road", "The Beatles",R.mipmap.ic_abbeyroad_foreground,R.string.abbeyroad))
            canciones.add(Canciones("Exile on Main Street", "The Rolling Stones",R.mipmap.ic_exileonmainst_foreground,R.string.exilesonmainstreet))
            canciones.add(Canciones("The Velvet Underground", "he Velvet Underground and Nico",R.mipmap.ic_velvetunderground_foreground,R.string.velvetunderground))
            canciones.add(Canciones("Are You Experienced", "Jimi Hendrix",R.mipmap.ic_areyouexperienced_foreground,R.string.areyouexperienced))
            canciones.add(Canciones("Back in Black", "AC/DC",R.mipmap.ic_backinblack_foreground,R.string.backinblack))
            canciones.add(Canciones("Appetite for Destruction", "Guns N’ Roses",R.mipmap.ic_appetitefordestruction_foreground,R.string.appetitefordestruction))
            canciones.add(Canciones("Led Zeppelin IV", "Led Zeppelin",R.mipmap.ic_ledzeppeliniv_foreground,R.string.ledzeppeliniv))
        }
        if (genero=="Blues"){
            canciones.add(Canciones("Lady Soul", "Aretha Franklin",R.mipmap.ic_ladysoul_foreground,R.string.ladysoul))
            canciones.add(Canciones("I Never Loved a Man the Way I Love You", "Aretha Franklin",R.mipmap.ic_neverloved_foreground,R.string.ineverloveda))
            canciones.add(Canciones("What's Going On", "Marvin Gaye",R.mipmap.ic_velvetunderground_foreground,R.string.whatsgoingon))
        }
        if (genero=="Jazz"){
            canciones.add(Canciones("Kind of Blue", "Miles Davis",R.mipmap.ic_kindofblue_foreground,R.string.kindofblue))
            canciones.add(Canciones("Bitches Brew", "Miles Davis",R.mipmap.ic_bitchesbrew_foreground,R.string.bitchesbrew))
            canciones.add(Canciones("A Love Supreme", "John Coltrane",R.mipmap.ic_alovesupreme_foreground,R.string.alovesupreme))
        }

        adaptador.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}