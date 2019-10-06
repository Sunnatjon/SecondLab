import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class RectanglePro extends JComponent implements MainInterface{
        private int x,y;
        public RectanglePro(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        public RectanglePro(){}
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Color c = Color.BLACK;
            g.setColor(c);
            g.fillRect(x, y, 70, 70);
        }

        @Override
        public void Create(JFrame frame, Random rand)
        {
            ArrayList<RectanglePro>RectList = MainWindow.getRecList();
            int widthC = rand.nextInt(400)+1;
            int heightC = rand.nextInt(200)+1;
            RectanglePro printRectangle = new RectanglePro(widthC, heightC);
            frame.add(printRectangle);
            RectList.add(printRectangle);
        }
    public void MoveTo(JFrame frame)
    {
        int dx = 20;
        int r = MainWindow.getRecList().size();
        for (int i = 0; i < r; i++)
        {
            RectanglePro sampleR = MainWindow.getRecList().get(i);
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
}
