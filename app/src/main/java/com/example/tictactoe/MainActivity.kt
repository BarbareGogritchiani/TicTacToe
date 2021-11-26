package com.example.tictactoe

import android.graphics.Color
import android.graphics.Color.BLUE
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var player1Points : TextView
    private lateinit var player2Points : TextView
    private lateinit var button1 : Button
    private lateinit var button2 : Button
    private lateinit var button3 : Button
    private lateinit var button4 : Button
    private lateinit var button5 : Button
    private lateinit var button6 : Button
    private lateinit var button7 : Button
    private lateinit var button8 : Button
    private lateinit var button9 : Button
    private lateinit var refresh : Button
    private lateinit var reset : Button

    var gau = 0
    var jos = 0

    private var activePlayer = 1

    private var firstPlayer = ArrayList <Int>()
    private var secondPlayer = ArrayList <Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()


    }

    override fun onClick(clickedView: View? ){
        if(clickedView is Button){
            var buttonNumber = 0
            when(clickedView.id){
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }
            if(buttonNumber != 0){
                playGame(clickedView , buttonNumber)
            }

        }

    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {

        if(activePlayer == 1){
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.RED)
            activePlayer = 2
            firstPlayer.add(buttonNumber)

        }
        else{
            clickedView.text = "0"
            clickedView.setBackgroundColor(Color.BLUE)
            activePlayer = 1
            secondPlayer.add(buttonNumber)

        }
        clickedView.isEnabled = false
        check()


    }

    private fun check() {


        var winnerPlayer = 0
        if(firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)){
            winnerPlayer  = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)){
            winnerPlayer = 2
        }
        if(firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)){
            winnerPlayer  = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)){
            winnerPlayer = 2
        }
        if(firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)){
            winnerPlayer  = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if(firstPlayer.contains(4) && firstPlayer.contains(1) && firstPlayer.contains(7)){
            winnerPlayer  = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(1) && secondPlayer.contains(7)){
            winnerPlayer = 2
        }
        if(firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)){
            winnerPlayer  = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)){
            winnerPlayer = 2
        }
        if(firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)){
            winnerPlayer  = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)){
            winnerPlayer = 2
        }
        if(firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)){
            winnerPlayer  = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if(firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)){
            winnerPlayer  = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if (winnerPlayer == 1) {
            Toast.makeText(this, "First player won! ", Toast.LENGTH_SHORT ).show()
            disableButtons()
            gau++
            player1Points.text = "Player1: $gau"

        }
        else if (winnerPlayer == 2){
            Toast.makeText(this, "Second player Won" ,Toast.LENGTH_SHORT).show()
            disableButtons()
            jos++
            player2Points.text = "Player2: $jos"
        }


    }

    private fun init(){

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        player1Points = findViewById(R.id.player1Points)
        player2Points = findViewById(R.id.player2Points)
        refresh = findViewById(R.id.button10)
        reset = findViewById(R.id.button11)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        refresh.setOnClickListener {
            refreshbtn()

        }
        reset.setOnClickListener {
            resetbtn()
        }


    }

    fun disableButtons() {
        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false
    }
    fun refreshbtn(){
        activePlayer = 1
        firstPlayer.clear()
        secondPlayer.clear()

        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true

        button1.text = " "
        button2.text = " "
        button3.text = " "
        button4.text = " "
        button5.text = " "
        button6.text = " "
        button7.text = " "
        button8.text = " "
        button9.text = " "

        button1.setBackgroundColor(BLUE)
        button2.setBackgroundColor(BLUE)
        button3.setBackgroundColor(BLUE)
        button4.setBackgroundColor(BLUE)
        button5.setBackgroundColor(BLUE)
        button6.setBackgroundColor(BLUE)
        button7.setBackgroundColor(BLUE)
        button8.setBackgroundColor(BLUE)
        button9.setBackgroundColor(BLUE)

    }
    fun resetbtn(){
        gau = 0
        jos = 0
        player1Points.text = "Player1: $gau"
        player2Points.text = "Player2: $jos"
        refreshbtn()


    }


}
