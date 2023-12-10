/*
 * Armon Wilson
 * SNHU
 * CS-250 Software Development Lifecycle
 * Project - Slideshow
 */

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(Color.BLUE);
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	private String getResizeIcon(int i) {
		String image = ""; 
		
//      ***ADDITIONS***
		// Images have been added to the resources folder. 
		// Image names within this function have been changed to match the images from within the
		// resources folder.
		// Jpeg sizes within resource folder are 640x268
		
		if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/CalaLunaTamarindoCostaRica.jpg") + "'</body></html>";
		} else if (i==2){
			
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/SpaEastmanQuebecCanada.jpg") + "'</body></html>";
		} else if (i==3){
			
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/IsrotelDeadSeaResortIsrael.jpg") + "'</body></html>";
		} else if (i==4){
			
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/HiltonSedonaResortSedonaArizona.jpg") + "'</body></html>";
		} else if (i==5){
			
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/NobuCaboSanLucas.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	
/*
 *     ***ADDITIONS***
 *     Altered the strings to add the new locations and descriptions of each.
 */
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==1){
			text = "<html><body><font size='5'>#1 Cala Luna - Tamarindo, Costa Rica.</font> <br>Experience transformative wellness, yoga,"
					+ " holistic treatments, and sustainable, locally sourced cuisine by the Pacific Ocean.</body></html>";
			
		} else if (i==2){
			text = "<html><body><font size='5'>#2 Spa Eastman - Quebec, Canada</font> <br>Nordic hot pools in forest surroundings, and "
					+ "energizing saunas and Igloo showers with refreshing scents.</body></html>";
			
		} else if (i==3){
			text = "<html><body><font size='5'>#3 Isrotel - Israel</font> <br>Dead Sea treatments, sulfur pools, saunas, and health workshops"
					+ " amid stunning mountain scenery.</body></html>";
			
		} else if (i==4){
			text = "<html><body><font size='5'>#4 Hilton Sedona Resort - Sedona, AZ</font> <br>Eforea Spa, local therapies, and access to Sedona's"
					+ " famed hiking trails amidst stunning red rock scenery. </body></html>";
			
		} else if (i==5){
			text = "<html><body><font size='5'>#5 Nobu - Cabo San Lucas, Mexico</font> <br>An Asian-inspired oasis with outdoor hydrotherapy,"
					+ " wellness activities, and ocean-view dining in Mexico's Baja California. </body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}