package hexagonnico.hotchocolate.registry;

import hexagonnico.hotchocolate.HotChocolate;
import hexagonnico.hotchocolate.content.item.ChocolateMilkItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
	
	public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, HotChocolate.ID);

	public static final RegistryObject<Item> CHOCOLATE_MILK = REGISTER.register("chocolate_milk", () -> new ChocolateMilkItem(new Item.Properties().food(ChocolateMilkItem.FOOD_PROPERTIES).craftRemainder(Items.BUCKET).stacksTo(1).tab(CreativeModeTab.TAB_MISC)));
}
