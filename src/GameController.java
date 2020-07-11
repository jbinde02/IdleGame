import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements Runnable {
    boolean running = true;
    Points pointsPerSecond = new Points(0);
    Points totalPoints = new Points(0);
    double flatValue = 0.0;
    double multiplier = 1.0;
    Building pointExcavator;

    GameBoard gameBoard;

    public GameController(){
        gameBoard = new GameBoard();
        //Buildings
        pointExcavator = new Building("Point Excavator", new Points(250) , new Points(10));
        //Buttons
        // +1 Points to total
        gameBoard.jClickerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalPoints.add(1.0);
                updateText();
            }
        });
        // +1 points per second
        gameBoard.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // pointsPerSecond.add(1.0);
                flatValue += 1;
                updateText();
            }
        });
        // 2 * Points per second
        gameBoard.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // pointsPerSecond.add(pointsPerSecond.getValue() * 2.0);
                multiplier += 1;
                updateText();
            }
        });
        // 10% points per second
        gameBoard.jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //  pointsPerSecond.add(pointsPerSecond.getValue() * 1.10);
                multiplier += .10;
                updateText();
            }
        });
        //Building : Point Excavator
        gameBoard.jBuildingButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add new building
                if(totalPoints.compareTo(new Points(pointExcavator.getCost())) == 1 || totalPoints.compareTo(new Points(pointExcavator.getCost())) == 0){
                    totalPoints.subtract(pointExcavator.getCost());
                    pointExcavator.buyBuilding();
                    gameBoard.jBuildingButton1.setText("Point Excavator : + 1" + " | Cost = " + pointExcavator.getCost() + " | Count = " + pointExcavator.getCount());
                    flatValue += pointExcavator.getIncome();
                }
            }
        });
    }

    public void run(){
        while(running){
            update();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void update(){
        //Round to three decimal places
        double pps = flatValue;
        pps = pps * multiplier;
        pps = Math.round(pps * 1000) / 1000;
        pointsPerSecond.setValue(pps);
        //Round to three decimal places
        totalPoints.add(pointsPerSecond);
        totalPoints.setValue(Math.round(totalPoints.getValue() * 1000) / 1000);
        updateText();
    }

    private void updateText(){
        gameBoard.jLabel1.setText("Points per second | " + pointsPerSecond.getValue() + " Flatvalue = " + flatValue + " Multiplier = " + multiplier);
        gameBoard.jLabel2.setText("Total Points | " + totalPoints.getValue());
    }
}
