import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Circle extends JComponent {
    private int x,y,w,h;
    private Iterator<Circle> iterC;
    private Color color = Color.RED;
    public Circle(int x, int y, int h, int w)
    {
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
    }
    public Circle(){}
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Color c = color;
        g.setColor(c);
        g.fillOval(x, y, w, h);
    }

    public void Create(JFrame frame, Random rand)
    {
        ArrayList<Circle> CircleList = MainWindow.getCircleList();
        int coordXC = rand.nextInt(400)+20;
        int coordYC = rand.nextInt(200)+20;
        Circle printCircle = new Circle(coordXC, coordYC,70,70);
        frame.add(printCircle);
        CircleList.add(printCircle);
        MainWindow.setCircleList(CircleList);
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

    public int Remove(JFrame frame, int index){
        int luck = 1;
        ArrayList<Circle> ac = MainWindow.getCircleList();
        iterC = ac.iterator();
        if (iterC.hasNext()){
            frame.remove(ac.get(index));
//            ac.remove(index);
//            for (int i = 0; i < ac.size(); i++) {
//                Circle c = ac.get(i);
//                frame.add(c);
//            }
//            MainWindow.setCircleList(ac);
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
    public void Visibility(JFrame frame,int index){
        Circle c = MainWindow.getCircleList().get(index);
        color = c.getColor();
        if (color == Color.RED) {
            color = new Color(255, 0, 0, 0);
        }
        else {
            color = Color.RED;
        }
        c.setColor(color);
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

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
