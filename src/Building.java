/**
 * This class represents a building which is a object that can be bought for points used in the controller class.
 * A building consist of a name, cost, income, count, and maximum count.
 *
 * @author Jacob Binder
 */

class Building {
    private String name;
    private Points cost;
    private Points income;
    private int count;
    private int maxCount;
    Building(String name, Points cost, Points income, int maxCount){
        this.name = name;
        this.cost = cost;
        this.income = income;
        this.count = 0;
        this.maxCount = maxCount;
    }

    double getCost() {
        return cost.getValue();
    }

    double getTotalIncome() {
        if(count == 0){
            return income.getValue();
        }
        return income.getValue() * count;
    }

    double getChangeInIncome(){
        return income.getValue();
    }

    int getCount() {
        return count;
    }

    String getName() {
        return name;
    }

    int getMaxCount() {
        return maxCount;
    }

    void buyBuilding(){
        count++;
    }

}
