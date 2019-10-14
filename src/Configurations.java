import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class Configurations extends JFrame {
    private JFrame frame = new JFrame();
    private int index = 0;
    private String indicator = "";
    private Iterator<Circle>iter;
    private JComboBox Change;
    private boolean visible;
    private int MIN = 10,MAX = 200,INIT = 70;
    public Configurations(){

    }
    public Configurations(JFrame frame,int index,String indicator,JComboBox Change)
    {
        this.indicator = indicator;
        this.frame = frame;
        this.index = index;
        this.Change = Change;
        setLayout(new BorderLayout());
        setSize(700,100);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel p = new JPanel();
        add(p,BorderLayout.NORTH);
        setVisible(true);
        JButton MoveTo = new JButton("Move");
        JButton Remove = new JButton("Remove");
        JButton setVisibility = new JButton("Set invisible");
        JSlider slider = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        p.add(MoveTo);
        p.add(Remove);
        p.add(setVisibility);
        p.add(slider);
        class SliderListener implements ChangeListener {
            @Override
            public void stateChanged(ChangeEvent e) {
                int change = slider.getValue();
                switch (indicator){
                    case "Circle":
                        MainWindow.getCircleList().get(index).ChangeHeight(frame,change,index);
                        MainWindow.getCircleList().get(index).ChangeWidth(frame,change,index);
                        break;
                    case "Rectangle":
                        MainWindow.getRectList().get(index).ChangeHeight(frame,change,index);
                        MainWindow.getRectList().get(index).ChangeWidth(frame,change,index);
                        break;
                    case "Line":
                        MainWindow.getLineList().get(index).ChangeHeight(frame,change,index);
                        MainWindow.getLineList().get(index).ChangeWidth(frame,change,index);
                        break;
                    default:
                        MainWindow.getLineList().get(index).ChangeHeight(frame,change,index);
                }
                frame.revalidate();
                frame.repaint();
            }
        }

        ChangeListener sliderListener = new SliderListener();
        slider.addChangeListener(sliderListener);

        class MoveToListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (indicator){
                    case "Circle":
                        MainWindow.getCircleList().get(index).MoveTo(frame,index);
                        break;
                    case "Rectangle":
                        MainWindow.getRectList().get(index).MoveTo(frame,index);
                        break;
                    case "Line":
                        MainWindow.getLineList().get(index).MoveTo(frame,index);
                        break;
                    default:
                        MainWindow.getLineList().get(index).MoveTo(frame,index);
                }
                frame.revalidate();
                frame.repaint();
                //dispose();
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
                        Change.removeItemAt(index);
                        break;
                    case "Rectangle":
                        MainWindow.getRectList().get(index).Remove(frame);
                        Change.removeItemAt(index);
                        break;
                    case "Line":
                        MainWindow.getLineList().get(index).Remove(frame);
                        Change.removeItemAt(index);
                        break;
                    default:
                        MainWindow.getLineList().get(index).Remove(frame);
                }
                dispose();
                frame.revalidate();
                frame.repaint();
                //dispose();
            }
        }
        ActionListener removeListener = new RemoveListener();
        Remove.addActionListener(removeListener);
        class VisibilityListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (indicator){
                    case "Circle":
                        MainWindow.getCircleList().get(index).Visibility(frame,index);
                        break;
                    case "Rectangle":
                        MainWindow.getRectList().get(index).Visibility(frame,index);
                        break;
                    case "Line":
                        MainWindow.getLineList().get(index).Visibility(frame,index);
                        break;
                    default:
                        MainWindow.getLineList().get(index).Visibility(frame,index);
                }
                frame.revalidate();
                frame.repaint();
            }
        }
        ActionListener visibilityListener = new VisibilityListener();
        setVisibility.addActionListener(visibilityListener);
    }
}
