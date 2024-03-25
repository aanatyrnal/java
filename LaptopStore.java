import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LaptopStore {
    private Set<Laptop> laptops;

    public LaptopStore() {
        this.laptops = new HashSet<>();
    }

    public void addLaptop(Laptop laptop) {
        laptops.add(laptop);
    }

    public void filterLaptops(Map<String, String> filters) {
        for (Laptop laptop : laptops) {
            boolean pass = true;
            for (Map.Entry<String, String> entry : filters.entrySet()) {
                String criteria = entry.getKey();
                String value = entry.getValue();
                switch (criteria) {
                    case "RAM":
                        if (!laptop.getRam().equals(value)) {
                            pass = false;
                        }
                        break;
                    case "HDD":
                        if (!laptop.getHdd().equals(value)) {
                            pass = false;
                        }
                        break;
                    case "OS":
                        if (!laptop.getOs().equals(value)) {
                            pass = false;
                        }
                        break;
                    case "Color":
                        if (!laptop.getColor().equals(value)) {
                            pass = false;
                        }
                        break;
                    default:
                        System.out.println("Unknown criteria: " + criteria);
                }
            }
            if (pass) {
                System.out.println(laptop);
            }
        }
    }

    public static void main(String[] args) {
        LaptopStore store = new LaptopStore();

        Laptop laptop1 = new Laptop("8GB", "512GB", "Windows", "Black");
        Laptop laptop2 = new Laptop("16GB", "1TB", "MacOS", "Silver");
        Laptop laptop3 = new Laptop("4GB", "256GB", "Linux", "Red");

        store.addLaptop(laptop1);
        store.addLaptop(laptop2);
        store.addLaptop(laptop3);

        Map<String, String> filters = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter filter criteria:");
        System.out.println("1 - RAM");
        System.out.println("2 - HDD");
        System.out.println("3 - OS");
        System.out.println("4 - Color");

        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter minimum RAM:");
                String minRam = scanner.next();
                filters.put("RAM", minRam);
                break;
            case 2:
                System.out.println("Enter minimum HDD:");
                String minHdd = scanner.next();
                filters.put("HDD", minHdd);
                break;
            case 3:
                System.out.println("Enter OS:");
                String os = scanner.next();
                filters.put("OS", os);
                break;
            case 4:
                System.out.println("Enter color:");
                String color = scanner.next();
                filters.put("Color", color);
                break;
            default:
                System.out.println("Invalid option");
        }

        store.filterLaptops(filters);
    }
}
