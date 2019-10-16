import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainWindow {
    private static Configurations config;
    private static Circle createCircle = new Circle();
    private static RectanglePro createRec = new RectanglePro();
    private static Line createLine = new Line();
    private static ArrayList<Circle> CircleList = new ArrayList<>();
    private static ArrayList<RectanglePro> RectList =  new ArrayList<>();
    private static ArrayList<Line> LineList =  new ArrayList<>();
    private static int LUCK = 0;
    private static ArrayList<String> textBox = new ArrayList<>();
    private static int SELECTED_INDEX,indexC = 0,indexR = 0,indexL = 0;
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
        JPanel panel2 = new JPanel();
        frame.add(panel,BorderLayout.NORTH);
        frame.add(panel2,BorderLayout.WEST);
        JButton CreateButton = new JButton("Create");
        JButton MoveTo = new JButton("MoveTo");
        JButton DeleteTheLast = new JButton("Delete");
        panel.add(CreateButton);
        panel.add(MoveTo);
        panel.add(DeleteTheLast);
        JComboBox shapeBox = new JComboBox(BOX_COLLECTION);
        JComboBox Change = new JComboBox();
        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> list = new JList<>(model);
        panel2.add(list);
        panel.add(Change);
        shapeBox.setSelectedItem(0);
        panel.add(shapeBox);

        class ListListener implements ListSelectionListener {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String msg = list.getSelectedValue()+"";
                int selectedIndex = list.getSelectedIndex();
                for (int i = 0; i < 20; i++){
                    if (msg.equals("Circle - "+ i)){
                        String indicator = "Circle";
                        config = new Configurations(frame,i,selectedIndex,indicator,model);
                        frame.revalidate();
                        frame.repaint();
                        break;
                    }
                }
                for (int i = 0; i < 20; i++){
                    if (msg.equals("Rectangle - "+ i)){
                        String indicator = "Rectangle";
                        config = new Configurations(frame,i,selectedIndex,indicator,model);
                        frame.revalidate();
                        frame.repaint();
                        break;
                    }
                }
                for (int i = 0; i < 20; i++){
                    if (msg.equals("Line - "+ i)){
                        String indicator = "Line";
                        config = new Configurations(frame,i,selectedIndex,indicator,model);
                        frame.revalidate();
                        frame.repaint();
                        break;
                    }
                }
            }
        }
        ListSelectionListener listSelectionListener = new ListListener();
        list.addListSelectionListener(listSelectionListener);

//        class DeleteButtonListener implements ActionListener
//        {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int Ctrue = 1,Rtrue = 1,Ltrue = 1;
//                switch (LUCK) {
//                    case 0:
//                        Ctrue = createCircle.Remove(frame, indexC);
//                        break;
//                    case 1:
//                        Ltrue = createLine.Remove(frame, indexR);
//                        break;
//                    case 2:
//                        Rtrue = createRec.Remove(frame, indexL);
//                        break;
//                    default:
//                        createLine.Remove(frame, indexC);
//                        break;
//                }
//                if (Ctrue == 0){
//                    LUCK = 1;
//                }
//                if (Ltrue == 0){
//                    LUCK = 2;
//                }
//                if (Rtrue == 0){
//                    LUCK = 0;
//                }
//                frame.revalidate();
//                frame.repaint();
//            }
//        }
//        ActionListener deleteBtnListener = new DeleteButtonListener();
//        DeleteTheLast.addActionListener(deleteBtnListener);

        class CreateListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                switch (SELECTED_INDEX){
                    case 0:
                        createCircle.Create(frame,rand);
                        model.addElement("Circle - "+ (CircleList.size()-1));
                        indexC++;
                        break;
                    case 1:
                        createRec.Create(frame,rand);
                        model.addElement("Rectangle - "+ (RectList.size()-1));
                        indexR++;
                        break;
                    case 2:
                        createLine.Create(frame,rand);
                        model.addElement("Line - "+ (LineList.size()-1));
                        indexL++;
                        break;
                    default:
                        model.addElement("Line - "+ indexL);
                        break;
                }
                frame.revalidate();
                frame.repaint();
            }
        }

        ActionListener createListener = new CreateListener();
        CreateButton.addActionListener(createListener);

        class ShapeBoxListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (event.getSource() == shapeBox)
                {
                    JComboBox cb = (JComboBox)event.getSource();
                    SELECTED_INDEX = cb.getSelectedIndex();
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