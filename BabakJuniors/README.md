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
											


PROJECT TITLE: SYSC 3110 Project â€“ Simple Machine Learning Framework

PURPOSE OF PROJECT: The purpose of this project is to come up with a very simple environment for performing machine learning on simple problems. We will use past examples to make 
					predictions about new ones. There is provided an input and based on the inputs, an output is provided. There will be training examples which will have values 
					for each feature and for the output, whereas a testing example only has values for the features, but the output is the job of the algorithm to
					figure out. This will be done by looking at different pattern and correlations between features and outputs in the training examples.
					
VERSION/DATE: 3.0/27th-November-2017

HOW TO START THIS PROJECT: 
						1) Click on Run and a JFrame Window will be visible.
						2) There will be a menubar on top and an empty Jlist for Training Examples and Testing Examples and a predict button. Click on the example menu and click
							on the Create Example menu option.
						3) Create a new Training Example by clicking on the option TrainExample and clicking on Create Training Example, a option menu will pop up to enter the
							name of the TrainingExample such as if the example is houses, use h1, h2 or etc. Enter the name and click OK.
						4) To Create Features for a particular Training Example, click on the option TrainExample and click on the Add Training Feature. An option pane will pop up asking
							the user to enter the index the user needs to add the feature at, if it is the first example then enter 0, if the example is second then enter 1, if
							third then enter 2 and so on. Once OK is clicked,An option pane will pop up asking to choose the option that needs to be (0 to exit, 1 for String, 2
							for float, 3 for composite and 4 to go into a composite feature and 5 to jump out of the current composite) once you select what option and click OK, 
							once OK is clicked, another pane will pop up depending on what has been clicked. if 1 or 2 has been Name of the feature and it value will be asked, once
							Ok is been clicked an option pane will ask again to enter this (0 to exit, 1 for String, 2 for float, 3 for composite and 4 to go into a composite feature and
							5 to jump out of the current composite), if clicked 3, then name of the composite feature will be asked, once again a pop up window will pop up like this
							(0 to exit, 1 for String, 2 for float, 3 for composite and 4 to go into a composite feature and 5 to jump out of the current composite) and then if you click 
							4 then it asks for which composite feature to jump in,once the name is entered and a correct name is entered and OK is clicked you enter the composite feature
							of the name chosen. Once in the Composite Feature the same pop up window will come asking which option to select from 0-5 inside the composite feature. To
							exit out of the Composite feature and add another composite feature or float or string feature, type in 5 and press ok and the Jlabel above  will notify under 
							which Composite Feature the user is in,(head means your exited out of every composite feature).(For Users operating Windows machine, Users
							might need to click the list of example to display/update the feature they have added to the list of examples)
	//tbd				5) To Edit a training feature.....
						6) To Save all the Training Example on a file , go to the TrainingExample menu item and click Save TrainExample to save it on a file.
						7) Create a new Testing Example by clicking on the option TestExample and clicking on Create Testing Example, a option menu will pop up to enter the
							name of the example, if the training example has 2 example then the name should be similar to testing example, but use h3 or h4 etc. Enter the name 
							and click OK. 
	//tbd				8)  To Create Features for a particular Testing Example, click on the option TestExample and click on the Add Testing Feature. An option pane will pop up asking
							the user to enter the index the user needs to add the feature at, if it is the first example then enter 0, if the example is second then enter 1, if
							third then enter 2 and so on. Once OK is clicked, another option pane will pop up and ask the name of the feature that needs to be added, enter the name
							and click OK. Once OK is clicked another option pane will pop up asking the type of feature need to be entered. If the type is String, type 1 and click 
							OK,if float type needs to be entered, then type 2 and click OK, or otherwise if it is a Coordinates value then type 3 and click OK. Depending on the 
							number thats entered another option pane will pop up asking the value of the feature need to be entered. (For Users operating Windows machine, Users
							might need to click the list of example to display/update the feature they have added to the list of examples)
							
	//tbd				9) To predict a feature, the logical requirement is that a single type of feature type should be available in both training and testing example in order to 
							predict a value, so that KNN can compare the nearest neighbours to find out which output to be predicted. To simple predict, click on the button Predict
							and then an option pane will pop up asking the user which feature name to predict, then another option pane will pop up asking the user to enter the 
							nearest KNN neighbours are there, the range of KNN neighbours will be 1 <= KNN Neighbours <= TrainingExample, Once OK is clicked another option pane will
							pop up asking the type of feature need to be entered. If the type is String, type 1 and click OK,if float type needs to be entered, then type 2 and 
							click OK, or otherwise if it is a Coordinates value then type 3 and click OK.
	//tbd				10) To Edit a training feature.....							
						11) To Save all the Testing Example on a file , go to the TestingExample menu item and click Save TestExample to save it on a file.

							
Class Descriptions:	
					Example Class (This class contains all the list of training and testing example and contains all the methods related to adding, and appending rank and creating
									feature type for each example and contains methods related to feature types. and eventually calculuates error)
					Feature Class (This class is an abstract super class contains abstract methods to be utilized by its subclasses, significant class for implementing Composite Pattern)
					CompositeFeature Class (This class is a subclass of Feature class and uses the inherited methods from the feature class and contains methods to allow the implementation of
					allowing the addition of another feature inside a CompositeFeature)
					FloatFeature Class (This class is a subclass of Feature class and uses the inherited methods from the feature class and contains methods to allow the implementation of
					allowing the addition of another feature of type Float inside a CompositeFeature or as an individual feature)
					StringFeature Class (This class is a subclass of Feature class and uses the inherited methods from the feature class and contains methods to allow the implementation of
					allowing the addition of another feature of type String inside a CompositeFeature or as an individual feature)
					KNN class (This class determine the nearest neighbors of a given testing example, given a certain K)
					Distance class (Belongs to a testing example and Maintains a table of distances between the testing example and all training examples. Rows represented by number
									of features and columns represented by number of training examples. Uses this table to normalize distances and use distances to find KNN)
					TestingExample Class (This class inherits all the features from the training example and utilizes the distance class to predict a certain feature compared to
									Training Example)
					TrainingExample Class (This class contains the list of features and methods to implement the list)
					KNNVeiw class ( This class contains the view part of the MVC pattern which is used to display the GUI machine learning algortitm)
					KNNController Class (This class contains the controller part of the MVC pattern which is used to implement GUI machine learning algorithm and the action listeners)

Reason for the version update: 
								1)Implemented the composite pattern on the feature class on the previous version to support the addition of a feature inside a feature
								2)The methods in the Feature class had to many instance variables that were not used and set to null, in this we removed the old implementation of feature
								implemented it according to Composite Pattern so it allows any kind of feature to be added in a certain implementation of a tree.
								3)The methods in the KNN class were are tightly coupled to the example class, therefore we decoupled the KNN class.
								4)Refactored redundent methods and applied high cohesion and loose coupling.
								5) In the previous version the KNN and Distance class had way too many responsibilites, It was used to perform distance calculation however its only responsibility
								is to get the k nearest neighbour and update the Distances according to nearest neighbors. therefore in this version, respective type feature classes are responsible
								for Distance calculation.
								6)In the previous version, the prediction feature only allowed to predict the price of a housing example, now in this version , the predict feature allows
								the user to predict any kind of feature depending on type the user provides as well as in any kind of the example.
								7)In the previous version the normalize distance were calculated in such a way that a feature may have more weight when its added together, but in this
								version the distance are normalized accordingly so that they are displayed between 0 and 1.