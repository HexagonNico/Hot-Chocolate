package hexagonnico.hotchocolate.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public final class ModFood {
	
	public static final FoodProperties CHOCOLATE_MILK = new FoodProperties.Builder().nutrition(4).saturationMod(0.3f).build();
	public static final FoodProperties HOT_CHOCOLATE = new FoodProperties.Builder().nutrition(6).saturationMod(0.5f).effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 2400, 0), 1.0f).build();
}
