
package com.example.firstsubmissionandroid

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class DetailActivity : AppCompatActivity() {

    private lateinit var detailImageView: ImageView
    private lateinit var detailTitleTextView: TextView
    private lateinit var detailOverviewTextView: TextView
    private lateinit var detailDescriptionTextView: TextView
    private lateinit var shareButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        detailImageView = findViewById(R.id.detail_image)
        detailTitleTextView = findViewById(R.id.detail_title)
        detailOverviewTextView = findViewById(R.id.detail_overview)
        detailDescriptionTextView = findViewById(R.id.detail_description)
        shareButton = findViewById(R.id.action_share)

        val title = intent.getStringExtra("title") ?: "No Title"
        val overview = intent.getStringExtra("overview") ?: "No Overview"
        val imageRes = intent.getIntExtra("image", R.drawable.garut)

        detailImageView.setImageResource(imageRes)
        detailTitleTextView.text = title
        detailOverviewTextView.text = overview
        detailDescriptionTextView.text = getDetailedDescription(title)

        // Share button functionality
        shareButton.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, title)
                putExtra(Intent.EXTRA_TEXT, "Check out this amazing place: $title \n$overview")
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }
    }

    private fun getDetailedDescription(title: String): String {
        return when (title) {
            "Gunung Papandayan" -> {
                """
                **Akses Lokasi**: Gunung Papandayan terletak di Kabupaten Garut, Jawa Barat. Akses menuju gunung ini cukup mudah. Dari pusat kota Garut, kamu bisa menuju ke arah Kecamatan Cisurupan. Kendaraan roda dua dan empat bisa langsung mencapai basecamp pendakian.
                
                **Biaya Tiket**: Rp 20.000 - Rp 30.000 untuk wisatawan lokal, Rp 100.000 untuk wisatawan mancanegara.
                
                **Keunikan**: Kawah belerang aktif, padang edelweiss, hutan mati, dan panorama alam yang mempesona menjadikan gunung ini destinasi favorit pendaki.
                
                **Waktu Terbaik untuk Berkunjung**: Mei hingga September (musim kemarau) untuk pemandangan terbaik dan jalur pendakian yang aman.
            """.trimIndent()
            }
            "Gunung Guntur" -> {
                """
                **Akses Lokasi**: Gunung Guntur bisa diakses dari Terminal Guntur di Garut. Gunakan transportasi umum atau pribadi menuju basecamp pendakian.
                
                **Biaya Tiket**: Rp 10.000 - Rp 20.000 per orang.
                
                **Keunikan**: Trek yang menantang dengan pemandangan matahari terbit yang luar biasa dari puncaknya. Medan berpasir menjadi tantangan tersendiri bagi pendaki.
                
                **Waktu Terbaik untuk Berkunjung**: Mei hingga Agustus (musim kemarau) untuk pendakian yang lebih aman dan menikmati sunrise yang indah.
            """.trimIndent()
            }
            "Gunung Sagara" -> {
                """
                **Akses Lokasi**: Gunung Sagara dapat diakses dari Kecamatan Wanaraja, Garut. Jalur pendakian mudah diikuti dan cocok untuk pemula.
                
                **Biaya Tiket**: Rp 10.000 - Rp 15.000 per orang.
                
                **Keunikan**: Pemandangan alam indah dari puncak dengan jalur yang mudah dan cocok untuk pendaki pemula.
                
                **Waktu Terbaik untuk Berkunjung**: Mei hingga Agustus (musim kemarau) untuk cuaca yang lebih stabil.
            """.trimIndent()
            }
            "Gunung Cikuray" -> {
                """
                **Akses Lokasi**: Gunung Cikuray bisa diakses dari desa Dayeuh Manggung, selatan Garut. Transportasi umum dan pribadi bisa digunakan menuju basecamp.
                
                **Biaya Tiket**: Rp 20.000 - Rp 30.000 per orang.
                
                **Keunikan**: Golden Sunrise dari puncak tertinggi di Garut, pemandangan yang sangat memukau dari puncaknya.
                
                **Waktu Terbaik untuk Berkunjung**: Juni hingga Agustus (musim kemarau) untuk menikmati sunrise yang sempurna.
            """.trimIndent()
            }
            "Curug Orok" -> {
                """
                **Akses Lokasi**: Curug Orok terletak di Desa Cikandang, Kecamatan Cikajang, Garut. Akses mudah dengan kendaraan roda dua atau empat. Dari parkiran, berjalan kaki sekitar 10 menit ke air terjun.
                
                **Biaya Tiket**: Rp 15.000 per orang.
                
                **Keunikan**: Air terjun tinggi dengan debit air deras dan suasana alam yang asri. Tempat yang sempurna untuk relaksasi dan menikmati keindahan alam.
                
                **Waktu Terbaik untuk Berkunjung**: Mei hingga September (musim kemarau) untuk menghindari hujan dan menikmati debit air yang aman.
            """.trimIndent()
            }
            "Curug Sanghyang Taraje" -> {
                """
                **Akses Lokasi**: Curug Sanghyang Taraje terletak di Kecamatan Pakenjeng, Garut. Aksesnya bisa ditempuh dengan kendaraan roda dua atau empat menuju desa terdekat, dilanjutkan dengan jalan kaki.
                
                **Biaya Tiket**: Sekitar Rp 15.000 per orang.
                
                **Keunikan**: Air terjun tinggi dengan debit air yang sangat deras, menjadikannya salah satu curug paling spektakuler di Garut.
                
                **Waktu Terbaik untuk Berkunjung**: Mei hingga September untuk menikmati cuaca yang lebih cerah dan kondisi air yang lebih baik.
            """.trimIndent()
            }
            "Pantai Santolo" -> {
                """
                **Akses Lokasi**: Pantai Santolo bisa dicapai dengan perjalanan darat dari pusat kota Garut menuju Kecamatan Cikelet. Perjalanan memakan waktu sekitar 3 jam menggunakan kendaraan pribadi.
                
                **Biaya Tiket**: Sekitar Rp 10.000 - Rp 15.000 per orang.
                
                **Keunikan**: Pasir putih, ombak yang tenang, dan keindahan alam laut menjadikan Pantai Santolo destinasi favorit bagi wisatawan yang mencari ketenangan.
                
                **Waktu Terbaik untuk Berkunjung**: April hingga Oktober, saat cuaca cerah dan ombak yang bersahabat.
            """.trimIndent()
            }
            "Pantai Karang Papak" -> {
                """
                **Akses Lokasi**: Pantai Karang Papak terletak di Kecamatan Cikelet, Garut. Akses dapat ditempuh dengan kendaraan pribadi atau umum. Jarak dari pusat kota sekitar 3 jam perjalanan.
                
                **Biaya Tiket**: Rp 10.000 per orang.
                
                **Keunikan**: Pantai ini terkenal dengan formasi batu karang yang indah dan hamparan pasir luas, cocok untuk bersantai dan menikmati suara ombak.
                
                **Waktu Terbaik untuk Berkunjung**: Mei hingga September untuk menikmati cuaca cerah dan suasana pantai yang tenang.
            """.trimIndent()
            }
            "Pantai Cijeruk" -> {
                """
                **Akses Lokasi**: Pantai Cijeruk adalah pantai tersembunyi yang bisa diakses dari Kecamatan Cibalong, Garut. Perjalanan dari pusat kota memakan waktu sekitar 3-4 jam dengan kendaraan pribadi.
                
                **Biaya Tiket**: Sekitar Rp 10.000 per orang.
                
                **Keunikan**: Pantai yang masih alami dan sepi, cocok bagi pengunjung yang ingin menikmati suasana tenang dan keindahan alam yang belum banyak terjamah wisatawan.
                
                **Waktu Terbaik untuk Berkunjung**: April hingga Oktober, saat cuaca cerah dan kondisi laut tenang.
            """.trimIndent()
            }
            "Puncak Guha" -> {
                """
                **Akses Lokasi**: Puncak Guha terletak di Kecamatan Bungbulang, Garut. Dari pusat kota, kamu bisa menuju pesisir selatan Garut. Akses jalan cukup baik untuk kendaraan pribadi.
                
                **Biaya Tiket**: Sekitar Rp 10.000 per orang.
                
                **Keunikan**: Tebing di atas laut yang menawarkan pemandangan sunset yang spektakuler. Lokasi ini juga terkenal sebagai tempat favorit untuk fotografi alam.
                
                **Waktu Terbaik untuk Berkunjung**: Waktu terbaik adalah sore hari, antara April hingga Oktober untuk menikmati sunset yang indah.
            """.trimIndent()
            }
            else -> "Tidak ada deskripsi panjang yang tersedia untuk $title."
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        @Suppress("DEPRECATION")
        onBackPressed()
        return true
    }
}
