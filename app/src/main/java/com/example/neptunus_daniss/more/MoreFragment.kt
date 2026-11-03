package com.example.neptunus_daniss.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.neptunus_daniss.R
import com.example.neptunus_daniss.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {
    private val dataList = listOf(
        "Kotlin", "Java", "Python", "C++", "JavaScript", "Dart", "Swift", "Go", "Ruby",
        "R", "PHP", "C#", "TypeScript", "Shell", "SQL", "Perl", "Rust", "Scala",
        "Haskell", "Lua", "Erlang", "Prolog", "Assembly", "Objective-C", "VBA"
    )

    private val dataListWithDesc = listOf(
        mapOf("title" to "Kotlin", "desc" to "Bahasa untuk Android modern"),
        mapOf("title" to "Java", "desc" to "Bahasa OOP yang populer"),
        mapOf("title" to "Python", "desc" to "Bahasa yang mudah dipahami"),
        mapOf("title" to "C++", "desc" to "Bahasa sistem dengan performa tinggi"),
        mapOf("title" to "JavaScript", "desc" to "Bahasa utama untuk web interaktif"),
        mapOf("title" to "Dart", "desc" to "Bahasa untuk aplikasi Flutter"),
        mapOf("title" to "Swift", "desc" to "Bahasa modern untuk platform Apple"),
        mapOf("title" to "Go", "desc" to "Bahasa efisien untuk layanan backend"),
        mapOf("title" to "Ruby", "desc" to "Bahasa dinamis yang ekspresif"),
        mapOf("title" to "R", "desc" to "Bahasa untuk statistik dan analisis data"),
        mapOf("title" to "PHP", "desc" to "Bahasa pemrograman sisi server"),
        mapOf("title" to "C#", "desc" to "Bahasa modern pada ekosistem .NET"),
        mapOf("title" to "TypeScript", "desc" to "JavaScript dengan tipe statis"),
        mapOf("title" to "Shell", "desc" to "Bahasa untuk otomasi perintah sistem"),
        mapOf("title" to "SQL", "desc" to "Bahasa untuk mengelola basis data"),
        mapOf("title" to "Perl", "desc" to "Bahasa serbaguna untuk pemrosesan teks"),
        mapOf("title" to "Rust", "desc" to "Bahasa sistem yang mengutamakan keamanan"),
        mapOf("title" to "Scala", "desc" to "Bahasa fungsional dan berorientasi objek"),
        mapOf("title" to "Haskell", "desc" to "Bahasa fungsional bertipe kuat"),
        mapOf("title" to "Lua", "desc" to "Bahasa skrip ringan dan mudah disematkan"),
        mapOf("title" to "Erlang", "desc" to "Bahasa untuk sistem konkuren dan tangguh"),
        mapOf("title" to "Prolog", "desc" to "Bahasa logika berbasis aturan"),
        mapOf("title" to "Assembly", "desc" to "Bahasa tingkat rendah dekat instruksi mesin"),
        mapOf("title" to "Objective-C", "desc" to "Bahasa berorientasi objek untuk Apple"),
        mapOf("title" to "VBA", "desc" to "Bahasa otomasi aplikasi Microsoft Office")
    )

    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = getString(R.string.more_title)
            setDisplayHomeAsUpEnabled(false)
        }

        /*
        binding.listViewItems.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            dataList
        )
        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataList[position]
            Toast.makeText(requireContext(), "Kamu memilih: $selectedItem", Toast.LENGTH_SHORT).show()
        }
        */

        val from = arrayOf("title", "desc")
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)
        binding.listViewItems.adapter = SimpleAdapter(
            requireContext(),
            dataListWithDesc,
            android.R.layout.simple_list_item_2,
            from,
            to
        )
        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataListWithDesc[position]
            val title = selectedItem.getValue("title")
            val desc = selectedItem.getValue("desc")
            Toast.makeText(
                requireContext(),
                "Kamu memilih: $title ($desc)",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
