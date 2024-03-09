package com.parcial;

public class Inventory {

    ItemShelf[] inventory = null;

    Inventory(int itemCount) {
        inventory = new ItemShelf[itemCount];
        initialEmptyInventory();
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public void initialEmptyInventory() {
        int startCode = 101;
        for (int i = 0; i < inventory.length; i++) {
            ItemShelf space = new ItemShelf();
            space.setCode(startCode++);
            space.setSoldOut(true);
            inventory[i] = space;
        }
    }

    public void addItem(Item item, int codeNumber) throws Exception {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getCode() == codeNumber) {
                if (itemShelf.isSoldOut()) {
                    itemShelf.setItem(item);
                    itemShelf.setSoldOut(false);
                } else {
                    throw new Exception("Already an item is present, you cannot add an item here.");
                }
            }
        }
    }

    public Item getItem(int codeNumber) throws Exception {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getCode() == codeNumber) {
                if (!itemShelf.isSoldOut()) {
                    return itemShelf.getItem();
                } else {
                    throw new Exception("Item already sold out.");
                }
            }
        }
        throw new Exception("Invalid Code.");
    }

    public void updateSoldOutItem(int codeNumber) {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getCode() == codeNumber) {
                itemShelf.setSoldOut(true);
            }
        }
    }

    // Método para mostrar los productos disponibles
    public void displayProducts() {
        System.out.println("Available Products:");
        for (ItemShelf shelf : inventory) {
            if (!shelf.isSoldOut()) {
                System.out.println("Code: " + shelf.getCode() + ", Item: " + shelf.getItem().getType().name()
                        + ", Price: " + shelf.getItem().getPrice());
            }
        }
    }
}
