import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class MainWindow {
    private static Configurations config = new Configurations();
    private static Circle createCircle = new Circle();
    private static RectanglePro createRec = new RectanglePro();
    private static Line createLine = new Line();
    private static ArrayList<Circle> CircleList = new ArrayList<>();
    private static ArrayList<RectanglePro> RectList =  new ArrayList<>();
    private static ArrayList<Line> LineList =  new ArrayList<>();
    private static int LUCK = 0;
    private static ArrayList<String> textBox = new ArrayList<>();
    public static void main(String[] args)
    {
        config.setVisible(false);
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
        JComboBox Change = new JComboBox();
        panel.add(Change);
        shapeBox.setSelectedItem(0);
        panel.add(shapeBox);

        class ChangeBtnListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent event) {
                JComboBox cb = (JComboBox)event.getSource();
                String msg = (String)cb.getSelectedItem();
                for (int i = 0; i < textBox.size(); i++){
                    if (msg.equals(i + " Circle")){
                        String indicator = "Circle";
                        config = new Configurations(frame,i,indicator,Change);
                        config.setVisible(true);
                        //CircleList.get(i).MoveTo(frame,i);
                        frame.revalidate();
                        frame.repaint();
                    }
                }
                for (int i = 0; i < textBox.size(); i++){
                    if (msg.equals(i + " Rectangle")){
                        String indicator = "Rectangle";
                        config = new Configurations(frame,i,indicator,Change);
                        config.setVisible(true);
                        //RectList.get(i).MoveTo(frame,i);
                        frame.revalidate();
                        frame.repaint();
                    }
                }
                for (int i = 0; i < textBox.size(); i++){
                    if (msg.equals(i + " Line")){
                        String indicator = "Line";
                        config = new Configurations(frame,i,indicator,Change);
                        config.setVisible(true);
                        //LineList.get(i).MoveTo(frame,i);
                        frame.revalidate();
                        frame.repaint();
                    }
                }
            }
        }
        ActionListener change = new ChangeBtnListener();
        Change.addActionListener(change);

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
                Change.addItem(textBox.get(textBox.size()-1));
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
                            textBox.add((CircleList.size()-1) + " Circle");
                            break;
                        case "Rectangle":
                            System.out.println("Rectangle");
                            createRec.Create(frame,rand);
                            textBox.add((RectList.size()-1) + " Rectangle");
                            break;
                        case "Line":
                            System.out.println("Line");
                            createLine.Create(frame,rand);
                            textBox.add((LineList.size()-1) + " Line");
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
                createCircle.MoveTo(frame,0);
                createRec.MoveTo(frame,0);
                createLine.MoveTo(frame,0);
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
    public static void setCircleList(ArrayList<Circle> circleList) {
        CircleList = circleList;
    }
    public static ArrayList<RectanglePro> getRectList() {
        return RectList;
    }
    public static void setRectList(ArrayList<RectanglePro> rectList) {
        RectList = rectList;
    }

    public static ArrayList<Line> getLineList(){
        return LineList;
    }
    public static void setLineList(ArrayList<Line> lineList) {
        LineList = lineList;
    }
}