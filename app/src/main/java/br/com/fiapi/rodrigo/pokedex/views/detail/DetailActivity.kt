package br.com.fiapi.rodrigo.pokedex.views.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import br.com.fiapi.rodrigo.pokedex.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.include_loading.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {
    val detailViewModel: DetailViewModel by viewModel()
    val picasso: Picasso by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        detailViewModel.getPokemon(intent.getStringExtra("POKEMON_NUMBER"))
        detailViewModel.pokemon.observe(this, Observer {
            picasso.load("https://pokedexdx.herokuapp.com${it.urlImagem}").into(ivPokemon)
            tvPokemonName.text = "${it.numero} ${it.nome}"
        })


        detailViewModel.isLoading.observe(this, Observer{
            if(it == true) {
                containerLoading.visibility = View.VISIBLE
            } else {
                containerLoading.visibility = View.GONE
            }
        })
    }
}