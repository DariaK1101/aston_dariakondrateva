
public class Main {
    public static void main(String[] args) {
        Bowl bowl = new Bowl(5);

        Cat cat1 = new Cat("Снежок");
        Cat cat2 = new Cat("Рыжик");

        Dog dog1 = new Dog("Стрелка");
        Dog dog2 = new Dog("Шарик");

        cat1.run(173);
        cat2.run(150);
        dog1.run(380);
        dog2.run(420);

        cat1.swim(2);
        cat2.swim(5);
        dog1.swim(6);
        dog2.swim(9);

        cat1.eat(bowl);
        cat2.eat(bowl);

        // для добавления еды:
        bowl.addFood(20);

        cat1.eat(bowl);
        cat2.eat(bowl);


        System.out.println("\nСнежок сыт: " + cat1.isFull);
        System.out.println("Рыжик сыт: " + cat2.isFull);
        System.out.println("Остаток еды в миске: " + bowl.getFoodAmount() + " единиц.");


        System.out.println("\nВсего животных: " + Animal.countAnimals);
        System.out.println("Всего собак: " + Dog.countDogs);
        System.out.println("Всего котов: " + Cat.countCats);
    }
}