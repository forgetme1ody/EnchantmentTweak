package io.github.forgetme1ody.enchantmenttweak;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(EnchantmentTweak.MODID)
public class EnchantmentTweak {
    public static final String MODID = "enchantmenttweak";
    public static final Logger LOGGER = LogUtils.getLogger();

    public EnchantmentTweak(IEventBus modEventBus, ModContainer modContainer) {
    }

    @SubscribeEvent
    public void onBlockFarmlandTrample(BlockEvent.FarmlandTrampleEvent event) {
    }

}
