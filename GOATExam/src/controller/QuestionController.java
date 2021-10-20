/*
This file is the controller for the question's screen. This file includes
all of the controls that exist within the question's screen as well as the
events and handlers for the question's screen controls.
 */

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Currency;
import java.util.ResourceBundle;

import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class QuestionController 
{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label questionNumberLabel;

    @FXML
    private Label question;

    @FXML
    private Label questionAnswerOne;

    @FXML
    private Label questionAnswerTwo;

    @FXML
    private Label questionAnswerThree;

    @FXML
    private Label questionAnswerFour;

	@FXML
	private Line ansOneTopBorder;

	@FXML
	private Line ansOneBottomBorder;

	@FXML
	private Line ansOneLeftBorder;

	@FXML
	private Line ansOneRightBorder;

	@FXML
	private Line ansTwoTopBorder;

	@FXML
	private Line ansTwoBottomBorder;

	@FXML
	private Line ansTwoLeftBorder;

	@FXML
	private Line ansTwoRightBorder;

	@FXML
	private Line ansThreeTopBorder;

	@FXML
	private Line ansThreeBottomBorder;

	@FXML
	private Line ansThreeLeftBorder;

	@FXML
	private Line ansThreeRightBorder;

	@FXML
	private Line ansFourTopBorder;

	@FXML
	private Line ansFourBottomBorder;

	@FXML
	private Line ansFourLeftBorder;

	@FXML
	private Line ansFourRightBorder;
    
    int counter = 1;

	// The array that stores the factors that are used to determine the user's
	// assigned career. This array is updated every time the user answers a
	// question.
	static public String[] answers = new String[10];

	// This array stores every question that the GOAT Exam will display as well
	// as the answers for each of those questions.
    String[][] questionsAnswers =
    	{
    			{
    				"You are approached by a frenzied Vault scientist, who yells, \"I'm going to put my quantum harmonizer in your photonic resonation chamber!\" What's your response?",
    				
    				"\"But doctor, wouldn't that cause a parabolic destabilization of the fission singularity?\"",
    				"\"Yeah? Up yours too, buddy!\"",
    				"Say nothing, grab a nearby pipe and hit the scientist in the head to knock him out. For all you knew, he was planning to blow up the vault.",
    				"Say nothing, but slip away before the scientist can continue his rant."
    			},
    			
    			{
    				"While working as an intern in the Clinic, a patient with a strange infection on his foot stumbles through the door. The infection is spreading at an alarming rate, but the doctor has stepped out for a while. What do you do?",
    				
    				"Amputate the foot before the infection spreads",
    				"Scream for help",
    				"Medicate the infected area to the best of your abilities",
    				"Restrain the patient, and merely observe as the infection spreads"
    				
    			},
    			
    			{
    				"You discover a young boy lost in the lower levels of the Vault. He's hungry and frightened, but also appears to be in possession of stolen property. What do you do?",
    				
    				"Give the boy a hug and tell him everything will be okay",
    				"Confiscate the property by force, and leave him there as punishment",
    				"Pick the boy's pocket to take the stolen property for yourself, and leave the boy to his fate",
    				"Lead the boy to safety, then turn him over to the overseer"
    				
    			},
    			
    			{
    				"Congratulations! You made one of the Vault 101 baseball teams! Which position do you prefer?",
    				
    				"Pitcher",
    				"Catcher",
    				"Designated Hitter",
    				"None, you wish the vault had a soccer team"
    				
    			},
    			
    			{
    				"Your grandmother invites you to tea, but you're surprised when she gives you a pistol and orders you to kill another Vault resident. What do you do?",
    				
    				"Obey your elder and kill the Vault resident with the pistol.",
    				"Offer your most prized possession for the resident's life.",
    				"Ask granny for a minigun instead. After all, you don't want to miss.",
    				"Throw your tea in granny's face."
    				
    			},
    			
    			{
    				"Old Mr. Abernathy has locked himself in his quarters again, and you've been ordered to get him out. How do you proceed?",
    				
    				"Use a bobby pin to pick the lock on the door.",
    				"Trade a Vault hoodlum for his cherry bomb and blow open the lock.",
    				"Go to the armory, retrieve a laser pistol, and blow the lock off.",
    				"Walk away, and let the old coot rot."
    				
    			},
    			
    			{
    				"Oh, no! You've been exposed to radiation, and a mutated hand has grown out of your stomach! What's the best course of treatment?",
    				
    				"A bullet to the brain",
    				"Large doses of anti-mutagen agent",
    				"Prayer. Maybe God will spare you in exchange for a life of pious devotion.",
    				"Removal of the mutated tissue with a precision laser"
    				
    			},
    			
    			{
    				"A fellow Vault 101 resident is in possession of a Grognak the Barbarian comic book, issue number 1. You want it. What's the best way to obtain it?",
    				
    				"Trade the comic book for one of your own valuable possessions",
    				"Steal the comic book at gunpoint",
    				"Sneak into the resident's quarters, and steal the comic book from his desk",
    				"Slip some knock out drops into the resident's Nuka-Cola, and take the comic book when he's unconscious."
    				
    			},
    			
    			{
    				"You decide it would be fun to play a prank on your father. You enter his private restroom when no one is looking, and....",
    				
    				"Loosen some bolts on some pipes. When the sink is turned on, the room will flood.",
    				"Put a firecracker in the toilet. That's sure to cause some chaos",
    				"Break into the locked medicine cabinet and replace his high blood pressure medication with sugar pills",
    				"Manipulate the power wattage on his razor, so he'll get an electric shock next time he shaves"
    				
    			},
    			
    			{
    				"Who is indisputably the most important person in Vault 101: He who shelters us from the harshness of the atomic wasteland, and to whom we owe everything we have, including our lives?",
    				
    				"The Overseer",
    				"The Overseer",
    				"The Overseer",
    				"The Overseer"
    				
    			},

				{
						"11",

						"11.1",
						"11.2",
						"11.3",
						"11.4"

				}
    	};

    @FXML
    void initialize() 
    {
		// The below events are triggered when the user selects an answer.
		// The counter variable is incremented after each answer is selected.
		// The counter variable works to keep track of which question the user
		// is currently on, and which answer is given and subsequently stored.
    	questionAnswerOne.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
    	{
    		nextScreen(counter++, 1);
    	});
    	
    	questionAnswerTwo.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
    	{
    		nextScreen(counter++, 2);
    	});
    	
    	questionAnswerThree.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
    	{
    		nextScreen(counter++, 3);
    	});
    	
    	questionAnswerFour.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
    	{
    		nextScreen(counter++, 4);
    	});


		// The below events work to display the lime-green borders whenever the
		// user hovers over each of the answers, and removes them whenever the
		// user is not hovering over the answers.
		questionAnswerOne.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event ->
		{
			ansOneTopBorder.setVisible(true);
			ansOneBottomBorder.setVisible(true);
			ansOneRightBorder.setVisible(true);
			ansOneLeftBorder.setVisible(true);
		});

		questionAnswerTwo.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event ->
		{
			ansTwoTopBorder.setVisible(true);
			ansTwoBottomBorder.setVisible(true);
			ansTwoRightBorder.setVisible(true);
			ansTwoLeftBorder.setVisible(true);
		});

		questionAnswerThree.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event ->
		{
			ansThreeTopBorder.setVisible(true);
			ansThreeBottomBorder.setVisible(true);
			ansThreeRightBorder.setVisible(true);
			ansThreeLeftBorder.setVisible(true);
		});

		questionAnswerFour.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event ->
		{
			ansFourTopBorder.setVisible(true);
			ansFourBottomBorder.setVisible(true);
			ansFourRightBorder.setVisible(true);
			ansFourLeftBorder.setVisible(true);
		});

		questionAnswerOne.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event ->
		{
			ansOneTopBorder.setVisible(false);
			ansOneBottomBorder.setVisible(false);
			ansOneRightBorder.setVisible(false);
			ansOneLeftBorder.setVisible(false);
		});

		questionAnswerTwo.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event ->
		{
			ansTwoTopBorder.setVisible(false);
			ansTwoBottomBorder.setVisible(false);
			ansTwoRightBorder.setVisible(false);
			ansTwoLeftBorder.setVisible(false);
		});

		questionAnswerThree.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event ->
		{
			ansThreeTopBorder.setVisible(false);
			ansThreeBottomBorder.setVisible(false);
			ansThreeRightBorder.setVisible(false);
			ansThreeLeftBorder.setVisible(false);
		});

		questionAnswerFour.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event ->
		{
			ansFourTopBorder.setVisible(false);
			ansFourBottomBorder.setVisible(false);
			ansFourRightBorder.setVisible(false);
			ansFourLeftBorder.setVisible(false);
		});
    }


	// This method switches to the next question whenever the user
	// has selected an answer for the question. This method will also
	// display the career screen whenever the user has selected an
	// answer for the tenth question, and has therefore completed
	// the exam.
    public void nextScreen(int questionNumber, int answerNumber)
	{
		if (questionNumber < 10) {
			storeAnswers(questionNumber, answerNumber);
			questionNumberLabel.setText("G.O.A.T. Question " + counter);
			question.setText(questionsAnswers[counter - 1][0]);
			questionAnswerOne.setText(questionsAnswers[counter - 1][1]);
			questionAnswerTwo.setText(questionsAnswers[counter - 1][2]);
			questionAnswerThree.setText(questionsAnswers[counter - 1][3]);
			questionAnswerFour.setText(questionsAnswers[counter - 1][4]);
		}	else if (questionNumber == 10)
		{
			counter = 1;
			questionAnswerOne.getScene().getWindow().hide();

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/careerscreen.fxml"));

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
		}
    }

	// This method stores the factor that helps assign
	// the career for the user once the user finishes
	// the exam. This method also keeps track of the question
	// number and the answer number that is chosen by the
	// integers passed.
	public void storeAnswers(int questionNumber, int answerNumber)
	{
		switch(questionNumber)
		{

			case 1: if(answerNumber == 1)
			{
				answers[counter-2] = "Science";
			} else if(answerNumber == 2)
			{
				answers[counter - 2] = "Speech";
			} else if(answerNumber == 3)
			{
				answers[counter - 2] = "Melee";
			} else if(answerNumber == 4)
			{
				answers[counter - 2] = "Sneak";
			}
				break;

			case 2: if(answerNumber == 1)
			{
				answers[counter - 2] = "Melee";
			} else if(answerNumber == 2)
			{
				answers[counter - 2] = "Speech";
			} else if(answerNumber == 3)
			{
				answers[counter - 2] = "Medicine";
			} else if(answerNumber == 4)
			{
				answers[counter - 2] = "Science";
			}
				break;

			case 3: if(answerNumber == 1)
			{
				answers[counter - 2] = "Speech";
			} else if(answerNumber == 2)
			{
				answers[counter - 2] = "Unarmed";
			} else if(answerNumber == 3)
			{
				answers[counter - 2] = "Sneak";
			} else if(answerNumber == 4)
			{
				answers[counter - 2] = "Nothing";
			}
				break;

			case 4: if(answerNumber == 1)
			{
				answers[counter - 2] = "Explosives";
			} else if(answerNumber == 2)
			{
				answers[counter - 2] = "BigGuns";
			} else if(answerNumber == 3)
			{
				answers[counter - 2] = "Melee";
			} else if(answerNumber == 4)
			{
				answers[counter - 2] = "Unarmed";
			}
				break;

			case 5: if(answerNumber == 1)
			{
				answers[counter - 2] = "SmallGuns";
			} else if(answerNumber == 2)
			{
				answers[counter - 2] = "Barter";
			} else if(answerNumber == 3)
			{
				answers[counter - 2] = "BigGuns";
			} else if(answerNumber == 4)
			{
				answers[counter - 2] = "Explosives";
			}
				break;

			case 6: if(answerNumber == 1)
			{
				answers[counter - 2] = "Lockpick";
			} else if(answerNumber == 2)
			{
				answers[counter - 2] = "Explosives";
				answers[counter - 2] = "Barter";
			} else if(answerNumber == 3)
			{
				answers[counter - 2] = "Energy";
			} else if(answerNumber == 4)
			{
				answers[counter - 2] = "Repair";
			}
				break;

			case 7: if(answerNumber == 1)
			{
				answers[counter - 2] = "SmallGuns";
			} else if(answerNumber == 2)
			{
				answers[counter - 2] = "Medicine";
			} else if(answerNumber == 3)
			{
				answers[counter - 2] = "Barter";
			} else if(answerNumber == 4)
			{
				answers[counter - 2] = "Energy";
			}
				break;

			case 8: if(answerNumber == 1)
			{
				answers[counter - 2] = "Barter";
			} else if(answerNumber == 2)
			{
				answers[counter - 2] = "SmallGuns";
			} else if(answerNumber == 3)
			{
				answers[counter - 2] = "Sneak";
			} else if(answerNumber == 4)
			{
				answers[counter - 2] = "Medicine";
			}
				break;

			case 9: if(answerNumber == 1)
			{
				answers[counter - 2] = "Repair";
			} else if(answerNumber == 2)
			{
				answers[counter - 2] = "Explosive";
			} else if(answerNumber == 3)
			{
				answers[counter - 2] = "Medicine";
			} else if(answerNumber == 4)
			{
				answers[counter - 2] = "Lockpick";
			}
				break;

			case 10: if(answerNumber == 1)
			{
				answers[counter - 2] = "Nothing";
			} else if(answerNumber == 2)
			{
				answers[counter - 2] = "Nothing";
			} else if(answerNumber == 3)
			{
				answers[counter - 2] = "Nothing";
			} else if(answerNumber == 4)
			{
				answers[counter - 2] = "Nothing";
			}
				break;

		}
	}
}
