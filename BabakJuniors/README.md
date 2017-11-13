------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------
# project-babak-juniors

The Authors for this project are as follows: 
											1)Hunho Ha
											2)Ahmed Khattab
											3)Arsalan Sadiq
											4)Jeffery Tudor
											


PROJECT TITLE: SYSC 3110 Project – Simple Machine Learning Framework

PURPOSE OF PROJECT: The purpose of this project is to come up with a very simple environment for performing machine learning on simple problems. We will use past examples to make 
					predictions about new ones. There is provided an input and based on the inputs, an output is provided. There will be training examples which will have values 
					for each feature and for the output, whereas a testing example only has values for the features, but the output is the job of the algorithm to
					figure out.This will be done by looking at different pattern and correlations between features and outputs in the training examples.
					
VERSION/DATE: 2.0/13th-November-2017

HOW TO START THIS PROJECT: 
						1) Click on Run and a JFrame Window will be visible.
						2) There will be a menubar on top and an empty Jlist for Training Examples and Testing Examples and a predict button. Click on the example menu and click
							on the Create Example menu option.
						3) To Create a new Training Example by clicking on the option TrainExample and clicking on Create Training Example, a option menu will pop up to enter the
							name of the example such as if the example is houses, use h1, h2 or etc. Enter the name and click OK.
						4) To Create Features for a particular Training Example, click on the option TrainExampleand click on the Add Feature. An option pane will pop up asking
							the user to enter the index the user needs to add the feature at, if it is the first example then enter 0, if the example is second then enter 1, if
							third then enter 2 and so on. Once OK is clicked, another option pane will pop up and ask the name of the feature that needs to be added, enter the name
							and click OK. Once OK is clicked another option pane will pop up asking the type of feature need to be entered. If the type is String, type 1 and click 
							OK,if float type needs to be entered, type 2 and click OK, or otherwise if it is a Coordinates value type then type 3 and click OK. Depending on the 
							number thats entered another option pane will pop up asking the value of the feature need to be entered. (For Users operating Windows machine, Users
							might need to click the list of example to display/update the feature they have added to the list of examples)
						5) Create a new Testing Example by clicking on the option TestExample and clicking on Create Testing Example, a option menu will pop up to enter the
							name of the example, if the training example has 2 example then the name should be similar to testing example, but use h3 or h4 etc. Enter the name 
							and click OK. 
						6)  To Create Features for a particular Testing Example, click on the option TestExample and click on the Add Testing Feature. An option pane will pop up asking
							the user to enter the index the user needs to add the feature at, if it is the first example then enter 0, if the example is second then enter 1, if
							third then enter 2 and so on. Once OK is clicked, another option pane will pop up and ask the name of the feature that needs to be added, enter the name
							and click OK. Once OK is clicked another option pane will pop up asking the type of feature need to be entered. If the type is String, type 1 and click 
							OK,if float type needs to be entered, then type 2 and click OK, or otherwise if it is a Coordinates value then type 3 and click OK. Depending on the 
							number thats entered another option pane will pop up asking the value of the feature need to be entered. (For Users operating Windows machine, Users
							might need to click the list of example to display/update the feature they have added to the list of examples)
						7) To predict a feature, the logical requirement is that a single type of feature type should be available in both training and testing example in order to 
							predict a value, so that KNN can compare the nearest neighbours to find out which output to be predicted. To simple predict, click on the button Predict
							and then an option pane will pop up asking the user which feature name to predict, then another option pane will pop up asking the user to enter the 
							nearest KNN neighbours are there, the range of KNN neighbours will be 1 <= KNN Neighbours <= TrainingExample, Once OK is clicked another option pane will
							pop up asking the type of feature need to be entered. If the type is String, type 1 and click OK,if float type needs to be entered, then type 2 and 
							click OK, or otherwise if it is a Coordinates value then type 3 and click OK.

							
Class Descriptions: Example Class (This class contains all the list of training and testing example and contains all the methods related to adding, and appending rank and creating
									feature type for each example and contains methods related to feature types. and eventually calculuates error)
					Feature Class (This class collects all the Attributes of an example listed out in different types allowing user to enter each attribute)
					KNN class (This class determine the nearest neighbors of a given testing example, given a certain K)
					Distance class (Belongs to a testing example and Maintains a table of distances between the testing example and all training examples. Rows represented by number
									of features and columns represented by number of training examples. Uses this table to normalize distances and use distances to find KNN)
					TestingExample Class (This class inherits all the features from the training example and utilizes the distance class to predict a certain feature compared to
									Training Example)
					TrainingExample Class (This class contains the list of features and methods to implement the list)
					KNNVeiw class ( This class contains the view part of the MVC pattern which is used to display the GUI machine learning algortitm)
					KNNController (This class contains the controller part of the MVC pattern which is used to implement GUI machine learning algorithm and the action listeners)

Reason for the version update: 
								1)Our structure of the algorithm in the previous version worked only for the example of the house, therefore we modified our design to work for anything
								kind of example such as Ladders, Rooms or either houses.n the project requirements, we were required to have more than one examples but in this modified
								version the GUI can work for any number of examples.
								2)The methods in the KNN class were are tightly coupled to the example class, therefore we decoupled the KNN class.
								3) In the previous version the KNN class had way too many responsibilites, It was used to perform distance calculation however its only responsibility
								is to get the k nearest neighbour. therefore in this version, the Distance class is responsible to perform the Distance calculation whihc depends on the
								data type.
								4)In the previous version, the prediction feature only allowed to predict the price of a housing example, now in this version , the predict feature allows
								the user to predict any kind of feature depending on type the user provides as well as in any kind of the example.
								5)In the previous version the normalize distance were calculated in such a way that a feature may have more weight when its added together, but in this
								version the distance are normalized accordingly so that they are displayed between 0 and 1.