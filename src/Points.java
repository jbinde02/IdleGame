/**
 * This class represents Points which are just a double value. I kind of got a bit carried away with using Points
 * instead of just doubles but here we are.
 *
 * @author Jacob Binder
 */

public class Points {
    private double value;

    Points(double value){
        this.value = value;
    }

    public Points(){
        this.value = 0;
    }

    double getValue(){
        return this.value;
    }

    void setValue(double value){
        this.value = value;
    }

    void add(Points modifier){
        this.value = this.value + modifier.value;
    }

    void add(Double modifier){
        this.value = this.value + modifier;
    }

    public void subtract(Points modifier){
        this.value = this.value - modifier.value;
    }

    void subtract(Double modifier){
        this.value = this.value - modifier;
    }

    public static int compare(Points points1, Points points2){
        double difference = points1.value - points2.value;
        if(difference == 0){
            return 0;
        }else if(difference > 0){
            return 1;
        } else{
            return -1;
        }
    }

    int compareTo(Points comparedTo){
        double difference = this.value - comparedTo.value;
        if(difference == 0){
            return 0;
        }else if(difference > 0){
            return 1;
        } else{
            return -1;
        }
    }
}
