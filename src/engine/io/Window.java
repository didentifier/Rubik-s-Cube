package engine.io;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;

public class Window {
    private int height , width;
    private String title;
    private long window;

    public Window(int width, int height, String title){
        this.height = height;
        this.width = width;
        this.title = title;
    }

    public void Create(){
        if(!glfwInit()) throw new IllegalStateException("Failed to initialize GLFW");

        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);

         window = glfwCreateWindow(width,height,title,0,0);

        if(window == 0) throw new IllegalStateException("No window created");


        GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());

        glfwSetWindowPos(window, (videoMode.width() - 640)/2, (videoMode.height() - 480) / 2);
        glfwShowWindow(window);
        glfwMakeContextCurrent(window);
        GL.createCapabilities();

    }


    public boolean Closed(){
    return glfwWindowShouldClose(window);

    }

    public void Update(){
        glfwPollEvents();
    }

    public void SwapBuffers(){
        glfwSwapBuffers(window);
    }

}
