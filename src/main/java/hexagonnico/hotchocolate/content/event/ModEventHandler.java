package hexagonnico.hotchocolate.content.event;

import hexagonnico.hotchocolate.HotChocolate;
import hexagonnico.hotchocolate.registry.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HotChocolate.ID)
public class ModEventHandler {
	
	@SubscribeEvent
	public static void onItemCrafted(ItemCraftedEvent event) {
		if(event.getCrafting().is(ModItems.CHOCOLATE_MILK.get())) {
			for(int i = 0; i < 9; i++) {
				ItemStack itemStack = event.getInventory().getItem(i);
				if(itemStack.is(Items.MILK_BUCKET)) {
					itemStack.shrink(1);
				}
			}
		}
	}
}
