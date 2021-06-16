package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Scanner;

public class Main extends Application
{
    public Main()
    {

    }

    public void init() throws Exception ///This is where timers are going to be running
    {
        System.out.println("This is useful for loading resources before window launches");
    }

    public void start(Stage primaryStage) throws Exception ///FXML PROPERTIES
    {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Debugging Screen");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) ///MAIN METHOD FOR COMMAND PROMPT SHORT CUTS FOR DEBUGGING MODE
    {
        System.out.println("Debugging Screen:");
        System.out.println("Enter corresponding number in the console:");
        System.out.println("[1] Game Screen");
        System.out.println("[2] Logic Terminal Shell");
        Scanner userInput = new Scanner(System.in);
        int lab = userInput.nextInt();

        switch (lab)
        {
            /* LATER FEATURE
                case 0:
                System.exit(0);
                break;
            */
            case 1:
                Application.launch(Game_Screen.class,args);
                userInput.close();
                break;

            case 2:
                Application.launch(gameLogic.class,args);
                userInput.close();
                break;


            default:
                System.out.println("Invalid Entry, exiting...");
                userInput.close();
                break;
        }

        userInput.close();

        launch(args);///This is main selection screen

    }
}
