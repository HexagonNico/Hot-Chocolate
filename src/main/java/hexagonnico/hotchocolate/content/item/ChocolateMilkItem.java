package hexagonnico.hotchocolate.content.item;

import java.util.List;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper;

public class ChocolateMilkItem extends Item {

	public ChocolateMilkItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity entity) {
		List<MobEffect> curableEffects = entity.getActiveEffects().stream()
				.filter(effect -> effect.isCurativeItem(new ItemStack(Items.MILK_BUCKET)))
				.map(MobEffectInstance::getEffect)
				.toList();
		curableEffects.forEach(entity::removeEffect);
		if(this.isEdible()) entity.eat(level, itemStack);
		if(entity instanceof Player player && !player.getAbilities().instabuild)
			itemStack.shrink(1);
		return itemStack.isEmpty() ? new ItemStack(Items.BUCKET) : itemStack;
	}

	@Override
	public int getUseDuration(ItemStack itemStack) {
		return 32;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemStack) {
		return UseAnim.DRINK;
	}

	@Override
	public SoundEvent getEatingSound() {
		return SoundEvents.GENERIC_DRINK;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		return ItemUtils.startUsingInstantly(level, player, hand);
	}

	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, CompoundTag nbt) {
		return new FluidBucketWrapper(stack);
	}
}
