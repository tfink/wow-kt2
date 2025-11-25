package de.torstenfink.wow.domain

import org.springframework.stereotype.Service
import java.io.File

@Service
class AddonImportService {
    fun loadFile(fileName: String): String {
        return File(fileName).readText()
    }

    fun convertToJson(lua: String): String {
        var content = lua.trim()

        content = content.replaceFirst("HurtsSaved = {", "{")

        val keyRegex = """\[(.*)] =""".toRegex()
        content = content.replace(keyRegex, "$1:")

        val trailingComma = """,\s*}""".toRegex()
        content = trailingComma.replace(content, "}")

        return content
    }

    fun convertToDtos(json: String): String {
        return ""
    }
}