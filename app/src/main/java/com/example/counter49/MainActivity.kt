package com.example.counter49

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.counter49.databinding.ActivityMainBinding
import com.example.counter49.present.Presenter
import com.example.counter49.view.CounterView

class MainActivity : AppCompatActivity(), CounterView {
    val presenter = Presenter()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            incrementBtn.setOnClickListener {
                presenter.increment()

            }
        }
    }

    override fun changeCount(count : Int) {
        binding.counterTv.text = count.toString()


    }

    override fun changeTextColor() {
        binding.counterTv.setTextColor(Color.GREEN)
    }

    override fun showToast() {
        Toast.makeText(this, "Поздравляем", Toast.LENGTH_SHORT).show()
    }

}