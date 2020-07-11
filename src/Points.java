public class Points {
    private double value;

    public Points(double value){
        this.value = value;
    }

    public Points(){
        this.value = 0;
    }

    public double getValue(){
        return this.value;
    }

    public void setValue(double value){
        this.value = value;
    }

    public void add(Points modifier){
        this.value = this.value + modifier.value;
    }

    public void add(Double modifier){
        this.value = this.value + modifier;
    }

    public void subtract(Points modifier){
        this.value = this.value - modifier.value;
    }

    public void subtract(Double modifier){
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

    public int compareTo(Points comparedTo){
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
