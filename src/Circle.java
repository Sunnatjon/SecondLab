import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Circle extends JComponent {
    private int x,y,w = 70,h = 70;
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
        g.fillOval(x, y, w, h);
    }

    public void Create(JFrame frame, Random rand)
    {
        ArrayList<Circle> CircleList = MainWindow.getCircleList();
        int coordXC = rand.nextInt(400)+1;
        int coordYC = rand.nextInt(200)+1;
        Circle printCircle = new Circle(coordXC, coordYC);
        frame.add(printCircle);
        CircleList.add(printCircle);
    }
    public void MoveTo(JFrame frame, int index)
    {
        int dx = 20;
        Circle sampleC = MainWindow.getCircleList().get(index);
        if (sampleC.getX() >= 580){
            sampleC.setX(sampleC.getX());
        }else {
            System.out.println(sampleC.getX());
            sampleC.setX(sampleC.getX()+dx);
        }
        sampleC.setY(sampleC.getY());
        frame.add(sampleC);
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
    public void ChangeWidth(JFrame frame,int width, int index){
        Circle c  = MainWindow.getCircleList().get(index);
        c.setW(width);
        frame.add(c);
    }
    public void ChangeHeight(JFrame frame,int height, int index){
        Circle c  = MainWindow.getCircleList().get(index);
        c.setH(height);
        frame.add(c);
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

    public void setW(int w) {
        this.w = w;
    }

    public void setH(int h) {
        this.h = h;
    }
}
