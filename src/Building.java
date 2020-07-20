public class Building {
    Points cost;
    Points income;
    String name;
    int count;
    int max;
    public Building(String name, Points cost, Points income, int max){
        this.name = name;
        this.cost = cost;
        this.income = income;
        this.count = 0;
        this.max = max;
    }

    public double getCost() {
        return cost.getValue();
    }

    public double getTotalIncome() {
        if(count == 0){
            return income.getValue();
        }
        return income.getValue() * count;
    }

    public double getChangeInIncome(){
        return income.getValue();
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public int getMax() {
        return max;
    }

    public void buyBuilding(){
        count++;
    }

}
