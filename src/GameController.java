import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameController implements Runnable {
    boolean running = true;
    boolean buildingUpdated = false;
    Points pointsPerSecond = new Points(0);
    Points totalPoints = new Points(0);
    double flatValue = 0.0;
    double multiplier = 1.0;
    Building pointExcavator, pointBaker;
    List<Building> buildingList = new ArrayList<Building>();
    Iterator<Building> iterator;
    GameBoard gameBoard;


    public GameController(){
        gameBoard = new GameBoard();
        //Buildings
        pointExcavator = new Building("Point Excavator", new Points(250) , new Points(10), 10);
        pointBaker = new Building("Point Baker", new Points(1000) , new Points(25), 5);
        addBuildingToList(pointExcavator);
        addBuildingToList(pointBaker);

        iterator = buildingList.iterator();
        while(iterator.hasNext()){
            addBuilding(iterator.next());
        }
        //Upgrade and Clicker Buttons
        // +1 Points to total or Clicker button
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
                flatValue += 1;
                updateText();
            }
        });
        // 2 * Points per second
        gameBoard.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                multiplier += 1;
                updateText();
            }
        });
        // 10% points per second
        gameBoard.jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                multiplier += .10;
                updateText();
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
        //Rounds to three decimal places
        pointsPerSecond.setValue(Math.round(flatValue * multiplier * 1000) / 1000);
        //Rounds to three decimal places
        totalPoints.add(pointsPerSecond);
        totalPoints.setValue(Math.round(totalPoints.getValue() * 1000) / 1000);
        updateText();
    }

    private void updateText(){
        gameBoard.jLabel1.setText("Points per second | " + pointsPerSecond.getValue() + " Flat Value = " + flatValue + " Multiplier = " + multiplier);
        gameBoard.jLabel2.setText("Total Points | " + totalPoints.getValue());
    }

    private void addBuilding(Building building){
        //Calls the gameboard to create a new jbutton and place it it a map with the key being the buildings name as well as putting it in the building panel.
        String key = building.getName();
        gameBoard.addBuildingButton(building);
        //Add action to the new building button
        gameBoard.getBuildingButton(key).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add new building button
                if(building.getCount()<building.getMax() && totalPoints.compareTo(new Points(building.getCost())) >= 0){
                    totalPoints.subtract(building.getCost());
                    building.buyBuilding();
                    gameBoard.getBuildingButton(key).setText(building.getName() + " | Points Per Second " + building.getChangeInIncome() + " | Cost = " + building.getCost() + " | Count = " + building.getCount());
                    flatValue += building.getChangeInIncome();
                }
            }
        });
    }

    private void addBuildingToList(Building building){
        if(!buildingList.contains(building)){
            buildingList.add(building);
        }else{
            System.out.println("Building already added in buildingList.");
        }
    }
}