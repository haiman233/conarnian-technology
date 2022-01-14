package me.jnsbndgz.conarniantechnology;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.WeaponUseHandler;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class FieryAxe extends SlimefunItem {

    public FieryAxe(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        addItemHandler(onWeaponHit());
    }

    private WeaponUseHandler onWeaponHit() {
        return new WeaponUseHandler() {
            @Override
            public void onHit(EntityDamageByEntityEvent event, Player player, ItemStack itemStack) {
                event.getEntity().setFireTicks(5 * 20);
            }
        };
    }
}
