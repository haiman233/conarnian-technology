package me.jnsbndgz.myfirstslimefunaddon;

import me.jnsbndgz.myfirstslimefunaddon.machines.ElectricFlintRecycler;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

public class MyFirstSlimefunAddon extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        NamespacedKey categoryId = new NamespacedKey(this, "barbarian_technology");
        CustomItemStack categoryItem = new CustomItemStack(Material.WOODEN_AXE, "&4Barbarian Technology");

        ItemGroup itemGroup = new ItemGroup(categoryId, categoryItem);

        // Fiery Axe
        SlimefunItemStack FieryAxeItemStack = new SlimefunItemStack("FIERY_AXE", Material.STONE_AXE, "&4Fiery Axe",
                "", "&cTurns your opponent", "&con fire!");
        ItemStack[] recipe = {
                null,                                   new ItemStack(Material.BLAZE_POWDER),   null,
                new ItemStack(Material.BLAZE_POWDER),   new ItemStack(Material.STONE_AXE),      new ItemStack(Material.BLAZE_POWDER),
                null,                                   new ItemStack(Material.BLAZE_POWDER),   null
        };
        FieryAxe fieryAxe = new FieryAxe(itemGroup, FieryAxeItemStack, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);

        // Fire Cake
        SlimefunItemStack fieryCakeItemStack = new SlimefunItemStack("FIRE_CAKE", Material.CAKE, "&cFire Cake",
                "", "&cTurns you on fire!");
        ItemStack[] fieryCakeRecipe = {
                new ItemStack(Material.DIAMOND),    null,                               new ItemStack(Material.DIAMOND),
                null,                               SlimefunItems.CARBONADO,            null,
                new ItemStack(Material.DIAMOND),    null,                               new ItemStack(Material.DIAMOND)
        };
        FireCake fireCake = new FireCake(itemGroup, fieryCakeItemStack, RecipeType.ENHANCED_CRAFTING_TABLE, fieryCakeRecipe);

        // Electric Dust Recycler
        SlimefunItemStack electricFlintRecyclerItemStack = new SlimefunItemStack("ELECTRIC_FLINT_RECYCLER", Material.FURNACE, "&eElectric Flint Recycler",
                "", "&c Turns flint into cobblestone");
        ItemStack[] electricFlintRecyclerRecipe = {
                null,                               new ItemStack(Material.PISTON),    null,
                new ItemStack(Material.PISTON),     new ItemStack(Material.FURNACE),   new ItemStack(Material.PISTON),
                null,                               new ItemStack(Material.PISTON),    null
        };
        ElectricFlintRecycler eFlintRecycler = new ElectricFlintRecycler(itemGroup, electricFlintRecyclerItemStack, RecipeType.ENHANCED_CRAFTING_TABLE, electricFlintRecyclerRecipe);

        // Registers
        fieryAxe.register(this);
        fireCake.register(this);
        eFlintRecycler.register(this);
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return "https://github.com/jnsbndgz/my-first-slimefun-addon/issues";
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
