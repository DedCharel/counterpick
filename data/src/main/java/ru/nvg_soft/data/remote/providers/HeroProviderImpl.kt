package ru.nvg_soft.data.remote.providers

import kotlinx.coroutines.Deferred
import ru.nvg_soft.data.remote.helpers.RetrofitFactory
import ru.nvg_soft.data.remote.models.HeroApi

class HeroProviderImpl {
    fun getHeroList():Deferred<List<HeroApi>>{
        return RetrofitFactory.getHeroesService().getHeroes()

    }
}