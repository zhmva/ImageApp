package com.serendipity.imageapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.serendipity.imageapp.databinding.ActivityMainBinding
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        initList()
        initBtnRandom()
        initBtnAdd()
    }

    private fun initBtnAdd() {
        binding.btnSubmit.setOnClickListener {
            val url = binding.etUrl.text.toString()
            if (isValid(url)) {
                list.add(url)
                binding.etUrl.setText("")
            } else {
                getToast(getString(R.string.toast))
            }
        }
    }

    private fun initBtnRandom() {
        binding.btnRandom.setOnClickListener {
            val randomUrl = list.random()
            binding.image.loadUrl(randomUrl)
        }
    }

    private fun initList() {
        list.add("https://cdn.wallpapersafari.com/72/99/JU3M10.jpg")
        list.add("https://data.whicdn.com/images/349922726/original.jpg")
        list.add("https://wallpapercave.com/wp/wp6592286.jpg")
        list.add("https://p.favim.com/orig/2018/08/22/aesthetic-scenery-sky-Favim.com-6206007.jpg")
        list.add("https://wallpapersflix.com/aesthetic/wp-content/uploads/2021/02/Scenery-Aesthetic-Wallpaper.jpg")
    }

    private fun isValid(url: String): Boolean = try {
        URL(url).toURI()
        true
    } catch (e: Exception) {
        false
    }
}