package ru.nvg_soft.counterpick.adapters

import android.view.View
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import ru.nvg_soft.counterpick.R
import ru.nvg_soft.domain.models.Hero
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
        private val tvHeroTitle:TextView = itemView.findViewById(R.id.tvHeroTitle)
        private val tvHeroAttackType:TextView = itemView.findViewById(R.id.tvHeroAttackType)
        private val ivAvatar: ImageView = itemView.findViewById(R.id.ivAvatar)

        fun bind(model: Hero){
            tvHeroTitle.text = model.title

            if (model.attackType == 0){
                tvHeroAttackType.text = itemView.context.getString(R.string.attack_type_melee)
            }else{
                tvHeroAttackType.text = itemView.context.getString(R.string.attack_type_ranged)
            }

        }
    }
}