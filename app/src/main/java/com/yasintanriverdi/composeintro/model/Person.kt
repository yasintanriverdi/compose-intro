package com.yasintanriverdi.composeintro.model

import androidx.annotation.DrawableRes
import com.yasintanriverdi.composeintro.R

data class Person(
    val name: String,
    val job: String,
    @DrawableRes val image: Int
)

val personList = listOf(
    Person(name = "Micheal Jackson", job = "Singer", image = R.drawable.micheal_jackson),
    Person(name = "Adele", job = "Singer", image = R.drawable.tada),
    Person(name = "Madonna", job = "Singer", image = R.drawable.tada),
    Person(name = "Beyonce", job = "Singer", image = R.drawable.tada),
    Person(name = "Rihanna", job = "Singer", image = R.drawable.tada),
    Person(name = "Angelina Jolie", job = "Actress", image = R.drawable.tada),
    Person(name = "Brad Pitt", job = "Actor", image = R.drawable.tada),
    Person(name = "Leonardo Di Caprio", job = "Actor", image = R.drawable.tada),
    Person(name = "Cristiano Ronaldo", job = "Football Player", image = R.drawable.tada),
    Person(name = "Lionel Message", job = "Football Player", image = R.drawable.tada),
    Person(name = "Neymar", job = "Football Player", image = R.drawable.tada),
    Person(name = "Roger Federer", job = "Tennis Player", image = R.drawable.tada),
    Person(name = "Rafael Nadal", job = "Tennis Player", image = R.drawable.tada),
    Person(name = "Al Pacino", job = "Actor", image = R.drawable.tada),
    Person(name = "Scarlett Johansson", job = "Actress", image = R.drawable.tada),
    Person(name = "LeBron James", job = "Basketball Player", image = R.drawable.tada),
    Person(name = "Jennifer Lopez", job = "Singer", image = R.drawable.tada),
    Person(name = "Johnny Depp", job = "Actor", image = R.drawable.tada),
    Person(name = "Tom Cruise", job = "Actor", image = R.drawable.tada),
    Person(name = "Will Smith", job = "Actor", image = R.drawable.tada),
)