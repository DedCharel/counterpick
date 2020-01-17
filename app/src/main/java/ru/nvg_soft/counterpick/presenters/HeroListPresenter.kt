package ru.nvg_soft.counterpick.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.nvg_soft.domain.models.Hero
import ru.nvg_soft.counterpick.views.HeroListView
import android.os.Handler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.nvg_soft.domain.repositories.implementations.HeroRepositoryImpl
import kotlin.concurrent.thread

@InjectViewState
class HeroListPresenter: MvpPresenter<HeroListView>() {
    private val heroesRepositoryImpl =HeroRepositoryImpl()
    fun fetchHeroes(){
        viewState.presentLoading()
        GlobalScope.launch ( Dispatchers.IO){
            try {
                val heroes = heroesRepositoryImpl.fechHeroes().await()
                withContext(Dispatchers.Main){
                    viewState.presentHeroes( data = heroes)
                }
            } catch (e:Exception){
                e.printStackTrace()
            }
        }





    }
}