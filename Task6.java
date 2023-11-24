/*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Cоздать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии)
фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
“Введите цифру, соответствующую необходимому критерию:
        1 - ОЗУ
        2 - Объем ЖД
        3 - Операционная система
        4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры
фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

 */

import java.util.*;

public class Task6 {
    public static void main(String[] args) {

        Set<Laptop> laptopS = getSetLap();

        System.out.println("Cписок всех ноутбуков:");
        for (Laptop laptop : laptopS) {
            System.out.println(laptop);
        }
        System.out.println("****************************************************************");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            Map<String, Object> map = new HashMap<>();
            System.out.println("Далее Вам необходимо ввести параметры для фильтра. Если Вы не хотите вводить определенный параметр, оставьте поле пустым и нажмите Enter)");
            System.out.println("Если в списке нет ноутбуков, удовлетворяющих введенным параметрам,то выведется весь список");
            System.out.print("Объем ОЗУ(RAM): ");
            String inputram = scanner.nextLine();
            if (!inputram.isEmpty()) {
                map.put("ram", Integer.parseInt(inputram));
            }

            System.out.print("Объем жесткого диска: ");
            String hdInput = scanner.nextLine();
            if (!hdInput.isEmpty()) {
                map.put("hd", Integer.parseInt(hdInput));
            }

            System.out.print("Операционная система: ");
            String OsInput = scanner.nextLine();
            if (!OsInput.isEmpty()) {
                map.put("os", OsInput);
            }

            System.out.print("Цвет: ");
            String colorInput = scanner.nextLine();
            if (!colorInput.isEmpty()) {
                map.put("color", colorInput);
            }

            System.out.println("Результаты: ");
            filterLaptops(map, laptopS);

            System.out.println();
        }

    }

    private static Set<Laptop> getSetLap() {
        Laptop laptop1 = new Laptop("Digma", 8, 256, "Linux", "зеленый");
        Laptop laptop2 = new Laptop("Apple", 32, 512, "macOS", "оранжевый");
        Laptop laptop3 = new Laptop("HP", 32, 512, "Windows", "голубой");
        Laptop laptop4 = new Laptop("Huawei", 16, 512, "Windows", "серый");
        Laptop laptop5 = new Laptop("MegaBook", 32, 512, "Linux", "черный");

        Set<Laptop> laptopSet = Set.of(laptop1, laptop2, laptop3, laptop4, laptop5);
        return laptopSet;
    }

    private static void filterLaptops(Map<String, Object> filters, Set<Laptop> laptopSet) {
        for (Laptop laptop : laptopSet) {
            boolean filter = true;

            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                switch (entry.getKey()) {

                    case "ram":
                        if (laptop.getRam() < (int) entry.getValue()) {
                            filter = false;
                        }
                        break;
                    case "hd":
                        if (laptop.getHd() < (int) entry.getValue()) {
                            filter = false;
                        }
                        break;
                    case "os":
                        if (!laptop.getOs().equalsIgnoreCase((String) entry.getValue())) {
                            filter = false;
                        }
                        break;
                    case "color":
                        if (!laptop.getColor().equalsIgnoreCase((String) entry.getValue())) {
                            filter = false;
                        }
                        break;

                }
            }

            if (filter) {
                System.out.println(laptop);
            }
        }
        System.out.println("--------------------------------------------------");
        System.out.println();
    }



}
