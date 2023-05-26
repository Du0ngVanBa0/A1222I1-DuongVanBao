package case_study.FuramaResort.service.implementations;

import case_study.FuramaResort.model.Facility;
import case_study.FuramaResort.model.House;
import case_study.FuramaResort.model.Room;
import case_study.FuramaResort.model.Villa;
import case_study.FuramaResort.repository.implementations.FacilityRepository;
import case_study.FuramaResort.service.interfaces.IFacilityService;
import case_study.FuramaResort.utils.Validation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements IFacilityService {
    FacilityRepository facilityRepository = new FacilityRepository();
    Scanner sc = new Scanner(System.in);

    @Override
    public void displayMaintenance() {
        LinkedHashMap<Facility, Integer> facilityIntegerLinkedHashMap = facilityRepository.getMap();
        System.out.println("--Display Maintenance Facility List--");
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : facilityIntegerLinkedHashMap.entrySet()) {
            if (facilityIntegerEntry.getValue() >= 5) {
                System.out.println(facilityIntegerEntry.getKey() + " was used " + facilityIntegerEntry.getValue() + " time(s)");
            }
        }
    }

    @Override
    public void display() {
        LinkedHashMap<Facility, Integer> facilityIntegerLinkedHashMap = facilityRepository.getMap();
        System.out.println("--Display Facility List--");
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : facilityIntegerLinkedHashMap.entrySet()) {
            System.out.println(facilityIntegerEntry.getKey() + " was used " + facilityIntegerEntry.getValue() + " time(s)");
        }
    }

    @Override
    public void add() {
        int choice = -1;
        do {
            try {
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
            } catch (NumberFormatException e) {
                System.out.println("->Error: Please enter integer number to choose!");
            }
        } while (true);
    }

    private void addVilla() {
        //Enter Villa's code
        String code;
        do {
            System.out.print("Enter Villa's code(Ex: SVVL-1234): ");
            code = sc.nextLine();
            if (new Validation().isVillaCode(code)) {
                break;
            } else {
                System.out.println("->Error: Villa's code must be SVVL-yyyy with y is a number 0-9!");
            }
        } while (true);
        //Enter Villa's name
        String name;
        do {
            System.out.print("Enter Service's name(Ex: Chung): ");
            name = sc.nextLine();
            if (new Validation().isServiceName(name)) {
                break;
            } else {
                System.out.println("->Error: Villa's name must be a word with capitalize first letter, second character is normal character");
            }
        } while (true);
        //Enter Villa's are
        double area;
        do {
            try {
                System.out.print("Enter Villa's area(>30): ");
                area = Double.parseDouble(sc.nextLine());
                if (area > 30) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Villa's area must be a double number and higher than 30!");
            }
        } while (true);
        //Enter Villa's cost
        int cost;
        do {
            try {
                System.out.print("Enter Villa's cost(>0): ");
                cost = Integer.parseInt(sc.nextLine());
                if (cost > 0) {
                    break;
                } else {
                    System.out.println("->Error: Villa's cost must be higher than 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Villa's cost must be an integer number!");
            }
        } while (true);
        //Enter Villa's max people number
        int maxPeople;
        do {
            try {
                System.out.print("Enter Villa's max people number(>0 and <20): ");
                maxPeople = Integer.parseInt(sc.nextLine());
                if (maxPeople > 0 && maxPeople < 20) {
                    break;
                } else {
                    System.out.println("->Error: Villa's max people number must be higher than 0 and smaller than 20!");
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Villa's max people number must be an integer number!");
            }
        } while (true);
        //Enter Villa's hire type
        System.out.println("Enter Villa's hire type:");
        String typeHire = enterHireType();
        System.out.print("Enter Villa's standard: ");
        String standard = enterStandard();
        //Enter Villa's pool area
        double areaPool;
        do {
            try {
                System.out.print("Enter Villa's pool area(>30): ");
                areaPool = Double.parseDouble(sc.nextLine());
                if (areaPool > 30) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Villa's pool area must be a double number and higher than 30!");
            }
        } while (true);
        //Enter Villa's floor number
        int numFloor;
        do {
            try {
                System.out.print("Enter Villa's floor number(>0): ");
                numFloor = Integer.parseInt(sc.nextLine());
                if (numFloor > 0) {
                    break;
                } else {
                    System.out.println("->Error: Villa's floor number must be higher than 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Villa's floor number must be an integer number!");
            }
        } while (true);
        facilityRepository.addNew(new Villa(code, name, area, cost, maxPeople, typeHire, standard, areaPool, numFloor));
    }

    private void addHouse() {
        //Enter House's code
        String code;
        do {
            System.out.print("Enter House's code(Ex: SVHO-1234): ");
            code = sc.nextLine();
            if (new Validation().isHouseCode(code)) {
                break;
            } else {
                System.out.println("->Error: House's code must be SVHO-yyyy with y is a number 0-9!");
            }
        } while (true);
        //Enter House's name
        String name;
        do {
            System.out.print("Enter Service's name(Ex: Chung): ");
            name = sc.nextLine();
            if (new Validation().isServiceName(name)) {
                break;
            } else {
                System.out.println("->Error: House's name must be a word with capitalize first letter, second character is normal character");
            }
        } while (true);
        //Enter House's area
        double area;
        do {
            try {
                System.out.print("Enter House's area(>30): ");
                area = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("->Error: House's area must be a double number and higher than 30!");
            }
        } while (true);
        //Enter House's cost
        int cost;
        do {
            try {
                System.out.print("Enter House's cost(>0): ");
                cost = Integer.parseInt(sc.nextLine());
                if (cost > 0) {
                    break;
                } else {
                    System.out.println("->Error: House's cost must be higher than 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: House's cost must be an integer number!");
            }
        } while (true);
        //Enter House's max people number
        int maxPeople;
        do {
            try {
                System.out.print("Enter House's max people number(>0 and <20): ");
                maxPeople = Integer.parseInt(sc.nextLine());
                if (maxPeople > 0 && maxPeople < 20) {
                    break;
                } else {
                    System.out.println("->Error: House's max people number must be higher than 0 and smaller than 20!");
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: House's max people number must be an integer number!");
            }
        } while (true);
        //Enter House's hire type
        System.out.println("Enter House's hire type:");
        String typeHire = enterHireType();
        System.out.print("Enter House's standard: ");
        String standard = enterStandard();
        //Enter House's floor number
        int numFloor;
        do {
            try {
                System.out.print("Enter House's floor number(>0): ");
                numFloor = Integer.parseInt(sc.nextLine());
                if (numFloor > 0) {
                    break;
                } else {
                    System.out.println("->Error: House's floor number must be higher than 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: House's floor number must be an integer number!");
            }
        } while (true);
        facilityRepository.addNew(new House(code, name, area, cost, maxPeople, typeHire, standard, numFloor));
    }

    private void addRoom() {
        //Enter Room's code
        String code;
        do {
            System.out.print("Enter Room's code(Ex: SVRO-1234): ");
            code = sc.nextLine();
            if (new Validation().isRoomCode(code)) {
                break;
            } else {
                System.out.println("->Error: Room's code must be SVRO-yyyy with y is a number 0-9!");
            }
        } while (true);
        //Enter Room's name
        String name;
        do {
            System.out.print("Enter Service's name(Ex: Chung): ");
            name = sc.nextLine();
            if (new Validation().isServiceName(name)) {
                break;
            } else {
                System.out.println("->Error: Room's name must be a word with capitalize first letter, second character is normal character");
            }
        } while (true);
        //Enter Room's area
        double area;
        do {
            try {
                System.out.print("Enter Room's area(>30): ");
                area = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("->Error: Room's area must be a double number and higher than 30!");
            }
        } while (true);
        //Enter Room's cost
        int cost;
        do {
            try {
                System.out.print("Enter Room's cost(>0): ");
                cost = Integer.parseInt(sc.nextLine());
                if (cost > 0) {
                    break;
                } else {
                    System.out.println("->Error: Room's cost must be higher than 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Room's cost must be an integer number!");
            }
        } while (true);
        //Enter Room's max people number
        int maxPeople;
        do {
            try {
                System.out.print("Enter Room's max people number(>0 and <20): ");
                maxPeople = Integer.parseInt(sc.nextLine());
                if (maxPeople > 0 && maxPeople < 20) {
                    break;
                } else {
                    System.out.println("->Error: Room's max people number must be higher than 0 and smaller than 20!");
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Room's max people number must be an integer number!");
            }
        } while (true);
        //Enter Room's hire type
        System.out.println("Enter Room's hire type:");
        String typeHire = enterHireType();
        System.out.println("Enter Room's free service: ");
        String freeService = sc.nextLine();
        facilityRepository.addNew(new Room(code, name, area, cost, maxPeople, typeHire, freeService));
    }

    private String enterHireType() {
        int valid = 0;
        do {
            try {
                System.out.print("1.\tYear\n" +
                        "2.\tMonth\n" +
                        "3.\tDay\n" +
                        "4.\tHour\n" +
                        "Enter your choice(1->4): ");
                valid = Integer.parseInt(sc.nextLine());
                if (valid < 1 || valid > 4) {
                    System.out.println("->Error: Only receive number 1->4!");
                } else {
                    switch (valid) {
                        case 1:
                            return "Year";
                        case 2:
                            return "Month";
                        case 3:
                            return "Day";
                        case 4:
                            return "Hour";
                    }
                    ;
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Please enter integer number to choose!");
            }
        } while (true);
    }

    private String enterStandard() {
        int choose = 0;
        do {
            try {
                System.out.print("1.\tISO 1\n" +
                        "2.\tISO 2\n" +
                        "3.\tISO 3\n" +
                        "4.\tISO 4\n" +
                        "5.\tISO 5\n" +
                        "6.\tISO 6\n" +
                        "7.\tISO 7\n" +
                        "8.\tISO 8\n" +
                        "9.\tISO 9\n" +
                        "Enter your choice(1->9): ");
                choose = Integer.parseInt(sc.nextLine());
                if (choose < 1 || choose > 9) {
                    System.out.println("->Error: Only receive number 1->9!");
                } else {
                    switch (choose) {
                        case 1:
                            return "ISO 1";
                        case 2:
                            return "ISO 2";
                        case 3:
                            return "ISO 3";
                        case 4:
                            return "ISO 4";
                        case 5:
                            return "ISO 5";
                        case 6:
                            return "ISO 6";
                        case 7:
                            return "ISO 7";
                        case 8:
                            return "ISO 8";
                        case 9:
                            return "ISO 9";

                    }
                    ;
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Please enter integer number to choose!");
            }
        } while (true);
    }
}
