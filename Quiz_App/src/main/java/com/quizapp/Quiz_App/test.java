package com.quizapp.Quiz_App;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class test {

	public static void main(String[] args) {

//		Session session = Hibernate_utility.getSessionFactory().openSession();
//		Transaction transaction = null;
//
//		transaction = session.beginTransaction();
//
//		Question q = new Question();
//		Question q1 = new Question();
//
//		Answer a = new Answer();
//		a.setAns("Rohit-Sharma");
//		a.setQuestion(q);
//		session.save(a);
//
//		Answer a1 = new Answer();
//		a1.setAns("Pacific Ocean");
//		a1.setQuestion(q1);
//		session.save(a1);
//
//		q.setQuestion("Who is India Cricket Team Captain");
//		q.setAns(a);
//		session.save(q);
//
//		q1.setQuestion("Which is the largest ocean in the world?");
//		q1.setAns(a1);
//		session.save(q1);
//
////		option for 1 question   
//
//		Options o1 = new Options();
//		o1.setOpt("Rohit-Sharma");
//		o1.setQuestion(q);
//		session.save(o1);
//
//		Options o2 = new Options();
//		o2.setOpt("Virat Kohli");
//		o2.setQuestion(q);
//		session.save(o2);
//
//		Options o3 = new Options();
//		o3.setOpt("KL Rahul");
//		o3.setQuestion(q);
//		session.save(o3);
//
//		Options o4 = new Options();
//		o4.setOpt("Bumrah");
//		o4.setQuestion(q);
//		session.save(o4);
//
////		option for 2 question
//
//		Options o5 = new Options();
//		o5.setOpt("Atlantic Ocean");
//		o5.setQuestion(q1);
//		session.save(o5);
//
//		Options o6 = new Options();
//		o6.setOpt("Indian Ocean");
//		o6.setQuestion(q1);
//		session.save(o6);
//
//		Options o7 = new Options();
//		o7.setOpt("Pacific Ocean");
//		o7.setQuestion(q1);
//		session.save(o7);
//
//		Options o8 = new Options();
//		o8.setOpt("Arctic Ocean");
//		o8.setQuestion(q1);
//		session.save(o8);
//
//		session.getTransaction().commit();
//		session.close();
//		System.out.println("success");
		
		
		
		  Session session = Hibernate_utility.getSessionFactory().openSession();
	        Transaction transaction = session.beginTransaction();

	        Question[] questions = new Question[5];
	    
	        Answer[] answers = {
	            new Answer("Rohit-Sharma",questions[0]),
	            new Answer("Pacific Ocean",questions[1]),
	            new Answer("New Delhi",questions[2]),
	            new Answer("Ganga",questions[3]),
	            new Answer("Diwali",questions[4])
	            
	        };


	        
	        questions[0] = new Question("Who is India Cricket Team Captain", answers[0]);
	        questions[1] = new Question("Which is the largest ocean in the world?",answers[1]);
	        questions[2] = new Question("What is the capital city of India?",answers[2]);
	        questions[3] = new Question("Which river is considered the holiest river in India?",answers[3]);
	        questions[4] = new Question("Which Indian festival is known as the Festival of Lights?",answers[4]);
	        
	        
	        	        
	        
	        for (int i = 0; i < questions.length; i++) {
	            questions[i].setAns(answers[i]);
	            answers[i].setQuestion(questions[i]);
	            session.save(answers[i]);
	            session.save(questions[i]);
	        }

	        
	        String[][] options = {
	            {"Rohit-Sharma", "Virat Kohli", "KL Rahul", "Bumrah"},
	            {"Atlantic Ocean", "Indian Ocean", "Pacific Ocean", "Arctic Ocean"},
	            {"Mumbai", "New Delhi", "Kolkata", "Bangalore"},
	            {"Yamuna","Ganga","Godavari","Brahmaputra"},
	            {"Holi","Eid","Diwali","Christmas"}
	            
	        };

	        
	        for (int i = 0; i < questions.length; i++) {
	            for (String opt : options[i]) {
	                session.save(new Options(opt, questions[i]));
	            }
	        }

	        transaction.commit();
	        session.close();
	        System.out.println("success");
	}

	
	
}
