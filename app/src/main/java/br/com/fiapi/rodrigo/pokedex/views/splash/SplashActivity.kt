package br.com.fiapi.rodrigo.pokedex.views.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import br.com.fiapi.rodrigo.pokedex.R
import br.com.fiapi.rodrigo.pokedex.views.main.MainActivity
import org.koin.android.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    val splashViewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashViewModel.checkHealth()
        splashViewModel.messageError.observe(this, Observer {
            if (it == "") {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        })
    }
}
