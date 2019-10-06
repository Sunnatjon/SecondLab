import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Circle extends JComponent implements MainInterface{
    private int x,y;
    private Iterator<Circle> iterC;
    public Circle(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public Circle(){}
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Color c = Color.RED;
        g.setColor(c);
        g.fillOval(x, y, 70, 70);
    }

    public void Create(JFrame frame, Random rand)
    {
        ArrayList<Circle> CircleList = MainWindow.getCircleList();
        int widthC = rand.nextInt(400)+1;
        int heightC = rand.nextInt(200)+1;
        Circle printCircle = new Circle(widthC, heightC);
        frame.add(printCircle);
        CircleList.add(printCircle);
    }
    public void MoveTo(JFrame frame)
    {
        int dx = 20;
        int c = MainWindow.getCircleList().size();
        for (int i = 0; i < c; i++)
        {
            Circle sampleC = MainWindow.getCircleList().get(i);
            if (sampleC.getX() >= 580){
                sampleC.setX(sampleC.getX());
            }
            else {
                System.out.println(sampleC.getX());
                sampleC.setX(sampleC.getX()+dx);
            }
            sampleC.setY(sampleC.getY());
            frame.add(sampleC);
        }
    }

    public int Remove(JFrame frame){
        int luck = 1;
        iterC = MainWindow.getCircleList().iterator();
        if (iterC.hasNext()){
            frame.remove(MainWindow.getCircleList().get(0));
            MainWindow.getCircleList().remove(0);
            for (int i = 0; i < MainWindow.getCircleList().size(); i++) {
                Circle c = MainWindow.getCircleList().get(i);
                frame.add(c);
            }
        }else {
            luck = 0;
        }
        return luck;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
