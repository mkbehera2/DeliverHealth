package com.deliverhealth.assignment.view.activity

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.deliverhealth.assignment.R
import com.deliverhealth.assignment.databinding.ActivityMainBinding
import com.deliverhealth.assignment.databinding.DetailsLayoutBinding
import com.deliverhealth.assignment.model.StarWarCharacter

class CharacterDetailActivity : AppCompatActivity() {

    companion object{
        private val TAG = CharacterDetailActivity::class.qualifiedName
    }

    private lateinit var binding: DetailsLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailsLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        populateViews();
    }

    private fun populateViews(){
        Log.d(TAG, "populateViews: ")
        val bundle = intent.getBundleExtra("myBundle")
        var starWarCharacter  = bundle?.getParcelable<StarWarCharacter>("selected_character") as StarWarCharacter
        val title = starWarCharacter.name?:"Name Not Found";
        val birthYear = starWarCharacter.birth_year?:"Year Not Found";
        val gender = starWarCharacter.gender?:"Gender Not Found";
        val height = starWarCharacter.height?:"height Not Found";
        val mass = starWarCharacter.mass?:"Mass Not Found";
        val eyeColor = starWarCharacter.eye_color?:"Eye Color Not Found";
        val hairColor = starWarCharacter.hair_color?:"Hair Color Not Found";
        val skinColor = starWarCharacter.skin_color?:"Skin Color Not Found";

        binding.name.text = title
        binding.birthYear.text = birthYear
        binding.gender.text = gender
        binding.height.text = "${height} cm"
        binding.mass.text = "${mass} kg"
        binding.eyeColor.text = eyeColor
        binding.hairColor.text = hairColor
        binding.skinColor.text = skinColor

        Glide.with(binding.imageview.context).load(starWarCharacter.image).into(binding.imageview)

    }
}