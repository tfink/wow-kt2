package de.torstenfink.wow.domain.addonImport

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown=true)
data class AddonData(
    val version: UInt,
    val characters: HashMap<String, Character>
)

@JsonIgnoreProperties(ignoreUnknown=true)
data class Character(
    val name: String,
    val realm: String,
    val region: String,
    val copper: Long,
    @JsonProperty(value = "class")
    val characterClass: Int,
    @JsonProperty(value = "hearthstone_location")
    val hearthstoneLocation: String,
    @JsonProperty(value = "last_update")
    val lastUpdate: Long,
    @JsonProperty(value = "item_level")
    val itemLevel: ItemLevel,
    val level: Int,
    val xp: Xp,
)

@JsonIgnoreProperties(ignoreUnknown=true)
data class ItemLevel(
    val max: Float,
    val equipped: Float,
    val pvp: Float,
)

@JsonIgnoreProperties(ignoreUnknown=true)
data class Xp(
    val max: Long,
    val current: Long,
    @JsonProperty(value = "is_resting")
    val isResting: Boolean,
    val rested: Long,
)