package ru.nvg_soft.counterpick.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_main.*
import ru.nvg_soft.counterpick.R
import ru.nvg_soft.counterpick.adapters.HeroAdapter
import ru.nvg_soft.counterpick.models.Hero
import ru.nvg_soft.counterpick.presenters.HeroListPresenter
import ru.nvg_soft.counterpick.views.HeroListView

class MainActivity : MvpAppCompatActivity(), HeroListView {

    private val mAdapter = HeroAdapter()

    @InjectPresenter
    lateinit var heroListPresenter: HeroListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()

        heroListPresenter.fetchHeroes()
    }

    private fun setupAdapter(){
        val layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL, false)
        recyclerHeroList.layoutManager = layoutManager
        recyclerHeroList.adapter = mAdapter

    }
    //View implementation
    override fun presentHeroes(data: List<Hero>) {
        recyclerHeroList.visibility = View.VISIBLE
        tvHeroListLoading.visibility = View.GONE

        mAdapter.setData(newHeroes = data)
    }

    override fun presentLoading() {
        recyclerHeroList.visibility = View.GONE
        tvHeroListLoading.visibility = View.VISIBLE
    }

}
