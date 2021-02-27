/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Puppy

class PuppyStaticData {

    companion object {

        val puppies = arrayListOf(
            Puppy(1, "Tony", "Chihuahua", "Salamanca, Spain", "6 weeks", R.drawable.chihuahua1, "Chihuahua dog"),
            Puppy(2, "Sparkles", "Chihuahua", "Madrid, Spain", "13 weeks", R.drawable.chihuahua2, "Chihuahua dog"),
            Puppy(3, "Joe", "Chihuahua", "Tijuana, Mexico", "8 weeks", R.drawable.chihuahua3, "Chihuahua dog"),
            Puppy(4, "Elliot", "Pug", "London, United Kingdom", "2 weeks", R.drawable.pug1, "Pug"),
            Puppy(5, "Pup", "Pug", "Brighton, United Kingdom", "4 weeks", R.drawable.pug2, "Pug"),
            Puppy(6, "Charlie", "Pug", "Dijon, France", "15 weeks", R.drawable.pug3, "Pug"),
            Puppy(7, "Max", "Maltese", "Saint-Jean-de-Luz, France", "21 weeks", R.drawable.maltese1, "Maltese"),
            Puppy(8, "Buddy", "Maltese", "Murcia, Spain", "22 weeks", R.drawable.maltese2, "Maltese"),
            Puppy(9, "Coco", "Maltese", "Madrid, Spain", "13 weeks", R.drawable.maltese3, "Maltese"),
            Puppy(10, "Lucy", "Shiba Inu", "Barcelona, Spain", "5 weeks", R.drawable.shiba1, "Shiba Inu"),
            Puppy(11, "Toby", "Shiba Inu", "Madrid, Spain", "6 weeks", R.drawable.shiba2, "Shiba Inu"),
        )

        fun getPuppy(id: Int): Puppy {
            return puppies.first { it.id == id }
        }
    }
}
