package hiber;

import hiber.config.AppConfig;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      Car car1 = new Car("Audi", 80);
      Car car2 = new Car("Bmw", 5);
      Car car3 = new Car("Mitsubishi", 9);
      Car car4 = new Car("Opel", 10);

      carService.add(car1);
      carService.add(car2);
      carService.add(car3);
      carService.add(car4);
      List<Car> carList = carService.listCars();


      userService.add(new User("User1", "Lastname1", "user1@mail.ru", carList.get(0)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", carList.get(1)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", carList.get(2)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", carList.get(3)));

      User userCar = userService.resultUserCar("Audi", 80);
      System.out.println("Имя: " + userCar.getFirstName() + "\nФамилия: "
              + userCar.getLastName() + "\nEmail: " + userCar.getEmail());
      System.out.println("***********************************************");



      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
      context.close();
   }
}
