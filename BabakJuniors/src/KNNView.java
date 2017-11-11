import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class KNNView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private KNNController controller;

	
	private JButton predict;
	private JMenuItem createTrainExample,createTestExample,editTestExample,editTrainExample,addFeature,createExample;
	private JMenu trainExample,testExample,example;
	

	
	public KNNView() {
		
		controller = new KNNController(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(100, 100);
		this.setSize(new Dimension(1024, 450));
		this.setResizable(true);
		
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		example = new JMenu("Example");
		trainExample = new JMenu("TrainExample");
		testExample = new JMenu("TestExample");
		
	
		GridLayout layout = new GridLayout(2, 1);
		this.setLayout(layout);

		JPanel trainingPanel = new JPanel();
		trainingPanel.setBackground(java.awt.Color.WHITE);

		JPanel testingPanel = new JPanel(new BorderLayout());
		testingPanel.setBackground(java.awt.Color.WHITE);
		
		
		TitledBorder trainBorder = BorderFactory.createTitledBorder("Training Example(s): ");
		TitledBorder testBorder = BorderFactory.createTitledBorder("Testing Example(s): ");
		testingPanel.setBorder(testBorder);
		trainingPanel.setBorder(trainBorder);
		
		
		this.add(trainingPanel);
		this.add(testingPanel);
		
		menuBar.add(example);
		menuBar.add(trainExample);
		menuBar.add(testExample);
	
		
		predict = new JButton("Predict");
		predict.setSize(10,10);
		predict.addActionListener(controller);
		
		
		
		createExample = new JMenuItem("Create Example");
		createExample.addActionListener(controller);

		createTrainExample = new JMenuItem("Create Training Example");
		createTrainExample.setEnabled(false);
		createTrainExample.addActionListener(controller);

		createTestExample = new JMenuItem("Create Testing Example");
		createTestExample.setEnabled(false);
		createTestExample.addActionListener(controller);
		
		addFeature = new JMenuItem ("Add Feature");
		addFeature.setEnabled(false);
		addFeature.addActionListener(controller);
		
		editTrainExample = new JMenuItem("Edit Training Example");
		editTrainExample.setEnabled(false);
		editTrainExample.addActionListener(controller);
		
		editTestExample = new JMenuItem("Edit Testing Example");
		editTestExample.setEnabled(false);
		editTestExample.addActionListener(controller);
		
		
		example.add(createExample);
		trainExample.add(createTrainExample);
		testExample.add(createTestExample);
		testExample.add(addFeature);
		trainExample.add(addFeature);
		testExample.add(editTestExample);
		trainExample.add(editTrainExample);
		
		
		testingPanel.add(predict,BorderLayout.SOUTH);
		
	
		this.setVisible(true);

	}
	
	public JMenuItem getAddFeature() {
		return addFeature;
	}
	
	public JMenuItem getTrainEdit() {
		return editTrainExample;	
	}
	
	public JMenuItem getTestEdit() {
		return editTestExample;	
	}
	
	public JMenuItem getTrainExample() {
		return createTrainExample;
	}
	
	public JMenu getExample() {
		return example;
	}
	
	public JMenuItem getTestExample() {
		return createTestExample;
	}
	
	public static void main(String args[]) {
		new KNNView();
	}

}
