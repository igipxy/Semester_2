import java.util.Scanner;

// 1. BUYER CLASS
class Buyer {
    String name;
    String phoneNumber;

    public Buyer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}

// 2. ORDER CLASS
class Order {
    int orderCode;
    String orderName;
    int price;

    public Order(int orderCode, String orderName, int price) {
        this.orderCode = orderCode;
        this.orderName = orderName;
        this.price = price;
    }
}

// 3. NODE FOR QUEUE (Double Linked List)
class QueueNode {
    int queueNumber;
    Buyer buyer;
    QueueNode prev, next;

    public QueueNode(int queueNumber, Buyer buyer) {
        this.queueNumber = queueNumber;
        this.buyer = buyer;
    }
}

// 4. NODE FOR ORDERS (Double Linked List)
class OrderNode {
    Order order;
    OrderNode prev, next;

    public OrderNode(Order order) {
        this.order = order;
    }
}

class QueueDLL {
    QueueNode head, tail;
    int size = 0;
    int currentQueueNumber = 1;

    public void addQueue(Buyer b) {
        QueueNode newNode = new QueueNode(currentQueueNumber++, b);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        System.out.println("Queue has been successfully added with number: " + newNode.queueNumber);
    }

    public void printQueue() {
        System.out.println("\n===== QUEUE LIST =====");
        QueueNode current = head;
        while (current != null) {
            System.out.println("Queue Number : " + current.queueNumber);
            System.out.println("Buyer Name   : " + current.buyer.name);
            System.out.println("Phone Number : " + current.buyer.phoneNumber);
            System.out.println("--------------------------------------");
            current = current.next;
        }
        System.out.println("Total Queue: " + size + "\n");
    }


    public QueueNode dequeue() {
        if (head == null) {
            return null;
        }
        QueueNode served = head;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return served;
    }

    
    public boolean cancelQueue(int queueNumber) {
        if (head == null) return false;

        QueueNode current = head;
        while (current != null && current.queueNumber != queueNumber) {
            current = current.next;
        }

        if (current == null) return false; 

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }

        size--;
        return true;
    }
}


// 6. ORDER DOUBLE LINKED LIST SYSTEM
class OrderDLL {
    OrderNode head, tail;

    public void addOrder(Order o) {
        OrderNode newNode = new OrderNode(o);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Manual Bubble Sort by Order Name (Alphabetical)
    public void sortOrdersByName() {
        if (head == null || head.next == null) return;
        
        boolean swapped;
        do {
            swapped = false;
            OrderNode current = head;
            
            while (current.next != null) {
                // If current order name is alphabetically greater than the next one, swap them
                if (current.order.orderName.compareToIgnoreCase(current.next.order.orderName) > 0) {
                    // Swapping the data (the Order object) instead of the Node links is much easier and safer
                    Order temp = current.order;
                    current.order = current.next.order;
                    current.next.order = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public void printOrderReport() {
        sortOrdersByName(); // Sort before printing
        
        System.out.println("==================================================");
        System.out.println("ORDER REPORT (SORTED BY ORDER NAME)");
        System.out.println("==================================================");
        System.out.printf("%-15s %-25s %s\n", "Order Code", "Order Name", "Price");

        OrderNode current = head;
        int totalRevenue = 0;
        
        while (current != null) {
            System.out.printf("%-15d %-25s %d\n", current.order.orderCode, current.order.orderName, current.order.price);
            totalRevenue += current.order.price;
            current = current.next;
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Total Revenue : Rp " + totalRevenue + "\n");
    }
}

// 7. MAIN CLASS (Driver / UI)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueDLL queue = new QueueDLL();
        OrderDLL orders = new OrderDLL();
        int choice;

        do {
            System.out.println("======================================");
            System.out.println("ROYAL DELISH QUEUE SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add Queue");
            System.out.println("2. Print Queue");
            System.out.println("3. Remove Queue and Order");
            System.out.println("4. Order Report");
            System.out.println("5. Cancel Queue");
            System.out.println("0. Exit");
            System.out.print("Choose menu : ");
            choice = sc.nextInt();
            sc.nextLine(); // Clear the newline character from buffer

            switch (choice) {
                case 1:
                    System.out.print("Buyer Name     : ");
                    String name = sc.nextLine();
                    System.out.print("Phone Number   : ");
                    String phone = sc.nextLine();
                    
                    Buyer b = new Buyer(name, phone);
                    queue.addQueue(b);
                    break;
                    
                case 2:
                    queue.printQueue();
                    break;
                    
                case 3:
                    QueueNode served = queue.dequeue();
                    if (served != null) {
                        System.out.println("\nServed Buyer:");
                        System.out.println("Queue Number : " + served.queueNumber);
                        System.out.println("Buyer Name   : " + served.buyer.name);
                        System.out.println("Phone Number : " + served.buyer.phoneNumber);
                        System.out.println("--------------------------------------");
                        
                        System.out.print("Order Code   : ");
                        int code = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Order Name   : ");
                        String orderName = sc.nextLine();
                        System.out.print("Price        : ");
                        int price = sc.nextInt();
                        sc.nextLine();

                        Order o = new Order(code, orderName, price);
                        orders.addOrder(o);
                        System.out.println("Order has been successfully added.\n");
                    } else {
                        System.out.println("The queue is currently empty!\n");
                    }
                    break;
                    
                case 4:
                    orders.printOrderReport();
                    break;

                case 5:
                    System.out.print("Enter queue number to cancel: ");
                    int cancelNumber = sc.nextInt();
                    sc.nextLine();

                    boolean canceled = queue.cancelQueue(cancelNumber);
                    if (canceled) {
                        System.out.println("Queue number " + cancelNumber + " has been canceled successfully.\n");
                    } else {
                        System.out.println("Queue number " + cancelNumber + " not found.\n");
                    }
                    break;

                case 0:
                    System.out.println("Exiting system...");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        
        sc.close();
    }
}