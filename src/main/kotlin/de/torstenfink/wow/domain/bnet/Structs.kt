package de.torstenfink.wow.domain.bnet

import com.fasterxml.jackson.annotation.JsonProperty

data class Faction(val type: String, val name: String)
data class Guild(val name: String, val id: Int, val realm: Realm, val faction: Faction)
data class GuildRoster(val guild: Guild, val members: List<GuildMember>)
data class GuildMember(val character: Character)
data class Character(val name: String, val realm: Realm, val level: Int)
data class Realm(val id: Int, val slug: String)

data class CharacterProfessions(val primaries: List<PrimaryProfession>)
data class PrimaryProfession(val profession: Profession, val tiers: List<Tier>)
data class Profession(val id: Int, val name: String)

data class Tier(
    @JsonProperty("tier") val innerTier: InnerTier,
)
data class InnerTier(val id: Int, val name: String)
