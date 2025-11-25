package de.torstenfink.wow.domain

@JvmInline
value class Copper(val copper: Long)
{
    init {
        require(copper >= 0) {"Copper must be greater than or equal to 0"}
    }

    override fun toString(): String {
        return copper.toString() + "g"
    }
}