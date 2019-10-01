package com.lambdaschool.sprintchallenge3_pokeapi

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<Pokemon> {

    companion object{
        const val KEY = "INTENT_KEY"
    }

    lateinit var pokemonService: PokemonApi
    lateinit var newPokemon: Pokemon
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pokemonService = PokemonApi.Factory.create()

        button_search.setOnClickListener {
            var pokemonId = et_search.text.toString()
            getPokemon(pokemonId)
        }

        recycler_view.apply {
            setHasFixedSize(false)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PokemonAdapter(PokeDex.pokeDex)
        }
    }

    override fun onFailure(call: Call<Pokemon>, t: Throwable) {
        Toast.makeText(this, "Request Failed", Toast.LENGTH_LONG).show()
        Log.i("FAILURE", t.toString())
    }

    override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
        if(response.isSuccessful) {

            if(checkPokemon(response) == 0) {

                if (count != 0) {
                    count = PokeDex.pokeDex.size
                }
                newPokemon = Pokemon(
                        response.body()?.name,
                        response.body()?.sprites,
                        response.body()?.id,
                        response.body()?.abilities,
                        response.body()?.types,
                        count
                )

                PokeDex.pokeDex.add(newPokemon)
                Toast.makeText(this, "New Pokemon Added", Toast.LENGTH_LONG).show()

                val intent = Intent(this, PokemonDetailsActivity::class.java)
                intent.putExtra(KEY, newPokemon.index)
                startActivity(intent)
                recycler_view.adapter?.notifyDataSetChanged()

                count++
            } else {
                Toast.makeText(this, "${response.body()?.name} has already been added to PokeDex", Toast.LENGTH_LONG).show()
            }

        } else {
            Toast.makeText(this, "Not a Valid Pokemon ID or Name", Toast.LENGTH_LONG).show()
        }
    }

    private fun getPokemon(pokemonId: String){
        pokemonService.getPokemon(pokemonId).enqueue(this)
    }

    private fun checkPokemon(response: Response<Pokemon>): Int {
        var result = 0
        for(i in 0 until PokeDex.pokeDex.size){
            if(response.body()?.name == PokeDex.pokeDex[i].name){
                result++
            }
        }
        return result
    }
}