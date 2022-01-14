package me.jnsbndgz.conarniantechnology;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockUseHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;

import org.bukkit.inventory.ItemStack;

public class FireCake extends SlimefunItem {

    public FireCake(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        addItemHandler(onBlockRightClick());
        addItemHandler(onItemUseRightClick());
    }

    private BlockUseHandler onBlockRightClick() {
        return new BlockUseHandler() {
            @Override
            public void onRightClick(PlayerRightClickEvent event) {
                event.cancel();
                event.getPlayer().setFireTicks(5 * 20);
            }
        };
    }

    private ItemUseHandler onItemUseRightClick() {
        return new ItemUseHandler() {
            @Override
            public void onRightClick(PlayerRightClickEvent event) {
                event.getPlayer().giveExpLevels(5);
            }
        };
    }
}
