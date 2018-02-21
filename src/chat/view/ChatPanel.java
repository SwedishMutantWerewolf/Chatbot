
package chat.view;

import chat.controller.ChatController;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
// need import for scrollpane
import javax.swing.JScrollPane;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JButton searchButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton tweetButton;
	private JButton chatButton;
	private JButton checkerButton;
	private JButton exitButton;
	private JButton randomButton;
	private SpringLayout baseLayout;
	private JTextField inputField;
	private JTextArea chatArea;
	private JLabel infoLabel;
	//Need a datamemeber for the scrollpane
	private JScrollPane chatScrollPane;

	/**
	 * Initializes GUI data members, also calling Panel, layout, and listeners methods
	 * @param baseController
	 */
	public ChatPanel(ChatController baseController)
	{
		super();
		this.baseController = baseController;

		// initialize GUI data members
		chatButton = new JButton("chat");
		exitButton = new JButton("Exit");
		randomButton = new JButton("Random, Click me");
		checkerButton = new JButton("check");
		infoLabel = new JLabel(" Type to chat with the chatbot");
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.SOUTH, exitButton, -7, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.NORTH, randomButton, 0, SpringLayout.NORTH, exitButton);
		baseLayout.putConstraint(SpringLayout.WEST, randomButton, 43, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, exitButton);
		baseLayout.putConstraint(SpringLayout.NORTH, checkerButton, 0, SpringLayout.NORTH, exitButton);
		baseLayout.putConstraint(SpringLayout.EAST, checkerButton, -6, SpringLayout.WEST, exitButton);
		//init the scrollpane
		chatScrollPane = new JScrollPane();
		baseLayout.putConstraint(SpringLayout.EAST, exitButton, 0, SpringLayout.EAST, chatScrollPane);
		
		

		inputField = new JTextField(25);
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, 237, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, inputField, -34, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 1, SpringLayout.NORTH, inputField);
		
		
		chatArea = new JTextArea(10, 25);
		//call new helper method
		
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
 
	}

	
	private void setupScrollPane() 
	{
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
	}

	/**
	 * sets up the window with color,layout, and adds components to the ChatFrame
	 */
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setLayout(baseLayout);
		//buttons
		this.add(chatButton);
		this.add(exitButton);
		this.add(randomButton);
		this.add(checkerButton);
		this.add(chatScrollPane);
		this.add(infoLabel);
		this.add(tweetButton);
		//text area
		this.add(inputField);
		chatArea.setEnabled(true);
		chatArea.setEditable(false);
		
	

	}

	/**
	 * the constraint on the components on the Frame
	 */
	private void setupLayout()
	{
		// TextArea
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatArea);
		baseLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 20, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 25, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -25, SpringLayout.EAST, this);
		
		//labels
		baseLayout.putConstraint(SpringLayout.NORTH, infoLabel, 8, SpringLayout.SOUTH, inputField);
		baseLayout.putConstraint(SpringLayout.WEST, infoLabel, 0, SpringLayout.WEST, inputField);
		
	}

	/**
	 * Listening for the components to take action once they are clicked
	 */
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = baseController.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});

		checkerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = baseController.useCheckers(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});

		exitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				changeRandomColor();
			}

		});

		randomButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				changeRandomColor();
			}
		});
	}

	/** 
	 * A method to change the Background color of the Frame
	 */
	private void changeRandomColor()
	{
		int red = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);

		this.setBackground(new Color(red, green, blue));
	}
}



