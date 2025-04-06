package net.kaupenjoe.tutorialmod.item;

import com.google.common.base.Suppliers;
import net.kaupenjoe.tutorialmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {
    PINK_GARNET(ModTags.Blocks.INCORRECT_FOR_PINK_GARNET_TOOL,
            1200, 5.0F, 4.0F, 22, () -> Ingredient.ofItems(ModItems.PINK_GARNET)),

    COPPER(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL,
            160, 5.0F, 1.0F, 10, () -> Ingredient.ofItems(Items.COPPER_INGOT)),

    TIN(ModTags.Blocks.INCORRECT_FOR_TIN_TOOL,
            60, 5.0F, 1.0F, 8, () -> Ingredient.ofItems(ModItems.TIN_INGOT)),

    BRONZE(ModTags.Blocks.INCORRECT_FOR_BRONZE_TOOL,
            200, 5.5F, 1.5F, 12, () -> Ingredient.ofItems(ModItems.BRONZE_INGOT));


    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(final TagKey<Block> inverseTag, final int itemDurability,final float miningSpeed,
                             final float attackDamage, final int enchantability,final Supplier<Ingredient> repairIngredient) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
