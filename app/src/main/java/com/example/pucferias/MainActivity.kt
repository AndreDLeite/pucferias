package com.example.pucferias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.pucferias.main.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(MainFragment(), false)

    }

    private fun replaceFragment(fragment: Fragment, addToStackBack: Boolean) {
        val fragmentTransaction = supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right)
        if(addToStackBack) {
            fragmentTransaction.addToBackStack(null)
        }
        fragmentTransaction.replace(R.id.frame_welcome, fragment).commit()
    }
}