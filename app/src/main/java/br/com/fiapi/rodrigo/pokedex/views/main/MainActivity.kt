package br.com.fiapi.rodrigo.pokedex.views.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import br.com.fiapi.rodrigo.pokedex.R
import br.com.fiapi.rodrigo.pokedex.views.list.ListPokemonsActivity
import br.com.fiapi.rodrigo.pokedex.views.scan.ScanActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btPokedex.setOnClickListener {
            startActivity(Intent(this, ScanActivity::class.java))
        }
        btPokemonList.setOnClickListener {
            startActivity(Intent(this, ListPokemonsActivity::class.java))
        }
        btClose.setOnClickListener {
            finish()
        }
    }
}
