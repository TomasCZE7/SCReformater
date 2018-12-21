package cz.hacker;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ConfigMain {


    public static void main(String[] args) throws IOException
    {
        File file = new File("shops.txt");
        file.createNewFile();
        Scanner sc = new Scanner(file);

        ArrayList<Category> categories = new ArrayList<>();

        while(sc.hasNextLine()){
            String s = sc.nextLine();
            if (s.charAt(2) != ' ' && s.charAt(0) == ' ')
            {
                Category category = new Category(s.substring(2).replace(":", ""));
                category.addItem(new Item());
                categories.add(category);
                continue;
            }
            if(categories.size() == 0){
                continue;
            }
            Item item = categories.get(categories.size()-1).getIncompleteItem();
            if (s.contains("material") && !s.contains("materialy"))
            {
                item.setMaterialName(s.substring(s.indexOf(": ")+2));
            }
            else if (s.contains("buyPrice")) {
                int price;
                try {
                    price = Integer.parseInt(s.substring(s.indexOf(": ") + 2));
                } catch (NumberFormatException ex){
                    price = 0;
                }
                item.setPrice(price);
                categories.get(categories.size()-1).addItem(new Item());
            }
        }
        for (Category category : categories){
            category.destroyBlankItems();
            category.sort();
        }

        BufferedWriter w = new BufferedWriter(new FileWriter("config.txt"));
        w.write("items: \n");

        int i = 0;
        for (Category category : categories){
            for (Item item : category.getItems()){
                w.write("    item" + i + ": \n");
                w.write("        material: " + item.getMaterialName() + "\n");
                w.write("        category: " + category.getName() + "\n");
                w.write("        buy: " + item.getPrice() + "\n");
                i++;
            }
        }
    }
}