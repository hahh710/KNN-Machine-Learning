import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class KNNView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private KNNController controller;

	private JPanel trainingPanel, testingPanel ;
	private JButton predict;
	private JMenuItem createTrainExample,createTestExample,editFeature,addFeature,createExample,restart,testingFeature;
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
		
		addFeature = new JMenuItem ("Add Feature");
		addFeature.setEnabled(false);
		addFeature.addActionListener(controller);
		
		editFeature = new JMenuItem("Edit Feature");
		editFeature.setEnabled(false);
		editFeature.addActionListener(controller);
		
		testingFeature = new JMenuItem("Add Testing Feature");
	
		testingFeature.addActionListener(controller);
		
		
		
		
		example.add(createExample);
		example.add(restart);
		trainExample.add(createTrainExample);
		testExample.add(createTestExample);
		testExample.add(addFeature);
		trainExample.add(addFeature);
		trainExample.add(editFeature);
		testExample.add(testingFeature);
		
		testingPanel.add(predict,BorderLayout.SOUTH);
		
	
		this.setVisible(true);

	}
	
	public JMenuItem getAddFeature() {
		return addFeature;
	}
	
	public JPanel getTrainingPanel() {
		return trainingPanel;
	}
	
	public JPanel getTestingPanel() {
		return testingPanel;
	}
	
	public JMenuItem getFeatureEdit() {
		return editFeature;	
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
