package ru.nvg_soft.domain.repositories.implementations

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import ru.nvg_soft.data.remote.providers.HeroProviderImpl
import ru.nvg_soft.domain.converters.HeroConverterImpl
import ru.nvg_soft.domain.models.Hero


class HeroRepositoryImpl (val heroConverter: HeroConverterImpl){
    private val heroProvider: HeroProviderImpl = HeroProviderImpl()


  suspend   fun fechHeroes(): Deferred<List<Hero>> {
        return try{
            val heroes = heroProvider.getHeroList().await()
            GlobalScope.async {
                heroes.map { hero -> heroConverter.fromApiToUI(model = hero) }
            }
        } catch (e:Exception){
            GlobalScope.async { error(e) }
        }
    }
}