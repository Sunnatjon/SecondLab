import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Line extends JComponent{
    private int x,y,w = 60,h = 60;
    Iterator<Line> iterL;
    public Line(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public Line(){}
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Color c = Color.ORANGE;
        g.setColor(c);
        g.drawLine(x, y, x+w, y+h);
    }

    public void Create(JFrame frame, Random rand)
    {
        ArrayList<Line>LineList = MainWindow.getLineList();
        int widthC = rand.nextInt(400)+1;
        int heightC = rand.nextInt(200)+1;
        Line printLine = new Line(widthC, heightC);
        frame.add(printLine);
        LineList.add(printLine);
    }
    public void MoveTo(JFrame frame,int index)
    {
        int dx = 20;
        Line sampleL = MainWindow.getLineList().get(index);
        if (sampleL.getX() >= 580){
            sampleL.setX(sampleL.getX());
        }
        else {
            System.out.println(sampleL.getX());
            sampleL.setX(sampleL.getX()+dx);
        }
        sampleL.setY(sampleL.getY());
        frame.add(sampleL);
    }
    public int Remove(JFrame frame){
        int luck = 1;
        iterL = MainWindow.getLineList().iterator();
        if (iterL.hasNext())
        {
            frame.remove(MainWindow.getLineList().get(0));
            MainWindow.getLineList().remove(0);
            for (int i = 0; i < MainWindow.getLineList().size(); i++) {
                Line l = MainWindow.getLineList().get(i);
                frame.add(l);
            }
        }else {
            luck = 0;
        }
        return luck;
    }
    public void ChangeWidth(JFrame frame,int width, int index){
        Line l  = MainWindow.getLineList().get(index);
        l.setW(width);
        frame.add(l);
    }
    public void ChangeHeight(JFrame frame,int height, int index){
        Circle c  = MainWindow.getCircleList().get(index);
        c.setH(height);
        frame.add(c);
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
