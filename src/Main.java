import engine.io.Window;

public class Main {

    public static void main(String[] args){

        Window window = new Window (800,600, "Rubik's Cube");
        window.Create();

        while(!window.Closed()){
            window.Update();
            System.out.println("HEY!");
            window.SwapBuffers();
        }

        }

    }


