import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class KNNController implements ActionListener{
	
	//private JList<Feature> feature;
	
	public KNNView view;
	
	public KNNController() {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		
		if (event.getActionCommand().equals("Create Feature")) {
			//knnAlg = new KNNAlgorithim();

			//feature = new JList< >(knnAlg.feature);
			//view.add(feature);
			
			//feature.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			view.getFile().setEnabled(true);

		}
		
		else if (event.getActionCommand().equals("Add Feature")) {
			view.getEdit().setEnabled(true);
			view.getRemove().setEnabled(true);
			
			String name = JOptionPane.showInputDialog(null, "What is feature's name?", "Input feature's Name", JOptionPane.QUESTION_MESSAGE);
			String value = JOptionPane.showInputDialog(null, "What is " + name + "'s value?", "Input " + name + "'s value value", JOptionPane.QUESTION_MESSAGE);

			//feature view = new feature(name, value);
			//knnAlg.addFeature(view);
		
			
			
		}
		else if (event.getActionCommand().equals("Edit Selected Buddy")) {
			
		//	feature featureEdit = knnAlg.getBuddy(feature.getSelectedIndex());
			//String nameEdit = featureEdit.getName();
			
			//String editFeatureName = JOptionPane.showInputDialog(null, "What is feature's name?", "Input feature's Name", JOptionPane.QUESTION_MESSAGE);
			//String editFeatureValue = JOptionPane.showInputDialog(null, "What is " + nameEdit + "'s value?", "Input " + nameEdit + "'s value value", JOptionPane.QUESTION_MESSAGE);
			
			//featureEdit.setFeatureName(editFeatureName);
			//featureEdit.setFeatureValue(editFeatureValue);
		}
		else if (event.getActionCommand().equals("Delete Selected Buddy")) {
			//knnAlg.removeBuddy(feature.getSelectedIndex());
		}
	}
}
	


