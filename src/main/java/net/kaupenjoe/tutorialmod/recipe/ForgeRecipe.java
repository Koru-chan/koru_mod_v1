package net.kaupenjoe.tutorialmod.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record ForgeRecipe(Ingredient inputItem1, Ingredient inputItem2, ItemStack output) implements Recipe<ForgeRecipeInput> {
    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem1);
        list.add(this.inputItem2); // Ora supporta due ingredienti
        return list;
    }

    @Override
    public boolean matches(ForgeRecipeInput input, World world) {
        if(world.isClient()) {
            return false;
        }

        // Controllo se uno o entrambi gli slot di input sono validi
        boolean firstMatches = inputItem1.test(input.getStackInSlot(0));
        boolean secondMatches = inputItem2 == null || inputItem2.test(input.getStackInSlot(1));

        return firstMatches && secondMatches;
    }

    @Override
    public ItemStack craft(ForgeRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.FORGE_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.FORGE_TYPE;
    }

    public static class Serializer implements RecipeSerializer<ForgeRecipe> {
        public static final MapCodec<ForgeRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient1").forGetter(ForgeRecipe::inputItem1),
                Ingredient.DISALLOW_EMPTY_CODEC.optionalFieldOf("ingredient2", Ingredient.EMPTY).forGetter(ForgeRecipe::inputItem2),
                ItemStack.CODEC.fieldOf("result").forGetter(ForgeRecipe::output)
        ).apply(inst, ForgeRecipe::new));

        public static final PacketCodec<RegistryByteBuf, ForgeRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, ForgeRecipe::inputItem1,
                        Ingredient.PACKET_CODEC, ForgeRecipe::inputItem2,
                        ItemStack.PACKET_CODEC, ForgeRecipe::output,
                        ForgeRecipe::new);

        @Override
        public MapCodec<ForgeRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, ForgeRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}
