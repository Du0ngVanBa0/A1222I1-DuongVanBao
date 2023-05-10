package FuramaResort.services;

import FuramaResort.models.Facility;
import FuramaResort.models.House;
import FuramaResort.models.Room;
import FuramaResort.models.Villa;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements IFacilityService {
    static LinkedHashMap<Facility, Integer> facility;
    static Scanner sc;

    static {
        facility = new LinkedHashMap<>();
        sc = new Scanner(System.in);
    }

    @Override
    public void display() {
        facility.forEach(Map.Entry);
    }

    @Override
    public void add() {
        int choice = -1;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n" +
                    "Enter your choice(1->4): ");
            choice = Integer.parseInt(sc.nextLine());
            if (choice < 1 || choice > 4) {
                System.out.println("Only receive number 1->4!");
            } else {
                switch (choice) {
                    case 1:
                        addVilla();
                        break;
                    case 2:
                        addHouse();
                        break;
                    case 3:
                        addRoom();
                        break;
                    case 4:
                        System.out.println("---Return main menu---");
                        return;
                }
            }
        } while (true);
    }

    public void addVilla() {
        System.out.print("Enter Villa's name: ");
        String name = sc.nextLine();
        System.out.print("Enter Villa's area: ");
        int area = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Villa's cost: ");
        int cost = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Villa's max people number: ");
        int maxPeople = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Villa's hire type:");
        int valid = 0;
        String typeHire = "";
        do {
            System.out.print("1.\tYear\n" +
                    "2.\tMonth\n" +
                    "3.\tDay\n" +
                    "4.\tHour\n" +
                    "Enter your choice(1->4): ");
            valid = Integer.parseInt(sc.nextLine());
        } while (valid < 1 || valid > 4);
        switch (valid) {
            case 1:
                typeHire = "Year";
                break;
            case 2:
                typeHire = "Month";
                break;
            case 3:
                typeHire = "Day";
                break;
            case 4:
                typeHire = "Hour";
                break;
        }
        System.out.print("Enter Villa's standard: ");
        String standard = sc.nextLine();
        System.out.print("Enter Villa's pool area: ");
        int areaPool = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Villa's floor number: ");
        int numFloor = Integer.parseInt(sc.nextLine());
        facility.put(new Villa(name, area, cost, maxPeople, typeHire, standard, areaPool, numFloor), 0);
    }

    public void addHouse() {
        System.out.print("Enter House's name: ");
        String name = sc.nextLine();
        System.out.print("Enter House's area: ");
        int area = Integer.parseInt(sc.nextLine());
        System.out.print("Enter House's cost: ");
        int cost = Integer.parseInt(sc.nextLine());
        System.out.print("Enter House's max people number: ");
        int maxPeople = Integer.parseInt(sc.nextLine());
        System.out.println("Enter House's hire type:");
        int valid = 0;
        String typeHire = "";
        do {
            System.out.print("1.\tYear\n" +
                    "2.\tMonth\n" +
                    "3.\tDay\n" +
                    "4.\tHour\n" +
                    "Enter your choice(1->4): ");
            valid = Integer.parseInt(sc.nextLine());
        } while (valid < 1 || valid > 4);
        switch (valid) {
            case 1:
                typeHire = "Year";
                break;
            case 2:
                typeHire = "Month";
                break;
            case 3:
                typeHire = "Day";
                break;
            case 4:
                typeHire = "Hour";
                break;
        }
        System.out.print("Enter House's standard: ");
        String standard = sc.nextLine();
        System.out.print("Enter House's floor number: ");
        int numFloor = Integer.parseInt(sc.nextLine());
        facility.put(new House(name, area, cost, maxPeople, typeHire, standard, numFloor), 0);
    }

    public void addRoom() {
        System.out.print("Enter Room's name: ");
        String name = sc.nextLine();
        System.out.print("Enter Room's area: ");
        int area = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Room's cost: ");
        int cost = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Room's max people number: ");
        int maxPeople = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Room's hire type:");
        int valid = 0;
        String typeHire = "";
        do {
            System.out.print("1.\tYear\n" +
                    "2.\tMonth\n" +
                    "3.\tDay\n" +
                    "4.\tHour\n" +
                    "Enter your choice(1->4): ");
            valid = Integer.parseInt(sc.nextLine());
        } while (valid < 1 || valid > 4);
        switch (valid) {
            case 1:
                typeHire = "Year";
                break;
            case 2:
                typeHire = "Month";
                break;
            case 3:
                typeHire = "Day";
                break;
            case 4:
                typeHire = "Hour";
                break;
        }
        System.out.println("Enter Room's free service: ");
        String freeService = sc.nextLine();
        facility.put(new Room(name, area, cost, maxPeople, typeHire, freeService), 0);
    }

    public void displayMaintenance() {

    }
}
