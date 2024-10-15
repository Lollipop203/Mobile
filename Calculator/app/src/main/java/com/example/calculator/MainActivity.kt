package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var textReuslt: TextView
    lateinit var textOperation: TextView

    var state: Int = 1
    var op: Int = 0
    var op1: Int  = 0
    var op2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.linear_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textReuslt = findViewById(R.id.text_result)
        textOperation = findViewById(R.id.text_operation)

        findViewById<Button>(R.id.btn0).setOnClickListener(this)
        findViewById<Button>(R.id.btn1).setOnClickListener(this)
        findViewById<Button>(R.id.btn2).setOnClickListener(this)
        findViewById<Button>(R.id.btn3).setOnClickListener(this)
        findViewById<Button>(R.id.btn4).setOnClickListener(this)
        findViewById<Button>(R.id.btn5).setOnClickListener(this)
        findViewById<Button>(R.id.btn6).setOnClickListener(this)
        findViewById<Button>(R.id.btn7).setOnClickListener(this)
        findViewById<Button>(R.id.btn8).setOnClickListener(this)
        findViewById<Button>(R.id.btn9).setOnClickListener(this)
        findViewById<Button>(R.id.btnAdd).setOnClickListener(this)
        findViewById<Button>(R.id.btnSub).setOnClickListener(this)
        findViewById<Button>(R.id.btnMul).setOnClickListener(this)
        findViewById<Button>(R.id.btnDiv).setOnClickListener(this)
        findViewById<Button>(R.id.btnEqual).setOnClickListener(this)
        findViewById<Button>(R.id.btnCE).setOnClickListener(this)
        findViewById<Button>(R.id.btnC).setOnClickListener(this)
        findViewById<Button>(R.id.btnBS).setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val id = v?.id
        when (id) {
            R.id.btn0 -> addDigit(0)
            R.id.btn1 -> addDigit(1)
            R.id.btn2 -> addDigit(2)
            R.id.btn3 -> addDigit(3)
            R.id.btn4 -> addDigit(4)
            R.id.btn5 -> addDigit(5)
            R.id.btn6 -> addDigit(6)
            R.id.btn7 -> addDigit(7)
            R.id.btn8 -> addDigit(8)
            R.id.btn9 -> addDigit(9)
            R.id.btnAdd -> setOperation(1)
            R.id.btnSub -> setOperation(2)
            R.id.btnMul -> setOperation(3)
            R.id.btnDiv -> setOperation(4)
            R.id.btnEqual -> calculate()
            R.id.btnCE -> clearEntry()
            R.id.btnC -> clearAll()
            R.id.btnBS -> backSpace()
        }
    }

    private fun addDigit(c: Int) {
        if (state == 1) {
            op1 = op1 * 10 + c
            textReuslt.text = "$op1"
        } else {
            op2 = op2 * 10 + c
            textReuslt.text = "$op2"
        }
    }

    private fun setOperation(c: Int) {
        state = 2
        when (c) {
            1 -> op = 1
            2 -> op = 2
            3 -> op = 3
            4 -> op = 4
        }
        showOperation(op)
    }

    private fun resetOperation() {
        state = 1
        op2 = 0
        op = 0
    }

    @SuppressLint("SetTextI18n")
    private fun showOperation(c: Int) {
        when (c) {
            1 -> textOperation.text = "$op1 + "
            2 -> textOperation.text = "$op1 - "
            3 -> textOperation.text = "$op1 x "
            4 -> textOperation.text = "$op1 / "
        }

    }

    @SuppressLint("SetTextI18n")
    private fun calculate() {
        textOperation.text = textOperation.text.toString() + "$op2 = "
        when (op) {
            1 -> op1 = op1 + op2
            2 -> op1 = op1 - op2
            3 -> op1 = op1 * op2
            4 -> op1 = op1 / op2
        }
        textReuslt.text = "$op1"
        resetOperation()
    }

    private fun clearEntry() {
        textReuslt.text = "0"
        textOperation.text = ""
        if (state == 1) {
            op1 = 0
        } else {
            op2 = 0
        }
    }

    private fun clearAll() {
        textReuslt.text = "0"
        textOperation.text = ""
        op1 = 0
        resetOperation()
    }

    private fun backSpace() {
        if (state == 1) {
            op1 = op1 / 10
            textReuslt.text = "$op1"
            textOperation.text = ""
        } else {
            op2 = op2 / 10
            textReuslt.text = "$op2"
        }
    }
}