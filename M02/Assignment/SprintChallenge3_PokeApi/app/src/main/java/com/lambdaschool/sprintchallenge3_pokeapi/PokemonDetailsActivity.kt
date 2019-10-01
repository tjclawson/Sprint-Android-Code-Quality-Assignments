package com.lambdaschool.sprintchallenge3_pokeapi

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pokemon_details.*

import java.util.ArrayList

class PokemonDetailsActivity : AppCompatActivity() {

    companion object {
        const val KEY = "INTENT_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        val index = intent.getIntExtra(KEY, 4)
        var pokemon = PokeDex.pokeDex[index]

        tv_name.append(pokemon.name)
        tv_id.append(pokemon.id.toString())

        for(i in 0 until pokemon.abilities!!.size){
            var ability = pokemon.abilities
            tv_abilities.append(ability!![i].ability.name + ", ")
        }

        for(i in 0 until pokemon.types!!.size){
            var type = pokemon.types
            tv_types.append(type!![i].type.name + ", ")
        }

        Picasso.get().load(pokemon.sprites!!.front_shiny).resize(1000, 1000).into(iv_detail)
    }
}
