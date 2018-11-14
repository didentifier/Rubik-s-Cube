import org.lwjgl.glfw.GLFWVidMode;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.opengl.GL;


public class Main {

    public static void main(String[] args){

        if(!glfwInit()){
            throw new IllegalStateException("Failed to initialize GLFW");

        }

        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);

        long window = glfwCreateWindow(640,480,"Runiks cube test",0,0);

        if(window == 0)
            throw new IllegalStateException("No window created");


        GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());

        glfwSetWindowPos(window, (videoMode.width() - 640)/2, (videoMode.height() - 480) / 2);
        glfwShowWindow(window);
        glfwMakeContextCurrent(window);
        GL.createCapabilities();

        while(!glfwWindowShouldClose(window)) {

            if(glfwGetKey(window, GLFW_KEY_A) == GL_TRUE) {
                System.out.println("A");
            }
            glfwPollEvents();
            glClear(GL_COLOR_BUFFER_BIT);

            glBegin(GL_QUADS);
            glColor4f(1,0,0,0);
            glVertex2f(-0.5f,0.5f);
            glColor4f(0,0,0,0);
            glVertex2f(0.5f,0.5f);
            glColor4f(1,0,1,0);
            glVertex2f(0.5f,-0.5f);
            glColor4f(1,1,0,0);
            glVertex2f(-0.5f,-0.5f);

            glEnd();
            glfwSwapBuffers(window);
        }

        glfwTerminate();

    }

}
