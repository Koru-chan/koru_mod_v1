package net.kaupenjoe.tutorialmod.screen;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class OutputSlot extends Slot {
    public OutputSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        // Non si può inserire nulla manualmente in uno slot di output
        return false;
    }

    @Override
    public boolean canTakeItems(net.minecraft.entity.player.PlayerEntity playerEntity) {
        // Puoi prendere l'oggetto, sì!
        return true;
    }

    @Override
    public int getMaxItemCount() {
        return 64; // O puoi mettere 1 se vuoi limitare
    }
}
