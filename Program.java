package java_project1;
import java.util.Scanner;
public class Program {
public static void main(String[] args) {
        Toy_shop my_shop=new Toy_shop();     
     
        my_shop.addToy(new Toy(20, "мишка",2));
        my_shop.addToy(new Toy(10, "кукла",4));
        my_shop.addToy(new Toy(30, "робот",10));
        my_shop.addToy(new Toy(40, "зайка",5));
        my_shop.addToy(new Toy(15, "машинка",6));
        
Scanner inputScanner = new Scanner(System.in);
while (true) {     

System.out.println("\nВас привествует магазин игрушек! Выберите действие:" );
System.out.println(" 1. Посмотреть список игрушек \n 2. Добавить игрушку в магазин \n 3. Добавить игрушку в список для розыгрыша \n 4. Провести розыгрыш \n 5. Изменить вес игрушки \n 6. Выход \n\n Введите число:" );
int choice=inputScanner.nextInt();

switch(choice){
    case 1:
    System.out.println("---СПИСОК ИГРУШЕК---" );
     my_shop.show_toysList();
    break;
    case 2:
    System.out.println("---ДОБАВЛЕНИЕ НОВОЙ ИГРУШКИ В МАГАЗИН---" );
    System.out.println("-Введите название игрушки" );
    String name_toy=inputScanner.next(); 
    System.out.println("-Введите вес игрушки" );
    int weighi_toy=inputScanner.nextInt();
    System.out.println("-Введите количество игрушек" );
    int count_toy =inputScanner.nextInt();
    my_shop.addToy(new Toy(weighi_toy, name_toy, count_toy));
    
    break;
    case 3:
    System.out.println("---ДОБАВЛЕНИЕ ИГРУШКИ В СПИСОК ДЛЯ РОЗЫГРЫША---" );
    System.out.println("1-добавить вручную-\n2-сформировать автоматически-\n Выберите действие:" );
    int num_menu=inputScanner.nextInt();
    if (num_menu==1){
        System.out.println("-Введите id игрушки (от 101 до " + Toy.getNo()+"): " );
        int id_toy=inputScanner.nextInt();
        my_shop.add_lot_List(id_toy);
        }
     else {
    if (num_menu==2){
        System.out.println("-Введите количество игрушек для розыгрыша");
        int size_toyList=inputScanner.nextInt();
        my_shop.create_lot_List(size_toyList);
        }
    else {
        System.out.println("Неверно введен пункт меню");
    }
   }
   my_shop.show_lot_List();
   
    break;
    case 4:
    System.out.println("---РОЗЫГРЫШ ПРИЗОВ---" );
   my_shop.give_out_toy();
    break;
    case 5:
    System.out.println("---ИЗМЕНИТЬ ВЕС ИГРУШКИ---" );
    System.out.println("-Введите id игрушки (от 101 до " + Toy.getNo()+"): " );
    int id_toy=inputScanner.nextInt();
    System.out.println("-Введите новый вес: " );
    int new_weight=inputScanner.nextInt();
    my_shop.changeWeightToy(id_toy, new_weight);
    break;
    case 6:
    System.out.println("---РАБОТА ОКОНЧЕНА!---" );
    inputScanner.close();
    return;
    default:
    System.out.println(" Такого пункта нет в меню, введите число от 1 до 5" );
    break;
    
}
}   

}
}
