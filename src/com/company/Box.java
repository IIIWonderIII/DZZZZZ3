package com.company;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {

    private final List<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public void addFruits(List<T> fruits) {
        this.fruits.addAll(fruits);
    }

    public double getWeight() {
        return fruits.stream().mapToDouble(Fruit::getWeight).sum();
    }

    public Box<T> pourFruitsToBox(Box<T> box) {
        box.addFruits(fruits);
        fruits.clear();

        return box;
    }

    public void swapFruitsInBox(int firstIndex, int secondIndex) {
        T temp = fruits.get(secondIndex);
        fruits.set(secondIndex, fruits.get(firstIndex));
        fruits.set(firstIndex, temp);
    }

    public boolean compare(Box<? extends Fruit> box) {
        return getWeight() == box.getWeight();
    }

}
