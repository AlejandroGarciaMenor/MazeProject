package maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RobotSelector extends JFrame {
    private JComboBox<Robot> robotComboBox;
    private JButton selectButton;
    private Robot selectedRobot;

    public RobotSelector(List<Robot> robots) {
        setTitle("Select a Robot");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        robotComboBox = new JComboBox<>(robots.toArray(new Robot[0]));
        selectButton = new JButton("Select");

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedRobot = (Robot) robotComboBox.getSelectedItem();
                dispose();
            }
        });

        add(robotComboBox, BorderLayout.CENTER);
        add(selectButton, BorderLayout.SOUTH);
    }

    public Robot getSelectedRobot() {
        return selectedRobot;
    }

    public static Robot showRobotSelector(List<Robot> robots) {
        RobotSelector selector = new RobotSelector(robots);
        selector.setVisible(true);
        while (selector.isVisible()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return selector.getSelectedRobot();
    }
}