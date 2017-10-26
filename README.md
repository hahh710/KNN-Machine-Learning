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

PURPOSE OF PROJECT: The purpose of this project is to come up with a very simple environment for
					performing machine learning on simple problems. We will use past examples to make predictions about new ones. There is provided an input and based on the inputs,
					an output is provided. The testing examples contains the attributes for each example , using the attributes we find the output of a new example contain similar
					attributes.
VERSION/DATE: 1.0/30th-October-2017
HOW TO START THIS PROJECT: Click on Run and you will be able to see the test cases, with each nearest neighbour, there will be a price given to the class.
Class Descriptions: Age Class (This class determines the age of a house given whether its old or new)
					Coordinates class (This class determines the coordinates of a house given its x and y positions.)
					House Class (This class collects all the Attributes of a house(Coordinates, Age, SqrFt, and price) into arraylist and returning as House class.)
					HouseAttributes Interface (An interface for the method getNormalizedValue used in the SqrFt class and Age class)
					KNN class (This class determine the price of a house given its house attributes compared to similar houses)
					SqrFt class (This class contains an attribute of a house which takes in an integer and using that it gets a normalized value which is under a certain limit)
					TestRun class (This class used to run the test cases and provide the output of a testing example which is the price.)
