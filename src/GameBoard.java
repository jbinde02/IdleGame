import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GameBoard {
    JFrame frame;
    JButton jClickerButton, jButton1, jButton2, jButton3;
    Map<String, JButton> jButtonBuildingMap;
    JLabel jLabel1, jLabel2;
    JPanel buttonPanel, pointPanel, buildingPanel;
    GridBagConstraints c = new GridBagConstraints();
    final int BUTTON_WIDTH = 200;
    final int BUTTON_HEIGHT =30;
    public GameBoard(){
        frame = new JFrame("Idle Game");
        frame.setSize(1000, 500);
        frame.setLayout(new GridBagLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jButtonBuildingMap = new HashMap<>();

        pointPanel = new JPanel();
        c.gridx = 0;
        c.gridy = 0;
        frame.add(pointPanel, c);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        c.gridx = 0;
        c.gridy = 1;
        frame.add(buttonPanel, c);

        buildingPanel = new JPanel();
        buildingPanel.setLayout(new BoxLayout(buildingPanel, BoxLayout.PAGE_AXIS));
        c.gridx = 1;
        c.gridy = 0;
        frame.add(buildingPanel, c);

        jClickerButton = new JButton("Click for Point");
        jClickerButton.setBounds(50, 60, 50, 50);
        buttonPanel.add(jClickerButton);

        jButton1 = new JButton("Points per second : + 1");
        jButton1.setBounds(50, 100, 200 , 30);
        buttonPanel.add(jButton1);

        jButton2 = new JButton("Points per second : * 2");
        jButton2.setBounds(50, 140, 200 , 30);
        buttonPanel.add(jButton2);

        jButton3 = new JButton("Points per second : + %10");
        jButton3.setBounds(50, 180, 200 , 30);
        buttonPanel.add(jButton3);

        jLabel1 = new JLabel("Points per second | ");
        jLabel1.setBounds(50, 20, 250, 30);
        pointPanel.add(jLabel1);

        jLabel2 = new JLabel("Total Points | ");
        jLabel2.setBounds(50, 50, 250, 30);
        pointPanel.add(jLabel2);

    }

    public void addBuildingButton(Building building){
        JButton newButton = new JButton();
        newButton.setName(building.getName());
        newButton.setText(newButton.getName() + " | Points Per Second " + building.getIncome() + " | Cost = " + building.getCost() + " | Count = " + building.getCount());
        newButton.setBounds(0, 180, BUTTON_WIDTH , BUTTON_HEIGHT);
        buildingPanel.add(newButton);
        jButtonBuildingMap.put(newButton.getName(), newButton);
    }

    public JButton getBuildingButton(String buildingName) {
        return jButtonBuildingMap.get(buildingName);
    }
}
