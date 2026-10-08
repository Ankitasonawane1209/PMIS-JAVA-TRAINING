package DAY4_8OCT;



//StudentProfile class
class StudentProfile {

 // Attributes
 String fullName;
 int studentID;
 double score;

 // Constructor 1: Exam Taker
 StudentProfile(String fullName, int studentID, double score) {
     this.fullName = fullName;
     this.studentID = studentID;
     this.score = score;
 }

 // Constructor 2: Direct Walk-in
 StudentProfile(String fullName, int studentID) {
     this.fullName = fullName;
     this.studentID = studentID;
     this.score = 0.0;
 }

 // Method to determine grade
 char getGrade() {

     if (score >= 90) {
         return 'A';
     } 
     else if (score >= 75) {
         return 'B';
     } 
     else if (score >= 50) {
         return 'C';
     } 
     else {
         return 'F';
     }
 }

 // Method to print report card
 void printReportCard() {

     System.out.println("Name: " + fullName);
     System.out.println("Student ID: " + studentID);
     System.out.println("Score: " + score);
     System.out.println("Grade: " + getGrade());
     System.out.println("----------------------");
 }
}


//Main / Runner class
public class Constructor_Problem2 {

 public static void main(String[] args) {

     // Exam Taker
     StudentProfile student1 =
             new StudentProfile("Anish", 101, 82.5);

     // Direct Walk-in
     StudentProfile student2 =
             new StudentProfile("Rahul", 102);

     // Print both report cards
     student1.printReportCard();
     student2.printReportCard();
 }
}