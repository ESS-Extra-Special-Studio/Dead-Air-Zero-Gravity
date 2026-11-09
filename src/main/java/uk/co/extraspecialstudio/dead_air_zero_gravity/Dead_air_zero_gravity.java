package uk.co.extraspecialstudio.dead_air_zero_gravity;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.slf4j.Logger;

import java.util.List;

@Mod(Dead_air_zero_gravity.MODID)
public class Dead_air_zero_gravity {
    public static final String MODID = "dead_air_zero_gravity";
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final List<String> TRACK_SLUGS = List.of(
        "after_the_noise",
        "aftermath",
        "better_than_a_battle",
        "blackhole_finale",
        "blackhole",
        "blame_it_on_gravity",
        "burn_for_me",
        "closer_than_we_should_be",
        "crash_and_collide",
        "crossfire",
        "crown_me",
        "dead_signal",
        "don_t_look_at_me_like_that",
        "falling_in",
        "found_you",
        "glass_between_us",
        "gravity_rising",
        "gravity_wins",
        "hit_the_lights",
        "mercy_on_me",
        "middle_of_the_war",
        "midnight_tango",
        "new_crown",
        "not_your_maybe",
        "pick_a_side",
        "say_it_out_loud",
        "still_here",
        "the_heart_comes_home",
        "too_close_to_back_down",
        "waiting_for_my_turn",
        "we_learned_how_to_float",
        "which_one",
        "you_stayed"
    );

    public Dead_air_zero_gravity(IEventBus modEventBus) {
        modEventBus.addListener(this::onRegister);
    }

    private void onRegister(RegisterEvent event) {
        event.register(Registries.SOUND_EVENT, registry -> {
            for (String slug : TRACK_SLUGS) {
                ResourceLocation id = new ResourceLocation(MODID, "music." + slug);
                registry.register(id, SoundEvent.createVariableRangeEvent(id));
            }
        });
        LOGGER.info("[Zero Gravity] Registered {} tracks.", TRACK_SLUGS.size());
    }
}
