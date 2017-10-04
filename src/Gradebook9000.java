import java.util.Scanner;

public class Gradebook9000
{
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args)
	{
		// Variables
		String[] names;	
		int[] avgGrades, testGrades, homeworkGrades, projectGrades;
		int numTests, numHomeworks;
		int numProjects, numStudents;
		int testAvg, homeworkAvg, projectAvg;
		int homeworkWeight, testWeight, projectWeight;
		String letterGrade = null;

		// Welcome the user to your program
		System.out.println("Welcome to Dustin's Gradebook!\n");

		// Get the number of students and initialize names and avgGrades
		System.out.println("Please enter the number of students in this class: ");
		numStudents = input.nextInt();
		input.nextLine();

		names = new String [numStudents];
		avgGrades = new int [numStudents];

		// prompt and initialize the corresponding variables

		// Get the students names
		// probably a loop since we don't know when we're coding how many students
		for (int i = 0; i < names.length; i++)
		{
			System.out.println("Please enter the name of a Student: ");
			names [i] = input.nextLine();

		}

		// Give the user information about the system.
		System.out.println("\nThis GradeBook calculates a student's grade");
		System.out.println("by calculating their average score for homework,");
		System.out.println("tests, and projects.  It then calculates a weighted");
		System.out.println("average to obtain their final score.\n");

		// Get the number of tests, homeworks, and projects and initialize the arrays
		// Initializing the arrays here is very important

		System.out.println("Please enter the number of Homework Assignments: ");
		numHomeworks = input.nextInt();
		input.nextLine();

		System.out.println("Please enter the number of Class Projects: ");
		numProjects = input.nextInt();
		input.nextLine();

		System.out.println("Please enter the number of Tests: ");
		numTests = input.nextInt();
		input.nextLine();

		System.out.println("Please enter the Weight of Homework Assignments in %:");
		homeworkWeight = input.nextInt();
		input.nextLine();

		System.out.println("Please enter the Weight of Class Projects in %: ");
		projectWeight = input.nextInt();
		input.nextLine();

		System.out.println("Please enter the Weight of Tests in %: ");
		testWeight = input.nextInt();
		input.nextLine();

		while (homeworkWeight+projectWeight+testWeight != 100)
		{
			System.out.println("Please ensure the Weight of your 3 categories adds up to 100% !\n");
			System.out.println("Please enter the Weight of Homework Assignments:");
			homeworkWeight = input.nextInt();
			input.nextLine();
			System.out.println("Please enter the Weight of Class Projects: ");
			projectWeight = input.nextInt();
			input.nextLine();
			System.out.println("Please enter the Weight of Tests: ");
			testWeight = input.nextInt();
			input.nextLine();
		}

		// initialize arrays for test, hw, and projects
		testGrades = new int [numTests];
		homeworkGrades = new int [numHomeworks];
		projectGrades = new int [numProjects];


		// Loop for each student, get the grades, store them, report average for each section
		
		for(int i = 0; i < names.length; i++ )
		{
			// Get the homework grades, calculate average, and report

			for(int j = 0; j < homeworkGrades.length; j++)
			{
				
				System.out.println("Enter " + names[i] + "'s score for Homework assignment #" + (j+1) + " , please enter a value 0-100 inclusively");
				homeworkGrades [j] = input.nextInt();
				input.nextLine();
				
				while(homeworkGrades [j] < 0 || homeworkGrades [j] > 100)			
				{
					System.out.println("Please ensure you are entering grades 0-100 inclusively!");
					System.out.println("Enter " + names[i] + "'s score for Homework assignment #" + (j+1) + " , please enter a value 0-100 inclusively");
					homeworkGrades [j] = input.nextInt();
					input.nextLine();
				}
		
			}
			homeworkAvg = averageArray(homeworkGrades);
			System.out.println(names[i] + "'s average for Homework is: " + homeworkAvg);

			// Get the project grades, calculate average, and report

			for(int j = 0; j < projectGrades.length; j++)
			{
				System.out.println("Enter " + names[i] + "'s score for Project #" + (j+1)+ " , please enter a value 0-100 inclusively");
				projectGrades [j] = input.nextInt();
				input.nextLine();
				
				while(projectGrades [j] < 0 || projectGrades [j] > 100)			
				{
					System.out.println("Please ensure you are entering grades 0-100 inclusively!");
					System.out.println("Enter " + names[i] + "'s score for Project #" + (j+1)+ " , please enter a value 0-100 inclusively");
					projectGrades [j] = input.nextInt();
					input.nextLine();
				}
			}
			projectAvg = averageArray(projectGrades);
			System.out.println(names[i] + "'s average for Projects is: " + projectAvg);

			// Get the test scores, calculate average, and report

			for(int j = 0; j < testGrades.length; j++)
			{
				System.out.println("Enter " + names[i] + "'s score for Test #" + (j+1) + " , please enter a value 0-100 inclusively");
				testGrades [j] = input.nextInt();
				input.nextLine();
				
				while(testGrades [j] < 0 || testGrades [j] > 100)			
				{
					System.out.println("Please ensure you are entering grades 0-100 inclusively!");
					System.out.println("Enter " + names[i] + "'s score for Test #" + (j+1) + " , please enter a value 0-100 inclusively");
					testGrades [j] = input.nextInt();
					input.nextLine();
				}
			}
			testAvg = averageArray(testGrades);
			System.out.println(names[i] + "'s average for Tests is: " + testAvg);

			// Calculate overall average grade and store it

			avgGrades [i] = (int)(homeworkAvg * ((double)homeworkWeight/100) + testAvg * ((double)testWeight/100) 
					+ projectAvg * ((double)projectWeight/100) + .5);

		}	//end the for loop

		// Print out grades
		for(int i = 0; i < names.length; i++)
		{
			if(avgGrades [i] >= 90)
			{
				letterGrade = "A";
			}
			else if(avgGrades [i] >= 80 && avgGrades [i] < 90)
			{
				letterGrade = "B";
			}
			else if(avgGrades [i] >= 70 && avgGrades [i] < 80)
			{
				letterGrade = "C";
			}
			else if(avgGrades [i] >= 60 && avgGrades [i] < 70)
			{
				letterGrade = "D";
			}
			else if(avgGrades [i] <= 59)
			{
				letterGrade = "F";
			}
			System.out.println("\n\nHere are the grades for " + names [i] + ": " + avgGrades [i] + " " + letterGrade);
		}

		System.out.println("\nThank you for using Dustin's Gradebook.  Have a nice day!");

		// Close the keyboard object
		input.close();
	}


	/**
	 * This method calculates the integer average of the array of integers
	 * passed in.  It follows the standard rounding procedures.
	 * @param array The array of ints to be averaged.
	 * @return The rounded average of the ints in the array.
	 */
	public static int averageArray(int[] array)
	{
		int sum = 0;
		for(int j = 0; j < array.length; j++)
		{
			sum += array[j];
		}
		return (int)(1.0 * sum / array.length + 0.5);
	}
	
	
	/**	Method gives a corresponding letter grade for a numerical grade entered
	 * 
	 */
	
//	public static char getLetterGrade(int grade)
//	{
//		char letterGrade;
//		if(grade >= 90)
//		{
//			letterGrade = 'A';
//		}
//		else if(grade >= 80)
//		{
//			letterGrade = 'B';
//		}
//		else if(grade >= 70)
//		{
//			letterGrade = 'C';
//		}
//		else if(grade >= 60)
//		{
//			letterGrade = 'D';
//		}
//		else
//		{
//			letterGrade = 'F';
//		}
//		
//		return letterGrade;
//	}

}
