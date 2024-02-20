package com.example.examplemod;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;


import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

    public static final RegistryObject<Item> BACON_ITEM =
            ITEMS.register("bacon_item", () -> new Item(new Item.Properties()
                    .tab(CreativeModeTab.TAB_FOOD)
                    .food(new FoodProperties.Builder()
                            .alwaysEat()
                            .fast()
                            // Glowing effect for 200gt as level 0 (100% chance of occurring)
                            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 200, 0), 1.0F)
                            .build())));

    public static void register(IEventBus bus)
    {
        ITEMS.register(bus);
    }
}