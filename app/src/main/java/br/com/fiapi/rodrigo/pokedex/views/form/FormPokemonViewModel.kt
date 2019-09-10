package br.com.fiapi.rodrigo.pokedex.views.form

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiapi.rodrigo.pokedex.models.Pokemon
import br.com.fiapi.rodrigo.pokedex.repository.PokemonRepository

class FormPokemonViewModel(

    val pokemonRepository: PokemonRepository) : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val messageResponse = MutableLiveData<String>()

    fun updatePokemon(pokemon: Pokemon) {
        isLoading.value = true
        pokemonRepository.updatePokemon(
            pokemon = pokemon,
            onComplete = {
                isLoading.value = false
                messageResponse.value = "Dados atualizados com sucesso"
            },
            onError = {
                isLoading.value = false
                messageResponse.value = it.message
            }
        )
    }
}