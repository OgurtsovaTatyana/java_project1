package java_project1;
import java.io.FileWriter;
import java.io.IOException;
import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.Random;
import java.time.LocalDate;

public class Toy_shop {
    private ArrayList<Toy> toysList;
    private ArrayList<Toy> toys_lot_List;

    public Toy_shop() {
        toysList = new ArrayList<>();
        toys_lot_List = new ArrayList<>();
    }
    /**Добавляет игрушку в магазин
     * @param toy
     */
    public void addToy(Toy toy) {
        toysList.add(toy);
    }
    /**Показавает лист игрушек магазина
     * 
     */
    public void show_toysList() {
        for (Toy item : toysList) {
            System.out.println(item);
        }
    }
    /**Добавляет игрушку в список для розыгрыша
     * @param id_toy
     */
    public void add_lot_List(int id_toy) {
        for(int i=0; i < toysList.size(); i++) {
            Toy item  = toysList.get(i);        
            if (item.id == id_toy) {
               item.count--;
               toys_lot_List.add(new Toy(item.weight, item.name, 1));
                if (item.count==0){
                    toysList.remove(i);                    
                }              
                            }
        }
    }
     /**Автоматически формирует список для розыгрыша
     * @param sizeList
     */
    public void create_lot_List(int sizeList) {
        ArrayList<Integer> weighListforID =new ArrayList<Integer>();
        for(int i=0; i < toysList.size(); i++) {
            Toy item  = toysList.get(i);
            for (int j = 0; j < item.weight; j++) {
                 weighListforID.add(item.id);
                 
            }
           }
           int startsize=toys_lot_List.size();
           while (toys_lot_List.size() < startsize+sizeList) {
            int index_id =(int)(Math.random() * weighListforID.size());
            this.add_lot_List(weighListforID.get(index_id));
           }
               
    }
    public void changeWeightToy(int id_toy,int new_Weight) {
        for(int i=0; i < toysList.size(); i++) {
            Toy item  = toysList.get(i);
            if (item.id==id_toy){
                item.setWeight(new_Weight);
            }
    }
}
    /**Показавает лист для розыгрыша
     * 
     */
    public void show_lot_List() {
        int i=0;
        for (Toy item : toys_lot_List) {
            System.out.println("Toy"+ i +": "+ item.name);
            i++;
        }
    }
    /**розыгрыш игрушек (выдает первую игрушку из списка, записывает в файл)
     * 
     */
    public void give_out_toy() {
        this.toys_lot_List.add(new Toy(10, "конструктор", 1));
        if (this.toys_lot_List.size() > 0) {
            Toy item = this.toys_lot_List.get(0);
            System.out.printf("Разыграна игрушка %s: ",item.name);     

            try {
                FileWriter file = new FileWriter("fileForToys.txt", true);           
                file.write(String.format("%tD : %s \n",LocalDate.now(), item.name));             
                file.close();             
             } catch (IOException e) {
                System.out.println("Возникла ошибка во время записи, проверьте данные.");
             }
            this.toys_lot_List.remove(0);
        } else {
            System.out.println("Список игрушек для розыгрыша пуст");
        }

    }
}
