package ru.nvg_soft.data.remote.service

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import ru.nvg_soft.data.remote.models.HeroApi

interface HeroesService {
    @GET("./heroes")
    fun getHeroes(): Deferred<List<HeroApi>>
}