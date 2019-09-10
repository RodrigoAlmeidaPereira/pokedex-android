package br.com.fiapi.rodrigo.pokedex.views.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiapi.rodrigo.pokedex.repository.PokemonRepository

class SplashViewModel(val pokemonRepository: PokemonRepository) : ViewModel() {

    val messageError: MutableLiveData<String> = MutableLiveData()

    fun checkHealth() {
        pokemonRepository.checkHealth(
            onComplete = {
                messageError.value = ""
            },
            onError = {
                messageError.value = it?.message
            }
        )
    }
}