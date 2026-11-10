package com.example.neptunus_daniss.home.pertemuan_10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.neptunus_daniss.databinding.FragmentTabCBinding

class TabCFragment : Fragment() {
    private var _binding: FragmentTabCBinding? = null
    private val binding get() = _binding!!

    private val productList = listOf(
        ProductModel("Sepatu Running Nike", "Rp 850.000", "shoe1"),
        ProductModel("Kemeja Flannel", "Rp 320.000", "shirt1"),
        ProductModel("Tas Ransel Laptop", "Rp 450.000", "bag1"),
        ProductModel("Jam Tangan Casio", "Rp 1.200.000", "watch1"),
        ProductModel("Headphone Sony", "Rp 1.500.000", "audio1"),
        ProductModel("Kaos Polos Premium", "Rp 150.000", "tshirt1"),
        ProductModel("Celana Jogger", "Rp 280.000", "pants1"),
        ProductModel("Sneakers Adidas", "Rp 950.000", "shoe2"),
        ProductModel("Dompet Kulit", "Rp 220.000", "wallet1"),
        ProductModel("Topi Baseball", "Rp 120.000", "hat1"),
        ProductModel("Mouse Gaming RGB", "Rp 275.000", "mouse1"),
        ProductModel("Keyboard Mechanical", "Rp 780.000", "keyboard1"),
        ProductModel("Monitor LG 24 Inch", "Rp 2.100.000", "monitor1"),
        ProductModel("Power Bank 20000mAh", "Rp 350.000", "powerbank1"),
        ProductModel("Charger Fast Charging", "Rp 180.000", "charger1"),
        ProductModel("Kacamata Hitam", "Rp 260.000", "glasses1"),
        ProductModel("Sandal Gunung", "Rp 340.000", "sandal1"),
        ProductModel("Jaket Hoodie", "Rp 410.000", "hoodie1"),
        ProductModel("Speaker Bluetooth", "Rp 620.000", "speaker1"),
        ProductModel("Tripod Kamera", "Rp 290.000", "tripod1"),
        ProductModel("Action Camera", "Rp 1.750.000", "camera1"),
        ProductModel("Smartphone Samsung", "Rp 4.500.000", "phone1"),
        ProductModel("Tablet Xiaomi", "Rp 3.250.000", "tablet1"),
        ProductModel("Laptop ASUS", "Rp 8.900.000", "laptop1"),
        ProductModel("Printer Epson", "Rp 2.350.000", "printer1"),
        ProductModel("Flashdisk 64GB", "Rp 95.000", "flashdisk1"),
        ProductModel("Harddisk External", "Rp 850.000", "hdd1"),
        ProductModel("Kursi Gaming", "Rp 1.950.000", "chair1"),
        ProductModel("Meja Kerja Minimalis", "Rp 1.450.000", "desk1"),
        ProductModel("Lampu LED RGB", "Rp 175.000", "lamp1"),
        ProductModel("Kompor Portable", "Rp 230.000", "stove1"),
        ProductModel("Blender Philips", "Rp 540.000", "blender1"),
        ProductModel("Rice Cooker", "Rp 480.000", "rice1"),
        ProductModel("Vacuum Cleaner", "Rp 1.250.000", "vacuum1"),
        ProductModel("Dispenser Air", "Rp 780.000", "dispenser1"),
        ProductModel("Botol Minum Tumbler", "Rp 110.000", "tumbler1"),
        ProductModel("Payung Lipat", "Rp 95.000", "umbrella1"),
        ProductModel("Bantal Leher Travel", "Rp 85.000", "pillow1"),
        ProductModel("Koper Kabin", "Rp 680.000", "luggage1"),
        ProductModel("Sepeda Lipat", "Rp 3.800.000", "bike1"),
        ProductModel("Helm Full Face", "Rp 920.000", "helmet1"),
        ProductModel("Sarung Tangan Motor", "Rp 140.000", "glove1"),
        ProductModel("Rak Buku Minimalis", "Rp 520.000", "bookshelf1"),
        ProductModel("Novel Best Seller", "Rp 98.000", "book1"),
        ProductModel("Paket Alat Lukis", "Rp 350.000", "paint1"),
        ProductModel("Gitar Akustik", "Rp 1.600.000", "guitar1"),
        ProductModel("Piano Keyboard", "Rp 2.750.000", "piano1"),
        ProductModel("Drone Mini", "Rp 1.950.000", "drone1"),
        ProductModel("Smartwatch Xiaomi", "Rp 670.000", "smartwatch1"),
        ProductModel("Router WiFi", "Rp 430.000", "router1")
    ).map { product ->
        product.copy(imageUrl = "https://picsum.photos/seed/${product.imageUrl}/400/300")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTabCBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvProducts.layoutManager = GridLayoutManager(requireContext(), 2)
        // binding.rvProducts.layoutManager = LinearLayoutManager(requireContext())
        binding.rvProducts.adapter = ProductAdapter(productList) { selectedItem ->
            Toast.makeText(
                requireContext(),
                "Anda memilih ${selectedItem.name}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
