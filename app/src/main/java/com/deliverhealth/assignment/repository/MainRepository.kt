package com.deliverhealth.assignment.repository

class MainRepository constructor(private val retrofitService: RetrofitService) {
    suspend fun getAllStarWarCharacters() = retrofitService.getAllStarWarCharacters()
}