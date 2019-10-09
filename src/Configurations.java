import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class Configurations extends JFrame {
    private JFrame frame;
    private int index;
    private String indicator;
    private Iterator<Circle>iter;
    public Configurations(JFrame frame,int index,String indicator)
    {
        this.indicator = indicator;
        this.frame = frame;
        this.index = index;
        setLayout(new BorderLayout());
        setSize(500,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel p = new JPanel();
        add(p,BorderLayout.NORTH);
        setVisible(true);
        String[] numbers = {"10","20","30","40","50","60","70","80","90","100"};
        JButton MoveTo = new JButton("Move");
        JButton Remove = new JButton("Remove");
        JButton setVisibility = new JButton("Set invisible");
        JButton SetSize = new JButton("Set size");
        JComboBox ChangeWidth = new JComboBox(numbers);
        JComboBox ChangeHeight = new JComboBox(numbers);
        p.add(MoveTo);
        p.add(Remove);
        p.add(setVisibility);
        p.add(ChangeWidth);
        p.add(ChangeHeight);
        p.add(SetSize);

        class MoveToListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (indicator){
                    case "Circle":
                        MainWindow.getCircleList().get(index).MoveTo(frame,index);
                        break;
                    case "Rectangle":
                        MainWindow.getRecList().get(index).MoveTo(frame,index);
                        break;
                    case "Line":
                        MainWindow.getLineList().get(index).MoveTo(frame,index);
                        break;
                    default:
                        MainWindow.getLineList().get(index).MoveTo(frame,index);
                }
                frame.revalidate();
                frame.repaint();
                dispose();
            }
        }
        ActionListener moveToListener = new MoveToListener();
        MoveTo.addActionListener(moveToListener);

        class RemoveListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (indicator){
                    case "Circle":
                        MainWindow.getCircleList().get(index).Remove(frame);
                        break;
                    case "Rectangle":
                        MainWindow.getRecList().get(index).Remove(frame);
                        break;
                    case "Line":
                        MainWindow.getLineList().get(index).Remove(frame);
                        break;
                    default:
                        MainWindow.getLineList().get(index).Remove(frame);
                }
                frame.revalidate();
                frame.repaint();
                dispose();
            }
        }
        ActionListener removeListener = new RemoveListener();
        Remove.addActionListener(removeListener);
        class VisibilityListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }
        class ChangeWidthListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                int msg = Integer.parseInt(cb.getSelectedItem().toString());
                switch (indicator){
                    case "Circle":
                        MainWindow.getCircleList().get(index).ChangeWidth(frame,msg,index);
                        break;
                    case "Rectangle":
                        MainWindow.getRecList().get(index).ChangeWidth(frame,msg,index);
                        break;
                    case "Line":
                        MainWindow.getLineList().get(index).ChangeWidth(frame,msg,index);
                        break;
                    default:
                        MainWindow.getLineList().get(index).ChangeWidth(frame,msg,index);
                }
            }
        }
        ActionListener changeWidthListener = new ChangeWidthListener();
        ChangeWidth.addActionListener(changeWidthListener);
        class ChangeHeightListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                int msg = (int)cb.getSelectedItem();
                switch (indicator){
                    case "Circle":
                        MainWindow.getCircleList().get(index).ChangeHeight(frame,msg,index);
                        break;
                    case "Rectangle":
                        MainWindow.getRecList().get(index).ChangeHeight(frame,msg,index);
                        break;
                    case "Line":
                        MainWindow.getLineList().get(index).ChangeHeight(frame,msg,index);
                        break;
                    default:
                        MainWindow.getLineList().get(index).ChangeHeight(frame,msg,index);
                }

            }
        }
        ActionListener changeHeightListener = new ChangeHeightListener();
        ChangeHeight.addActionListener(changeHeightListener);
        class SetSizeActionListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }
    }
}
