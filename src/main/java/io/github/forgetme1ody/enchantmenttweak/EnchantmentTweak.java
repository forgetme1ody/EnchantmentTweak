package io.github.forgetme1ody.enchantmenttweak;

import com.mojang.logging.LogUtils;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.slf4j.Logger;

@Mod(EnchantmentTweak.MODID)
public class EnchantmentTweak {
    public static final String MODID = "enchantmenttweak";
    public static final Logger LOGGER = LogUtils.getLogger();

    public EnchantmentTweak(IEventBus modEventBus, ModContainer modContainer) {
        NeoForge.EVENT_BUS.addListener(EnchantmentTweak::featherFallingProtectFarmland);
    }

    private static void featherFallingProtectFarmland(BlockEvent.FarmlandTrampleEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof LivingEntity livingEntity) {
            Holder.Reference<Enchantment> enchantment = entity.level().registryAccess().getOrThrow(Enchantments.FEATHER_FALLING);
            int level = EnchantmentHelper.getEnchantmentLevel(enchantment, livingEntity);
            if (level > 0) {
                event.setCanceled(true);
            }
        }
    }

}
