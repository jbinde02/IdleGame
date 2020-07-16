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
        if(count == 0){
            return income.getValue();
        }
        return income.getValue() * count;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void buyBuilding(){
        count++;
    }

}
