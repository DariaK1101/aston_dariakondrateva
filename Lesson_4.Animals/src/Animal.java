
class Animal {
    static int countAnimals = 0;
    static int countDogs = 0;
    static int countCats = 0;

    String name;

    public Animal(String name) {
        this.name = name;
        countAnimals++;
    }

    public void run(int distance) {
    }

    public void swim(int distance) {
    }
}