package ru.nvg_soft.counterpick.adapters

import android.view.View
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.nvg_soft.counterpick.R
import ru.nvg_soft.counterpick.models.Hero
import java.util.*

class HeroAdapter: RecyclerView.Adapter<HeroAdapter.ViewHolder>() {
    private var mHeroList: MutableList<Hero> = LinkedList()

    fun setData(newHeroes: List<Hero>){
        mHeroList.clear()
        mHeroList.addAll(newHeroes)

        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.cell_hero,viewGroup,false))
    }

    override fun getItemCount(): Int {
        return mHeroList.count()
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(mHeroList[position])

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(model: Hero){

        }
    }
}