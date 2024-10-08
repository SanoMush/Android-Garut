
package com.example.firstsubmissionandroid

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var articleList: List<Article>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        articleList = listOf(
            Article("Gunung Papandayan", "Gunung Papandayan merupakan salah satu gunung di Jawa Barat yang terkenal dengan kawah belerangnya serta panorama alam yang mempesona. Puncak gunung ini menjadi destinasi favorit bagi pendaki, dengan bonus pemandangan indah di sekitar hutan mati dan padang edelweiss.", R.drawable.papandayan),
            Article("Gunung Guntur", "Gunung Guntur terkenal dengan pemandangan alam yang menakjubkan dan medan pendakian yang menantang. Berlokasi di Garut, gunung ini menawarkan panorama alam yang eksotis, terutama bagi para pendaki yang mencari pengalaman mendaki yang menantang namun memuaskan.", R.drawable.guntur),
            Article("Gunung Sagara", "Gunung Sagara menjadi destinasi pendakian baru di Garut yang menarik perhatian para pendaki. Meski ketinggiannya tidak setinggi gunung lain di Jawa Barat, Sagara menawarkan trek yang menarik dan pemandangan indah dari puncaknya.", R.drawable.sagara),
            Article("Gunung Cikuray", "Gunung Cikuray adalah gunung tertinggi di Garut dan salah satu destinasi pendakian populer di Jawa Barat. Pemandangan dari puncaknya sangat spektakuler, terutama saat matahari terbit yang sering disebut sebagai \"Golden Sunrise Cikuray.\"", R.drawable.cikuray),
            Article("Curug Orok", "Curug Orok adalah air terjun yang terletak di Garut dan menjadi salah satu tempat wisata alam yang terkenal. Air terjun ini memiliki ketinggian yang cukup signifikan dan suasana alam yang asri, menjadikannya destinasi favorit bagi wisatawan yang ingin menikmati ketenangan alam.", R.drawable.curugorok),
            Article("Curug Sanghyang Taraje", "Curug Sanghyang Taraje merupakan air terjun yang terkenal dengan ketinggiannya dan debit airnya yang deras. Berada di kawasan Garut, air terjun ini menjadi tujuan wisata yang populer berkat keindahannya dan mitos yang menyelimutinya.", R.drawable.taraje),
            Article("Pantai Santolo", "Pantai Santolo adalah salah satu pantai paling terkenal di Garut yang menawarkan panorama indah dengan pasir putih dan ombak yang menenangkan. Pantai ini menjadi tempat favorit bagi wisatawan yang mencari ketenangan dan keindahan alam laut.", R.drawable.santolo),
            Article("Pantai Karang Papak", "Pantai Karang Papak dikenal dengan keindahan batu karang dan hamparan pasir yang luas. Pantai ini cocok untuk bersantai sambil menikmati pemandangan alam serta suara deburan ombak yang menenangkan.", R.drawable.karang),
            Article("Pantai Cijeruk", "Pantai Cijeruk merupakan salah satu pantai tersembunyi di Garut yang menawarkan suasana alami dan tenang. Pantai ini cocok untuk pengunjung yang ingin menikmati keindahan alam tanpa keramaian.", R.drawable.cijeruk),
            Article("Puncak Guha", "Puncak Guha adalah tebing yang terletak di pesisir selatan Garut, menawarkan pemandangan laut yang menakjubkan. Lokasi ini menjadi spot favorit bagi fotografer dan pengunjung yang ingin menikmati keindahan matahari terbenam dari ketinggian.", R.drawable.puncakguha),
        )

        val adapter = ArticleAdapter(this, articleList)
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate menu
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}
