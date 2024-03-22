package com.example.maxsustopshiriq

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.maxsustopshiriq.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            usd.setOnFocusChangeListener { v, hasFocus ->
                if(hasFocus){
                    usd.addTextChangedListener {
                        if(usd.hasFocus()) {
                            som.setText("${usd.text.toString().toLong() * 12559}")
                        }
                    }
                }
            }
            som.setOnFocusChangeListener { v, hasFocus ->
                if (hasFocus){
                    som.addTextChangedListener {
                        if (som.hasFocus()) {
                            usd.setText("${som.text.toString().toLong() / 12559}")
                        }
                    }
                }
            }
        }
    }
}