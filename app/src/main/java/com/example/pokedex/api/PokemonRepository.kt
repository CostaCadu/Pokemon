package com.example.pokedex.api

import android.util.Log
import com.example.pokedex.model.PokemonApiResult
import com.example.pokedex.model.PokemonsApiResult
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

object PokemonRepository {
    private val service:PokemonService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

         service = retrofit.create(PokemonService::class.java)
    }
    fun listPokemons(limit: Int = 151): PokemonsApiResult? {
       val call = service.listPokemons(limit)

        return call.execute().body()

    }
    fun getPokemon(number: Int): PokemonApiResult? {
        val call = service.getPokemon(number)

        return call.execute().body()


    }
}