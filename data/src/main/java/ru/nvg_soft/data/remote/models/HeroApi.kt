package ru.nvg_soft.data.remote.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json

@Serializable
data class HeroApi (val id: Int, val name: String, val localized_name: String,
                    val primary_attr: String, val attack_type: String, val roles: List<String>,val legs:Int){
    companion object{
        @UnstableDefault
        fun toObject(strngValue: String):HeroApi {
            return Json.nonstrict.parse(serializer(),strngValue)
        }
    }
}
@UnstableDefault
fun HeroApi.toOJson():String{
    return Json.stringify(HeroApi.serializer(),this)
}