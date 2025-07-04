class Cat extends Animal {
    boolean hungry;
    boolean isFull;

    public Cat(String name) {
        super(name);
        this.hungry = true;
        this.isFull = false;
        countCats++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать больше 200 м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(Bowl bowl) {
        if (hungry && bowl.feedCat(10)) {
            isFull = true;
            hungry = false;
            System.out.println("\n" + name + " поел и теперь сыт.");
        } else {
            System.out.println(name + " не может поесть, в миске недостаточно еды.");
        }
    }
}