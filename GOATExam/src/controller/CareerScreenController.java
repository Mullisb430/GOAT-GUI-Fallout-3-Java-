/*
This is the controller file for the career screen FXML file ("/view/careerscreen.fxml").
This file includes all of the controls that exist on the career screen FXML file, and all
of the actions that the buttons trigger.
 */


package controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class CareerScreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label jobTitle;

    @FXML
    private Label jobDescription;

    @FXML
    private Label strengthSkill;

    @FXML
    private Label perceptionSkill;

    @FXML
    private Label enduranceSkill;

    @FXML
    private Label charismaSkill;

    @FXML
    private Label intelligenceSkill;

    @FXML
    private Label agilitySkill;

    @FXML
    private Label luckSkill;

    @FXML
    private ImageView jobIcon;

    @FXML
    private Label barterSkill;

    @FXML
    private Label biggunsSkill;

    @FXML
    private Label energySkill;

    @FXML
    private Label explosivesSkill;

    @FXML
    private Label lockpickSkill;

    @FXML
    private Label medicineSkill;

    @FXML
    private Label meleeSkill;

    @FXML
    private Label repairSkill;

    @FXML
    private Label scienceSkill;

    @FXML
    private Label smallgunsSkill;

    @FXML
    private Label sneakSkill;

    @FXML
    private Label speechSkill;

    @FXML
    private Label unarmedSkill;

    @FXML
    private Button careerPlayAgainButton;

    @FXML
    private Line playAgainTopBorder;

    @FXML
    private Line playAgainBottomBorder;

    @FXML
    private Line playAgainRightBorder;

    @FXML
    private Line playAgainLeftBorder;

    @FXML
    private Button careerStartScreenButton;

    @FXML
    private Line careerStartTopBorder;

    @FXML
    private Line careerStartBottomBorder;

    @FXML
    private Line careerStartRightBorder;

    @FXML
    private Line careerStartLeftBorder;

    // The random number generator that generates random numbers
    // within the range that is deemed based on the answers given
    // in the test and the career assigned based on those answers.
    Random dice = new Random();

    // Image JavaFX object that will hold the vault boy icon
    // based on the career assigned.
    Image img;

    @FXML
    void initialize() throws URISyntaxException
    {
        careerChooser();

        // Takes the user to question number 1, so that they can do the test again.
        careerPlayAgainButton.setOnAction(event ->
        {
            unarmedSkill.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/questionscreen.fxml"));

            try
            {
                loader.load();
            } catch (IOException e)
            {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        // Borders appear when the "Play Again" button is hovered over.
        careerPlayAgainButton.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event ->
        {
            playAgainTopBorder.setVisible(true);
            playAgainBottomBorder.setVisible(true);
            playAgainRightBorder.setVisible(true);
            playAgainLeftBorder.setVisible(true);
        });

        // Borders disappear when the user's mouse exits the "Play Again" button's border.
        careerPlayAgainButton.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event ->
        {
            playAgainTopBorder.setVisible(false);
            playAgainBottomBorder.setVisible(false);
            playAgainRightBorder.setVisible(false);
            playAgainLeftBorder.setVisible(false);
        });
        careerChooser();

        // Takes the user to the start screen so the user can take the test again, or
        // view the "info screen."
        careerStartScreenButton.setOnAction(event ->
        {
            unarmedSkill.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/startscreen.fxml"));

            try
            {
                loader.load();
            } catch (IOException e)
            {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        // Borders appear when the "Start Screen" button is hovered over.
        careerStartScreenButton.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event ->
        {
            careerStartTopBorder.setVisible(true);
            careerStartBottomBorder.setVisible(true);
            careerStartRightBorder.setVisible(true);
            careerStartLeftBorder.setVisible(true);
        });

        // Borders disappear when the user's mouse exits the "Start Screen" button's border.
        careerStartScreenButton.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event ->
        {
            careerStartTopBorder.setVisible(false);
            careerStartBottomBorder.setVisible(false);
            careerStartRightBorder.setVisible(false);
            careerStartLeftBorder.setVisible(false);
        });
    }

    // Based on the career assigned, this method sets the text for all of the skills and the
    // career title and description.
    public void setCareer(String careerTitle, String careerDescription, int statsNum)
    {
        jobTitle.setText(careerTitle);
        jobDescription.setText(careerDescription);
        strengthSkill.setText(Integer.toString(dice.nextInt(1) + careerStats[statsNum][0]));
        perceptionSkill.setText(Integer.toString(dice.nextInt(1) + careerStats[statsNum][1]));
        enduranceSkill.setText(Integer.toString(dice.nextInt(1) + careerStats[statsNum][2]));
        charismaSkill.setText(Integer.toString(dice.nextInt(1) + careerStats[statsNum][3]));
        agilitySkill.setText(Integer.toString(dice.nextInt(1) + careerStats[statsNum][4]));
        intelligenceSkill.setText(Integer.toString(dice.nextInt(1) + careerStats[statsNum][5]));
        luckSkill.setText(Integer.toString(dice.nextInt(1) + careerStats[statsNum][6]));

        barterSkill.setText(Integer.toString(dice.nextInt(10) + careerStats[statsNum][7]));
        biggunsSkill.setText(Integer.toString(dice.nextInt(10) + careerStats[statsNum][8]));
        energySkill.setText(Integer.toString(dice.nextInt(10) + careerStats[statsNum][9]));
        explosivesSkill.setText(Integer.toString(dice.nextInt(10) + careerStats[statsNum][10]));
        lockpickSkill.setText(Integer.toString(dice.nextInt(10) + careerStats[statsNum][11]));
        medicineSkill.setText(Integer.toString(dice.nextInt(10) + careerStats[statsNum][12]));
        meleeSkill.setText(Integer.toString(dice.nextInt(10) + careerStats[statsNum][13]));
        repairSkill.setText(Integer.toString(dice.nextInt(10) + careerStats[statsNum][14]));
        scienceSkill.setText(Integer.toString(dice.nextInt(10) + careerStats[statsNum][15]));
        smallgunsSkill.setText(Integer.toString(dice.nextInt(10) + careerStats[statsNum][16]));
        sneakSkill.setText(Integer.toString(dice.nextInt(10) + careerStats[statsNum][17]));
        speechSkill.setText(Integer.toString(dice.nextInt(10) + careerStats[statsNum][18]));
        unarmedSkill.setText(Integer.toString(dice.nextInt(10) + careerStats[statsNum][19]));

    }

    /*
    Once the exam is finished, all of the answers given by the user are considered,
    a career is chosen, and stat/skill ranges are determined. The icon is also set
    based on the career chosen.
     */
    public void careerChooser() throws URISyntaxException {
        List<String> answers = Arrays.asList(QuestionController.answers);
        int barter = Collections.frequency(answers, "Barter");
        int lockpick = Collections.frequency(answers, "Lockpick");
        int medicine = Collections.frequency(answers, "Medicine");
        int explosives = Collections.frequency(answers, "Explosive");
        int repair = Collections.frequency(answers, "Repair");
        int sneak = Collections.frequency(answers, "Sneak");
        int smallguns = Collections.frequency(answers, "SmallGuns");
        int bigguns = Collections.frequency(answers, "BigGuns");
        int energy = Collections.frequency(answers, "Energy");
        int unarmed = Collections.frequency(answers, "Unarmed");
        int speech = Collections.frequency(answers, "Speech");
        int science = Collections.frequency(answers, "Science");
        int melee = Collections.frequency(answers, "Melee");

        if (barter == 4)
        {
            setCareer("Vault Chaplain",
                "They say the G.O.A.T never lies. According to this, you're slated to be the next vault ... Chaplain. God help us all.",
                    0);
                    img = new Image(getClass().getResource("/assets/vault_chaplain.png").toURI().toString());
                    jobIcon.setImage(img);
        } else if (bigguns == 2)
        {

            setCareer("Laundry cannon operator",
                    "Well according to this, you're in line to be trained as a laundry cannon operator. First time for everything indeed.",
                    1);
                     img = new Image(getClass().getResource("/assets/laundry.png").toURI().toString());
                     jobIcon.setImage(img);
        } else if (energy == 2)
        {
            setCareer("Pedicurist",
                    "t's nice to know I can still be surprised. Pedicurist! I might have guessed Manicurist, or even Masseuse. But apparently you're a foot person.",
                    2);
                    img = new Image(getClass().getResource("/assets/pedicurist.png").toURI().toString());
                    jobIcon.setImage(img);
        } else if (explosives == 4)
        {
            setCareer("Waste management specialist",
                    "It says here you're perfectly suited for a career as a Waste Management Specialist. A specialist, mind you, not just a dabbler. Congratulations!",
                    3);
                    img = new Image(getClass().getResource("/assets/waste.png").toURI().toString());
                    jobIcon.setImage(img);
        } else if (lockpick == 2)
        {
            setCareer("Vault loyalty inspector",
                    "Huh. \"Vault Loyalty Inspector\"... I thought that had been phased out decades ago. Well, sounds like a job right up your alley, hmm?",
                    4);
                    img = new Image(getClass().getResource("/assets/inspector.png").toURI().toString());
                    jobIcon.setImage(img);
        } else if (medicine == 4)
        {
            setCareer("Clinical test subject",
                    "Interesting. \"Clinical Test Subject\"... sounds like something you should excel at. I guess you and your dad will be working together.",
                    5);
                    img = new Image(getClass().getResource("/assets/test_subject.png").toURI().toString());
                    jobIcon.setImage(img);
        } else if (melee == 3)
        {
            setCareer("Fry cook",
                    "Looks like the diner's going to get a new Fry Cook. I'll just say this once: hold the mustard, extra pickles. Ha ha ha.",
                    6);
                    img = new Image(getClass().getResource("/assets/cook.png").toURI().toString());
                    jobIcon.setImage(img);


        } else if (repair == 2)
        {
            setCareer("Jukebox technician",
                    "Thank goodness. We're finally getting a new Jukebox Technician. That thing hasn't worked right since old Joe Palmer passed.",
                    7);
                    img = new Image(getClass().getResource("/assets/technician.png").toURI().toString());
                    jobIcon.setImage(img);
        } else if (science == 2)
        {
            setCareer("Pip-Boy programmer",
                    "Well, well. Pip-Boy Programmer, eh? Stanley will finally have someone to talk shop with.",
                    8);
                    img = new Image(getClass().getResource("/assets/programmer.png").toURI().toString());
                    jobIcon.setImage(img);
        } else if (smallguns == 3)
        {
            setCareer("Tattoo artist",
                    "Huh. I wonder who will be brave enough to be your first customer as the vault's new Tattoo Artist? I promise it won't be me.",
                    9);
                    img = new Image(getClass().getResource("/assets/tattoo.png").toURI().toString());
                    jobIcon.setImage(img);
        } else if (sneak == 3)
        {
            setCareer("Shift supervisor",
                    "Apparently you're management material. You're going to be trained as a Shift Supervisor. Could I be talking to the next Overseer? Stranger things have happened.",
                    10);
                    img = new Image(getClass().getResource("/assets/supervisor.png").toURI().toString());
                    jobIcon.setImage(img);
        } else if (speech == 2)
        {
            setCareer("Marriage counselor",
                    "Wow. Wow. Says here you're going to be the vault's Marriage Counselor. Almost makes me want to get married, just to be able to avail myself of your services.",
                    11);
                    img = new Image(getClass().getResource("/assets/counselor.png").toURI().toString());
                    jobIcon.setImage(img);
        } else if(unarmed == 2)
        {
            setCareer("Little league coach",
                    "I always thought you'd have a career in professional sports. You're the new vault Little League coach! Congratulations.",
                    12);
                    img = new Image(getClass().getResource("/assets/littleleague.png").toURI().toString());
                    jobIcon.setImage(img);
        } else
        {
            randomChoice();
        }


    }


    // Each of the determined stat/skill ranges based on the career assigned to the user.
    public int[][] careerStats = {
            // Vault Chaplain stats
            {6, 8, 5, 9, 6, 2, 4,   99, 35, 48, 50, 65, 75, 80, 20, 10, 35, 60, 90, 45},
           //S  P  E  C  I  A  L    Ba  Bg  Ew  Ex  Lp  Md  Mw  Re  Sc  Sg  Sn  Sp  Ua

            // Laundry Cannon Operator
            {8, 4, 7, 2, 4, 7, 6,   35, 95, 50, 50, 65, 25, 48, 95, 80, 45, 25, 25, 35},
           //S  P  E  C  I  A  L    Ba  Bg  Ew  Ex  Lp  Md  Mw  Re  Sc  Sg  Sn  Sp  Ua

            // Pedicurist
            {3, 8, 5, 8, 5, 3, 6,   65, 35, 95, 35, 35, 35, 55, 55, 75, 95, 45, 85, 95},
           //S  P  E  C  I  A  L    Ba  Bg  Ew  Ex  Lp  Md  Mw  Re  Sc  Sg  Sn  Sp  Ua

            // Waste Management Specialist
            {8, 6, 8, 3, 5, 6, 3,   35, 65, 35, 95, 55, 35, 65, 90, 55, 55, 25, 25, 45},
           //S  P  E  C  I  A  L    Ba  Bg  Ew  Ex  Lp  Md  Mw  Re  Sc  Sg  Sn  Sp  Ua

           // Vault Loyalty Inspector
            {3, 8, 6, 8, 7, 8, 3,   45, 55, 25, 25, 95, 45, 25, 45, 45, 45, 95, 65, 35},
           //S  P  E  C  I  A  L    Ba  Bg  Ew  Ex  Lp  Md  Mw  Re  Sc  Sg  Sn  Sp  Ua

           // Clinical Test Subject
            {6, 5, 8, 5, 8, 3, 1,   35, 35, 35, 45, 55, 95, 35, 45, 90, 65, 35, 25, 35},
           //S  P  E  C  I  A  L    Ba  Bg  Ew  Ex  Lp  Md  Mw  Re  Sc  Sg  Sn  Sp  Ua

           // Fry Cook
            {4, 6, 7, 5, 3, 7, 4,   35, 55, 55, 75, 35, 25, 95, 55, 65, 25, 35, 45, 95},
           //S  P  E  C  I  A  L    Ba  Bg  Ew  Ex  Lp  Md  Mw  Re  Sc  Sg  Sn  Sp  Ua

           // Jukebox Technician
            {4, 7, 2, 6, 6, 4, 6,   35, 65, 85, 65, 25, 25, 55, 95, 75, 75, 35, 45, 55},
           //S  P  E  C  I  A  L    Ba  Bg  Ew  Ex  Lp  Md  Mw  Re  Sc  Sg  Sn  Sp  Ua

           // Pip-Boy Programmer
            {4, 7, 3, 2, 9, 3, 6,   35, 55, 65, 65, 35, 35, 45, 95, 95, 35, 45, 35, 35},
           //S  P  E  C  I  A  L    Ba  Bg  Ew  Ex  Lp  Md  Mw  Re  Sc  Sg  Sn  Sp  Ua

           // Tattoo Artist
            {5, 8, 3, 8, 5, 5, 3,   85, 65, 85, 65, 25, 25, 85, 55, 55, 95, 35, 90, 25},
           //S  P  E  C  I  A  L    Ba  Bg  Ew  Ex  Lp  Md  Mw  Re  Sc  Sg  Sn  Sp  Ua

           // Shift Supervisor
            {3, 7, 5, 8, 5, 4, 4,   35, 35, 45, 55, 90, 65, 85, 50, 50, 50, 95, 75, 35},
           //S  P  E  C  I  A  L    Ba  Bg  Ew  Ex  Lp  Md  Mw  Re  Sc  Sg  Sn  Sp  Ua

           // Marriage Counselor
            {3, 8, 5, 8, 6, 3, 5,   45, 35, 35, 45, 90, 55, 50, 35, 35, 45, 90, 95, 35},
           //S  P  E  C  I  A  L    Ba  Bg  Ew  Ex  Lp  Md  Mw  Re  Sc  Sg  Sn  Sp  Ua

           // Little League Coach
            {8, 7, 7, 5, 5, 7, 2,   35, 55, 25, 25, 35, 35, 95, 75, 55, 35, 35, 45, 95}};
           //S  P  E  C  I  A  L    Ba  Bg  Ew  Ex  Lp  Md  Mw  Re  Sc  Sg  Sn  Sp  Ua

    // If a career can't be determined based on the user's answers (Not enough data extracted from the user's answers),
    // a random career is chosen. All thirteen careers have approximately equal odds of being selected
    public void randomChoice() throws URISyntaxException {
        int choice = dice.nextInt(13) + 1; // Generates random number between 1 - 13

        System.out.println(choice);

       switch(choice)
       {
           case 1 :    setCareer("Vault Chaplain",
                       "They say the G.O.A.T never lies. According to this, you're slated to be the next vault ... Chaplain. God help us all.",
                       0);
                       img = new Image(getClass().getResource("/assets/vault_chaplain.png").toURI().toString());
                       jobIcon.setImage(img);
                        break;
           case 2 :    setCareer("Laundry cannon operator",
                       "Well according to this, you're in line to be trained as a laundry cannon operator. First time for everything indeed.",
                       1);
                       img = new Image(getClass().getResource("/assets/laundry.png").toURI().toString());
                       jobIcon.setImage(img);
                        break;
           case 3 :    setCareer("Pedicurist",
                       "t's nice to know I can still be surprised. Pedicurist! I might have guessed Manicurist, or even Masseuse. But apparently you're a foot person.",
                       2);
                       img = new Image(getClass().getResource("/assets/pedicurist.png").toURI().toString());
                       jobIcon.setImage(img);
                        break;
           case 4 :    setCareer("Waste management specialist",
                       "It says here you're perfectly suited for a career as a Waste Management Specialist. A specialist, mind you, not just a dabbler. Congratulations!",
                       3);
                       img = new Image(getClass().getResource("/assets/waste.png").toURI().toString());
                       jobIcon.setImage(img);
                        break;
           case 5 :    setCareer("Vault loyalty inspector",
                       "Huh. \"Vault Loyalty Inspector\"... I thought that had been phased out decades ago. Well, sounds like a job right up your alley, hmm?",
                       4);
                       img = new Image(getClass().getResource("/assets/inspector.png").toURI().toString());
                       jobIcon.setImage(img);
                        break;
           case 6 :    setCareer("Clinical test subject",
                       "Interesting. \"Clinical Test Subject\"... sounds like something you should excel at. I guess you and your dad will be working together.",
                       5);
                       img = new Image(getClass().getResource("/assets/test_subject.png").toURI().toString());
                       jobIcon.setImage(img);
                        break;
           case 7 :    setCareer("Fry cook",
                       "Looks like the diner's going to get a new Fry Cook. I'll just say this once: hold the mustard, extra pickles. Ha ha ha.",
                       6);
                       img = new Image(getClass().getResource("/assets/cook.png").toURI().toString());
                       jobIcon.setImage(img);
                        break;
           case 8 :    setCareer("Jukebox technician",
                       "Thank goodness. We're finally getting a new Jukebox Technician. That thing hasn't worked right since old Joe Palmer passed.",
                       7);
                       img = new Image(getClass().getResource("/assets/technician.png").toURI().toString());
                       jobIcon.setImage(img);
                        break;
           case 9 :    setCareer("Pip-Boy programmer",
                       "Well, well. Pip-Boy Programmer, eh? Stanley will finally have someone to talk shop with.",
                       8);
                       img = new Image(getClass().getResource("/assets/programmer.png").toURI().toString());
                       jobIcon.setImage(img);
                        break;
           case 10 :   setCareer("Tattoo artist",
                       "Huh. I wonder who will be brave enough to be your first customer as the vault's new Tattoo Artist? I promise it won't be me.",
                       9);
                       img = new Image(getClass().getResource("/assets/tattoo.png").toURI().toString());
                       jobIcon.setImage(img);
                        break;
           case 11 :   setCareer("Shift supervisor",
                       "Apparently you're management material. You're going to be trained as a Shift Supervisor. Could I be talking to the next Overseer? Stranger things have happened.",
                       10);
                       img = new Image(getClass().getResource("/assets/supervisor.png").toURI().toString());
                       jobIcon.setImage(img);
                        break;
           case 12 :   setCareer("Marriage counselor",
                       "Wow. Wow. Says here you're going to be the vault's Marriage Counselor. Almost makes me want to get married, just to be able to avail myself of your services.",
                       11);
                       img = new Image(getClass().getResource("/assets/counselor.png").toURI().toString());
                       jobIcon.setImage(img);
                        break;
           case 13 :   setCareer("Little league coach",
                       "I always thought you'd have a career in professional sports. You're the new vault Little League coach! Congratulations.",
                       12);
                       img = new Image(getClass().getResource("/assets/littleleague.png").toURI().toString());
                       jobIcon.setImage(img);
                        break;
       }
    }
}