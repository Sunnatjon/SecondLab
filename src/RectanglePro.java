import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class RectanglePro extends JComponent{
        private int x,y,w = 70,h = 70;
        private Color color = Color.BLACK;
        Iterator<RectanglePro> iterR;
        public RectanglePro(int x, int y,int w,int h)
        {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }
        public RectanglePro(){}
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Color c = color;
            g.setColor(c);
            g.fillRect(x, y, w, h);
        }

        public void Create(JFrame frame, Random rand)
        {
            ArrayList<RectanglePro>RectList = MainWindow.getRectList();
            int widthC = 70;
            int heightC = 70;
            int XR = rand.nextInt(400)+1;
            int YR = rand.nextInt(200)+1;
            RectanglePro printRectangle = new RectanglePro(XR,YR,widthC, heightC);
            RectList.add(printRectangle);
            frame.add(printRectangle);
            MainWindow.setRectList(RectList);
        }

    public void Create(JFrame frame, int X,int Y, int S)
    {
        ArrayList<RectanglePro>RectList = MainWindow.getRectList();
        int XR = X;
        int YR = Y;
        int widthC = S;
        int heightC = S;
        RectanglePro printRectangle = new RectanglePro(XR,YR,widthC, heightC);
        RectList.add(printRectangle);
        frame.add(printRectangle);
        MainWindow.setRectList(RectList);
    }
    public void MoveTo(JFrame frame,int index)
    {
        int dx = 20;
        RectanglePro sampleR = MainWindow.getRectList().get(index);
        if (sampleR.getX() >= 580){
            sampleR.setX(sampleR.getX());
        }
        else {
            System.out.println(sampleR.getX());
            sampleR.setX(sampleR.getX()+dx);
        }
        sampleR.setY(sampleR.getY());
        frame.add(sampleR);
    }
    public int Remove(JFrame frame, int index){
        int luck = 1;
        ArrayList<RectanglePro> ar = MainWindow.getRectList();
        iterR = ar.iterator();
        if (iterR.hasNext()){
            frame.remove(ar.get(index));
        }else {
            luck = 0;
        }
        return luck;
    }
    public void ChangeWidth(JFrame frame,int width, int index){
        RectanglePro r  = MainWindow.getRectList().get(index);
        r.setW(width);
        frame.add(r);
    }
    public void ChangeHeight(JFrame frame,int height, int index){
        RectanglePro r  = MainWindow.getRectList().get(index);
        r.setH(height);
        frame.add(r);
    }
    public void Visibility(JFrame frame, int index){
        RectanglePro r = MainWindow.getRectList().get(index);
        color = r.getColor();
        if (color == Color.BLACK) {
            color = new Color(255, 0, 0, 0);
        }
        else {
            color = Color.BLACK;
        }
        r.setColor(color);
        frame.add(r);
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setW(int w) {
        this.w = w;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
