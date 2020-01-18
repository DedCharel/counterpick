package ru.nvg_soft.domain.repositories.implementations

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import ru.nvg_soft.domain.models.Hero


class HeroRepositoryImpl {
     fun fechHeroes(): Deferred<List<Hero>> {
        Thread.sleep(3000)

        val mockData =ArrayList<Hero>()
        mockData.add(Hero(id = 0, title = "Anti-Mage", icon = "", attackType = 0))
        mockData.add(Hero(id = 1, title = "Dark Willow", icon = "", attackType = 1))
        mockData.add(Hero(id = 2, title = "Lion", icon = "", attackType = 1))

        return GlobalScope.async { mockData }
    }
}