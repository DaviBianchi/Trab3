

public class Main {
    public static void main(String[] args) {
        DoubleChainedList list = new DoubleChainedList(10);
        list.add("Adrian");list.add("Davi");list.add("Claudio");list.add("Moze");list.add("Edward");list.add("TAco");list.add("Ana");list.add("gabre");list.add("Fer");list.add("Linda");
        System.out.println("\nSize: " + list.getSize() + "\n\nPrint List || "+ list + "|| FULL? " + list.isFull());
        list.remove(1);
        System.out.println("\nPrint List || " + list + "|| EMPTY? " + list.isEmpty());
        System.out.println("\nFirst " + list.get(1));
        list.cleanList();
        System.out.println("" + list);


    }
}
