package ru.msakhterov.results.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.msakhterov.results.R
import ru.msakhterov.results.ui.fragments.ActivitiesFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ru.msakhterov.results.R.layout.activity_main)
        setSupportActionBar(toolbar)

        val fragment = supportFragmentManager.findFragmentById(R.id.container)
        if (savedInstanceState == null && fragment == null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, ActivitiesFragment())
            transaction.commit()
        }
    }
}
