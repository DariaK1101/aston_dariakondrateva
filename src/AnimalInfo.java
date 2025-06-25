//Задание 1.Создать классы Собака и Кот с наследованием от класса Животное.
//Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
// Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
//Добавить подсчет созданных котов, собак и животных.
//Расширить задачу, добавив для котов возможность кушать из миски, выполнив следующие пункты:
//Сделать так, чтобы в миске с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
//Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
//Считаем, что если коту мало еды в миске, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
//Создать массив котов и миску с едой, попросить всех котов покушать из этой миски и потом вывести информацию о сытости котов в консоль.
//Добавить метод, с помощью которого можно было бы добавлять еду в миску
class Animal {
    String breed;
    String name;
    public int run;
    public boolean swim;
    protected static int animalCount = 0;

    public Animal() {
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public String getName() {
        return name;
    }


    public void animalInfo() {
        System.out.println("\nЖивотное: " + breed);
    }
}


class Cat extends Animal {
    int distanceRun = 200;
    private static int catCount = 0;
    private boolean isFull;

    public Cat(String name, int run) {
        this.breed = "Кот";
        this.name = name;
        this.run = run;
        this.swim = false;
        catCount++;
        this.isFull = false;
    }

    public static int getCatCount() {
        return catCount;
    }

    public void catInfo() {

        System.out.println("Кличка кота: " + name + "\nДистанция: " + distanceRun + "м." + "\nПробежал: " + run + "м." + "\nПроплыл:" + swim + " - коты не плавают!");
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.decreaseFood(amount)) {
            this.isFull = true;
            System.out.println("\n" + name + " поел и теперь сыт.");
        } else {
            System.out.println(name + " не смог поесть. Нет еды в миске!");
        }
    }

    public boolean isFull() {
        return isFull;
    }
}

class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int amount) {
        if (amount <= 0) {
            System.out.println("\nКоличество еды должно быть больше нуля!");
            return false;
        }
        if (food >= amount) {
            food -= amount;
            return true;
        }
        System.out.println("\nНе хватает еды в миске. В миске: " + food + " еды.");
        return false;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("\nДобавлено " + amount + " еды в миску");
        } else {
            System.out.println("\nНевозможно добавить 0 еды!");
        }

    }

    public int getFood() {
        return food;
    }
}


class Dog extends Animal {

    public int swim;
    int distanceRun = 500;
    int distanceSwim = 10;
    private static int dogCount = 0;

    public Dog(String name, int run, int swim) {
        this.breed = "Собака";
        this.name = name;
        this.run = run;
        this.swim = swim;
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    public void dogInfo() {
        System.out.println("Кличка собаки: " + name + "\nДистанция бег: " + distanceRun + "м." + "\nПробежал: " + run + "м." + "\nДистанция плавание: " + distanceSwim + "м." + "\nПроплыл:" + swim + "м.");
    }
}

public class AnimalInfo {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Снежок", 173);
        cat1.animalInfo();
        cat1.catInfo();

        Cat cat2 = new Cat("Рыжик", 150);
        cat2.animalInfo();
        cat2.catInfo();

        Dog dog1 = new Dog("Шарик", 420, 9);
        dog1.animalInfo();
        dog1.dogInfo();

        Dog dog2 = new Dog("Стрелка", 380, 6);
        dog2.animalInfo();
        dog2.dogInfo();


        System.out.println("\nВсего животных: " + Animal.getAnimalCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
        System.out.println("Всего собак: " + Dog.getDogCount());

        //еда в миске
        Bowl bowl = new Bowl(10);
        Cat[] cats = {cat1, cat2};
        for (Cat cat : cats) {
            cat.eat(bowl, 15);
            System.out.println(cat.getName() + " сыт: " + cat.isFull());
        }
        System.out.println("\nОстаток еды в миске: " + bowl.getFood());

        bowl.addFood(15);
        System.out.println("Теперь в миске: " + bowl.getFood());

        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eat(bowl, 10);
                System.out.println(cat.getName() + " сыт: " + cat.isFull());
            }
        }
        System.out.println("Остаток еды в миске: " + bowl.getFood());


    }
}







