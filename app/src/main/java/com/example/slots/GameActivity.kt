package com.example.slots

import android.content.Context
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.graphics.drawable.toDrawable
import androidx.lifecycle.lifecycleScope
import com.example.slots.databinding.ActivityGameBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class GameActivity : AppCompatActivity() {
    private var imagesViewArray: MutableList<ImageView> = mutableListOf<ImageView>()
    var imagesArray1: MutableList<Int> = mutableListOf<Int>()
    var imagesArray2: MutableList<Int> = mutableListOf<Int>()
    var imagesArray3: MutableList<Int> = mutableListOf<Int>()
    private lateinit var binding: ActivityGameBinding
    var isGameActive:Boolean = true
    var diamond:Int? = null
    var gameSound: MediaPlayer? = null
    var moneySound: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        gameSound = MediaPlayer.create(this,R.raw.sound_of_game)
        moneySound = MediaPlayer.create(this,R.raw.money )
        diamond = getSharedPreferences("settings", Context.MODE_PRIVATE)
            .getInt("diamond", 1000)
        binding.diamondTextView.text = diamond.toString()

        init()
    }

    private fun init() {
        for (i in 1..9) {
            val viewImage = "slot$i"
            var temp = resources.getIdentifier(viewImage, "id", packageName);
            var imageView = findViewById<ImageView>(temp)
            imagesViewArray.add(imageView)
        }

        for (i in 0..9){
            when(i){
                0-> imagesArray1.add(R.drawable.gnome)
                1-> imagesArray1.add(R.drawable.cauldron)
                2-> imagesArray1.add(R.drawable.apple)
                3-> imagesArray1.add(R.drawable.cyclops)
                4-> imagesArray1.add(R.drawable.treasure)
                5-> imagesArray1.add(R.drawable.castle)
                6-> imagesArray1.add(R.drawable.tower)
                7-> imagesArray1.add(R.drawable.forest)
                8-> imagesArray1.add(R.drawable.cauldron)
                9-> imagesArray1.add(R.drawable.treasure)
            }
        }
    }

    fun roll(view: View) {
        if (isGameActive ){
            if(diamond!!<100){
                Toast.makeText(this,"Oops you don't have enough diamonds",Toast.LENGTH_SHORT).show()
            }
            else {
                setDiamond(-100)
                isGameActive = false
                anim()
            }
        }
    }



    private fun anim(){
        gameSound!!.start()
        lifecycleScope.launch(Dispatchers.Main){
            for (i in 0..getRandomNumber()){
                var temp1 = i
                var temp2 = i
                var temp3 = i
                while (temp1 !in 0..9){
                    temp1-=10
                }
                    imagesViewArray[0].setImageResource(imagesArray1[temp1])
                    imagesViewArray[0].tag = Integer.valueOf(imagesArray1[temp1]);

                while (temp2 !in 0..8){
                    temp2 -=9
                }
                if (i>8) {
                    imagesViewArray[3].setImageResource(imagesArray1[temp2])
                    imagesViewArray[3].tag = Integer.valueOf(imagesArray1[temp2]);
                }
                    else {
                        imagesViewArray[3].setImageResource(imagesArray1[temp2+1])
                        imagesViewArray[3].tag = Integer.valueOf(imagesArray1[temp2+1]);
                }
                while (temp3 !in 0..7){
                    temp3 -=8
                }
                if (i>7) {
                    imagesViewArray[6].setImageResource(imagesArray1[temp3])
                    imagesViewArray[6].tag = Integer.valueOf(imagesArray1[temp3]);
                }
                    else {
                        imagesViewArray[6].setImageResource(imagesArray1[temp3+2])
                        imagesViewArray[6].tag = Integer.valueOf(imagesArray1[temp2+2]);
                }
                delay(200L)
            }
            for (i in 0..getRandomNumber()){
                var temp1 = i
                var temp2 = i
                var temp3 = i
                while (temp1 !in 0..9){
                    temp1-=10
                }
                imagesViewArray[1].setImageResource(imagesArray1[temp1])
                imagesViewArray[1].tag = Integer.valueOf(imagesArray1[temp1]);

                while (temp2 !in 0..8){
                    temp2 -=9
                }
                if (i>8) {
                    imagesViewArray[4].setImageResource(imagesArray1[temp2])
                    imagesViewArray[4].tag = Integer.valueOf(imagesArray1[temp2]);
                }
                else {
                    imagesViewArray[4].setImageResource(imagesArray1[temp2+1])
                    imagesViewArray[4].tag = Integer.valueOf(imagesArray1[temp2+1]);
                }

                while (temp3 !in 0..7){
                    temp3 -=8
                }
                if (i>7) {
                    imagesViewArray[7].setImageResource(imagesArray1[temp3])
                    imagesViewArray[7].tag = Integer.valueOf(imagesArray1[temp3]);
                }
                else {
                    imagesViewArray[7].setImageResource(imagesArray1[temp3+2])
                    imagesViewArray[7].tag = Integer.valueOf(imagesArray1[temp2+2]);
                }
                delay(200L)
            }
            for (i in 0..getRandomNumber()){
                var temp1 = i
                var temp2 = i
                var temp3 = i
                while (temp1 !in 0..9){
                    temp1-=10
                }
                imagesViewArray[2].setImageResource(imagesArray1[temp1])
                imagesViewArray[2].tag = Integer.valueOf(imagesArray1[temp1]);
                while (temp2 !in 0..8){
                    temp2 -=9
                }
                if (i>8) {
                    imagesViewArray[5].setImageResource(imagesArray1[temp2])
                    imagesViewArray[5].tag = Integer.valueOf(imagesArray1[temp2]);
                }
                else {
                    imagesViewArray[5].setImageResource(imagesArray1[temp2+1])
                    imagesViewArray[5].tag = Integer.valueOf(imagesArray1[temp2+1]);
                }
                while (temp3 !in 0..7){
                    temp3 -=8
                }
                if (i>7) {
                    imagesViewArray[8].setImageResource(imagesArray1[temp3])
                    imagesViewArray[8].tag = Integer.valueOf(imagesArray1[temp3]);
                }
                else {
                    imagesViewArray[8].setImageResource(imagesArray1[temp3+2])
                    imagesViewArray[8].tag = Integer.valueOf(imagesArray1[temp2+2]);
                }
                delay(200L)
            }
            checkWin()
            isGameActive = true
        }
    }

    private fun getRandomNumber(): Int {
        var random: Int? = null
        val rand = Random(System.nanoTime())
        random = (5..20).random(rand)
        return random
    }

    private fun setDiamond(number:Int){
        diamond = diamond!! + number
        if (diamond == 0) {
            binding.getFreeD.visibility = View.VISIBLE
        }
        binding.diamondTextView.text = diamond.toString()
        showActionWithDiamond(number)
        var prefs = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putInt("diamond", diamond!!).apply()
    }

    fun freeDiamonds(view:View){
        moneySound!!.start()
        view.visibility = View.INVISIBLE
        setDiamond(1000)
    }


    private fun showActionWithDiamond(diamond:Int){
        lifecycleScope.launch(Dispatchers.Main){
            with(binding){
                actionTextView.visibility = View.VISIBLE
                diamondImageView3.visibility = View.VISIBLE
                if (diamond > 0){
                    actionTextView.text = "+ $diamond"
                }
                else actionTextView.text = diamond.toString()
                delay(1000L)
                actionTextView.visibility = View.INVISIBLE
                diamondImageView3.visibility = View.INVISIBLE
            }
        }
    }

    private  fun checkWin(){
        var sumOfDiamond = 0
        if (imagesViewArray[0].tag == imagesViewArray[1].tag)
            sumOfDiamond += 200
        if (imagesViewArray[1].tag == imagesViewArray[2].tag)
            sumOfDiamond += 200
        if (imagesViewArray[3].tag == imagesViewArray[4].tag)
            sumOfDiamond += 200
        if (imagesViewArray[4].tag == imagesViewArray[5].tag)
            sumOfDiamond += 200
        if (imagesViewArray[6].tag == imagesViewArray[7].tag)
            sumOfDiamond += 200
        if (imagesViewArray[7].tag == imagesViewArray[8].tag)
            sumOfDiamond += 200

        if (imagesViewArray[0].tag == imagesViewArray[1].tag && imagesViewArray[0].tag == imagesViewArray[2].tag)
            sumOfDiamond += 100
        if (imagesViewArray[3].tag == imagesViewArray[4].tag && imagesViewArray[4].tag == imagesViewArray[6].tag)
            sumOfDiamond += 100

        if (imagesViewArray[7].tag == imagesViewArray[8].tag && imagesViewArray[7].tag == imagesViewArray[9].tag)
            sumOfDiamond += 100


        //сверка по строке
        if (imagesViewArray[0].tag == R.drawable.treasure && imagesViewArray[1].tag == R.drawable.treasure && imagesViewArray[2].tag == R.drawable.treasure ){
            sumOfDiamond += 300
        }
        if (imagesViewArray[3].tag == R.drawable.treasure && imagesViewArray[4].tag == R.drawable.treasure && imagesViewArray[5].tag == R.drawable.treasure ){
            sumOfDiamond += 300
        }
        if (imagesViewArray[6].tag == R.drawable.treasure && imagesViewArray[7].tag == R.drawable.treasure && imagesViewArray[8].tag == R.drawable.treasure ){
            sumOfDiamond += 300
        }
        setDiamond(sumOfDiamond)
    }

}
