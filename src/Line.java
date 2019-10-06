import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Line extends JComponent implements MainInterface{
    private int x,y;
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
        g.drawLine(x, y, x+60, y+60);
    }
    @Override
    public void Create(JFrame frame, Random rand)
    {
        ArrayList<Line>LineList = MainWindow.getLineList();
        int widthC = rand.nextInt(400)+1;
        int heightC = rand.nextInt(200)+1;
        Line printLine = new Line(widthC, heightC);
        frame.add(printLine);
        LineList.add(printLine);
    }
    public void MoveTo(JFrame frame)
    {
        int dx = 20;
        int l = MainWindow.getLineList().size();
        for (int i = 0; i < l; i++)
        {
            Line sampleL = MainWindow.getLineList().get(i);
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
