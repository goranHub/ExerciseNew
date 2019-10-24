package com.sicoapp.exercise

import com.sicoapp.model.Primjer

/**
 * @author ll4
 * @date 10/23/2019
 */
object  PrimjerImpl :Iprimjer {
    override fun prvi() : Primjer {

        var name = "Goran"
        var age = 18
       return Primjer(name,age)
    }

    fun drugi():Primjer{
        var name = "Goro"
        var age = 22
        return Primjer(name, age)
    }
}