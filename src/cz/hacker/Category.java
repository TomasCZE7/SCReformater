package cz.hacker;

import java.util.ArrayList;
import java.util.Collections;

public class Category {

    private ArrayList<Item> items = new ArrayList<>();
    private String name;

    public Category(String name){
        this.name = name;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public Item getIncompleteItem(){
        for (Item item : items){
            if(item.getPrice() == -1)
                return item;
            if(item.getMaterialName() == null || item.getMaterialName().isEmpty())
                return item;
        }
        return null;
    }

    public void destroyBlankItems(){
        while(getIncompleteItem() != null){
            items.remove(getIncompleteItem());
        }
    }

    public void sort(){
        Collections.sort(items, new SortComparator());
    }

    public String getName() {
        return name;
    }

}
