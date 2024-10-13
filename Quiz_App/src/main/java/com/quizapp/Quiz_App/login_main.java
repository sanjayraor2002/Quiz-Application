package com.quizapp.Quiz_App;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class login_main {

	public static void register(Scanner scanner) {

		System.out.println(ConsoleColors.YELLOW_BACKGROUND+ConsoleColors.PURPLE+"--------------Register as a New User -------------"+ConsoleColors.RESET);
		Scanner in = new Scanner(System.in);
		System.out.print("Enter Username: ");
		String username = in.nextLine();
		System.out.print("Enter Password: ");
		String password = in.nextLine();

		Session session = Hibernate_utility.getSessionFactory().openSession();
		Transaction transaction = null;

		transaction = session.beginTransaction();
		User user = new User(username, password);
		session.save(user);
		transaction.commit();

		System.out.println("User Registered Successfully");
		session.close();

	}

	public static boolean login(Scanner scanner) {
		System.out.println(ConsoleColors.BLUE_BACKGROUND);
		
		System.out.println("⏩⏩⏩⏩⏩⏩⏩⏩⏩⏩⏩  Login  ⏩⏩⏩⏩⏩⏩⏩⏩⏩⏩");
		
		System.out.println(ConsoleColors.RESET);
		Scanner in = new Scanner(System.in);
		System.out.print("Enter Username: ");
		String username = in.nextLine();
		System.out.print("Enter Password: ");
		String password = in.nextLine();

		Session session = Hibernate_utility.getSessionFactory().openSession();

		Query<User> query = session.createQuery("From User Where username=:username AND password=:password",User.class);
		query.setParameter("username", username);
		query.setParameter("password", password);

		User user = query.uniqueResult();
		if (user != null) {
			return true;
		}
		return false;

	}

}
