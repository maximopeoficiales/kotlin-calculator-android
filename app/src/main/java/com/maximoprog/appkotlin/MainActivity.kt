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

        binding.resultText.text = "0"
        this.operation = NO_OPERATION;

        binding.zeroBtn.setOnClickListener { this.numberPress("0") }
        binding.oneBtn.setOnClickListener { this.numberPress("1") }
        binding.twoBtn.setOnClickListener { this.numberPress("2") }
        binding.threeBtn.setOnClickListener { this.numberPress("3") }
        binding.fourBtn.setOnClickListener { this.numberPress("4") }
        binding.fiveBtn.setOnClickListener { this.numberPress("5") }
        binding.sixBtn.setOnClickListener { this.numberPress("6") }
        binding.sevenBtn.setOnClickListener { this.numberPress("7") }
        binding.eightBtn.setOnClickListener { this.numberPress("8") }
        binding.nineBtn.setOnClickListener { this.numberPress("9") }
        binding.decimalBtn.setOnClickListener { this.numberPress(".") }

//        OPERATIONS
        binding.addBtn.setOnClickListener { this.operationPress(ADD) }
        binding.subtractBtn.setOnClickListener { this.operationPress(SUBTRACT) }
        binding.multiplyBtn.setOnClickListener { this.operationPress(MULTIPLY) }
        binding.divideBtn.setOnClickListener { this.operationPress(DIVISION) }

        binding.clearBtn.setOnClickListener { this.clearAction() }

        binding.equalBtn.setOnClickListener { this.equalsAction() }
    }

    private fun equalsAction() {
        var result = when (this.operation) {
            ADD -> this.num1 + this.num2;
            SUBTRACT -> this.num1 - this.num2;
            MULTIPLY -> this.num1 * this.num2;
            DIVISION -> this.num1 / this.num2;
            else -> 0;
        }
        this.num1 = result as Double;

        if ("$result".endsWith(".0")) {
            binding.resultText.text = "$result".replace(".0", "");
        } else {
            binding.resultText.text = "%.2f".format(result);
        };

    }

    private fun clearAction() {
        this.num1 = 0.0;
        this.num2 = 0.0;
        binding.resultText.text = "0";
//        this.operation = NO_OPERATION;
    }

    @SuppressLint("SetTextI18n")
    private fun numberPress(digit: String) {

        if (binding.resultText.text == "0" && digit != ".") {
            binding.resultText.text = "$digit";
        } else {
            binding.resultText.text = "${binding.resultText.text}${digit}";

        }
        if (this.operation == NO_OPERATION) {
            this.num1 = binding.resultText.text.toString().toDouble();
        } else {
            this.num2 = binding.resultText.text.toString().toDouble();

        }
    }

    private fun operationPress(operation: Int) {
        this.operation = operation;
        this.num1 = binding.resultText.text.toString().toDouble();
        binding.resultText.text = "0";
    }

    companion object {
        const val ADD = 1;
        const val SUBTRACT = 2;
        const val MULTIPLY = 3;
        const val DIVISION = 4;
        const val NO_OPERATION = 5;
    }
}