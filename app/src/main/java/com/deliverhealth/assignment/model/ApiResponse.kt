package com.deliverhealth.assignment.model

import com.google.gson.annotations.SerializedName

data class ApiResponse (
	@SerializedName("results") val starWarCharLists : List<StarWarCharacter>
)