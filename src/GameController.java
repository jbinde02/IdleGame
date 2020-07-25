import java.util.ArrayList;
import java.util.List;

public class GameController implements Runnable {
    private Points pointsPerSecond = new Points(0);
    private Points totalPoints = new Points(0);
    private double flatValue = 0.0;
    private double multiplier = 1.0;
    private List<Building> buildingList = new ArrayList<>();
    private GameBoard gameBoard;


    GameController(){
        gameBoard = new GameBoard();
        //Buildings
        Building pointExcavator = new Building("Point Excavator", new Points(250), new Points(10), 10);
        Building pointBaker = new Building("Point Baker", new Points(1000), new Points(25), 5);
        Building pointExpander = new Building("Point Expander", new Points(2500), new Points(100), 2);
        addBuildingToList(pointExcavator);
        addBuildingToList(pointBaker);
        addBuildingToList(pointExpander);

        for (Building building : buildingList) {
            addBuilding(building);
        }
        //Upgrade and Clicker Buttons
        // +1 Points to total or Clicker button
        gameBoard.jClickerButton.addActionListener(e -> {
            totalPoints.add(1.0);
            updateText();
        });
        // +1 points per second
        gameBoard.jButton1.addActionListener(e -> {
            flatValue += 1;
            updateText();
        });
        // 2 * Points per second
        gameBoard.jButton2.addActionListener(e -> {
            multiplier += 1;
            updateText();
        });
        // 10% points per second
        gameBoard.jButton3.addActionListener(e -> {
            multiplier += .10;
            updateText();
        });
    }

    public void run(){
        boolean running = true;
        while(running){
            update();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                running = false;
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
        gameBoard.getBuildingButton(key).addActionListener(e -> {
            // Add new building button
            if(building.getCount()<building.getMaxCount() && totalPoints.compareTo(new Points(building.getCost())) >= 0){
                totalPoints.subtract(building.getCost());
                building.buyBuilding();
                gameBoard.getBuildingButton(key).setText(building.getName() + " | Points Per Second " + building.getChangeInIncome() + " | Cost = " + building.getCost() + " | Count = " + building.getCount());
                flatValue += building.getChangeInIncome();
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