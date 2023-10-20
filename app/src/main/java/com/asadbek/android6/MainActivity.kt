package com.asadbek.android6

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.asadbek.android6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var time = 3000
    var birinchi = 0
    var ikkinchi = 0
    var oneKey = ""
    var twoKey = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.imageView.setOnClickListener {
            anim1(binding.imageView)
        }
        binding.imageView2.setOnClickListener {
            anim(binding.imageView2)
        }

    }



    private fun anim(view: View){
        val anim = AnimationUtils.loadAnimation(this,R.anim.anim_1)
        view.startAnimation(anim)
        anim.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {

                if (ikkinchi == 0){
                    twoKey = "heart"
                    binding.imageView2.setImageDrawable(ContextCompat.getDrawable(this@MainActivity,R.drawable.icons8_heart_60px_2))
                    ikkinchi = 1
                }else{
                    binding.imageView2.setImageDrawable(ContextCompat.getDrawable(this@MainActivity,R.drawable.gamefon))
                    ikkinchi = 0
                }
            }

            override fun onAnimationEnd(p0: Animation?) {
               /*
                val handler = Handler()
                handler.postDelayed({
                    binding.imageView.setImageDrawable(ContextCompat.getDrawable(this@MainActivity,R.drawable.gamefon))
                },time.toLong())
                */
            }

            override fun onAnimationRepeat(p0: Animation?) {

            }
        })
    }
    private fun anim1(view: View){
        val anim = AnimationUtils.loadAnimation(this,R.anim.anim_1)
        view.startAnimation(anim)
        anim.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
                if (birinchi == 0){
                    oneKey = "heart"
                    binding.imageView.setImageDrawable(ContextCompat.getDrawable(this@MainActivity,R.drawable.icons8_heart_60px_2))
                    birinchi = 1
                    if (oneKey == twoKey){
                        absending(binding.imageView,binding.imageView2)
                        binding.imageView.visibility = View.INVISIBLE
                        binding.imageView2.visibility = View.INVISIBLE
                        oneKey = ""
                        twoKey = ""
                    }
                }else if (birinchi == 1 && ikkinchi == 1){
                    if (oneKey == twoKey){
                        absending(binding.imageView,binding.imageView2)
                    }
                }
                else{
                    binding.imageView.setImageDrawable(ContextCompat.getDrawable(this@MainActivity,R.drawable.gamefon))
                    birinchi = 0
                }
            }

            override fun onAnimationEnd(p0: Animation?) {
              /*
                val handler = Handler()
                handler.postDelayed({
                    binding.imageView.setImageDrawable(ContextCompat.getDrawable(this@MainActivity,R.drawable.gamefon))
                },time.toLong())
               */
            }

            override fun onAnimationRepeat(p0: Animation?) {

            }
        })
    }
    private fun absending(view: View,view2: View){
        val anim = AnimationUtils.loadAnimation(this,R.anim.absending)
        view.startAnimation(anim)
        view2.startAnimation(anim)
    }
    private fun scale(view: View){
        val anim = AnimationUtils.loadAnimation(this,R.anim.scale)
        view.startAnimation(anim)
    }
    private fun translate(view: View){
        val anim = AnimationUtils.loadAnimation(this,R.anim.translate)
        view.startAnimation(anim)
    }
    private fun rotate(view: View){
        val anim = AnimationUtils.loadAnimation(this,R.anim.rotate)
        view.startAnimation(anim)
    }
    private fun hammasi(view: View){
        val animation = AnimationUtils.loadAnimation(this,R.anim.combonation)
        view.startAnimation(animation)
        animation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
                
            }

            override fun onAnimationEnd(p0: Animation?) {
                Toast.makeText(this@MainActivity, "Animatsiya tugadi!", Toast.LENGTH_SHORT).show()
                binding.mainLayout.setBackgroundColor(ContextCompat.getColor(this@MainActivity,R.color.purple_700))
            }

            override fun onAnimationRepeat(p0: Animation?) {
                
            }
        })
    }

}