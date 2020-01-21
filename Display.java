import java.awt.Dimension;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import java.awt.*;

public class Display extends Canvas implements Runnable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Thread thread;
    private JFrame frame;
    private static String title = "3D Renderer";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static boolean running = false;

    public Display(){
        this.frame = new JFrame();

        Dimension size = new Dimension(WIDTH, HEIGHT);
        this.frame.setPreferredSize(size);
    }

    public static void main(String[] args) {
        Display display = new Display();
        display.frame.setTitle(title);
        display.frame.add(display);
        display.frame.pack();
        display.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.frame.setLocationRelativeTo(null);
        display.frame.setResizable(false);
        display.frame.setVisible(true);
    }

    public synchronized void start(){
        running = true;
        this.thread = new Thread(this, "Display");
        this.thread.start();
    }
    
    public synchronized void stop(){
        running = false;
        try{
            thread.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }

    }

    @Override
    public void run(){
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final int fps = 60;
        final double ns = 1000000000.0 / fps;
        double delta = 0;
        int frames = 0;


        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                update();
                delta--;
            }
            render();
            frames++;

            //fps display
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                this.frame.setTitle(title + " | " + frames + " fps");
                frames = 0;
            }
        }
        stop();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs ==null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH * 2, HEIGHT * 2);

        g.setColor(Color.RED);
        g.fillRect(50, 100, 200, 200);

        g.dispose();
        bs.show();
    }

    private void update(){

    }
}