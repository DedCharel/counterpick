package ru.nvg_soft.domain.converters

import ru.nvg_soft.data.remote.models.HeroApi
import ru.nvg_soft.domain.models.Hero

class HeroConverterImpl {
    fun fromApiToUI(model:HeroApi):Hero{
        return Hero(id = model.id, title = model.name,
            attackType = if (model.attack_type == "Melee"){
                0} else{1},icon = "")
    }
}