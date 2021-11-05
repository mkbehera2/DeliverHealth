package com.deliverhealth.assignment.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.deliverhealth.assignment.databinding.CharacterRowBinding
import com.deliverhealth.assignment.model.StarWarCharacter
import com.deliverhealth.assignment.view.listener.ClickListener

class StarWarCharacterAdapter(val clickListener: ClickListener) : RecyclerView.Adapter<MainViewHolder>() {

    var startWarCharacterList = mutableListOf<StarWarCharacter>()

    fun setCharacters(characters: List<StarWarCharacter>) {
        this.startWarCharacterList = characters.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = CharacterRowBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val starWarCharacter = startWarCharacterList[position]
        holder.binding.title.text = starWarCharacter.name
        Glide.with(holder.itemView.context).load(starWarCharacter.image).into(holder.binding.thumbnail)
        holder.binding.rowItem.setOnClickListener{
            clickListener?.onClick(starWarCharacter)
        }
    }

    override fun getItemCount(): Int {
        return startWarCharacterList.size
    }
}

class MainViewHolder(val binding: CharacterRowBinding) : RecyclerView.ViewHolder(binding.root) {

}