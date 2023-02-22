package TEST;

public class RiverT {
    // State
    private int size = 0;
    private DoubListT<AnimalT> animals;

    // Constructors
    public RiverT(int n) {
        animals = new DoubListT<AnimalT>();
        size = n;
    }

    // Methods
    public int getSize() { return size; }

    public void initialize(AnimalT b, AnimalT f) {
        animals.addFirst(b);
        animals.addFirst(f);
    }

    public void iterate(RiverT a) {}

    public void createNew(String a) {}

    public void addAnimal() {}

    public void removeAnimal() {}

    public String summary(int s) { return null; }

    public String toString() {
        String r = "River: \n";
        r += "size = " + animals.size();
        r += "\n";

//        SingListT.Node<AnimalT> walk = animals.head;
//        if (walk == null) { r+= "empty list\n"; }
//        for (int i = 0; i < animals.getSize(); i++) {
//            r += walk.getElement().getSpecies() + "\n";
//            walk = walk.getNext();
//        }

        DoubListT.Node<AnimalT> walk = animals.header;
        System.out.println(walk);
        System.out.println(walk.getElement());
        walk = walk.getNext();
        System.out.println(walk);
        System.out.println(walk.getElement());
        System.out.println(walk.getElement().getSpecies());
        System.out.println();

        walk = animals.header.getNext();
        int num = 1;
        r += "Start of List Loop\n";
        for (int i = 0; i < animals.size(); i++) {
            r += num + ". " + walk.getElement().getSpecies() + "\n";
            walk = walk.getNext();
            num ++;
        }
        r += "End of List\n";
        return r;
    }


    // MAIN -------------------------------------------------------
    public static void main(String[] args) {

        RiverT portneuf = new RiverT(20); // Doubly Linked List
        AnimalT bear = new AnimalT("bear");
        AnimalT fish = new AnimalT("fish");
        AnimalT cat = new AnimalT("cat");


        portneuf.animals.addFirst(fish);
        portneuf.initialize(cat, bear);
        System.out.println(portneuf);
    }

}
