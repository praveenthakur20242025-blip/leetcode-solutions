import java.util.*;

class Item {
    private int id;
    private String name;
    private String brand;
    private int price;

    public Item(int id, String name, String brand, int price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }
}

class Cart {
    private ArrayList<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public boolean addItem(Item i) {
        for (Item item : items) {
            if (item.getId() == i.getId()) {
                return false;
            }
        }

        items.add(i);
        return true;
    }

    public boolean removeItem(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                items.remove(i);
                return true;
            }
        }

        return false;
    }

    public int getCount() {
        return items.size();
    }

    public int getTotalBill() {
        int total = 0;

        for (Item item : items) {
            total += item.getPrice();
        }

        return total;
    }

    public Item getCostliest() {
        if (items.isEmpty()) {
            return null;
        }

        Item costly = items.get(0);

        for (Item item : items) {
            if (item.getPrice() > costly.getPrice()) {
                costly = item;
            }
        }

        return costly;
    }
}

public class hy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cart cart = new Cart();

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            String operation = sc.next();

            if (operation.equals("ADD")) {
                int id = sc.nextInt();
                String name = sc.next();
                String brand = sc.next();
                int price = sc.nextInt();

                Item item = new Item(id, name, brand, price);

                if (!cart.addItem(item)) {
                    System.out.println("Duplicate Item");
                }

            } else if (operation.equals("REMOVE")) {
                int id = sc.nextInt();

                if (!cart.removeItem(id)) {
                    System.out.println("Item Not Found");
                }
            }
        }

        if (cart.getCount() == 0) {
            System.out.println("Cart is Empty");
        } else {
            System.out.println("Total Items: " + cart.getCount());
            System.out.println("Total Bill: " + cart.getTotalBill());
            System.out.println("Costliest Item: " +
                    cart.getCostliest().getName());
        }

        sc.close();
    }
}