package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Puppy

class PuppyStaticData {

    companion object {

        val puppies = arrayListOf(
            Puppy(1,"Tony", "Chihuahua", R.drawable.chihuahua1, "Chihuahua dog"),
            Puppy(2,"Sparkles", "Chihuahua", R.drawable.chihuahua2, "Chihuahua dog"),
            Puppy(3,"Joe", "Chihuahua", R.drawable.chihuahua3, "Chihuahua dog"),
            Puppy(4,"Elliot", "Pug", R.drawable.pug1, "Pug"),
            Puppy(5,"Pup", "Pug", R.drawable.pug2, "Pug"),
            Puppy(6,"Charlie", "Pug", R.drawable.pug3, "Pug"),
            Puppy(7,"Max", "Maltese", R.drawable.maltese1, "Maltese"),
            Puppy(8,"Buddy", "Maltese", R.drawable.maltese2, "Maltese"),
            Puppy(9,"Coco", "Maltese", R.drawable.maltese3, "Maltese"),
            Puppy(10,"Lucy", "Shiba Inu", R.drawable.shiba1, "Shiba Inu"),
            Puppy(11,"Toby", "Shiba Inu", R.drawable.shiba2, "Shiba Inu"),
        )

        fun getPuppy(id: Int) : Puppy {
            return puppies.first { it.id == id }
        }
    }

}