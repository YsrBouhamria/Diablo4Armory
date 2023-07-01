package com.ysr.diablo4armory.common

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.toLowerCase
import com.ysr.diablo4armory.R
import java.util.Locale

object DrawableMapper {

    fun getSpellDrawableFromName(string: String): Int {
        when (string.lowercase(Locale.ROOT).replace(" ", "")) {

            "arclash" -> return R.drawable.arc_lash
            "attack" -> return R.drawable.attack
            "blight" -> return R.drawable.blight
            "blizzard" -> return R.drawable.blizzard
            "bloodhowl" -> return R.drawable.blood_howl
            "bloodmist" -> return R.drawable.blood_mist
            "bloodwave" -> return R.drawable.blood_wave
            "bonespear" -> return R.drawable.bone_spear
            "bonesplinters" -> return R.drawable.bone_splinters
            "bonestorm" -> return R.drawable.bone_storm
            "challengingshout" -> return R.drawable.challenging_shout
            "corpseexplosion" -> return R.drawable.corpse_explosion
            "corpsetendrils" -> return R.drawable.corpse_tendrils
            "cyclonearmor" -> return R.drawable.cyclone_armor
            "darkshroud" -> return R.drawable.dark_shroud
            "deathtrap" -> return R.drawable.death_trap
            "debilitatingroar" -> return R.drawable.debilitating_roar
            "decrepify" -> return R.drawable.decrepify
            "deepfreeze" -> return R.drawable.deep_freeze
            "earthspike" -> return R.drawable.earth_spike
            "earthernbulwark" -> return R.drawable.earthen_bulwark
            "firebolt" -> return R.drawable.fire_bolt
            "fireball" -> return R.drawable.fireball
            "flameshield" -> return R.drawable.flame_shield
            "frostnova" -> return R.drawable.frost_nova
            "golem" -> return R.drawable.golem
            "grizzlyrage" -> return R.drawable.grizzly_rage
            "hammeroftheancients" -> return R.drawable.hammer_of_the_ancients
            "hemorrhage" -> return R.drawable.hemorrhage
            "hurricane" -> return R.drawable.hurricane
            "hydra" -> return R.drawable.hydra
            "icearmor" -> return R.drawable.ice_armor
            "iceblades" -> return R.drawable.ice_blades
            "iceshards" -> return R.drawable.ice_shards
            "inferno" -> return R.drawable.inferno
            "lightningspear" -> return R.drawable.lightning_spear
            "lungingstrike" -> return R.drawable.lunging_strike
            "poisonimbuement" -> return R.drawable.poison_imbuement
            "poisontrap" -> return R.drawable.poison_trap
            "pulverize" -> return R.drawable.pulverize
            "puncture" -> return R.drawable.puncture
            "raiseskeleton" -> return R.drawable.raise_skeleton
            "rallyingcry" -> return R.drawable.rallying_cry
            "shadowstep" -> return R.drawable.shadow_step
            "stormstrike" -> return R.drawable.storm_strike
            "teleport" -> return R.drawable.storm_strike
            "tornado" -> return R.drawable.tornado
            "trample" -> return R.drawable.trample
            "twistingblades" -> return R.drawable.twisting_blades
            "unstablecurrents" -> return R.drawable.unstable_currents
            "warcry" -> return R.drawable.war_cry
            "whirlwind" -> return R.drawable.whirlwind
            "wrathofthebereserker" -> return R.drawable.wrath_of_the_berserker

        }

        return R.drawable.teleport
    }

    fun getClassDrawableFromName(string: String): Int {
        when (string.lowercase(Locale.ROOT).replace(" ", "")) {
            "sorcerer" -> return R.drawable.sorcerer
            "barbarian" -> return R.drawable.barbarian
            "druid" -> return R.drawable.druid
            "necromancer" -> return R.drawable.necromancer
            "rogue" -> return R.drawable.rogue
            else -> return R.drawable.sorcerer
        }
        return R.drawable.sorcerer
    }
}