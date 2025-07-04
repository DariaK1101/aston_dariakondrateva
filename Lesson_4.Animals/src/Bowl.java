class Bowl {
    int food;

    public Bowl(int foodAmount) {
        this.food = foodAmount;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("В миску добавлено " + amount + " еды. Сейчас в миске " + food + " еды.");
        } else {
            System.out.println("Невозможно добавить отрицательное количество еды!");
        }
    }

    public boolean feedCat(int amount) {
        if (food >= amount) {
            food -= amount;
            return true;
        } else {
            System.out.println("\nНедостаточно еды! Cейчас в миске " + food + " еды.");
            return false;
        }
    }

    public int getFoodAmount() {
        return food;
    }
}
