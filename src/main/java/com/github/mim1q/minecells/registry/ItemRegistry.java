package com.github.mim1q.minecells.registry;

import com.github.mim1q.minecells.MineCells;
import com.github.mim1q.minecells.item.AssassinsDaggerItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;

import java.util.HashSet;
import java.util.Set;

public class ItemRegistry {

  private static final Set<Item> simpleItems = new HashSet<>();

  public static final Item ELEVATOR_MECHANISM = new Item(new FabricItemSettings().group(ItemGroupRegistry.MINECELLS_BLOCKS_AND_ITEMS));
  public static final BucketItem SEWAGE_BUCKET = new BucketItem(FluidRegistry.STILL_SEWAGE, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1));
  public static final BucketItem ANCIENT_SEWAGE_BUCKET = new BucketItem(FluidRegistry.STILL_ANCIENT_SEWAGE, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1));

  public static final AssassinsDaggerItem ASSASSINS_DAGGER = new AssassinsDaggerItem(new FabricItemSettings()
    .group(ItemGroupRegistry.MINECELLS_WEAPONS)
    .maxDamage(1200));

  public static void register() {
    registerSimpleItem("elevator_mechanism", ELEVATOR_MECHANISM);
    registerSimpleItem("sewage_bucket", SEWAGE_BUCKET);
    registerSimpleItem("ancient_sewage_bucket", ANCIENT_SEWAGE_BUCKET);

    Registry.register(Registry.ITEM, MineCells.createId("assassins_dagger"), ASSASSINS_DAGGER);
  }

  public static void registerSimpleItem(String name, Item item) {
    Registry.register(Registry.ITEM, MineCells.createId(name), item);
    simpleItems.add(item);
  }

  public static Set<Item> getSimpleItems() {
    return simpleItems;
  }
}
