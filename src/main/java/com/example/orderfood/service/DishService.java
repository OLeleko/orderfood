package com.example.orderfood.service;

import com.example.orderfood.dao.DishRepository;
import com.example.orderfood.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DishService {
    private List<String> finalList;
    private InputService inputService;
    @Autowired
    DishRepository dishRepository;

    @PostConstruct
    public void start() {
        inputService = new InputService(System.in);
        finalList = new ArrayList<>();
        String cousine = chooseCuisine();
        System.out.println("Choose main dish: \n");
        String mainDish = chooseStage(cousine, "main");
        finalList.add(mainDish);
        System.out.println("Choose dessert: \n");
        String dessert = chooseStage(cousine, "dessert");
        finalList.add(dessert);
        if (yesNo("drink")) {
            finalList.add(chooseStage(cousine, "drink"));
            if (yesNo("ice")) {
                finalList.add("ice");
            }
            if (yesNo("lemon")) {
                finalList.add("lemon");
            }
        } else {
            System.out.println(printOrder(finalList));
        }
        System.out.println(printOrder(finalList));
        inputService.closeBuffer();
    }

    public Map<Integer, Dish> getByCuisineAndStage(String cuisine, String stage) {
        ArrayList<Dish> listDishes = new ArrayList<>();
        dishRepository.findDishesByCuisineAndStage(cuisine, stage).forEach(dish -> listDishes.add(dish));
        Map<Integer, Dish> dishMap = new HashMap<>();
        for (int i = 0; i < listDishes.size(); i++) {
            dishMap.put(i + 1, listDishes.get(i));
        }
        return dishMap;
    }

    public String chooseCuisine() {
        int counter = 3;
        int choice = 0;
        String result = "";
        System.out.println("Please choose cuisine: \n" +
                "1 - Polish \n" +
                "2 - Mexican \n" +
                "3 - Italian \n");
        while (counter > 0) {
            choice = inputService.getChoice();
            if (choice < 1 || choice > 3) {
                System.out.println("Wrong choice. Try again.");
                counter--;
            } else {
                break;
            }
            if (counter == 0) {
                System.out.println("You did wrong choice 3 times. Good bye.");
                System.exit(0);
            }
        }
        switch (choice) {
            case 1:
                result = "polish";
                break;
            case 2:
                result = "mexican";
                break;
            case 3:
                result = "italian";
                break;
        }
        return result;
    }

    public String chooseStage(String cuisine, String stage) {
        int counter = 3;
        int choice = 0;
        String result = "";
        Map<Integer, Dish> map = getByCuisineAndStage(cuisine, stage);
        String menu = printMap(map);
        System.out.println(menu);
        while (counter > 0) {
            choice = inputService.getChoice();
            if (!map.containsKey(choice)) {
                System.out.println("Wrong choice. Try again.");
                counter--;
            } else {
                result = map.get(choice).toString();
                break;
            }
        }
        if (counter == 0) {
            System.out.println("You did wrong choice 3 times. Good bye.");
            System.exit(0);
        }
        return result;
    }

    public String printMap(Map<Integer, Dish> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, Dish> entry : map.entrySet()) {
            stringBuilder.append(entry.getKey() + " - " + entry.getValue());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


    public boolean yesNo(String meal) {
        int counter = 3;
        int choice = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Would you like " + meal + "?");
        stringBuilder.append("\n");
        stringBuilder.append("Press 1 for YES");
        stringBuilder.append("\n");
        stringBuilder.append("Press 2 for NO");
        System.out.println(stringBuilder.toString());
        while (counter > 0) {
            choice = inputService.getChoice();
            if (choice < 1 || choice > 2) {
                System.out.println("Wrong choice. Try again.");
                counter--;
            } else {
                break;
            }
        }
        return choice == 1;
    }

    public String printOrder(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Your order is:\n");
        for (String dish : list) {
            stringBuilder.append(dish);
            stringBuilder.append("\n");
        }
        stringBuilder.append("Thank you for your order.");
        return stringBuilder.toString();
    }
}
