/*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. 
Критерии фильтрации можно хранить в Map. Например:
        “Введите цифру, соответствующую необходимому критерию:
        1 - ОЗУ
        2 - Объем ЖД
        3 - Операционная система
        4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры
фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
*/


public class Laptop {

    private String name;
    private int ram;
    private int hd;
    private String os;
    private String color;

    public Laptop(String name, int ram, int hd, String os, String color) {
        this.name = name;
        this.ram = ram;
        this.hd = hd;
        this.os = os;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getRam() {
        return ram;
    }

    public int getHd() {
        return hd;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("Название: %s, ОЗУ: %s, Объем ЖД: %s, Оперативная система: %s, Цвет: %s ", name, ram, hd, os, color);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Laptop)) {
            return false;
        }
        Laptop laptopS = (Laptop) obj;
        return name.equals(laptopS.name) && ram == laptopS.ram && laptopS.equals(laptopS.hd) && os.equals(laptopS.os) && color.equals(laptopS.color);
    }

}
