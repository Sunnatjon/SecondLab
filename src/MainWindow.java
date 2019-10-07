import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class MainWindow {
    private static Circle createCircle = new Circle();
    private static RectanglePro createRec = new RectanglePro();
    private static Line createLine = new Line();
    private static ArrayList<Circle> CircleList = new ArrayList<>();
    private static ArrayList<RectanglePro> RectList =  new ArrayList<>();
    private static ArrayList<Line> LineList =  new ArrayList<>();
    private static int LUCK = 0;
    public static void main(String[] args)
    {
        Random rand = new Random();
        final JFrame frame = new JFrame();
        final String[] BOX_COLLECTION = {"Circle","Rectangle","Line"};
        final int FRAME_WIDTH  = 1300;
        final int FRAME_HEIGHT = 750;

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("PhotoShop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        frame.add(panel,BorderLayout.NORTH);
        JButton CreateButton = new JButton("Create");
        JButton MoveTo = new JButton("MoveTo");
        JButton DeleteTheLast = new JButton("Delete");
        panel.add(CreateButton);
        panel.add(MoveTo);
        panel.add(DeleteTheLast);
        JComboBox shapeBox = new JComboBox(BOX_COLLECTION);
        shapeBox.setSelectedItem(0);
        panel.add(shapeBox);

        class DeleteButtonListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                int Ctrue = 1,Rtrue = 1,Ltrue = 1;
                switch (LUCK) {
                    case 0:
                        Ctrue = createCircle.Remove(frame);
                        break;
                    case 1:
                        Ltrue = createLine.Remove(frame);
                        break;
                    case 2:
                        Rtrue = createRec.Remove(frame);
                        break;
                    default:
                        createLine.Remove(frame);
                        break;
                }
                if (Ctrue == 0){
                    LUCK = 1;
                }
                if (Ltrue == 0){
                    LUCK = 2;
                }
                if (Rtrue == 0){
                    LUCK = 0;
                }
                frame.revalidate();
                frame.repaint();
            }
        }
        ActionListener deleteBtnListener = new DeleteButtonListener();
        DeleteTheLast.addActionListener(deleteBtnListener);

        class RectangleButtonListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                frame.revalidate();
                frame.repaint();
            }
        }

        ActionListener rectButtonListener = new RectangleButtonListener();
        CreateButton.addActionListener(rectButtonListener);

        class ShapeBoxListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (event.getSource() == shapeBox)
                {
                    JComboBox cb = (JComboBox)event.getSource();
                    String msg = (String)cb.getSelectedItem();
                    switch (msg)
                    {
                        case "Circle":
                            System.out.println("Circle");
                            createCircle.Create(frame,rand);
                            break;
                        case "Rectangle":
                            System.out.println("Rectangle");
                            createRec.Create(frame,rand);
                            break;
                        case "Line":
                            System.out.println("Line");
                            createLine.Create(frame,rand);
                            break;
                        default:
                            System.out.println("Something");
                            break;
                    }
                }
            }
        }
        ActionListener sbl = new ShapeBoxListener();
        shapeBox.addActionListener(sbl);
        frame.setVisible(true);
        class MoveToListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent event) {
                createCircle.MoveTo(frame);
                createRec.MoveTo(frame);
                createLine.MoveTo(frame);
                frame.revalidate();
                frame.repaint();
            }
        }
        ActionListener mt = new MoveToListener();
        MoveTo.addActionListener(mt);
    }

    public static ArrayList<Circle> getCircleList(){
        return CircleList;
    }
    public static ArrayList<RectanglePro> getRecList(){
        return RectList;
    }
    public static ArrayList<Line> getLineList(){
        return LineList;
    }
}