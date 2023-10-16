package com.maangataapps.thedogapp.domain.repository.breeds

import androidx.paging.Pager
import com.maangataapps.thedogapp.domain.model.breeds.Breed
import com.maangataapps.thedogapp.domain.repository.RetrofitRepository

interface BreedsRepository: RetrofitRepository {
    fun getBreedsList(): Pager<Int, Breed>
}