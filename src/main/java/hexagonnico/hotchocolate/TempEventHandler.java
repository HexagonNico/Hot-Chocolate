package hexagonnico.hotchocolate;

import net.minecraftforge.event.entity.player.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HotChocolate.ID)
public class TempEventHandler {
	
	@SubscribeEvent
	public static void onItemCrafted(ItemCraftedEvent event) {
		/*ItemStack crafting = event.getCrafting();
		if(crafting.is(Items.CAKE)) {
			for(int i = 0; i < 9; i++) {
				ItemStack item = event.getInventory().getItem(i);
				if(item.is(Items.MILK_BUCKET)) {
					item.shrink(1);
				}
			}
		}*/
	}
}
