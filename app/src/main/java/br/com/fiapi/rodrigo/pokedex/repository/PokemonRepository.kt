package br.com.fiapi.rodrigo.pokedex.repository

import br.com.fiapi.rodrigo.pokedex.models.Pokemon

interface PokemonRepository {
    fun checkHealth(
        onComplete:() -> Unit,
        onError: (Throwable?) -> Unit
    )

    fun getPokemons(
        size: Int,
        sort: String,
        onComplete: (List<Pokemon>?) -> Unit,
        onError: (Throwable?) -> Unit
    )

    fun updatePokemon(
        pokemon: Pokemon,
        onComplete:(Pokemon?) -> Unit,
        onError:(Throwable) -> Unit
    )

    fun getPokemon(
        number: String,
        onComplete:(Pokemon?) -> Unit,
        onError:(Throwable) -> Unit
    )
}