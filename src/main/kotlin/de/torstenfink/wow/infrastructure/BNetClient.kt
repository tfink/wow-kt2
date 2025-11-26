package de.torstenfink.wow.infrastructure

import de.torstenfink.wow.domain.BNetClient
import de.torstenfink.wow.domain.bnet.CharacterProfessions
import de.torstenfink.wow.domain.bnet.GuildRoster
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class BNetClient(
    private val restClient: RestClient,
): BNetClient {
    override fun guildRoster(
        realmSlug: String,
        nameSlug: String
    ): GuildRoster {
        return restClient.get().uri("/data/wow/guild/$realmSlug/$nameSlug/roster?namespace={namespace}&locale={locale}")
            .retrieve()
            .body(GuildRoster::class.java)!!
    }

    override fun characterProfessions(
        realmSlug: String,
        characterName: String
    ): CharacterProfessions {
        return restClient.get().uri("/profile/wow/character/$realmSlug/$characterName/professions?namespace={namespace}&locale={locale}")
            .retrieve()
            .body(CharacterProfessions::class.java)!!
    }
}