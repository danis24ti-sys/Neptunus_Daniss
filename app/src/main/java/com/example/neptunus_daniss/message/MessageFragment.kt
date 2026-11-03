package com.example.neptunus_daniss.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.neptunus_daniss.R
import com.example.neptunus_daniss.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {
    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://i.pravatar.cc/150?img=1", "21"),
        MessageModel("Budi", "Sudah makan?", "https://i.pravatar.cc/150?img=2", "24"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://i.pravatar.cc/150?img=3", "19"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://i.pravatar.cc/150?img=4", "27"),
        MessageModel("Eka", "Nice job kemarin!", "https://i.pravatar.cc/150?img=5", "22"),
        MessageModel("Fajar", "Lagi ngapain?", "https://i.pravatar.cc/150?img=6", "25"),
        MessageModel("Gita", "Boleh minta tolong?", "https://i.pravatar.cc/150?img=7", "20"),
        MessageModel("Hana", "Lihat email ya", "https://i.pravatar.cc/150?img=8", "23"),
        MessageModel("Irfan", "Oke noted", "https://i.pravatar.cc/150?img=9", "26"),
        MessageModel("Joko", "Sampai jumpa besok", "https://i.pravatar.cc/150?img=10", "28")
    )

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = getString(R.string.message_title)
            setDisplayHomeAsUpEnabled(false)
        }
        binding.listMessageItems.adapter = MessageAdapter(requireContext(), messageList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
