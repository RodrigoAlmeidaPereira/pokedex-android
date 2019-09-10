package br.com.fiapi.rodrigo.pokedex.views.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiapi.rodrigo.pokedex.models.Pokemon
import br.com.fiapi.rodrigo.pokedex.repository.PokemonRepository

class DetailViewModel(
    val pokemonRepository: PokemonRepository
) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val pokemon = MutableLiveData<Pokemon>()

    fun getPokemon(number: String) {
        isLoading.value = true
        pokemonRepository.getPokemon(
            number,
            onComplete = {
                isLoading.value = false
                pokemon.value = it
            },
            onError = {
                isLoading.value = false
            }
        )
    }
}