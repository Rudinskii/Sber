
package sber1_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Map;

public class Sber1_1 {
      

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(
                "Задача ВС Java Сбер.csv"));
        String line = null;
        Scanner scanner = null;
        int index = 0;
        int count = 0; //количество городов 
        List<City> cityList = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            City city = new City();
            scanner = new Scanner(line);
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                String data = scanner.next();            
                if (index == 1)
                    city.setName(data);
                else if (index == 2)
                    city.setRegion(data);
                else if (index == 3)
                    city.setDistrict(data);
                else if (index == 4)
                   city.setPopulation(Integer.parseInt(data));
                else if (index == 5)
                   city.setFoundation(data);
                index++;   
            }
            index = 0;
            cityList.add(city);
            count++;
        }   
        reader.close();   
        
        //Сортировка по названию города
        List<City> sortCity1 = new ArrayList<>();
        List<City> sortCity2 = new ArrayList<>();
        
        sortCity1 = cityList.stream()
                 .sorted((a,b)->a.getName()
                 .compareTo(b.getName()))
                 .collect(Collectors.toList());
        
//Сортировка по округу и названию города
        sortCity2 = cityList.stream()
                           .sorted(Comparator.comparing(City::getDistrict)
                           .thenComparing(City::getName))
                           .collect(Collectors.toList());
        
//Определение города с максимальным населением         
          int  []ar = new int[count];
          int maxPopul = ar[0];
          int indexMaxPopul =0;
       for (int i=0; i<ar.length-1; i++){
   ar[i] =  cityList.get(i).getPopulation();
   if (maxPopul<ar[i]){
       maxPopul=ar[i];
       indexMaxPopul = i;
   }      
   } 
  //     System.out.println("["+indexMaxPopul+"] = "+maxPopul);
  
 //cityList.forEach(System.out::println);
        System.out.println("Сортировка по городу \n");
 sortCity1.forEach(System.out::println);
        System.out.println("\n");
        System.out.println("Сортировка по округу и городу \n");
 sortCity2.forEach(System.out::println);

 //Группировка городов по региону
// Map<String, Long> citiesByRegion = cityList.stream().collect(
// Collectors.groupingBy(City::getRegion, Collectors.counting()));     
// for(Map.Entry<String, Long> item : citiesByRegion.entrySet()){
//    System.out.println(item.getKey() + " - " + item.getValue());
//}

    }
    }
    

