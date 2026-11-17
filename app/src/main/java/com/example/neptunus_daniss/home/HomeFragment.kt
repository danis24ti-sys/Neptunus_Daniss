package com.example.neptunus_daniss.home

import android.content.Intent
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.neptunus_daniss.AuthActivity
import com.example.neptunus_daniss.R
import com.example.neptunus_daniss.databinding.FragmentHomeBinding
import com.example.neptunus_daniss.data.api.CatFactApiClient
import com.example.neptunus_daniss.data.api.PhotoApiClient
import com.example.neptunus_daniss.home.pertemuan_4.FourthActivity
import com.example.neptunus_daniss.home.pertemuan_5.FifthActivity
import com.example.neptunus_daniss.home.pertemuan_6.SixthActivity
import com.example.neptunus_daniss.home.pertemuan_10.Pertemuan10Activity
import com.example.neptunus_daniss.home.pertemuan_10.TenthActivity
import com.example.neptunus_daniss.home.photo.PhotoAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = getString(R.string.home_title)
            setDisplayHomeAsUpEnabled(false)
        }

        loadCatFact()
        binding.btnRefresh.setOnClickListener { loadCatFact() }
        loadPhoto()

        val sharedPref = requireContext().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        binding.textWelcome.text = getString(
            R.string.welcome_user,
            sharedPref.getString("username", "").orEmpty()
        )

        binding.btnPertemuan2.setOnClickListener { showUnavailableMeeting(2) }
        binding.btnPertemuan3.setOnClickListener { showUnavailableMeeting(3) }
        binding.btnMasuk.setOnClickListener {
            startActivity(Intent(requireContext(), FourthActivity::class.java))
        }
        binding.btnMasukP5.setOnClickListener {
            startActivity(Intent(requireContext(), FifthActivity::class.java))
        }
        binding.btnPertemuan6.setOnClickListener {
            startActivity(Intent(requireContext(), SixthActivity::class.java))
        }
        binding.btnPertemuan9.setOnClickListener {
            startActivity(Intent(requireContext(), Pertemuan10Activity::class.java))
        }
        binding.btnPertemuan11.setOnClickListener {
            startActivity(Intent(requireContext(), TenthActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    sharedPref.edit().clear().apply()
                    startActivity(
                        Intent(requireContext(), AuthActivity::class.java)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    )
                    requireActivity().finish()
                    dialog.dismiss()
                    Log.i("HomeFragment", "Pengguna logout")
                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }

    private fun loadCatFact() {
        lifecycleScope.launch {
            try {
                val response = CatFactApiClient.apiService.getCatFact()
                binding.tvCatFact.text = "\"${response.fact}\""
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                binding.tvCatFact.text = "Gagal mengambil fakta kucing."
            }
        }
    }

    private fun loadPhoto() {
        lifecycleScope.launch {
            try {
                val photos = PhotoApiClient.apiService.getPhotos()
                binding.rvGallery.adapter = PhotoAdapter(photos)
                // binding.rvGallery.layoutManager = LinearLayoutManager(requireContext())
                binding.rvGallery.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                // binding.rvGallery.layoutManager = GridLayoutManager(requireContext(), 2)
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Gagal memuat gambar", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showUnavailableMeeting(number: Int) {
        Toast.makeText(
            requireContext(),
            "Materi Pertemuan $number belum tersedia.",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
