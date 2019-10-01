package com.lambdaschool.sprintchallenge3_pokeapi

import android.graphics.Bitmap
import org.json.JSONException
import org.json.JSONObject

import java.io.Serializable
import java.util.ArrayList


class Pokemon(
        var name: String?,
        var sprites: Sprites?,
        var id: Int?,
        var abilities: List<Abilities>?,
        var types: List<Types>?,
        var index: Int): Serializable

object PokeDex {
    val pokeDex = mutableListOf<Pokemon>()
}

class Ability(val name: String)

class Abilities(val ability: Ability)

class Type(val name: String)

class Types(val type: Type)

class Sprites(val front_shiny: String)

