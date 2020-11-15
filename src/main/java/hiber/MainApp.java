package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
//import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 =new User("User2", "Lastname2", "user2@mail.ru");
      User user3 =new User("User3", "Lastname3", "user3@mail.ru");
      User user4 =new User("User4", "Lastname4", "user4@mail.ru");

//      CarService carService = context.getBean(CarService.class);

      Car carUser1 = new Car("BMW", 5);
      Car carUser2 = new Car("Audi", 515);
      Car carUser3 = new Car("Mercedes", 600);
      Car carUser4 = new Car("Opel", 1);

      user1.setUserCar(carUser1);
      user2.setUserCar(carUser2);
      user3.setUserCar(carUser3);
      user4.setUserCar(carUser4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      User userq = userService.getUserByCar("BMW", 5);
      System.out.println("Id = "+userq.getId());
      System.out.println("First Name = "+userq.getFirstName());
      System.out.println("Last Name = "+userq.getLastName());
      System.out.println("Email = "+userq.getEmail());
      System.out.println();

      context.close();
   }
}
