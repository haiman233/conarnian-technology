package me.jnsbndgz.slimefunaddon;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

public class MyFirstSlimefunAddon extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        Config cfg = new Config(this);

        NamespacedKey categoryId = new NamespacedKey(this, "barbarian_technology");
        CustomItemStack categoryItem = new CustomItemStack(Material.LEATHER_CHESTPLATE, "&4Barbarian Technology");

        ItemGroup itemGroup = new ItemGroup(categoryId, categoryItem);
        SlimefunItemStack itemStack = new SlimefunItemStack("FIERY_AXE", Material.STONE_AXE, "&4Fiery Axe",
                "", "&cTurns your opponent", "&con fire!");
        ItemStack[] recipe = {
                null,                                   new ItemStack(Material.BLAZE_POWDER),   null,
                new ItemStack(Material.BLAZE_POWDER),   new ItemStack(Material.STONE_AXE),      new ItemStack(Material.BLAZE_POWDER),
                null,                                   new ItemStack(Material.BLAZE_POWDER),   null
        };

        SlimefunItem sfItem = new SlimefunItem(itemGroup, itemStack, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);

        sfItem.register(this);
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

}
