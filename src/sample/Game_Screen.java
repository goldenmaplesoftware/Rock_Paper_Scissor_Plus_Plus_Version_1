package sample;
import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.selections.*;
import sample.selections.CPUSelect.*;
import java.io.*;
import java.net.MalformedURLException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;


public class Game_Screen extends Application
{
    MediaPlayer musicplayer;
    MediaPlayer musicplayer2;
    private boolean terminateProcess=true;
    private int counter = 1;
    private Label round = new Label("Round: ");

    public FadeTransition slowFade(Node node, int duration) {
        FadeTransition fade = new FadeTransition(Duration.millis(duration), node);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.setCycleCount(4);
        fade.setAutoReverse(true);
        return fade;
    }

    public FadeTransition slowFadeOut(Node node, int duration) {
        FadeTransition fade = new FadeTransition(Duration.millis(duration), node);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.setCycleCount(2);
        fade.setAutoReverse(true);
        return fade;
    }

    public RotateTransition PlusAnimation(Node node, double angle) {
        RotateTransition rotate = new RotateTransition(Duration.millis(1000), node);
        rotate.setByAngle(angle);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setAutoReverse(true);
        return rotate;
    }


    public ScaleTransition ScaleAnimation(Node node, int duration) {
        ScaleTransition scale = new ScaleTransition(Duration.millis(duration), node);
        scale.setByX(3);
        scale.setByY(2);
        scale.setCycleCount(2);
        scale.setAutoReverse(true);
        return scale;
    }

    public PauseTransition delayFrame(int duration) {
        return new PauseTransition(Duration.millis(1000));
    }

public void music1()
{
    try {
        File file = new File("./resources/gameScreen.mp3");

        Media musicFile = new Media(file.toURI().toURL().toString());
        musicplayer = new MediaPlayer(musicFile);
        musicplayer.setOnEndOfMedia(new Runnable()
        {

            @Override
            public void run()
            {
                musicplayer.seek(Duration.ZERO);
            }
        });
        musicplayer.setAutoPlay(true);
        musicplayer.setVolume(0.5);
    } catch (MalformedURLException e) {
        System.out.println("DOESN'T LOOP FOREVER");
        e.printStackTrace();
    }

}

    public void music2()
    {
        try {

            File file = new File("./resources/gameOverScreen.mp3.mp3");


            Media musicFile = new Media(file.toURI().toURL().toString());

            musicplayer = new MediaPlayer(musicFile);
            musicplayer.setOnEndOfMedia(new Runnable()
            {

                @Override
                public void run()
                {
                    musicplayer.seek(Duration.ONE);
                }
            });
            musicplayer.setAutoPlay(true);
            musicplayer.setVolume(0.5);
        } catch (MalformedURLException e) {
            System.out.println("DOESN'T LOOP FOREVER");
            e.printStackTrace();
        }

    }

    public void music3()
    {
        try {
            File file = new File("./resources/titleScreen.mp3");

            Media musicFile = new Media(file.toURI().toURL().toString());
            musicplayer = new MediaPlayer(musicFile);
            musicplayer.setOnEndOfMedia(new Runnable()
            {

                @Override
                public void run()
                {
                    musicplayer.seek(Duration.ONE);
                }
            });
            musicplayer.setAutoPlay(true);
            musicplayer.setVolume(0.5);
        } catch (MalformedURLException e) {
            System.out.println("DOESN'T LOOP FOREVER");
            e.printStackTrace();
        }

    }


    private boolean screenMusicPlay=false;

    @Override
    public void start(Stage window) throws Exception
    {
        System.out.println(new File(".").getCanonicalFile().toString());
        //////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
//                                          INDEX
//////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////

/**TODO ADD ROUNDS AND GLOBAL EARNINGS INTO THE I/O REPISITORY
 * FURTHER STYLING
 *
 */
        ///THESE ARE WHAT THESE SCREENS POINT TO,  WE CALL SCENES SCREENS IN THIS PROGRAM...

        ///SCREEN 1= MAIN MENU SCREEN
        ///SCREEN 2= STARTS GAME ACTIVITY
        ///SCREEN 3= HIGH SCORES MENU
        ///SCREEN 4= SETTINGS MENU
        ///SCREEN 5= PAUSE SCREEN
        ///SCREEN 6=
        ///SCREEN 7= GAME OVER

        ///SCREEN SET UP
        StackPane screen1 = new StackPane(); ///SCREEN 1 SET UP
        GridPane screen2 = new GridPane();   ///SCREEN 2 SET UP
        BorderPane screen3 = new BorderPane(); ///SCREEN 3 SET UP
        BorderPane screen3_subscreen2 = new BorderPane(); ///SCREEN 3 SUBSCREEN SET UP
        StackPane screen4 = new StackPane(); ///SCREEN 4 SET UP
        StackPane screen5 = new StackPane(); ///SCREEN 5 SET UP
        StackPane screen6 = new StackPane(); ///SCREEN 6 SET UP
        StackPane screen7 = new StackPane(); ///SCREEN 7 SET UP



        ///SCREEN SET UP ALIGNMENTS
        screen1.setAlignment(Pos.CENTER);
        screen2.setAlignment(Pos.CENTER);
        screen4.setAlignment(Pos.CENTER);
        screen7.setAlignment(Pos.CENTER);

        ///SCREEN SET UP DIMENSIONS
        Scene scene = new Scene(screen1, 1280,720);
        Scene scene2 = new Scene(screen2, 1280,720);
        Scene scene3 = new Scene(screen3, 1280,720);
        Scene scene3_sub2 = new Scene(screen3_subscreen2, 1280, 720);
        Scene scene4 = new Scene(screen4, 1280,720);
        Scene scene5 = new Scene(screen5, 1280,720);
        Scene scene6 = new Scene(screen6, 1280,720);
        Scene scene7= new Scene(screen7, 1280,720);

        scene.setCursor(Cursor.CROSSHAIR);
        scene6.setCursor(Cursor.CROSSHAIR);



        ///SCREEN SET UP COLOURS


        screen1.setStyle("-fx-background-color: #00308B;"); ///BACKGROUND COLOR 1
        screen2.setStyle("-fx-background-color: #6f685d;");
        screen3.setStyle("-fx-background-color: orange;"); ///BACKGROUND COLOR 3
        screen3_subscreen2.setStyle("-fx-background-color: #6f685d;");
        screen4.setStyle("-fx-background-color: violet"); ///BACKGROUND COLOR 4
        screen5.setStyle("-fx-background-color: beige"); ///BACKGROUND COLOR 5
        screen6.setStyle("-fx-background-color: orange"); ///BACKGROUND COLOR 5
        screen7.setStyle("-fx-background-color: black"); ///BACKGROUND COLOR 5

        ///INITIALIZED IMAGES

        Image cardEmpty = new Image("file:./resources/nullcard.png");
        Image cardRock = new Image("file:./resources/rockcard.png");
        Image cardPaper = new Image("file:./resources/papercard.png");
        Image cardScissors = new Image("file:./resources/scissorscard.png");
        Image cardWind = new Image("file:./resources/windcard.png");
        Image cardWater = new Image("file:./resources/watercard.png");
        Image cardFire = new Image("file:./resources/firecard.png");
        Image walletID = new Image("file:./resources/bitcoin_address.png");



        ///IMAGE VIEW ON STAGE [DEFAULT] [PLAYER]:
        ImageView imageViewPlayer = new ImageView(cardEmpty);
        ImageView imageViewPlayerRock = new ImageView(cardRock);
        ImageView imageViewPlayerPaper = new ImageView(cardPaper);
        ImageView imageViewPlayerScissors = new ImageView(cardScissors);
        ImageView imageViewPlayerWind = new ImageView(cardWind);
        ImageView imageViewPlayerFire = new ImageView(cardFire);
        ImageView imageViewPlayerWater = new ImageView(cardWater);


        ///IMAGE VIEW ON STAGE [DEFAULT] [CPU]:
        ImageView imageViewCPU = new ImageView(cardEmpty);

        ImageView imageViewCPURock = new ImageView(cardRock);
        ImageView imageViewCPUPaper = new ImageView(cardPaper);
        ImageView imageViewCPUScissors = new ImageView(cardScissors);
        ImageView imageViewCPUWind = new ImageView(cardWind);
        ImageView imageViewCPUFire = new ImageView(cardFire);
        ImageView imageViewCPUWater = new ImageView(cardWater);

        ///WALLET ID
        ImageView imageViewWalletID = new ImageView(walletID);

        ///WALLET ID ORIENTATION:
        imageViewPlayer.setFitHeight(99.1);
        imageViewPlayer.setFitWidth(99.1);


        ///IMAGE PLAYER DEFAULT ORIENTATION:
        imageViewPlayer.setFitHeight(199.1);
        imageViewPlayer.setFitWidth(199.1);


        ///IMAGE PLAYER Rock orientation:
        imageViewPlayerRock.setFitHeight(199.1);
        imageViewPlayerRock.setFitWidth(199.1);

        ///IMAGE PLAYER Paper orientation:
        imageViewPlayerRock.setFitHeight(199.1);
        imageViewPlayerRock.setFitWidth(199.1);

        ///IMAGE PLAYER Scissors orientation:
        imageViewPlayerRock.setFitHeight(199.1);
        imageViewPlayerRock.setFitWidth(199.1);

        ///IMAGE PLAYER FIRE orientation:
        imageViewPlayerFire.setFitHeight(199.1);
        imageViewPlayerFire.setFitWidth(199.1);

        ///IMAGE PLAYER WATER orientation:
        imageViewPlayerWater.setFitHeight(199.1);
        imageViewPlayerWater.setFitWidth(199.1);

        ///IMAGE PLAYER WIND orientation:
        imageViewPlayerWind.setFitHeight(199.1);
        imageViewPlayerWind.setFitWidth(199.1);


        ///IMAGE CPU DEFAULT ORIENTATION:
        imageViewCPU.setFitHeight(199.1);
        imageViewCPU.setFitWidth(199.1);

        ///IMAGE CPU Rock orientation:
        imageViewCPURock.setFitHeight(199.1);
        imageViewCPURock.setFitWidth(199.1);

        ///IMAGE CPU Paper orientation:
        imageViewCPURock.setFitHeight(199.1);
        imageViewCPURock.setFitWidth(199.1);

        ///IMAGE CPU Scissors orientation:
        imageViewCPURock.setFitHeight(199.1);
        imageViewCPURock.setFitWidth(199.1);

        ///IMAGE CPU FIRE orientation:
        imageViewCPUFire.setFitHeight(199.1);
        imageViewCPUFire.setFitWidth(199.1);

        ///IMAGE CPU WATER orientation:
        imageViewCPUWater.setFitHeight(199.1);
        imageViewCPUWater.setFitWidth(199.1);

        ///IMAGE CPU WIND orientation:
        imageViewCPUWind.setFitHeight(199.1);
        imageViewCPUWind.setFitWidth(199.1);




//////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
//                              SCREEN 1 - THE MAIN MENU SCREEN
//////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////

        music3();
        StackPane root = new StackPane();

        Text titleName= new Text("Rock Paper Scissors");
        Text titleNamePlusL= new Text("+");
        Text titleNamePlusR= new Text("+");
        Text authorName= new Text("Golden Maple Software");
        Text authorStudentNumber= new Text("© 2021");






        titleName.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,35));
        titleName.setFill(Color.GOLD);
        titleName.setStroke(Color.BLACK);
        ///StackPane.setAlignment(titleName, Pos.CENTER);

        titleNamePlusL.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,35));
        titleNamePlusL.setFill(Color.GOLD);
        titleNamePlusL.setStroke(Color.BLACK);
        ///StackPane.setAlignment(titleNamePlusL, Pos.CENTER);

        titleNamePlusR.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,35));
        titleNamePlusR.setFill(Color.GOLD);
        titleNamePlusR.setStroke(Color.BLACK);
        ///StackPane.setAlignment(titleNamePlusR, Pos.CENTER);

        authorName.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,25));
        authorName.setFill(Color.RED);
        authorName.setStroke(Color.BLACK);
        ///StackPane.setAlignment(authorName, Pos.BOTTOM_RIGHT);

        authorStudentNumber.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,25));
        authorStudentNumber.setFill(Color.RED);
        authorStudentNumber.setStroke(Color.BLACK);
        ///StackPane.setAlignment(authorStudentNumber, Pos.CENTER);



        ///THIS MOVES THE TITLE NAME
        TranslateTransition movementTitle=new TranslateTransition(Duration.millis(3250),titleName);
        movementTitle.setFromX(-300);
        movementTitle.setFromY(-450);
        movementTitle.setToX(0);
        movementTitle.setToY(-300);


        ///THIS MOVES THE TITLE author name
        TranslateTransition author=new TranslateTransition(Duration.millis(3250),authorName);
        author.setFromX(-200);
        author.setFromY(650);
        author.setToX(-15);
        author.setToY(285);

        ///THIS MOVES THE TITLE author number
        TranslateTransition authorNumber=new TranslateTransition(Duration.millis(3250),authorStudentNumber);
        authorNumber.setFromX(-200);
        authorNumber.setFromY(650);
        authorNumber.setToX(40);
        authorNumber.setToY(315);

        ///LEFT PLUS
        TranslateTransition movementTitlePlusL=new TranslateTransition(Duration.millis(3250),titleNamePlusL);
        movementTitlePlusL.setFromX(-300);
        movementTitlePlusL.setFromY(-450);
        movementTitlePlusL.setToX(190);
        movementTitlePlusL.setToY(-310);

        ///Right PLUS
        TranslateTransition movementTitlePlusR=new TranslateTransition(Duration.millis(3250),titleNamePlusR);
        movementTitlePlusR.setFromX(-300);
        movementTitlePlusR.setFromY(-450);
        movementTitlePlusR.setToX(209);
        movementTitlePlusR.setToY(-310);


        ///WHERE BUTTONS WILL BE PLACED
        Rectangle rectangle = new Rectangle();
        rectangle.setX(250);
        rectangle.setY(405);
        rectangle.setWidth(1290);
        rectangle.setHeight(500);
        rectangle.setFill(Color.DARKBLUE);


        StrokeTransition middleScreen = new StrokeTransition(Duration.millis(5000), rectangle, Color.YELLOW,Color.RED);
        middleScreen.setCycleCount(Animation.INDEFINITE);
        middleScreen.setAutoReverse(true);

        SequentialTransition mainTitleTimeline = new SequentialTransition();

        ParallelTransition plusPlusTimeLine = new ParallelTransition(); ///group 1
        ParallelTransition plusAnimation=new ParallelTransition(); ///group 2
        plusPlusTimeLine.getChildren().addAll(movementTitlePlusL,movementTitlePlusR,author,authorNumber);

        plusAnimation.getChildren().addAll(PlusAnimation(titleNamePlusR,45),PlusAnimation(titleNamePlusL,-45));
        plusPlusTimeLine.play();
        middleScreen.play();
        mainTitleTimeline.getChildren().addAll(movementTitle,ScaleAnimation(authorName,1500),delayFrame(1500),plusAnimation);

        mainTitleTimeline.play();



        ///BUTTON PROPERTIES FOR SCREEN 1

        ///STARTS GAME ACTIVITY WINDOW:
        Button startButton = new Button("START THE GAME");
        startButton.setStyle("-fx-background-color: #002061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;");
        startButton.styleProperty().bind(Bindings.when(startButton.hoverProperty())
                .then("-fx-background-color: #402061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;")
                .otherwise("-fx-background-color: #002061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;"));


        startButton.setOnAction(actionEvent ->
        {
            startButton.setMnemonicParsing(true);
            System.out.println("The Start Button was clicked.");
            startButton.setText("_GOOD LUCK!");
            screenMusicPlay=true;

            music1();

            ///GLOBAL TIMER REINSERT
            window.setScene(scene3); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
        });

        ///HIGH SCORES MENU:
        Button highScoreButton = new Button("HIGH SCORES");
        highScoreButton.setStyle("-fx-background-color: #002061; -fx-font-family:'Gentium Book Basic'; -fx-color:#000000; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;");
        highScoreButton.styleProperty().bind(Bindings.when(highScoreButton.hoverProperty())
                .then("-fx-background-color: #402061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;")
                .otherwise("-fx-background-color: #002061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;"));



        highScoreButton.setOnAction(actionEvent ->
        {
            System.out.println("The HighScores Button was clicked.");
            window.setScene(scene3_sub2);
        });
/*
        ///SETTINGS MENU:
        Button settingsButton = new Button("SETTINGS");
        settingsButton.setStyle("-fx-background-color: #002061; -fx-font-family:'Gentium Book Basic'; -fx-color:#000000; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;");
        settingsButton.styleProperty().bind(Bindings.when(settingsButton.hoverProperty())
                .then("-fx-background-color: #402061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;")
                .otherwise("-fx-background-color: #002061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;"));

        settingsButton.setOnAction(actionEvent ->
        {
            System.out.println("The Settings Button was clicked.");
            window.setScene(scene4);


        });
*/
        ///CREDITS MENU:

        Button creditsButton = new Button("CREDITS");
        creditsButton.setStyle("-fx-background-color: #002061; -fx-font-family:'Gentium Book Basic'; -fx-color:#000000; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;");
        creditsButton.styleProperty().bind(Bindings.when(creditsButton.hoverProperty())
                .then("-fx-background-color: #402061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;")
                .otherwise("-fx-background-color: #002061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;"));
        creditsButton.setOnAction(actionEvent ->
        {
            System.out.println("The Settings Button was clicked.");
            window.setScene(scene6);
        });

        Button exitButton = new Button("EXIT");
        exitButton.setStyle("-fx-background-color: #002061; -fx-font-family:'Gentium Book Basic'; -fx-color:#000000; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;");
        exitButton.styleProperty().bind(Bindings.when(exitButton.hoverProperty())
                .then("-fx-background-color: #402061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;")
                .otherwise("-fx-background-color: #002061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;"));

        exitButton.setOnAction(actionEvent ->
        {
            System.out.println("The Exit Button was clicked.");
            System.exit(1);
        });

        ///BUTTON PROPERTIES:
        VBox buttonView = new VBox(startButton, highScoreButton /*,settingsButton*/,creditsButton, exitButton);
        buttonView.setAlignment(Pos.CENTER);
        buttonView.setSpacing(10);
        buttonView.setPadding(new Insets(10, 10, 10, 10));

        //////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
//                              SCREEN 3 - ENTER NAME AND THE HIGH SCORES MENU
//////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////

        ///ENTER YOUR NAME...

        TextField fileInputName = new TextField();
        fileInputName.setPromptText("Enter your name here");///Prompt text
        fileInputName.setFont(Font.font(18));
        screen3.setCenter(fileInputName);
        File file = new File("highscore.txt");

        String[] randomNameGenerated = {"Elliot","James","Roger","Patrice","Patrick","Mike","Teddy","Mary","Janice","Amy","Peter","Paul","John"};
        Random random = new Random();
        int index = random.nextInt(randomNameGenerated.length);


        Text promptUserTitle = new Text("Enter your name in the text box below");
        promptUserTitle.setFont(Font.font("Cambria", 30.0));
        promptUserTitle.setFill(Color.WHITE);
        promptUserTitle.setStrokeWidth(1.35);
        promptUserTitle.setStroke(Color.RED);
        screen3.setTop(promptUserTitle);

        Text promptUserTitle2 = new Text("Name entered!");
        promptUserTitle2.setFont(Font.font("Cambria", 30.0));
        promptUserTitle2.setFill(Color.WHITE);
        promptUserTitle2.setStrokeWidth(1.35);
        promptUserTitle2.setStroke(Color.RED);




        Text outputNameScreenFromFile = new Text(randomNameGenerated[index]);
        outputNameScreenFromFile.setFont(Font.font("Cambria", 30.0));
        outputNameScreenFromFile.setFill(Color.WHITE);
        outputNameScreenFromFile.setStrokeWidth(1.35);
        outputNameScreenFromFile.setStroke(Color.RED);







        Button goToScoreScreen=new Button("START GAME!");
        goToScoreScreen.setStyle("-fx-background-color: #002061; -fx-font-family:'Gentium Book Basic'; -fx-color:#000000; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;");
        goToScoreScreen.styleProperty().bind(Bindings.when(goToScoreScreen.hoverProperty())
                .then("-fx-background-color: #402061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;")
                .otherwise("-fx-background-color: #002061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;"));

        goToScoreScreen.setOnAction(actionEvent ->
        {
            window.setScene(scene2);
        });

        screen3.setBottom(goToScoreScreen);

        fileInputName.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->
        {

            if (key.getCode() == KeyCode.ENTER) ///WRITES THE HIGHSCORE WHEN PRESSED
            {
                ///THIS DISPLAYS THE ENTERED ENTRIES TO THE SCREEN
                System.out.println("Number entered in text field");
                System.out.println("Written to the screen");
                outputNameScreenFromFile.setText(fileInputName.getText());
                ///outputScreenFromFile.setText(fileInput.getText());
                screen3.setTop(promptUserTitle2);
                BufferedWriter bw=null;
                FileWriter fw = null;
                PrintWriter pw = null;

                try
                {
                    if (!file.exists())
                    {
                        System.out.println("ERROR DOESN'T EXIST");
                    }

                    fw = new FileWriter(file,true);
                    System.out.println("File written Successfully");
                    pw = new PrintWriter(fw);
                    pw.write( "ENTRY PLAYER: "+fileInputName.getText().toString()+"\n");
                    pw.close();
                    fw.close();

                }

                catch (IOException e)
                {
                    e.printStackTrace();
                }


            }

        });


///////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                              SCREEN 2 - THE GAME SCREEN
///////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///TITLE

        ///THESE ARE THE CONDITIONS OF THE GAME THAT IT HAS TO ABIDE BY FOR ROUND MECHANIC AND LOOPING MECHANIC

        int count; ///FOR LOOP COUNTER
        int userWins = 0, cpuWins = 0, ties = 0;


        AtomicBoolean userWon = new AtomicBoolean(false);
        AtomicBoolean cpuWon = new AtomicBoolean(false);
        AtomicBoolean tied = new AtomicBoolean(false);

/*

       boolean gameEndingRound = true; ///This will keep game looping until limit is reached
        double bankAccountGlobal = 0;
        double bankAccountGlobalFinal = 0;
        boolean GAMEOVER = false;

        AtomicInteger bankAccount = new AtomicInteger();
        AtomicInteger rounds = new AtomicInteger();
        System.out.println("BANK ACCOUNT $ " + bankAccount);

        Timer moneyEarntimer = new Timer();
        TimerTask task = new TimerTask() {
            int i = 10;

            @Override
            public void run() {
                if (i > 0) {
                    System.out.println(i);
                    i--;
                }

                if (i == 0) {
                    bankAccount.addAndGet(1);
                    System.out.println("TOTAL BANK ACCOUNT $ " + bankAccount);
                }
                if (i == 0) {
                    moneyEarntimer.cancel();
                }
            }

        };

            moneyEarntimer.scheduleAtFixedRate(task, 0, 1000);
*/


                Text playerNameTitle = new Text("Player Name");
                playerNameTitle.setFont(Font.font("Cambria", 30.0));
                playerNameTitle.setFill(Color.WHITE);
                playerNameTitle.setStrokeWidth(1.35);
                playerNameTitle.setStroke(Color.BLUE);
                ///SUBTITLE TO ENTER
                TextField playerName = new TextField();
                String playerNameDisplayed = playerName.getText();

                Button nameEntry = new Button();
                nameEntry.setText("Submit");
                nameEntry.setOnAction(actionEvent ->
                {
                    System.out.println("Player Name that was entered:" + playerName.getText());


                });

                ///CPU SELECT PLACEHOLDER TEXT
                ///Text CPUSELECT = new Text("THE PLAYER:"+ "\nTHE CPU:");
                ////CPUSELECT.setFont(Font.font("Cambria", 20.0));
                ////CPUSELECT.setFill(Color.WHITE);
                //// CPUSELECT.setStrokeWidth(1.35);
                ////CPUSELECT.setStroke(Color.RED);

                ///PLAYER LIST OPTION KEYS DENOTED BOX
                ////VBox cpuView = new VBox(CPUSELECT);
                ///cpuView.setAlignment(Pos.BOTTOM_RIGHT);
                ///cpuView.setPadding(new Insets(50, 80, 50, 10));
                ////screen2.addRow(5, cpuView);

                ///WINNING LOSING TITLE PROPERTIES
                String roundScreenDisplay="PLAYER -- RESULT!" + "\nCPU -- RESULT!";  /// IF CPU -- WON
                Text timerTitle = new Text(roundScreenDisplay);
                timerTitle.setFont(Font.font("Cambria", 30.0));
                timerTitle.setFill(Color.WHITE);
                timerTitle.setStrokeWidth(1.35);
                timerTitle.setStroke(Color.YELLOW);

                ///ROUND SUBTITLE PLACEHOLDER
                AtomicBoolean playerRoundInc= new AtomicBoolean(false); ///THIS CONTROLS WHEN ROUNDS INCREASE OR DECREASE
                ///CONVERT STRING TO INT
                String roundScreen="1";
                int roundScreenCount= Integer.parseInt(roundScreen);
/*
                ///CONVERT INT TO STRING
                AtomicInteger roundScreenStart= new AtomicInteger(1);
                String roundScreenDisplay=String.valueOf(roundScreenStart.get());
*/



                Text timerTitlePlace = new Text("");
                timerTitlePlace.setFont(Font.font("Cambria", 30.0));
                timerTitlePlace.setFill(Color.WHITE);
                timerTitlePlace.setStrokeWidth(1.35);
                timerTitlePlace.setStroke(Color.BLUE);



                ///CPU TITLE
                Text CPUTitle = new Text("CPU");
                CPUTitle.setFont(Font.font("Cambria", 30.0));
                CPUTitle.setFill(Color.WHITE);
                CPUTitle.setStrokeWidth(1.35);
                CPUTitle.setStroke(Color.RED);


                ///CPU SUBTITLE
                Text CPUSubTitle = new Text("VARIANT 1"); ///CAN ONLY BE 11 CHAR LONG
                CPUSubTitle.setFont(Font.font("Cambria", 30.0));
                CPUSubTitle.setFill(Color.WHITE);
                CPUSubTitle.setStrokeWidth(1.35);
                CPUSubTitle.setStroke(Color.RED);

                ///LIST OF OPTIONS SUBTITLE 1
                Text optionsPlayerStandard = new Text("[1]-ROCK\n" + "[2]-PAPER\n" + "[3]-SCISSORS\n");
                optionsPlayerStandard.setFont(Font.font("Cambria", 20.0));
                optionsPlayerStandard.setFill(Color.WHITE);
                optionsPlayerStandard.setStrokeWidth(1.35);
                optionsPlayerStandard.setStroke(Color.INDIANRED);

                ///LIST OF OPTIONS SUBTITLE 2
                Text optionsPlayerElemental = new Text("[4]-WATER\n" + "[5]-FIRE\n" + "[6]-WIND\n");
                optionsPlayerElemental.setFont(Font.font("Cambria", 20.0));
                optionsPlayerElemental.setFill(Color.WHITE);
                optionsPlayerElemental.setStrokeWidth(1.35);
                optionsPlayerElemental.setStroke(Color.INDIANRED);

                ///BANK ACCOUNT FUNCTION TEXT
                Text titleBankAccount = new Text("BANK ACCOUNT $");
                titleBankAccount.setFont(Font.font("Cambria", 20.0));
                titleBankAccount.setFill(Color.WHITE);
                titleBankAccount.setStrokeWidth(1.35);
                titleBankAccount.setStroke(Color.GOLD);

                ///BANK ACCOUNT NUMBER PLACEHOLDER TEXT
                Text BankAccount = new Text("0.00");
                BankAccount.setFont(Font.font("Cambria", 20.0));
                BankAccount.setFill(Color.WHITE);
                BankAccount.setStrokeWidth(1.35);
                BankAccount.setStroke(Color.GOLD);

                ///BANK ACCOUNT WAGER TEXT
                Text titleBankAccountWager = new Text("WAGER: $");
                titleBankAccountWager.setFont(Font.font("Cambria", 20.0));
                titleBankAccountWager.setFill(Color.WHITE);
                titleBankAccountWager.setStrokeWidth(1.35);
                titleBankAccountWager.setStroke(Color.RED);

                ///BANK ACCOUNT NUMBER PLACEHOLDER TEXT
                Text BankAccountWager = new Text("0.00");
                BankAccountWager.setFont(Font.font("Cambria", 20.0));
                BankAccountWager.setFill(Color.WHITE);
                BankAccountWager.setStrokeWidth(1.35);
                BankAccountWager.setStroke(Color.RED);

                ///LIST OF OPTIONS SUBTITLE 3
                Text optionsPlayerSCROLL = new Text("[↑]-INCREASE INCREMENT\n" + "[↓]-DECREASE INCREMENT\n");
                optionsPlayerSCROLL.setFont(Font.font("Cambria", 20.0));
                optionsPlayerSCROLL.setFill(Color.WHITE);
                optionsPlayerSCROLL.setStrokeWidth(1.35);
                optionsPlayerSCROLL.setStroke(Color.INDIANRED);

                ///PLAYER NAME BOX
                VBox playerViewName = new VBox(playerNameTitle,outputNameScreenFromFile);////playerName,nameEntry);
                playerViewName.setAlignment(Pos.TOP_LEFT);
                playerViewName.setSpacing(10);
                playerViewName.setPadding(new Insets(10, 10, 10, 55));
                screen2.addRow(0, playerViewName);

                ///RESULT BOX
                VBox timerViewName = new VBox(timerTitle, timerTitlePlace);
                timerViewName.setAlignment(Pos.BASELINE_CENTER);
                timerViewName.setSpacing(10);
                timerViewName.setPadding(new Insets(10, 10, 10, 25));
                screen2.addRow(0, timerViewName);


                ///ROUND BOX:
                VBox ROUNDName = new VBox(round);
                ROUNDName.setAlignment(Pos.BOTTOM_RIGHT);
                ROUNDName.setPadding(new Insets(-100, -150, -240, 155));

                round.setText("Round:" + "\n" + counter);
                round.setFont(Font.font("Cambria", 30.0));
                screen2.addRow(0, ROUNDName);


                ///CPU NAME BOX
                VBox CPUviewName = new VBox(CPUTitle, CPUSubTitle);
                CPUviewName.setAlignment(Pos.TOP_RIGHT);
                CPUviewName.setPadding(new Insets(10, 10, 10, 15));
                screen2.addRow(0, CPUviewName);


                ///PLAYER LIST OPTION KEYS DENOTED BOX
                HBox playerView = new HBox(optionsPlayerStandard, optionsPlayerElemental);
                playerView.setAlignment(Pos.BOTTOM_LEFT);
                playerView.setSpacing(10);
                playerView.setPadding(new Insets(10, 10, 10, 25));
                screen2.addRow(5, playerView);

                ///PLAYER LIST OPTION KEYS DENOTED BOX
                VBox playerView2 = new VBox(titleBankAccount, BankAccount, titleBankAccountWager, BankAccountWager, optionsPlayerSCROLL);
                playerView2.setAlignment(Pos.BOTTOM_CENTER);
                playerView2.setPadding(new Insets(190, 10, 10, 10));
                screen2.addRow(5, playerView2);


                ///PLAYER CARDS
                HBox PLAYERCard = new HBox(imageViewPlayer);
                PLAYERCard.setSpacing(125);
                PLAYERCard.setAlignment(Pos.CENTER);
                PLAYERCard.setPadding(new Insets(130, 10, 10, 10));
                screen2.getChildren().add(PLAYERCard);

///WAGERING EVENTS CONTROLLED BY THE PLAYER

        AtomicReference<Double> bankAccountTitle= new AtomicReference<>(10.00);
        AtomicInteger wagerIncrement=new AtomicInteger();
        AtomicReference<Double> bankAccountTitleWager= new AtomicReference<>(0.00);

        boolean gameEndingRound = true; ///This will keep game looping until limit is reached
        double bankAccountGlobal = 0;
        double bankAccountGlobalFinal = 0;
        boolean GAMEOVER = false;


        AtomicInteger rounds = new AtomicInteger();
        BankAccountWager.setText(String.valueOf(bankAccountTitleWager.get()));
        System.out.println("WAGER AMOUNT $ " + BankAccountWager.getText().toString());

        BankAccount.setText(String.valueOf(bankAccountTitle.get()));
        System.out.println("BANK ACCOUNT $ " + BankAccount.getText().toString());

        System.out.println("\n************\n"+"GAME STATISTICS"+"\n************\n" + "\nRound:" + rounds +"\nBank Account:$"+"\nEntire Games Earnings:$"+bankAccountGlobalFinal + "\nCPU Won:" + cpuWins + "\nPlayer Won:" + userWins + "\nTies:" + ties );

    /*
        outputNameScreenFromFile.setText(wagerInputName.getText());

        */


        scene2.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->
        {
            if (key.getCode() == KeyCode.UP) {
                if (bankAccountTitle.get() >= 1)
                {
                    wagerIncrement.getAndAdd(2);
                    BankAccountWager.setText(String.valueOf(wagerIncrement));
                    ///BankAccountWager.setText(String.valueOf(bankAccountTitle.get()-wagerIncrement.get()));
                    System.out.println("WAGER AMOUNT $ " + BankAccountWager.getText().toString());
                    ///BankAccount.setText(String.valueOf(bankAccountTitle.get()-wagerIncrement.get()));
                    ///System.out.println("BANK ACCOUNT $ " + BankAccount.getText().toString());

                }
            }
        });



        scene2.addEventHandler(KeyEvent.KEY_RELEASED, (key) ->
        {
            if (key.getCode() == KeyCode.UP) {
                System.out.println("You pressed released +");

            }
        });


        scene2.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->
        {
            if (key.getCode() == KeyCode.DOWN)
            {
                System.out.println("You pressed released -");
                wagerIncrement.getAndAdd(-2);
                BankAccountWager.setText(String.valueOf(wagerIncrement));

            }
        });

        scene2.addEventHandler(KeyEvent.KEY_RELEASED, (key) ->
        {
            if (key.getCode() == KeyCode.DOWN) {
                System.out.println("You pressed released -");
            }
        });













            /*
            cpu_var_1 variant1=new cpu_var_1();
            rock variant3=new rock();
            System.out.println("Comparing objects cpu1 and player1 = " + variant1.equals(variant3));
            int player1=variant3.hashCode();
           */

                ///PLACE THIS WITH IN A TIMER THAT LOOPS!
/*
            cpu_var_1 variant1=new cpu_var_1();
            int cpuSelectionRock_Round_1=variant1.hashCode(); ///Distinct Code
*/

                AtomicInteger playerSelected = new AtomicInteger(); ///THIS IS THE PLAYER SELECTION TO COMPARE
                AtomicInteger cpuSelected = new AtomicInteger();

                ///CPU CARDS
                VBox CPUCard = new VBox(imageViewCPU);
                CPUCard.setAlignment(Pos.CENTER);
                CPUCard.setPadding(new Insets(-130, -880, -250, 10));
                screen2.getChildren().add(CPUCard);

                AtomicBoolean playerSelection= new AtomicBoolean(false);

                int max = 7;
                int min = 1;
                Random CPUselection_RAND= new Random();

        do
                { //TODO UPDATE THE LOOP FOR ROUND ITTERATION AND FOR BETTING SYSTEM TO WORK
                    ///RunnableCPU CPU_1 = new RunnableCPU("CPU 1");
                    ///CPU_1.thread2.start();
                int CPU= CPUselection_RAND.nextInt(max - min) + min;
                switch (CPU) // THIS IS THE INITAL DRAW OF THE CPU TO COMPARE WITH THE PLAYER, THIS NEEDS TO HAPPEN...
                {
                    case 1 -> {
                        cpuSelectRock();
                        System.out.println("test " + cpuSelected);
                        cpuSelected.set(1);
                        screen2.getChildren().remove(CPUCard);
                        VBox CPUCard1 = new VBox(imageViewCPURock);
                        CPUCard1.setSpacing(125);
                        CPUCard1.setAlignment(Pos.CENTER);
                        CPUCard1.setPadding(new Insets(-130, -880, -250, 10));
                        screen2.getChildren().add(CPUCard1);

                    }
                    case 2 -> {
                        cpuSelectPaper();
                        System.out.println("test " + cpuSelected);
                        cpuSelected.set(2);
                        screen2.getChildren().remove(CPUCard);
                        VBox CPUCard2 = new VBox(imageViewCPUPaper);
                        CPUCard2.setSpacing(125);
                        CPUCard2.setAlignment(Pos.CENTER);
                        CPUCard2.setPadding(new Insets(-130, -880, -250, 10));
                        screen2.getChildren().add(CPUCard2);
                    }
                    case 3 -> {
                        cpuSelectScissors();
                        System.out.println("test " + cpuSelected);
                        cpuSelected.set(3);
                        screen2.getChildren().remove(CPUCard);
                        VBox CPUCard3 = new VBox(imageViewCPUScissors);
                        CPUCard3.setSpacing(125);
                        CPUCard3.setAlignment(Pos.CENTER);
                        CPUCard3.setPadding(new Insets(-130, -880, -250, 10));
                        screen2.getChildren().add(CPUCard3);
                    }
                    case 4 -> {
                        cpuSelectWater();
                        System.out.println("test " + cpuSelected);
                        cpuSelected.set(4);
                        screen2.getChildren().remove(CPUCard);
                        VBox CPUCard4 = new VBox(imageViewCPUWater);
                        CPUCard4.setSpacing(125);
                        CPUCard4.setAlignment(Pos.CENTER);
                        CPUCard4.setPadding(new Insets(-130, -880, -250, 10));
                        screen2.getChildren().add(CPUCard4);
                    }
                    case 5 -> {
                        cpuSelectFire();
                        System.out.println("test " + cpuSelected);
                        cpuSelected.set(5);
                        screen2.getChildren().remove(CPUCard);
                        VBox CPUCard5 = new VBox(imageViewCPUFire);
                        CPUCard5.setSpacing(125);
                        CPUCard5.setAlignment(Pos.CENTER);
                        CPUCard5.setPadding(new Insets(-130, -880, -250, 10));
                        screen2.getChildren().add(CPUCard5);
                    }
                    case 6 -> {
                        cpuSelectWind();
                        System.out.println("test " + cpuSelected);
                        cpuSelected.set(6);
                        screen2.getChildren().remove(CPUCard);
                        VBox CPUCard6 = new VBox(imageViewCPUWind);
                        CPUCard6.setSpacing(125);
                        CPUCard6.setAlignment(Pos.CENTER);
                        CPUCard6.setPadding(new Insets(-130, -880, -250, 10));
                        screen2.getChildren().add(CPUCard6);
                    }
                }
            } while (playerSelection.get());

                playerSelection.set(false);


                ///PLAYER CONTROLS TO SELECT ON TOP PART KEYBOARD
                scene2.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->
                {


                    if (key.getCode() == KeyCode.DIGIT1) ///FETCHES PLAYER ROCK OBJECT
                    {
                        selectRock(); ///PLAYER SELECTED ROCK OBJECT
                        playerSelected.set(1);

                        System.out.println("You pressed " + playerSelected);
                        screen2.getChildren().remove(PLAYERCard);

                        HBox PLAYERCard1 = new HBox(imageViewPlayerRock);
                        PLAYERCard1.setSpacing(125);
                        PLAYERCard1.setAlignment(Pos.CENTER);
                        PLAYERCard1.setPadding(new Insets(130, 10, 10, 10));
                        screen2.getChildren().add(PLAYERCard1);

                    }
                });

                int finalCpuSelected = cpuSelected.get();
                scene2.addEventHandler(KeyEvent.KEY_RELEASED, (key) ->
                {
                    if (key.getCode() == KeyCode.DIGIT1) {
                        System.out.println("You released " + playerSelected);
                        System.out.println("PLAYER SELECTED " + playerSelected.get());

                        ///THIS IS A DUPLICATE OF CPU CONDITION TO UPDATE WHEN THE PLAYER SELECTS IN THE LOOP!



                        int CPU= CPUselection_RAND.nextInt(max - min) + min;
                        switch (CPU)
                        {
                            case 1 -> {
                                cpuSelectRock();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(1);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard1 = new VBox(imageViewCPURock);
                                CPUCard1.setSpacing(125);
                                CPUCard1.setAlignment(Pos.CENTER);
                                CPUCard1.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard1);

                            }
                            case 2 -> {
                                cpuSelectPaper();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(2);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard2 = new VBox(imageViewCPUPaper);
                                CPUCard2.setSpacing(125);
                                CPUCard2.setAlignment(Pos.CENTER);
                                CPUCard2.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard2);
                            }
                            case 3 -> {
                                cpuSelectScissors();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(3);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard3 = new VBox(imageViewCPUScissors);
                                CPUCard3.setSpacing(125);
                                CPUCard3.setAlignment(Pos.CENTER);
                                CPUCard3.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard3);
                            }
                            case 4 -> {
                                cpuSelectWater();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(4);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard4 = new VBox(imageViewCPUWater);
                                CPUCard4.setSpacing(125);
                                CPUCard4.setAlignment(Pos.CENTER);
                                CPUCard4.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard4);
                            }
                            case 5 -> {
                                cpuSelectFire();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(5);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard5 = new VBox(imageViewCPUFire);
                                CPUCard5.setSpacing(125);
                                CPUCard5.setAlignment(Pos.CENTER);
                                CPUCard5.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard5);
                            }
                            case 6 -> {
                                cpuSelectWind();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(6);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard6 = new VBox(imageViewCPUWind);
                                CPUCard6.setSpacing(125);
                                CPUCard6.setAlignment(Pos.CENTER);
                                CPUCard6.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard6);
                            }
                        }

                        ///THIS COMPARES WHAT BOTH SELECTED

                        System.out.println(" COND CHECK PLAYER"+ playerSelection.get());
                        System.out.println(" COND CHECK CPU"+ cpuSelected.get());


                        ///THIS IS THE CONDITIONAL THE LOGIC OF THE GAME IS BASED ON TITLE AND BETTING WISE
                        if(!playerSelection.get() && cpuSelected.get()==1)
                        {
                            ///BankAccount.setText(String.valueOf(bankAccountTitle.get()));
                            String roundScreenDisplay3= "PLAYER TIED!";
                            timerTitle.setText(roundScreenDisplay3);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            System.out.println(BankAccount.getText());
                            System.out.println(" COND CHECK BANK"+ bankAccountTitle.get());
                            System.out.println(bankAccountTitle.get());

                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }

                        }

                        if(!playerSelection.get() && cpuSelected.get()==2)
                        {
                            BankAccount.setText(String.valueOf(bankAccountTitle.get()-wagerIncrement.get()));
                            bankAccountTitle.getAndSet(bankAccountTitle.get()-wagerIncrement.get());
                            String roundScreenDisplay3= "PLAYER LOST!";
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            System.out.println(BankAccount.getText());
                            System.out.println(bankAccountTitle.get());

                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }

                        }


                        if(!playerSelection.get() && cpuSelected.get()==3)
                        {
                            BankAccount.setText(String.valueOf(bankAccountTitle.get()+wagerIncrement.get()));
                            bankAccountTitle.getAndSet(bankAccountTitle.get()+wagerIncrement.get());
                            String roundScreenDisplay3= "PLAYER WON!";
                            timerTitle.setText(roundScreenDisplay3);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            System.out.println(BankAccount.getText());
                            System.out.println(bankAccountTitle.get());

                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }
                        }

                        if(!playerSelection.get() && cpuSelected.get()==4)
                        {
                            ///BankAccount.setText(String.valueOf(bankAccountTitle.get()));
                            String roundScreenDisplay3= "PLAYER TIED!";
                            timerTitle.setText(roundScreenDisplay3);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            System.out.println(BankAccount.getText());
                            System.out.println(bankAccountTitle.get());

                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }
                        }

                        if(!playerSelection.get() && cpuSelected.get()==5)
                        {
                            ///BankAccount.setText(String.valueOf(bankAccountTitle.get()));
                            String roundScreenDisplay3= "PLAYER TIED!";
                            timerTitle.setText(roundScreenDisplay3);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            System.out.println(BankAccount.getText());
                            System.out.println(bankAccountTitle.get());

                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }
                        }

                        if(!playerSelection.get() && cpuSelected.get()==6)
                        {
                            ///BankAccount.setText(String.valueOf(bankAccountTitle.get()));
                            String roundScreenDisplay3= "PLAYER TIED!";
                            timerTitle.setText(roundScreenDisplay3);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            System.out.println(BankAccount.getText());
                            System.out.println(bankAccountTitle.get());

                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }
                        }



                        round.setText("Round:" + "\n" + counter);
                        counter();
                        round.setFont(Font.font("Cambria", 30.0));
                        ROUNDName.getChildren().add(round);



                    }


                        if (playerSelected.get() == 1 && finalCpuSelected == 1) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            tied.set(true);
                            System.out.println("YOU SELECTED ROCK" + " CPU SELECTED ROCK" + " \nPLAYER LOST!");
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);

                        }

                        else if (playerSelected.get() == 1 && finalCpuSelected == 2) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            cpuWon.set(true);
                            System.out.println("YOU SELECTED ROCK" + " CPU SELECTED PAPER" + " \nPLAYER LOST!");
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                        }

                        else if (playerSelected.get() == 1 && finalCpuSelected == 3) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            userWon.set(true);
                            System.out.println("YOU SELECTED ROCK" + " CPU SELECTED SCISSORS" + " \nPLAYER LOST!");
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                        }

                        else if (playerSelected.get() == 1 && finalCpuSelected == 4) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            tied.set(true);
                            System.out.println("YOU SELECTED ROCK" + " CPU SELECTED FIRE" + " \nPLAYER LOST!");
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                        }

                        else if (playerSelected.get() == 1 && finalCpuSelected == 5) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            tied.set(true);
                            System.out.println("YOU SELECTED ROCK" + " CPU SELECTED WATER" + " \nPLAYER LOST!");
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                        }

                        else if (playerSelected.get() == 1 && finalCpuSelected == 6) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            tied.set(true);
                            System.out.println("YOU SELECTED ROCK" + " CPU SELECTED WIND" + " \nPLAYER LOST!");
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                        }


                });

                scene2.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> ///FETCHES PLAYER PAPER OBJECT
                {
                    if (key.getCode() == KeyCode.DIGIT2) {
                        selectPaper(); ///SELECTED PAPER OBJECT

                        playerSelected.set(2);
                        System.out.println("You pressed " + playerSelected);

                        screen2.getChildren().remove(PLAYERCard);
                        HBox PLAYERCard2 = new HBox(imageViewPlayerPaper);
                        PLAYERCard2.setSpacing(125);
                        PLAYERCard2.setAlignment(Pos.CENTER);
                        PLAYERCard2.setPadding(new Insets(130, 10, 10, 10));
                        screen2.getChildren().add(PLAYERCard2);
                    }
                });

                scene2.addEventHandler(KeyEvent.KEY_RELEASED, (key) ->
                {
                    if (key.getCode() == KeyCode.DIGIT2) {
                        System.out.println("You released " + playerSelected);


                        ///THIS IS A DUPLICATE OF CPU CONDITION TO UPDATE WHEN THE PLAYER SELECTS IN THE LOOP!
                        int CPU= CPUselection_RAND.nextInt(max - min) + min;

                        switch (CPU) ///debugging conditional release
                        {
                            case 1 -> {
                                cpuSelectRock();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(1);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard1 = new VBox(imageViewCPURock);
                                CPUCard1.setSpacing(125);
                                CPUCard1.setAlignment(Pos.CENTER);
                                CPUCard1.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard1);

                            }
                            case 2 -> {
                                cpuSelectPaper();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(2);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard2 = new VBox(imageViewCPUPaper);
                                CPUCard2.setSpacing(125);
                                CPUCard2.setAlignment(Pos.CENTER);
                                CPUCard2.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard2);
                            }
                            case 3 -> {
                                cpuSelectScissors();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(3);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard3 = new VBox(imageViewCPUScissors);
                                CPUCard3.setSpacing(125);
                                CPUCard3.setAlignment(Pos.CENTER);
                                CPUCard3.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard3);
                            }
                            case 4 -> {
                                cpuSelectWater();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(4);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard4 = new VBox(imageViewCPUWater);
                                CPUCard4.setSpacing(125);
                                CPUCard4.setAlignment(Pos.CENTER);
                                CPUCard4.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard4);
                            }
                            case 5 -> {
                                cpuSelectFire();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(5);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard5 = new VBox(imageViewCPUFire);
                                CPUCard5.setSpacing(125);
                                CPUCard5.setAlignment(Pos.CENTER);
                                CPUCard5.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard5);
                            }
                            case 6 -> {
                                cpuSelectWind();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(6);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard6 = new VBox(imageViewCPUWind);
                                CPUCard6.setSpacing(125);
                                CPUCard6.setAlignment(Pos.CENTER);
                                CPUCard6.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard6);
                            }
                        }


                        ///THIS COMPARES WHAT BOTH SELECTED

                        System.out.println(" COND CHECK PLAYER"+ playerSelection.get());
                        System.out.println(" COND CHECK CPU"+ cpuSelected.get());

                        ///THIS IS THE CONDITIONAL THE LOGIC OF THE GAME IS BASED ON TITLE AND BETTING WISE
                        if(!playerSelection.get() && cpuSelected.get()==1)
                        {

                            BankAccount.setText(String.valueOf(bankAccountTitle.get()+wagerIncrement.get()));
                            bankAccountTitle.getAndSet(bankAccountTitle.get()+wagerIncrement.get());
                            String roundScreenDisplay3= "PLAYER WON!";

                            timerTitle.setText(roundScreenDisplay3);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }
                        }

                        if(!playerSelection.get() && cpuSelected.get()==2)
                        {
                            String roundScreenDisplay3= "PLAYER TIED!";
                            timerTitle.setText(roundScreenDisplay3);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }
                        }


                        if(!playerSelection.get() && cpuSelected.get()==3)
                        {
                            BankAccount.setText(String.valueOf(bankAccountTitle.get()-wagerIncrement.get()));
                            bankAccountTitle.getAndSet(bankAccountTitle.get()-wagerIncrement.get());
                            String roundScreenDisplay3= "PLAYER LOST!";
                            timerTitle.setText(roundScreenDisplay3);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }
                        }

                        if(!playerSelection.get() && cpuSelected.get()==4)
                        {
                            BankAccount.setText(String.valueOf(bankAccountTitle.get()-wagerIncrement.get()));
                            bankAccountTitle.getAndSet(bankAccountTitle.get()-wagerIncrement.get());
                            String roundScreenDisplay3= "PLAYER LOST!";;
                            timerTitle.setText(roundScreenDisplay3);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }
                        }

                        if(!playerSelection.get() && cpuSelected.get()==5)
                        {
                            BankAccount.setText(String.valueOf(bankAccountTitle.get()-wagerIncrement.get()));
                            bankAccountTitle.getAndSet(bankAccountTitle.get()-wagerIncrement.get());
                            String roundScreenDisplay3= "PLAYER LOST!";;
                            timerTitle.setText(roundScreenDisplay3);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }
                        }

                        if(!playerSelection.get() && cpuSelected.get()==6)
                        {
                            BankAccount.setText(String.valueOf(bankAccountTitle.get()-wagerIncrement.get()));
                            bankAccountTitle.getAndSet(bankAccountTitle.get()-wagerIncrement.get());
                            String roundScreenDisplay3= "PLAYER LOST!";;
                            timerTitle.setText(roundScreenDisplay3);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }
                        }


                        if (playerSelected.get() == 2 && finalCpuSelected == 1) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            userWon.set(true);
                            System.out.println("YOU SELECTED PAPER" + " CPU SELECTED ROCK" + " \nPLAYER WON!");
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                        } else if (playerSelected.get() == 2 && finalCpuSelected == 2) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            tied.set(true);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            System.out.println("YOU BOTH SELECTED PAPER3" + " \nPLAYER AND CPU ARE TIED!");
                        } else if (playerSelected.get() == 2 && finalCpuSelected == 3) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            cpuWon.set(true);
                            System.out.println("YOU SELECTED PAPER" + " CPU SELECTED SCISSORS" + " \nPLAYER LOST!");
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                        } else if (playerSelected.get() == 2 && finalCpuSelected == 4) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            cpuWon.set(true);
                            System.out.println("YOU SELECTED PAPER" + " CPU SELECTED WATER" + " \nPLAYER LOST!");
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                        } else if (playerSelected.get() == 2 && finalCpuSelected == 5) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            cpuWon.set(true);
                            System.out.println("YOU SELECTED PAPER" + " CPU SELECTED FIRE" + " \nPLAYER LOST!");
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                        } else if (playerSelected.get() == 2 && finalCpuSelected == 6) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            cpuWon.set(true);
                            System.out.println("YOU SELECTED PAPER" + " CPU SELECTED WIND" + " \nPLAYER LOST!");
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                        }

                        ///ROUNDS MUST COME BEFORE PLAYER CONDITIONALS WITH CPU!!!
                        round.setText("Round:" + "\n" + counter);
                        counter();
                        round.setFont(Font.font("Cambria", 30.0));
                        ROUNDName.getChildren().add(round);

                    }
                });

                scene2.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->
                {
                    if (key.getCode() == KeyCode.DIGIT3) {
                        selectScissors(); ///SELECTED SCISSORS OBJECT

                        playerSelected.set(3);
                        System.out.println("You pressed " + playerSelected);


                        screen2.getChildren().remove(PLAYERCard);
                        HBox PLAYERCard3 = new HBox(imageViewPlayerScissors);
                        PLAYERCard3.setSpacing(125);
                        PLAYERCard3.setAlignment(Pos.CENTER);
                        PLAYERCard3.setPadding(new Insets(130, 10, 10, 10));
                        screen2.getChildren().add(PLAYERCard3);

                    }
                });

                scene2.addEventHandler(KeyEvent.KEY_RELEASED, (key) ->
                {
                    if (key.getCode() == KeyCode.DIGIT3) {
                        System.out.println("You released " + playerSelected);

                        ///THIS IS A DUPLICATE OF CPU CONDITION TO UPDATE WHEN THE PLAYER SELECTS IN THE LOOP!
                        int CPU= CPUselection_RAND.nextInt(max - min) + min;

                        switch (CPU) ///debugging conditional release
                        {
                            case 1 -> {
                                cpuSelectRock();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(1);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard1 = new VBox(imageViewCPURock);
                                CPUCard1.setSpacing(125);
                                CPUCard1.setAlignment(Pos.CENTER);
                                CPUCard1.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard1);

                            }
                            case 2 -> {
                                cpuSelectPaper();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(2);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard2 = new VBox(imageViewCPUPaper);
                                CPUCard2.setSpacing(125);
                                CPUCard2.setAlignment(Pos.CENTER);
                                CPUCard2.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard2);
                            }
                            case 3 -> {
                                cpuSelectScissors();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(3);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard3 = new VBox(imageViewCPUScissors);
                                CPUCard3.setSpacing(125);
                                CPUCard3.setAlignment(Pos.CENTER);
                                CPUCard3.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard3);
                            }
                            case 4 -> {
                                cpuSelectWater();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(4);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard4 = new VBox(imageViewCPUWater);
                                CPUCard4.setSpacing(125);
                                CPUCard4.setAlignment(Pos.CENTER);
                                CPUCard4.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard4);
                            }
                            case 5 -> {
                                cpuSelectFire();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(5);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard5 = new VBox(imageViewCPUFire);
                                CPUCard5.setSpacing(125);
                                CPUCard5.setAlignment(Pos.CENTER);
                                CPUCard5.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard5);
                            }
                            case 6 -> {
                                cpuSelectWind();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(6);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard6 = new VBox(imageViewCPUWind);
                                CPUCard6.setSpacing(125);
                                CPUCard6.setAlignment(Pos.CENTER);
                                CPUCard6.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard6);
                            }
                        }

                        ///THIS COMPARES WHAT BOTH SELECTED

                        System.out.println(" COND CHECK PLAYER"+ playerSelection.get());
                        System.out.println(" COND CHECK CPU"+ cpuSelected.get());

                        ///THIS IS THE CONDITIONAL THE LOGIC OF THE GAME IS BASED ON TITLE AND BETTING WISE
                        if(!playerSelection.get() && cpuSelected.get()==1)
                        {
                            BankAccount.setText(String.valueOf(bankAccountTitle.get()-wagerIncrement.get()));
                            bankAccountTitle.getAndSet(bankAccountTitle.get()-wagerIncrement.get());
                            String roundScreenDisplay3= "PLAYER LOST!";;
                            timerTitle.setText(roundScreenDisplay3);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }
                        }

                        if(!playerSelection.get() && cpuSelected.get()==2)
                        {
                            BankAccount.setText(String.valueOf(bankAccountTitle.get()+wagerIncrement.get()));
                            bankAccountTitle.getAndSet(bankAccountTitle.get()+wagerIncrement.get());
                            String roundScreenDisplay3= "PLAYER WON!";

                            timerTitle.setText(roundScreenDisplay3);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }
                        }


                        if(!playerSelection.get() && cpuSelected.get()==3)
                        {
                            String roundScreenDisplay3= "PLAYER TIED!";
                            timerTitle.setText(roundScreenDisplay3);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }
                        }

                        if(!playerSelection.get() && cpuSelected.get()==4)
                        {
                            BankAccount.setText(String.valueOf(bankAccountTitle.get()-wagerIncrement.get()));
                            bankAccountTitle.getAndSet(bankAccountTitle.get()-wagerIncrement.get());
                            String roundScreenDisplay3= "PLAYER LOST!";;
                            timerTitle.setText(roundScreenDisplay3);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }
                        }

                        if(!playerSelection.get() && cpuSelected.get()==5)
                        {
                            String roundScreenDisplay3= "PLAYER TIED!";
                            timerTitle.setText(roundScreenDisplay3);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }
                        }

                        if(!playerSelection.get() && cpuSelected.get()==6)
                        {
                            String roundScreenDisplay3= "PLAYER TIED!";
                            timerTitle.setText(roundScreenDisplay3);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }
                        }



                        if (playerSelected.get() == 3 && finalCpuSelected == 1) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            cpuWon.set(true);
                            System.out.println("YOU SELECTED SCISSORS" + " CPU SELECTED ROCK" + " \nPLAYER LOST!");
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                        } else if (playerSelected.get() == 3 && finalCpuSelected == 2) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            userWon.set(true);
                            System.out.println("YOU SELECTED SCISSORS" + " CPU SELECTED PAPER" + " \nPLAYER WON!");
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                        } else if (playerSelected.get() == 3 && finalCpuSelected == 3) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            tied.set(true);
                            System.out.println("YOU BOTH SELECTED SCISSORS" + " \nPLAYER AND CPU ARE TIED!");

                        } else if (playerSelected.get() == 3 && finalCpuSelected == 4) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            cpuWon.set(true);
                            System.out.println("YOU SELECTED SCISSORS" + " CPU SELECTED WATER" + " \nPLAYER LOST!");
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                        } else if (playerSelected.get() == 3 && finalCpuSelected == 5) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            tied.set(true);
                            System.out.println("YOU SELECTED SCISSORS" + " CPU SELECTED FIRE" + " \nPLAYER TIED!");
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                        } else if (playerSelected.get() == 3 && finalCpuSelected == 6) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            tied.set(true);
                            System.out.println("YOU SELECTED SCISSORS" + " CPU SELECTED WIND" + " \nPLAYER TIED!");
                        }

                        ///ROUNDS MUST COME BEFORE PLAYER CONDITIONALS WITH CPU!!!
                        round.setText("Round:" + "\n" + counter);
                        counter();
                        round.setFont(Font.font("Cambria", 30.0));
                        ROUNDName.getChildren().add(round);

                    }
                });

                scene2.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->
                {
                    if (key.getCode() == KeyCode.DIGIT4) {
                        selectWater(); ///SELECTED WATER OBJECT

                        playerSelected.set(4);
                        System.out.println("You pressed " + playerSelected);

                        screen2.getChildren().remove(PLAYERCard);
                        HBox PLAYERCard4 = new HBox(imageViewPlayerWater);
                        PLAYERCard4.setSpacing(125);
                        PLAYERCard4.setAlignment(Pos.CENTER);
                        PLAYERCard4.setPadding(new Insets(130, 10, 10, 10));
                        screen2.getChildren().add(PLAYERCard4);
                    }
                });

                scene2.addEventHandler(KeyEvent.KEY_RELEASED, (key) ->
                {
                    if (key.getCode() == KeyCode.DIGIT4) {
                        System.out.println("You released " + playerSelected);

                        ///THIS IS A DUPLICATE OF CPU CONDITION TO UPDATE WHEN THE PLAYER SELECTS IN THE LOOP!
                        int CPU= CPUselection_RAND.nextInt(max - min) + min;

                        switch (CPU) ///debugging conditional release
                        {
                            case 1 -> {
                                cpuSelectRock();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(1);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard1 = new VBox(imageViewCPURock);
                                CPUCard1.setSpacing(125);
                                CPUCard1.setAlignment(Pos.CENTER);
                                CPUCard1.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard1);

                            }
                            case 2 -> {
                                cpuSelectPaper();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(2);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard2 = new VBox(imageViewCPUPaper);
                                CPUCard2.setSpacing(125);
                                CPUCard2.setAlignment(Pos.CENTER);
                                CPUCard2.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard2);
                            }
                            case 3 -> {
                                cpuSelectScissors();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(3);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard3 = new VBox(imageViewCPUScissors);
                                CPUCard3.setSpacing(125);
                                CPUCard3.setAlignment(Pos.CENTER);
                                CPUCard3.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard3);
                            }
                            case 4 -> {
                                cpuSelectWater();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(4);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard4 = new VBox(imageViewCPUWater);
                                CPUCard4.setSpacing(125);
                                CPUCard4.setAlignment(Pos.CENTER);
                                CPUCard4.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard4);
                            }
                            case 5 -> {
                                cpuSelectFire();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(5);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard5 = new VBox(imageViewCPUFire);
                                CPUCard5.setSpacing(125);
                                CPUCard5.setAlignment(Pos.CENTER);
                                CPUCard5.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard5);
                            }
                            case 6 -> {
                                cpuSelectWind();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(6);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard6 = new VBox(imageViewCPUWind);
                                CPUCard6.setSpacing(125);
                                CPUCard6.setAlignment(Pos.CENTER);
                                CPUCard6.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard6);
                            }
                        }



                        ///THIS IS THE CONDITIONAL THE LOGIC OF THE GAME IS BASED ON TITLE AND BETTING WISE
                        if(!playerSelection.get() && cpuSelected.get()==1)
                        {
                            BankAccount.setText(String.valueOf(bankAccountTitle.get()-wagerIncrement.get()));
                            bankAccountTitle.getAndSet(bankAccountTitle.get()-wagerIncrement.get());
                            String roundScreenDisplay3= "PLAYER LOST!";
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }
                        }

                        if(!playerSelection.get() && cpuSelected.get()==2)
                        {
                            BankAccount.setText(String.valueOf(bankAccountTitle.get()+wagerIncrement.get()));
                            bankAccountTitle.getAndSet(bankAccountTitle.get()+wagerIncrement.get());
                            String roundScreenDisplay3= "PLAYER WON!";
                            timerTitle.setText(roundScreenDisplay3);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }
                        }


                        if(!playerSelection.get() && cpuSelected.get()==3)
                        {
                            BankAccount.setText(String.valueOf(bankAccountTitle.get()+wagerIncrement.get()));
                            bankAccountTitle.getAndSet(bankAccountTitle.get()+wagerIncrement.get());
                            String roundScreenDisplay3= "PLAYER WON!";
                            timerTitle.setText(roundScreenDisplay3);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }
                        }

                        if(!playerSelection.get() && cpuSelected.get()==4)
                        {
                            BankAccount.setText(String.valueOf(bankAccountTitle.get()-wagerIncrement.get()));
                            bankAccountTitle.getAndSet(bankAccountTitle.get()-wagerIncrement.get());
                            String roundScreenDisplay3= "PLAYER LOST!";
                            timerTitle.setText(roundScreenDisplay3);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }
                        }

                        if(!playerSelection.get() && cpuSelected.get()==5)
                        {
                            BankAccount.setText(String.valueOf(bankAccountTitle.get()-wagerIncrement.get()));
                            bankAccountTitle.getAndSet(bankAccountTitle.get()-wagerIncrement.get());
                            String roundScreenDisplay3= "PLAYER LOST!";;
                            timerTitle.setText(roundScreenDisplay3);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }

                        }

                        if(!playerSelection.get() && cpuSelected.get()==6)
                        {
                            String roundScreenDisplay3= "PLAYER TIED!";
                            timerTitle.setText(roundScreenDisplay3);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }
                        }



                        if (playerSelected.get() == 4 && finalCpuSelected == 1) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            tied.set(true);
                            System.out.println("YOU SELECTED WATER" + " CPU SELECTED ROCK" + " \nPLAYER TIED!");
                        } else if (playerSelected.get() == 4 && finalCpuSelected == 2) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            userWon.set(true);
                            System.out.println("YOU SELECTED WATER" + " CPU SELECTED PAPER" + " \nPLAYER WON!");
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                        } else if (playerSelected.get() == 4 && finalCpuSelected == 3) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            userWon.set(true);
                            System.out.println("YOU SELECTED WATER" + " CPU SELECTED SCISSORS" + " \nPLAYER WON!");
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                        } else if (playerSelected.get() == 4 && finalCpuSelected == 4) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            tied.set(true);
                            System.out.println("YOU BOTH SELECTED WATER" + " \nPLAYER AND CPU ARE TIED!");

                        } else if (playerSelected.get() == 4 && finalCpuSelected == 5) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            cpuWon.set(true);
                            System.out.println("YOU SELECTED WATER" + " CPU SELECTED FIRE" + " \nPLAYER LOST!");
                        } else if (playerSelected.get() == 4 && finalCpuSelected == 6) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            tied.set(true);
                            System.out.println("YOU SELECTED WATER" + " CPU SELECTED WIND" + " \nPLAYER TIED!");
                        }

                        ///ROUNDS MUST COME BEFORE PLAYER CONDITIONALS WITH CPU!!!
                        round.setText("Round:" + "\n" + counter);
                        counter();
                        round.setFont(Font.font("Cambria", 30.0));
                        ROUNDName.getChildren().add(round);

                    }
                });
                scene2.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->
                {
                    if (key.getCode() == KeyCode.DIGIT5) {
                        selectFire(); ///SELECTED FIRE OBJECT

                        playerSelected.set(5);
                        System.out.println("You pressed " + playerSelected);
                        screen2.getChildren().remove(PLAYERCard);
                        HBox PLAYERCard5 = new HBox(imageViewPlayerFire);
                        PLAYERCard5.setSpacing(125);
                        PLAYERCard5.setAlignment(Pos.CENTER);
                        PLAYERCard5.setPadding(new Insets(130, 10, 10, 10));
                        screen2.getChildren().add(PLAYERCard5);
                    }
                });

                scene2.addEventHandler(KeyEvent.KEY_RELEASED, (key) ->
                {
                    if (key.getCode() == KeyCode.DIGIT5)
                    {
                        System.out.println("You released " + playerSelected);

                        ///THIS IS A DUPLICATE OF CPU CONDITION TO UPDATE WHEN THE PLAYER SELECTS IN THE LOOP!
                        int CPU= CPUselection_RAND.nextInt(max - min) + min;

                        switch (CPU) ///debugging conditional release

                        {
                            case 1 -> {
                                cpuSelectRock();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(1);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard1 = new VBox(imageViewCPURock);
                                CPUCard1.setSpacing(125);
                                CPUCard1.setAlignment(Pos.CENTER);
                                CPUCard1.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard1);

                            }
                            case 2 -> {
                                cpuSelectPaper();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(2);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard2 = new VBox(imageViewCPUPaper);
                                CPUCard2.setSpacing(125);
                                CPUCard2.setAlignment(Pos.CENTER);
                                CPUCard2.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard2);
                            }
                            case 3 -> {
                                cpuSelectScissors();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(3);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard3 = new VBox(imageViewCPUScissors);
                                CPUCard3.setSpacing(125);
                                CPUCard3.setAlignment(Pos.CENTER);
                                CPUCard3.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard3);
                            }
                            case 4 -> {
                                cpuSelectWater();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(4);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard4 = new VBox(imageViewCPUWater);
                                CPUCard4.setSpacing(125);
                                CPUCard4.setAlignment(Pos.CENTER);
                                CPUCard4.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard4);
                            }
                            case 5 -> {
                                cpuSelectFire();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(5);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard5 = new VBox(imageViewCPUFire);
                                CPUCard5.setSpacing(125);
                                CPUCard5.setAlignment(Pos.CENTER);
                                CPUCard5.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard5);
                            }
                            case 6 -> {
                                cpuSelectWind();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(6);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard6 = new VBox(imageViewCPUWind);
                                CPUCard6.setSpacing(125);
                                CPUCard6.setAlignment(Pos.CENTER);
                                CPUCard6.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard6);
                            }
                        }


                        ///THIS IS THE CONDITIONAL THE LOGIC OF THE GAME IS BASED ON TITLE AND BETTING WISE
                        if(!playerSelection.get() && cpuSelected.get()==1)
                        {
                            String roundScreenDisplay3= "PLAYER TIED!";
                            timerTitle.setText(roundScreenDisplay3);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }

                        }

                        if(!playerSelection.get() && cpuSelected.get()==2)
                        {
                            BankAccount.setText(String.valueOf(bankAccountTitle.get()+wagerIncrement.get()));
                            bankAccountTitle.getAndSet(bankAccountTitle.get()+wagerIncrement.get());
                            String roundScreenDisplay3= "PLAYER WON!";
                            timerTitle.setText(roundScreenDisplay3);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }

                        }


                        if(!playerSelection.get() && cpuSelected.get()==3)
                        {
                            String roundScreenDisplay3= "PLAYER TIED!";
                            timerTitle.setText(roundScreenDisplay3);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }

                        }

                        if(!playerSelection.get() && cpuSelected.get()==4)
                        {
                            BankAccount.setText(String.valueOf(bankAccountTitle.get()+wagerIncrement.get()));
                            bankAccountTitle.getAndSet(bankAccountTitle.get()+wagerIncrement.get());
                            String roundScreenDisplay3= "PLAYER WON!";
                            timerTitle.setText(roundScreenDisplay3);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }

                        }

                        if(!playerSelection.get() && cpuSelected.get()==5)
                        {
                            String roundScreenDisplay3= "PLAYER TIED!";
                            timerTitle.setText(roundScreenDisplay3);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }

                        }

                        if(!playerSelection.get() && cpuSelected.get()==6)
                        {
                            BankAccount.setText(String.valueOf(bankAccountTitle.get()-wagerIncrement.get()));
                            bankAccountTitle.getAndSet(bankAccountTitle.get()-wagerIncrement.get());
                            String roundScreenDisplay3= "PLAYER LOST!";;
                            timerTitle.setText(roundScreenDisplay3);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }
                        }


                        if (playerSelected.get() == 5 && finalCpuSelected == 1) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            tied.set(true);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            System.out.println("YOU SELECTED FIRE" + " CPU SELECTED ROCK" + " \nPLAYER TIED!");

                        } else if (playerSelected.get() == 5 && finalCpuSelected == 2) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            userWon.set(true);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            System.out.println("YOU SELECTED FIRE" + " CPU SELECTED PAPER" + " \nPLAYER WON!");

                        } else if (playerSelected.get() == 5 && finalCpuSelected == 3) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            tied.set(true);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            System.out.println("YOU SELECTED FIRE" + " CPU SELECTED SCISSORS" + " \nPLAYER TIED!");

                        } else if (playerSelected.get() == 5 && finalCpuSelected == 4) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            userWon.set(true);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            System.out.println("YOU SELECTED FIRE" + " CPU SELECTED WATER" + " \nPLAYER WON!");

                        } else if (playerSelected.get() == 5 && finalCpuSelected == 5) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            tied.set(true);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            System.out.println("YOU BOTH SELECTED FIRE" + " CPU SELECTED FIRE" + " \nPLAYER TIED!");

                        } else if (playerSelected.get() == 5 && finalCpuSelected == 6) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            cpuWon.set(true);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            System.out.println("YOU SELECTED FIRE" + " CPU SELECTED WIND" + " \nPLAYER LOST!");
                        }

                        ///ROUNDS MUST COME BEFORE PLAYER CONDITIONALS WITH CPU!!!
                        round.setText("Round:" + "\n" + counter);
                        counter();
                        round.setFont(Font.font("Cambria", 30.0));
                        ROUNDName.getChildren().add(round);

                    }
                });

                scene2.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->
                {
                    if (key.getCode() == KeyCode.DIGIT6) {
                        selectWind(); ///SELECTED WIND OBJECT

                        playerSelected.set(6);
                        System.out.println("You pressed " + playerSelected);

                        screen2.getChildren().remove(PLAYERCard);
                        HBox PLAYERCard6 = new HBox(imageViewPlayerWind);
                        PLAYERCard6.setSpacing(125);
                        PLAYERCard6.setAlignment(Pos.CENTER);
                        PLAYERCard6.setPadding(new Insets(130, 10, 10, 10));
                        screen2.getChildren().add(PLAYERCard6);
                    }
                });

                scene2.addEventHandler(KeyEvent.KEY_RELEASED, (key) ->
                {
                    if (key.getCode() == KeyCode.DIGIT6) {
                        System.out.println("You released " + playerSelected);

                        ///THIS IS A DUPLICATE OF CPU CONDITION TO UPDATE WHEN THE PLAYER SELECTS IN THE LOOP!
                        int CPU= CPUselection_RAND.nextInt(max - min) + min;

                        switch (CPU) ///debugging conditional release
                        {
                            case 1 -> {
                                cpuSelectRock();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(1);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard1 = new VBox(imageViewCPURock);
                                CPUCard1.setSpacing(125);
                                CPUCard1.setAlignment(Pos.CENTER);
                                CPUCard1.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard1);

                            }
                            case 2 -> {
                                cpuSelectPaper();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(2);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard2 = new VBox(imageViewCPUPaper);
                                CPUCard2.setSpacing(125);
                                CPUCard2.setAlignment(Pos.CENTER);
                                CPUCard2.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard2);
                            }
                            case 3 -> {
                                cpuSelectScissors();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(3);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard3 = new VBox(imageViewCPUScissors);
                                CPUCard3.setSpacing(125);
                                CPUCard3.setAlignment(Pos.CENTER);
                                CPUCard3.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard3);
                            }
                            case 4 -> {
                                cpuSelectWater();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(4);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard4 = new VBox(imageViewCPUWater);
                                CPUCard4.setSpacing(125);
                                CPUCard4.setAlignment(Pos.CENTER);
                                CPUCard4.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard4);
                            }
                            case 5 -> {
                                cpuSelectFire();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(5);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard5 = new VBox(imageViewCPUFire);
                                CPUCard5.setSpacing(125);
                                CPUCard5.setAlignment(Pos.CENTER);
                                CPUCard5.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard5);
                            }
                            case 6 -> {
                                cpuSelectWind();
                                System.out.println("test " + cpuSelected);
                                cpuSelected.set(6);
                                screen2.getChildren().remove(CPUCard);
                                VBox CPUCard6 = new VBox(imageViewCPUWind);
                                CPUCard6.setSpacing(125);
                                CPUCard6.setAlignment(Pos.CENTER);
                                CPUCard6.setPadding(new Insets(-130, -880, -250, 10));
                                screen2.getChildren().add(CPUCard6);
                            }
                        }


                        ///THIS IS THE CONDITIONAL THE LOGIC OF THE GAME IS BASED ON TITLE AND BETTING WISE
                        if(!playerSelection.get() && cpuSelected.get()==1)
                        {
                            BankAccount.setText(String.valueOf(bankAccountTitle.get()-wagerIncrement.get()));
                            bankAccountTitle.getAndSet(bankAccountTitle.get()-wagerIncrement.get());
                            String roundScreenDisplay3= "PLAYER LOST!";
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            timerTitle.setText(roundScreenDisplay3);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }

                        }

                        if(!playerSelection.get() && cpuSelected.get()==2)
                        {
                            BankAccount.setText(String.valueOf(bankAccountTitle.get()+wagerIncrement.get()));
                            bankAccountTitle.getAndSet(bankAccountTitle.get()+wagerIncrement.get());
                            String roundScreenDisplay3= "PLAYER WON!";
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            timerTitle.setText(roundScreenDisplay3);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }

                        }


                        if(!playerSelection.get() && cpuSelected.get()==3)
                        {
                            String roundScreenDisplay3= "PLAYER TIED!";
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            timerTitle.setText(roundScreenDisplay3);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }

                        }

                        if(!playerSelection.get() && cpuSelected.get()==4)
                        {
                            BankAccount.setText(String.valueOf(bankAccountTitle.get()-wagerIncrement.get()));
                            bankAccountTitle.getAndSet(bankAccountTitle.get()-wagerIncrement.get());
                            String roundScreenDisplay3= "PLAYER LOST!";
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            timerTitle.setText(roundScreenDisplay3);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }

                        }

                        if(!playerSelection.get() && cpuSelected.get()==5)
                        {
                            BankAccount.setText(String.valueOf(bankAccountTitle.get()+wagerIncrement.get()));
                            bankAccountTitle.getAndSet(bankAccountTitle.get()+wagerIncrement.get());
                            String roundScreenDisplay3= "PLAYER WON!";
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            timerTitle.setText(roundScreenDisplay3);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }

                        }

                        if(!playerSelection.get() && cpuSelected.get()==6)
                        {
                            String roundScreenDisplay3= "PLAYER TIED!";
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            timerTitle.setText(roundScreenDisplay3);
                            if(bankAccountTitle.get()==100) ///MULTIPLIER X2
                            {
                                System.out.println("MULTIPLIER INCREASED");
                            }
                            else if(bankAccountTitle.get()<=0) ///GAME OVER SCREEN
                            {
                                System.out.println("YOUR OUT OF MONEY GAME OVER");
                                music2();
                                terminateProcess=false;
                                window.setScene(scene7); ///GOES TO THE NAME SCREEN THEN THAT GOES TO THE SCORES
                            }

                        }

                        if (playerSelected.get() == 6 && finalCpuSelected == 1) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            tied.set(true);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            System.out.println("YOU SELECTED WIND" + " CPU SELECTED ROCK" + " \nPLAYER TIED!");

                        } else if (playerSelected.get() == 6 && finalCpuSelected == 2) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            userWon.set(true);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            System.out.println("YOU SELECTED WIND" + " CPU SELECTED PAPER" + " \nPLAYER WON!");

                        } else if (playerSelected.get() == 6 && finalCpuSelected == 3) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            tied.set(true);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            System.out.println("YOU SELECTED WIND" + " CPU SELECTED SCISSORS" + " \nPLAYER TIED!");

                        } else if (playerSelected.get() == 6 && finalCpuSelected == 4) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            tied.set(true);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            System.out.println("YOU SELECTED WIND" + " CPU SELECTED WATER" + " \nPLAYER TIED!");

                        } else if (playerSelected.get() == 6 && finalCpuSelected == 5) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            userWon.set(true);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            System.out.println("YOU BOTH SELECTED WIND" + " CPU SELECTED FIRE" + " \nPLAYER WON!");

                        } else if (playerSelected.get() == 6 && finalCpuSelected == 6) ///IF CPU GENERATED AND PLAYER MATCHES
                        {
                            ///ADD TEXT INDICATOR THAT TELLS SCREEN THIS!!!!
                            tied.set(true);
                            timerTitle.setFill(Color.WHITE);
                            timerTitle.setStrokeWidth(1.35);
                            timerTitle.setStroke(Color.YELLOW);
                            System.out.println("YOU SELECTED WIND" + " CPU SELECTED WIND" + " \nPLAYER TIED!");

                        }

                        ///ROUNDS MUST COME BEFORE PLAYER CONDITIONALS WITH CPU!!!
                        round.setText("Round:" + "\n" + counter);
                        counter();
                        round.setFont(Font.font("Cambria", 30.0));
                        ROUNDName.getChildren().add(round);

                    }
                });




        //////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
//                              SCREEN 4 - SETTINGS MENU
//////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////

        ///RETURNS PLAYER TO HOME SCREEN
        Button goToEntryScreen4=new Button("RETURN");
        goToEntryScreen4.setStyle("-fx-background-color: #696969; -fx-font-family:'Gentium Book Basic'; -fx-color:#000000; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;");
        goToEntryScreen4.styleProperty().bind(Bindings.when(goToEntryScreen4.hoverProperty())
                .then("-fx-background-color: #402061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;")
                .otherwise("-fx-background-color: #002061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;"));
        goToEntryScreen4.setOnAction(actionEvent ->
        {
            window.setScene(scene);
        });

        VBox buttonsGameOver3=new VBox(goToEntryScreen4);
        buttonsGameOver3.setAlignment(Pos.TOP_RIGHT);
        buttonsGameOver3.setSpacing(10);
        buttonsGameOver3.setPadding(new Insets(10, 10, 10, 10));
        screen3_subscreen2.setBottom(buttonsGameOver3);

        ///TODO DISABLE MUSIC
        ///STANDARD THEME
        ///DARK THEME

        ///TODO DISABLE MUSIC

        ///MUSIC (ON) (OFF)


        ///TODO CHANGE CONTROL SCHEME

        ///NUM-PAD (KEYBOARD ONLY)
        ///TRADITONAL LAYOUT (KEYBOARD ONLY)
        /// MOUSE CLICK (MOUSE ONLY)

        ///TODO ASPECT RATIO ADJUST

        ///SELECT ONLY ONE
        ///1920 X 1080
        ///1366 X 768
        ///1280 x 720
        ///360 X 640





        //////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
//                              SCREEN 5 - PAUSE SCREEN
//////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
        Text pauseTitle = new Text("PAUSED");


        //////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
//                              SCREEN 6 - CREDITS SCREEN
//////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////

        Text titleName2 = new Text("Rock Paper Scissors");
        Text titleNamePlusL2 = new Text("+");
        Text titleNamePlusR2 = new Text("+");
        Text authorName2 = new Text("Golden Maple Software");
        Text authorStudentNumber2 = new Text("© 2021");
        Text creditsTitle2 = new Text("Credits");
        Text creditsTitle12 = new Text("Music:");
        Text creditsTitle22 = new Text("Game Screen Music : Pacman's Park- PacMania 1987 Namco");
        Text creditsTitle32 = new Text("Title Screen && Credit Music: Paper Mario -  Shooting Star Summit- 1997 Nintendo");
        Text creditsTitle33 = new Text("Game Over Music: Donkey Kong Country Game Over Theme 1995 RARE");

        HBox walletIDBox = new HBox(imageViewWalletID);
        walletIDBox.setLayoutX(200);
        walletIDBox.setAlignment(Pos.BOTTOM_RIGHT);

        titleName2.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 35));
        titleName2.setFill(Color.GOLD);
        titleName2.setStroke(Color.BLACK);
        ///StackPane.setAlignment(titleName, Pos.CENTER);

        titleNamePlusL2.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 35));
        titleNamePlusL2.setFill(Color.GOLD);
        titleNamePlusL2.setStroke(Color.BLACK);
        ///StackPane.setAlignment(titleNamePlusL, Pos.CENTER);

        titleNamePlusR2.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 35));
        titleNamePlusR2.setFill(Color.GOLD);
        titleNamePlusR2.setStroke(Color.BLACK);
        ///StackPane.setAlignment(titleNamePlusR, Pos.CENTER);

        authorName2.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 25));
        authorName2.setFill(Color.RED);
        authorName2.setStroke(Color.BLACK);
        ///StackPane.setAlignment(authorName, Pos.BOTTOM_RIGHT);

        authorStudentNumber2.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 25));
        authorStudentNumber2.setFill(Color.RED);
        authorStudentNumber2.setStroke(Color.BLACK);
        ///StackPane.setAlignment(authorStudentNumber, Pos.CENTER);

        creditsTitle2.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 25));
        creditsTitle2.setFill(Color.RED);
        creditsTitle2.setStroke(Color.BLACK);
        ///StackPane.setAlignment(authorStudentNumber, Pos.CENTER);

        creditsTitle12.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 25));
        creditsTitle12.setFill(Color.GREEN);
        creditsTitle12.setStroke(Color.BLACK);

        creditsTitle22.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 25));
        creditsTitle22.setFill(Color.YELLOW);
        creditsTitle22.setStroke(Color.BLACK);

        creditsTitle32.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 25));
        creditsTitle32.setFill(Color.YELLOW);
        creditsTitle32.setStroke(Color.BLACK);

        creditsTitle33.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 25));
        creditsTitle33.setFill(Color.YELLOW);
        creditsTitle33.setStroke(Color.BLACK);



        ///THIS MOVES THE TITLE NAME
        TranslateTransition movementTitle2 = new TranslateTransition(Duration.millis(3250), titleName2);
        movementTitle2.setFromX(-300);
        movementTitle2.setFromY(-450);
        movementTitle2.setToX(0);
        movementTitle2.setToY(-300);


        ///THIS MOVES THE TITLE author name
        TranslateTransition author2 = new TranslateTransition(Duration.millis(3250), authorName2);
        author2.setFromX(-200);
        author2.setFromY(650);
        author2.setToX(-15);
        author2.setToY(285);

        ///THIS MOVES THE TITLE author number
        TranslateTransition authorNumber2 = new TranslateTransition(Duration.millis(3250), authorStudentNumber2);
        authorNumber2.setFromX(-200);
        authorNumber2.setFromY(650);
        authorNumber2.setToX(40);
        authorNumber2.setToY(315);

        ///LEFT PLUS
        TranslateTransition movementTitlePlusL2 = new TranslateTransition(Duration.millis(3250), titleNamePlusL2);
        movementTitlePlusL2.setFromX(-300);
        movementTitlePlusL2.setFromY(-450);
        movementTitlePlusL2.setToX(190);
        movementTitlePlusL2.setToY(-310);

        ///Right PLUS
        TranslateTransition movementTitlePlusR2 = new TranslateTransition(Duration.millis(3250), titleNamePlusR2);
        movementTitlePlusR2.setFromX(-300);
        movementTitlePlusR2.setFromY(-450);
        movementTitlePlusR2.setToX(209);
        movementTitlePlusR2.setToY(-310);


        ///CREDITS TITLE
        TranslateTransition movementCredits_12 = new TranslateTransition(Duration.millis(3250), creditsTitle2);
        movementCredits_12.setFromX(-250);
        movementCredits_12.setFromY(-450);
        movementCredits_12.setToX(0);
        movementCredits_12.setToY(-200);

        ///CATEGORY 1 --- MUSIC:
        TranslateTransition categoryCredits_Music2 = new TranslateTransition(Duration.millis(3250), creditsTitle12);
        categoryCredits_Music2.setFromX(-250);
        categoryCredits_Music2.setFromY(-450);
        categoryCredits_Music2.setToX(0);
        categoryCredits_Music2.setToY(-160);

        ///CATEGORY 1 --- MUSIC CREDITS INDIVIDUAL-- ENTRY 1:
        TranslateTransition creditMusic_12 = new TranslateTransition(Duration.millis(3250), creditsTitle22);
        creditMusic_12.setFromX(0);
        creditMusic_12.setFromY(-450);
        creditMusic_12.setToX(0);
        creditMusic_12.setToY(-100);

        ///CATEGORY 1 --- MUSIC CREDITS INDIVIDUAL -- ENTRY 2:
        TranslateTransition creditMusic_22 = new TranslateTransition(Duration.millis(3250), creditsTitle32);
        creditMusic_22.setFromX(0);
        creditMusic_22.setFromY(-450);
        creditMusic_22.setToX(0);
        creditMusic_22.setToY(-30);

        ///CATEGORY 1 --- MUSIC CREDITS INDIVIDUAL -- ENTRY 2:
        TranslateTransition creditMusic_32 = new TranslateTransition(Duration.millis(3250), creditsTitle33);
        creditMusic_32.setFromX(0);
        creditMusic_32.setFromY(-450);
        creditMusic_32.setToX(0);
        creditMusic_32.setToY(30);



        ///WHERE RETURN BUTTONS WILL BE PLACED
        Button returnButton = new Button("RETURN");
        returnButton.setStyle("-fx-font-family:'Gentium Book Basic'; -fx-background-color: #e6bb00; -fx-border-color:#614f00;-fx-border-width: 3px; -fx-font-size: 2em;");
        returnButton.styleProperty().bind(Bindings.when(returnButton.hoverProperty())
                .then("-fx-font-family:'Gentium Book Basic'; -fx-background-color: #e6bb00; -fx-border-color:#614f00;-fx-border-width: 3px; -fx-font-size: 2em;")
                .otherwise("-fx-font-family:'Gentium Book Basic'; -fx-background-color:#6b5700; -fx-border-color:#614f00;-fx-border-width: 3px; -fx-font-size: 2em;"));

        returnButton.setOnAction(actionEvent ->
        {
            System.out.println("The Return Button was clicked.");
            window.setScene(scene);
        });

        ///BUTTON PROPERTIES:
        VBox buttonView2 = new VBox(returnButton);
        buttonView2.setAlignment(Pos.TOP_RIGHT);
        buttonView2.setSpacing(10);
        buttonView2.setPadding(new Insets(10, 10, 10, 10));



        StrokeTransition middleScreen2 = new StrokeTransition(Duration.millis(5000), Color.YELLOW, Color.RED);
        middleScreen2.setCycleCount(Animation.INDEFINITE);
        middleScreen2.setAutoReverse(true);


        SequentialTransition mainTitleTimeline2 = new SequentialTransition();

        ParallelTransition plusPlusTimeLine2 = new ParallelTransition(); ///group 1
        ParallelTransition plusAnimation2 = new ParallelTransition(); ///group 2
        ParallelTransition musicCreditsAnimation2=new ParallelTransition();///music pops up at once

        plusPlusTimeLine2.getChildren().addAll(movementTitlePlusL2, movementTitlePlusR2, author2, authorNumber2);

        plusAnimation2.getChildren().addAll(PlusAnimation(titleNamePlusR2, 45), PlusAnimation(titleNamePlusL2, -45));
        plusPlusTimeLine2.play();
        middleScreen2.play();
        musicCreditsAnimation2.play();
        mainTitleTimeline2.getChildren().addAll(movementTitle2, movementCredits_12,categoryCredits_Music2, ScaleAnimation(authorName2, 1500), delayFrame(1500), creditMusic_12,creditMusic_22,creditMusic_32,plusAnimation2);

        mainTitleTimeline2.play();




        //////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
//                              SCREEN 7 - GAME OVER
//////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////


        ///THIS BUTTON TERMINATES THE PROGRAM
        Button goToEntryScreen2=new Button("EXIT");
        goToEntryScreen2.setStyle("-fx-background-color: #696969; -fx-font-family:'Gentium Book Basic'; -fx-color:#000000; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;");
        goToEntryScreen2.styleProperty().bind(Bindings.when(goToEntryScreen2.hoverProperty())
                .then("-fx-background-color: #402061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;")
                .otherwise("-fx-background-color: #002061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;"));
        goToEntryScreen2.setOnAction(actionEvent ->
        {
            System.exit(2);
        });

        VBox buttonsGameOver=new VBox(goToEntryScreen2);

        buttonsGameOver.setAlignment(Pos.TOP_RIGHT);
        buttonsGameOver.setSpacing(10);
        buttonsGameOver.setPadding(new Insets(10, 10, 10, 10));


        Text gameOverTitle= new Text("Rock Paper Scissors");
        Text gameOvertitleNamePlusL= new Text("+");
        Text gameOvertitleNamePlusR= new Text("+");
        Text gameoverWord= new Text("Game Over");
        Text gameOverThankYou= new Text("Thanks for playing.");


        gameOverTitle.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,35));
        gameOverTitle.setFill(Color.GOLD);
        gameOverTitle.setStroke(Color.BLACK);

        gameOvertitleNamePlusL.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,35));
        gameOvertitleNamePlusL.setFill(Color.GOLD);
        gameOvertitleNamePlusL.setStroke(Color.BLACK);

        gameOvertitleNamePlusR.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,35));
        gameOvertitleNamePlusR.setFill(Color.GOLD);
        gameOvertitleNamePlusR.setStroke(Color.BLACK);

        gameoverWord.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,35));
        gameoverWord.setFill(Color.GOLD);
        gameoverWord.setStroke(Color.BLACK);


        ///THIS MOVES THE TITLE NAME
        TranslateTransition movementTitleGameOver=new TranslateTransition(Duration.millis(3250),gameOverTitle);
        movementTitleGameOver.setFromX(-300);
        movementTitleGameOver.setFromY(-450);
        movementTitleGameOver.setToX(0);
        movementTitleGameOver.setToY(-300);


        ///THIS MOVES THE TITLE author name
        TranslateTransition gameoverWordTitle=new TranslateTransition(Duration.millis(3250),gameoverWord);
        gameoverWordTitle.setFromX(-200);
        gameoverWordTitle.setFromY(650);
        gameoverWordTitle.setToX(-15);
        gameoverWordTitle.setToY(70);


        ///LEFT PLUS
        TranslateTransition movementTitlePlusLgameover=new TranslateTransition(Duration.millis(3250),gameOvertitleNamePlusL);
        movementTitlePlusLgameover.setFromX(-300);
        movementTitlePlusLgameover.setFromY(-450);
        movementTitlePlusLgameover.setToX(190);
        movementTitlePlusLgameover.setToY(-310);

        ///Right PLUS
        TranslateTransition movementTitlePlusRgameover=new TranslateTransition(Duration.millis(3250),gameOvertitleNamePlusR);
        movementTitlePlusRgameover.setFromX(-300);
        movementTitlePlusRgameover.setFromY(-450);
        movementTitlePlusRgameover.setToX(209);
        movementTitlePlusRgameover.setToY(-310);


        SequentialTransition mainTitleTimeline3 = new SequentialTransition();

        ParallelTransition plusPlusTimeLine3 = new ParallelTransition(); ///group 1
        ParallelTransition plusAnimation3 = new ParallelTransition(); ///group 2
        ParallelTransition musicCreditsAnimation3=new ParallelTransition();///music pops up at once

        plusPlusTimeLine3.getChildren().addAll(movementTitlePlusRgameover, movementTitlePlusLgameover, gameoverWordTitle);

        plusAnimation3.getChildren().addAll(PlusAnimation(gameOvertitleNamePlusR, 45), PlusAnimation(gameOvertitleNamePlusL, -45));

        plusPlusTimeLine3.play();

        musicCreditsAnimation3.play();
        mainTitleTimeline3.getChildren().addAll(movementTitleGameOver,ScaleAnimation(gameOverTitle, 1500), delayFrame(1500), plusAnimation3);

        mainTitleTimeline3.play();





    if(!terminateProcess)
    {
    Timer screentimer = new Timer();
    TimerTask task = new TimerTask() {
        int i = 20;

        @Override
        public void run() {
            if (i > 0) {
                System.out.println(i);
                i--;
            }


            if (i == 0) {
                System.exit(0);
            }
        }

    };

    screentimer.scheduleAtFixedRate(task, 0, 1000);
}




        ///StackPane.setAlignment(titleName, Pos.CENTER);



        //////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
//                              SCREEN 3 SUB SCREEN- HIGH SCORE SCREEN AFTER GAME OVER
//////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////

        Button goToEntryScreen3=new Button("RETURN");
        goToEntryScreen3.setStyle("-fx-background-color: #696969; -fx-font-family:'Gentium Book Basic'; -fx-color:#000000; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;");
        goToEntryScreen3.styleProperty().bind(Bindings.when(goToEntryScreen2.hoverProperty())
                .then("-fx-background-color: #402061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;")
                .otherwise("-fx-background-color: #002061; -fx-color:#000000; -fx-font-family:'Gentium Book Basic'; -fx-border-color:#2f3031;-fx-border-width: 3px; -fx-font-size: 2em;"));
        goToEntryScreen3.setOnAction(actionEvent ->
        {
            window.setScene(scene);
        });



        VBox buttonsGameOver2=new VBox(goToEntryScreen3);

        buttonsGameOver2.setAlignment(Pos.TOP_RIGHT);
        buttonsGameOver2.setSpacing(10);
        buttonsGameOver2.setPadding(new Insets(10, 10, 10, 10));
        screen3_subscreen2.setBottom(buttonsGameOver2);

        ///SCREEN 3 (DISPLAYS AFTER GAME OVER ANIMATION) -- SUBSCREEN DISPLAY CONTENTS

        Text highScoreTitle = new Text("ENTER YOUR NAME");
        highScoreTitle.setFont(Font.font("Cambria", 40.0));
        highScoreTitle.setFill(Color.WHITE);
        highScoreTitle.setStrokeWidth(1.35);
        highScoreTitle.setStroke(Color.YELLOW);
        screen3_subscreen2.setTop(highScoreTitle);

        ///FILE CONTENT BOX

        TextArea fileContents=new TextArea();
        fileContents.setWrapText(true);
        fileContents.setEditable(false);  ///CANNOT BE EDITED
        screen3_subscreen2.setCenter(fileContents);
        BufferedReader in=new BufferedReader(new FileReader(file));
        ///FILE I O PROPERTIES TEST
        String delimeterLine="";
        fileContents.setText("");


        ////TODO TRACK ROUNDS AND GLOBAL EARNINGS THROUGH THIS FUNCTION SOMEHOW...
        while ((delimeterLine=in.readLine())!=null)
        {
            fileContents.appendText( delimeterLine + "\n");
        }







//////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
//                                THE END OF THE PROGRAM
//////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////

        ///ALL SCENES SET UP AND EXECUTION PROPERTIES:
        ///screen1.getChildren().addAll(titleGame, subTitle, buttonView); ///ADDS STUFF TO SCREEN
        ////screen2.getChildren().addAll();
        screen1.getChildren().addAll(titleName,rectangle,buttonView,titleNamePlusL,titleNamePlusR,authorName,authorStudentNumber);
        screen4.getChildren().addAll(buttonsGameOver3);
        screen6.getChildren().addAll(walletIDBox,titleName2,buttonView2, titleNamePlusL2, titleNamePlusR2, authorName2, authorStudentNumber2,creditsTitle2,creditsTitle12,creditsTitle22,creditsTitle32,creditsTitle33);
        screen7.getChildren().addAll(buttonsGameOver,gameOverTitle,gameOvertitleNamePlusL,gameOvertitleNamePlusR,gameoverWord,gameOverThankYou);

        ///ALL SCENES SET UP PROPERTIES
        window.setTitle("Rock Paper Scissors ++");
        window.setResizable(false);  ///SIZABLE ADJUSTMENT
        window.setScene(scene);
        window.show();
    }


    /**
     * CPU OPTIONS IT CAN SELECT
     */
    public void cpuSelectRock() {
        int cpuSelected = 1;
        System.out.println(cpuSelected);
        new cpu_rock("CPU Selected Rock", cpuSelected);
    }

    public void cpuSelectPaper() {
        int cpuSelected = 2;
        ///System.out.println(cpuSelected);
        new cpu_paper("CPU Selected Paper", cpuSelected);
    }

    public void cpuSelectScissors() {
        int cpuSelected = 3;
        System.out.println(cpuSelected);
        new cpu_scissors("CPU Selected Scissors", cpuSelected);
    }

    public void cpuSelectWater() {
        int cpuSelected = 4;
        ///System.out.println(cpuSelected);
        new cpu_water("CPU Selected Water", cpuSelected);
    }

    public void cpuSelectFire() {
        int cpuSelected = 5;
        ///System.out.println(cpuSelected);
        new cpu_fire("CPU Selected Water", cpuSelected);
    }

    public void cpuSelectWind() {
        int cpuSelected = 5;
        ///System.out.println(cpuSelected);
        new cpu_wind("CPU Selected Wind", cpuSelected);
    }


    /**
     * PLAYER SELECTED
     * ROCK AND THIS CONDITION HAPPENS
     *
     */

    public void selectRock() {
        new player_rock("rock", 1);

    }

    /**
     * PLAYER SELECTED
     * PAPER AND THIS CONDITION HAPPENS
     */

    public void selectPaper() {
        new player_paper("paper", 2);
    }

    /**
     * PLAYER SELECTED
     * SCISSORS AND THIS CONDITION HAPPENS
     */

    public void selectScissors() {
        new player_scissors("scissors", 3);
    }

    /**
     * PLAYER SELECTED
     * WATER AND THIS CONDITION HAPPENS
     */

    public void selectWater() {
        new player_water("scissors", 4);
    }

    /**
     * PLAYER SELECTED
     * FIRE AND THIS CONDITION HAPPENS
     */
    public void selectFire() {
        new player_fire("fire", 5);
    }

    /**
     * PLAYER SELECTED
     * WIND AND THIS CONDITION HAPPENS
     */
    public void selectWind() {
        new player_wind("wind", 6);
    }

    /**
     * GENERALIZED CPU
     * RANDOMIZED WITH ONLY 3 CONDITIONS THAT CAN BE THE RESULT
     */
    public static void CPU() {
        new cpu();
    }

    public void counter()
    {
        counter++;
    }

    }


