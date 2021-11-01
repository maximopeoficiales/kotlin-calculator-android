package com.maximoprog.appkotlin

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maximoprog.appkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    private var num1: Double = 0.00;
    private var num2: Double = 0.00;
    private var operation: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(layoutInflater);
        val view = binding.root;
        setContentView(view);

        binding.zeroBtn.setOnClickListener { this.numberPress("1") }
        binding.oneBtn.setOnClickListener { this.numberPress("1") }
        binding.twoBtn.setOnClickListener { this.numberPress("2") }
        binding.threeBtn.setOnClickListener { this.numberPress("3") }
        binding.fourBtn.setOnClickListener { this.numberPress("4") }
        binding.fiveBtn.setOnClickListener { this.numberPress("5") }
        binding.sixBtn.setOnClickListener { this.numberPress("6") }
        binding.sevenBtn.setOnClickListener { this.numberPress("7") }
        binding.eightBtn.setOnClickListener { this.numberPress("8") }
        binding.nineBtn.setOnClickListener { this.numberPress("9") }

//        OPERATIONS
        binding.addBtn.setOnClickListener { this.operationPress(ADD) }
        binding.subtractBtn.setOnClickListener { this.operationPress(SUBTRACT) }
        binding.multiplyBtn.setOnClickListener { this.operationPress(MULTIPLY) }
        binding.divideBtn.setOnClickListener { this.operationPress(DIVISION) }

    }

    @SuppressLint("SetTextI18n")
    private fun numberPress(digit: String) {
        binding.resultText.text = "${binding.resultText.text}${digit}";
    }

    private fun operationPress(operation: Int) {
        this.operation = operation;
        this.num1 = binding.resultText.text.toString().toDouble();
        binding.resultText.text = "0";
    }

    companion object {
        const val ADD = 1;
        const val SUBTRACT = 1;
        const val MULTIPLY = 1;
        const val DIVISION = 1;
        const val NO_OPERATION = 1;
    }
}