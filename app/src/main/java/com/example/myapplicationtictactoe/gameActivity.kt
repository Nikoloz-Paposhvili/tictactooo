package com.example.myapplicationtictactoe

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView

class gameActivity : AppCompatActivity() {

    private lateinit var player1Name: TextView
    private lateinit var player2Name: TextView
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var resetButton: Button
    private lateinit var over: View

    private var winner = ""

    var chartg:String = "X"
    var toggler = 0

    var player1PTS = 0
    var player2PTS = 0



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        player1Name = findViewById(R.id.textView2)
        player2Name = findViewById(R.id.textView3)
        button1 = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        resetButton = findViewById(R.id.reset)
        over = findViewById(R.id.over)

        val bundle: Bundle? = intent.extras
        val name1 = bundle?.get("name1")
        val name2 = bundle?.get("name2")



        player1Name.text = name1.toString() + ": 0"
        player2Name.text = name2.toString() + ": 0"

        var buttonArray = arrayOf(button1, button2, button3, button4, button5, button6, button7, button8, button9)

        for (btn in buttonArray){
            btn.setOnClickListener {
                if(btn.text.toString() ==""){
                    chartg = "X"
                    btn.setBackgroundColor(Color.BLACK)
                    if(toggler%2==1){
                        chartg = "O"
                        btn.setBackgroundColor(Color.RED)
                    }
                    btn.text = chartg
                    if (check()){
                        if (winner == "X"){
                            player1PTS++
                        }else{
                            player2PTS++
                        }


                        for(btn in buttonArray){
                            if(btn.text.toString() == ""){
                                btn.text = ""
                            }
                        }

                        Handler(Looper.getMainLooper()).postDelayed(
                            {
                                player1Name.text = name1.toString() + ": $player1PTS"
                                player2Name.text = name2.toString() + ": $player2PTS"
                                reset()
                            },
                            800
                        )
                    }
                    if(!isEmpty()){
                        for(btn in buttonArray){
                            if(btn.text.toString() == ""){
                                btn.text = " "
                            }
                        }

                        Handler(Looper.getMainLooper()).postDelayed(
                            {
                                reset()
                            },
                            800
                        )
                    }
                    toggler++
                }
            }
        }

        resetButton.setOnClickListener {
            reset()
            player1Name.text = name1.toString() + ": 0"
            player2Name.text = name2.toString() + ": 0"
        }
    }

    fun check():Boolean{
        var buttonArray = arrayOf(button1, button2, button3, button4, button5, button6, button7, button8, button9)

        var isWin = false
        if (button1.text.toString() == button2.text.toString() && button2.text.toString() == button3.text.toString() && button3.text.toString() == "X" ||
            button4.text.toString() == button5.text.toString() && button5.text.toString() == button6.text.toString() && button6.text.toString() == "X" ||
            button7.text.toString() == button8.text.toString() && button8.text.toString() == button9.text.toString() && button9.text.toString() == "X" ||
            button1.text.toString() == button4.text.toString() && button4.text.toString() == button7.text.toString() && button7.text.toString() == "X" ||
            button2.text.toString() == button5.text.toString() && button5.text.toString() == button8.text.toString() && button8.text.toString() == "X" ||
            button3.text.toString() == button6.text.toString() && button6.text.toString() == button9.text.toString() && button9.text.toString() == "X" ||
            button1.text.toString() == button5.text.toString() && button5.text.toString() == button9.text.toString() && button9.text.toString() == "X" ||
            button3.text.toString() == button5.text.toString() && button5.text.toString() == button7.text.toString() && button7.text.toString() == "X" ) {
            winner = "X"
            isWin = true
            for(btn in buttonArray){
                if(btn.text.toString() == ""){
                    btn.text = " "
                }
            }
        }else if(button1.text.toString() == button2.text.toString() && button2.text.toString() == button3.text.toString() && button3.text.toString() == "O" ||
            button4.text.toString() == button5.text.toString() && button5.text.toString() == button6.text.toString() && button6.text.toString() == "O" ||
            button7.text.toString() == button8.text.toString() && button8.text.toString() == button9.text.toString() && button9.text.toString() == "O" ||
            button1.text.toString() == button4.text.toString() && button4.text.toString() == button7.text.toString() && button7.text.toString() == "O" ||
            button2.text.toString() == button5.text.toString() && button5.text.toString() == button8.text.toString() && button8.text.toString() == "O" ||
            button3.text.toString() == button6.text.toString() && button6.text.toString() == button9.text.toString() && button9.text.toString() == "O" ||
            button1.text.toString() == button5.text.toString() && button5.text.toString() == button9.text.toString() && button9.text.toString() == "O" ||
            button3.text.toString() == button5.text.toString() && button5.text.toString() == button7.text.toString() && button7.text.toString() == "O" ){
            winner = "O"
            isWin = true
            for(btn in buttonArray){
                if(btn.text.toString() == ""){
                    btn.text = " "
                }
            }
        }
        return isWin
    }

    private fun reset(){
        var buttonArray = arrayOf(button1, button2, button3, button4, button5, button6, button7, button8, button9)
        for(btn in buttonArray){
            btn.text = ""
            btn.isEnabled = true
            btn.setBackgroundColor(Color.rgb(98,0,238))
            toggler = 0
            player1PTS = 0
            player2PTS = 0

        }
    }

    private fun isEmpty():Boolean{
        var buttonArray = arrayOf(button1, button2, button3, button4, button5, button6, button7, button8, button9)
        var status = false
        for (btn in buttonArray) {
            if(btn.text.toString() == ""){
                status = true
            }
        }
        return status
    }


}