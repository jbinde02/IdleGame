public class Building {
    Points cost;
    Points income;
    String name;
    int count;
    public Building(String name, Points cost, Points income){
        this.name = name;
        this.cost = cost;
        this.income = income;
        this.count = 0;
    }

    public double getCost() {
        return cost.getValue();
    }

    public double getIncome() {
        return income.getValue() * count;
    }

    public int getCount() {
        return count;
    }

    public void buyBuilding(){
        count++;
    }

}
