package com.lambdaschool.sprintchallenge3_pokeapi

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

interface PokemonApi{

    @GET("{name-id}")
    fun getPokemon(@Path("name-id") pokemonId: String): Call<Pokemon>

    class Factory {

        companion object {
            val BASE_URL = "https://pokeapi.co/api/v2/pokemon/"
            val gson = Gson()
            val okHttpClient = OkHttpClient.Builder()
                    .addNetworkInterceptor(StethoInterceptor())
                    .retryOnConnectionFailure(false)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .build()

            fun create(): PokemonApi {

                return Retrofit.Builder()
                        .baseUrl(PokemonApi.Factory.BASE_URL)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build()
                        .create(PokemonApi::class.java)
            }
        }
    }
}