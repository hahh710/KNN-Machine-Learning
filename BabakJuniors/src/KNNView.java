import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class KNNView extends JFrame{

	/**
	 * an instance of KNN belongs to each instance of testing example
	 *
	 * @Authors: Ahmed Khattab
	 * @Purpose: Determine the nearest neighbors of a given testing example, given a certain K
	 *
	 * @field variables
	 * - nearestNeighbors ArrayList<TrainingExamples>: represents the list of nearest neighbors
	 * - k int: represents the number of nearest neighbors
	 * - testEx Testing Example: represents the reference to the owner of this instance
	 * 
	 * @methods 
	 *+getTestExample
	 *+getAddFeature
	 *+getTrainingPanel
	 *+getTrainingPanel
	 *+
	 *
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private KNNController controller;

	private JPanel trainingPanel, testingPanel ;
	private JButton predict;
	private JMenuItem createTrainExample,createTestExample,editTrainFeature,addTrainingFeature,createExample,restart,addTestingFeature,calculateError,editTestFeature;
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
		
	
		GridLayout layout = new GridLayout(2,2);
		this.setLayout(layout);

		trainingPanel = new JPanel(new BorderLayout());
		trainingPanel.setBackground(java.awt.Color.WHITE);
		

		testingPanel = new JPanel(new BorderLayout());
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
		
		restart = new JMenuItem("Restart");
		restart.addActionListener(controller);

		createTrainExample = new JMenuItem("Create Training Example");
		createTrainExample.setEnabled(false);
		createTrainExample.addActionListener(controller);

		createTestExample = new JMenuItem("Create Testing Example");
		createTestExample.setEnabled(false);
		createTestExample.addActionListener(controller);
		
		addTrainingFeature = new JMenuItem ("Add Training Feature");
		addTrainingFeature.setEnabled(false);
		addTrainingFeature.addActionListener(controller);
		
		editTrainFeature = new JMenuItem("Edit Training Feature");
		editTrainFeature.setEnabled(false);
		editTrainFeature.addActionListener(controller);
		
		calculateError = new JMenuItem("CalculateError");
		calculateError.setEnabled(false);
		calculateError.addActionListener(controller);
		
		addTestingFeature = new JMenuItem("Add Testing Feature");
		addTestingFeature.setEnabled(false);
		addTestingFeature.addActionListener(controller);
		

		editTestFeature = new JMenuItem("Edit Testing Feature");
		editTestFeature.setEnabled(false);
		editTestFeature.addActionListener(controller);
		
		
		
		
		
		example.add(createExample);
		example.add(restart);
		trainExample.add(createTrainExample);
		testExample.add(createTestExample);
		testExample.add(addTrainingFeature);
		trainExample.add(addTrainingFeature);
		trainExample.add(editTrainFeature);
		testExample.add(addTestingFeature);
		testExample.add(editTestFeature);
		testExample.add(calculateError);
		
		testingPanel.add(predict,BorderLayout.SOUTH);
		
	pack();
		this.setVisible(true);

	}
	
	public JMenuItem getTrainFeature() {
		return addTrainingFeature;
	}
	
	public JPanel getTrainingPanel() {
		return trainingPanel;
	}
	
	public JPanel getTestingPanel() {
		return testingPanel;
	}
	
	public JMenuItem getFeatureTrainEdit() {
		return editTrainFeature;	
	}
	
	public JMenuItem getFeatureTestEdit() {
		return editTestFeature;	
	}
	
	public JMenuItem getTrainExample() {
		return createTrainExample;
	}
	
	public JMenuItem getCalculateError() {
		return calculateError;
	}
	
	public JMenu getExample() {
		return example;
	}
	
	public JMenuItem getTestExample() {
		return createTestExample;
	}
	
	public JMenuItem getTestFeature() {
		return addTestingFeature;
	}
	
	
	public static void main(String args[]) {
		new KNNView();
	}

}
