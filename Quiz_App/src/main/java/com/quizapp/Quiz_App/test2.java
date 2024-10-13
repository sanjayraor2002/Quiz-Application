package com.quizapp.Quiz_App;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class test2 {

	public static void main(String[] args) {
		
	    
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        
        while(true) {
        Scanner in=new Scanner(System.in);
		System.out.println(ConsoleColors.YELLOW_BACKGROUND+ConsoleColors.PURPLE+"----------------Login and Register System-----------------"+ConsoleColors.RESET);
		System.out.println("1: Register ");
		System.out.println("2: Login");
		System.out.println("3: Exit");
		System.out.print("Choose an Option: ");
		int option=in.nextInt();
		
			
			switch(option) {
			case 1: login_main.register(in);
					System.out.println("Once Registered ....Please Login");
					break;
					
			case 2: if(login_main.login(in)) {
					startQuiz(factory,in);
					
			}else {
				System.out.println("Login Failed");
			}
					break;
			
			case 3: System.out.println("Exit");
					Hibernate_utility.getSessionFactory().close();
					System.exit(0);
					break;
			default:
					System.out.println("Invalid Option");
			
		}
		}
	}

	public static void startQuiz(SessionFactory factory, Scanner in) {
		System.out.println("--------------------------------------------------");
		System.out.println(ConsoleColors.GREEN +"*******************Valid User*******************"+ConsoleColors.RESET);
		System.out.println(ConsoleColors.RED+"🎯🎯🎯🎯   Welcome To Quiz Application   🎯🎯🎯🎯"+ConsoleColors.RESET);
		System.out.println("--------------------------------------------------");
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		List<Question> questions=session.createQuery("from Question",Question.class).list();
		

		int qn=1;
		int score = 0;

		for(Question q:questions) {

			System.out.println(ConsoleColors.CYAN+"Question --> "+ConsoleColors.RESET+ qn +" "+ConsoleColors.BLUE+ConsoleColors.YELLOW_BACKGROUND+ q.getQuestion()+ConsoleColors.RESET);

			if (q.getOption() != null && !q.getOption().isEmpty()) {
				int optionNumber = 1;
				System.out.println("Options");
				for (Options opt : q.getOption()) {

					System.out.println(ConsoleColors.RED+optionNumber +ConsoleColors.RESET+ ". " +ConsoleColors.CYAN +opt.getOpt()+ConsoleColors.RESET);
					optionNumber++;
				}
			} else {
				System.out.println("No options available for this question.");
			}
		
		

		Scanner sc = new Scanner(System.in);
		System.out.print("Choose an option (1-4): ");
		int selectedOption = sc.nextInt();

		if (selectedOption < 1 || selectedOption > 4) {
			System.out.println("Invalid option selected!");
			System.exit(0);
		}

//		Session session4 = factory.openSession();
//		Transaction tx2 = session4.beginTransaction();

		Answer correctAnswer = q.getAns();
		
		if (correctAnswer != null) {

			String correctAnswerText = correctAnswer.getAns();
			Options selectedOpt = q.getOption().get(selectedOption - 1);

			if (selectedOpt.getOpt().equalsIgnoreCase(correctAnswerText)) {
				System.out.println(ConsoleColors.GREEN+"Correct Answer \u2705"+ConsoleColors.RESET);
				score++;
				System.out.println();
              
			} else {
				System.out.println(ConsoleColors.RED+"Wrong Answer \u274C"+ConsoleColors.RESET);
				System.out.println();
				
				System.out.println(ConsoleColors.GREEN_BACKGROUND+"Your Score is: " + ConsoleColors.RED+  score  +ConsoleColors.RESET);
				System.out.println("--------------------------------------------------");
				System.out.println(ConsoleColors.YELLOW+"**********Thank You for Taking Quiz***************"+ConsoleColors.RESET);
				System.out.println(ConsoleColors.RESET);
				System.exit(0);
			}
		} else {
			System.out.println("No answer found for this question.");
		}
		qn++;
	}
		System.out.println("--------------------------------------------------");
		 	System.out.println("-------------Quiz completed--------------");
	        System.out.println("Your final score is: " + ConsoleColors.YELLOW+score+ConsoleColors.RESET);
	        System.out.println(ConsoleColors.BLUE+"**********Thank You for Taking Quiz***************"+ConsoleColors.RESET);
	        System.exit(0);

	        tx.commit();
	        session.close();
	}
}

