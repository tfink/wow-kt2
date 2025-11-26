package de.torstenfink.wow.domain

import de.torstenfink.wow.domain.bnet.CharacterProfessions
import de.torstenfink.wow.domain.bnet.GuildRoster

interface BNetClient {
    fun guildRoster(realmSlug: String, nameSlug: String): GuildRoster
    fun characterProfessions(realmSlug: String, characterName: String): CharacterProfessions
}