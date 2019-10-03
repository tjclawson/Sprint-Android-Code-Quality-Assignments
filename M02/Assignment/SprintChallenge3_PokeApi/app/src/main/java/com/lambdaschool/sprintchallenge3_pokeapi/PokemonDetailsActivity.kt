package com.lambdaschool.sprintchallenge3_pokeapi

import android.annotation.SuppressLint
import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
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

        iv_detail.setOnClickListener {
            AlertDialog.Builder(this)
                    .setTitle("Delete entry")
                    .setMessage("Test")

                    // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.
                    .setPositiveButton(android.R.string.yes,
                            DialogInterface.OnClickListener { dialog, which ->
                                dialog.dismiss()
                            })

                    // A null listener allows the button to dismiss the dialog and take no further action.
                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show()
        }
    }
}
