import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Renderer implements KeyListener{
    ArrayList<Point3D<Integer>> points;
    Panel panel;
    Vector3<Double> rotation;
    boolean running;
    JFrame frame;
    Point3D<Integer> cameraPos;

    public Renderer(){
        panel = new Panel();
        points = new ArrayList<>();
    }

    public void Run(){
        Init();
        while(running == true){
            Refresh();
        }
        End();
    }

    public void Init(){
        points.add(new Point3D<Integer>(200 , 300, 100));
        points.add(new Point3D<Integer>(100 , 100, 100));
        points.add(new Point3D<Integer>(300 , 100, 100));

        DrawFrame();

        rotation = new Vector3<Double>(0.0,0.0,0.0);
        cameraPos = new Point3D<Integer>(0,0,0);

        running = true;
    }
    public void Refresh(){
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final int fps = 144;
        final double ns = 1000000000.0 / fps;
        double delta = 0;
        int frames = 0;

        while (running == true){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                /*
                points.get(0).x += 0;
                points.get(1).x += 0;
                points.get(2).x += 0;

                points.get(0).y += 0;
                points.get(1).y += 0;
                points.get(2).y += 0;

                points.get(0).z += 0;
                points.get(1).z += 0;
                points.get(2).z += 0;
                */
                RefreshPoints(points.get(0), points.get(1), points.get(2), rotation);
                delta--;   
            }
            //panel.revalidate();
            panel.repaint();          
            //frame.revalidate();
            frame.repaint();    
        }
    }
    public void End(){}

    public void DrawFrame(){
        frame = new JFrame("Renderermath Test");
        frame.addKeyListener(this);
        Dimension size = new Dimension(800,600);
        frame.setPreferredSize(size);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }    

    @Override
    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();
        switch( keyCode ) { 
            case KeyEvent.VK_UP:                
                rotation.z -= Math.toRadians(1.0);
                break;
            case KeyEvent.VK_DOWN:
                rotation.z += Math.toRadians(1.0);
                break;
            case KeyEvent.VK_LEFT:
                rotation.y -= Math.toRadians(1.0);
                break;
            case KeyEvent.VK_RIGHT :
                rotation.y += Math.toRadians(1.0);
                break;
            case KeyEvent.VK_W :
                cameraPos.z += 5;
                break;
            case KeyEvent.VK_S :
                cameraPos.z -= 5;
                break;
            case KeyEvent.VK_A :
                cameraPos.x += 5;
                break;
            case KeyEvent.VK_D :
                cameraPos.x -= 5;
                break;
            case KeyEvent.VK_ESCAPE :
                running = false;
                break;
        }
    }
    @Override
    public void keyTyped(KeyEvent e){}
    @Override
    public void keyReleased(KeyEvent e){}

    

    

    public void RefreshPoints(Point3D<Integer> p1, Point3D<Integer> p2, Point3D<Integer> p3, Vector3<Double> rotation){
        Point2D<Integer> _p1 = MathR.Project3Dto2DInteger(cameraPos, p1, rotation);// new Point2D<Integer>(p1.x,p1.y); //
        Point2D<Integer> _p2 = MathR.Project3Dto2DInteger(cameraPos, p2, rotation);// new Point2D<Integer>(p2.x,p2.y); //
        Point2D<Integer> _p3 = MathR.Project3Dto2DInteger(cameraPos, p3, rotation);// new Point2D<Integer>(p3.x,p3.y); //
        panel.SetTestPoly(_p1, _p2, _p3);
    }
}