package com.deliverhealth.assignment.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class StarWarCharacter (
	@SerializedName("name") val name : String,
	@SerializedName("height") val height : String,
	@SerializedName("mass") val mass : String,
	@SerializedName("hair_color") val hair_color : String,
	@SerializedName("skin_color") val skin_color : String,
	@SerializedName("eye_color") val eye_color : String,
	@SerializedName("birth_year") val birth_year : String,
	@SerializedName("gender") val gender : String,
	@SerializedName("image") val image : String
):Parcelable