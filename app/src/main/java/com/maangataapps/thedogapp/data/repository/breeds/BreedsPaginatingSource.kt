package com.maangataapps.thedogapp.data.repository.breeds

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.maangataapps.thedogapp.data.api.breeds.BreedsApi
import com.maangataapps.thedogapp.data.local.LocalStore
import com.maangataapps.thedogapp.domain.model.breeds.Breed
import com.maangataapps.thedogapp.domain.repository.RetrofitRepository
import com.maangataapps.thedogapp.infrastructure.utils.LIMIT_HITS
import com.maangataapps.thedogapp.infrastructure.utils.NetworkUtils
import retrofit2.awaitResponse

class BreedsPaginatingSource(
    private val api: BreedsApi,
    private val networkUtils: NetworkUtils,
): PagingSource<Int, Breed>(), RetrofitRepository {

    override fun getRefreshKey(state: PagingState<Int, Breed>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Breed> {
        val page = params.key ?: 0

        if (networkUtils.isOnline()) {
            return try {
                val response = api.getBreedsList(
                    limit = LIMIT_HITS,
                    page = page,
                ).awaitResponse()

                LoadResult.Page(
                    data = response.body().orEmpty(),
                    prevKey = null,
                    nextKey = if (response.body().isNullOrEmpty()) null else page.plus(1),
                )
            } catch (e: Exception) {
                LoadResult.Error(e)
            }
        } else {
            return try {
                val response = LocalStore.getPaginatedBreeds(
                    limit = LIMIT_HITS,
                    page = page,
                )

                LoadResult.Page(
                    data = response,
                    prevKey = null,
                    nextKey = if (response.isEmpty()) null else page.plus(1),
                )
            } catch (e: Exception) {
                LoadResult.Error(e)
            }
        }
    }

}