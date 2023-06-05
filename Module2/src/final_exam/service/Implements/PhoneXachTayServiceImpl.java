package final_exam.service.Implements;

import final_exam.model.PhoneXachTay;
import final_exam.repository.Implements.PhoneXachTayRepositoryImpl;
import final_exam.service.interfaces.IPhoneXachTayService;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PhoneXachTayServiceImpl implements IPhoneXachTayService {
    PhoneXachTayRepositoryImpl phoneXachTayRepository = new PhoneXachTayRepositoryImpl();
    Scanner sc = new Scanner(System.in);

    @Override
    public void add() {
        String ID = String.valueOf(autoCode());
        String name = enterName();
        int price = enterPrice();
        int quantity = enterQuantity();
        String status = enterStatus();
        String country = enterCountry();
        String producer = enterProducer();
        phoneXachTayRepository.addNew(new PhoneXachTay(ID, name, price, quantity, producer, country, status));
        System.out.println("Thêm thành công!");
    }

    private String enterStatus() {
        int valid = 0;
        do {
            try {
                System.out.print("Nhập Trạng thái:\n1. Da sua chua\n2. Chua sua chua\nEnter number(1->2): ");
                valid = Integer.parseInt(sc.nextLine());
                if (valid != 1 && valid != 2) {
                    System.out.println("->Error: Only receive number 1->2!");
                } else {
                    switch (valid) {
                        case 1:
                            return "Da sua chua";
                        case 2:
                            return "Chua sua chua";
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Please enter integer number to choose!");
            }
        } while (true);
    }

    private int enterPrice() {
        int price = 0;
        do {
            System.out.print("Nhập giá bán: ");
            try {
                price = Integer.parseInt(sc.nextLine());
                if (price <= 0) {
                    System.out.println("->Error: GIá bán phải lớn hơn 0 ");
                } else {
                    return price;
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Please enter integer number!");
            }
        } while (true);
    }

    private int enterQuantity() {
        int quantity = 0;
        do {
            System.out.print("Nhập số lượng: ");
            try {
                quantity = Integer.parseInt(sc.nextLine());
                if (quantity <= 0) {
                    System.out.println("->Error: Số lượng phải lớn hơn 0 ");
                } else {
                    return quantity;
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Please enter integer number!");
            }
        } while (true);
    }

    private String enterName() {
        String fullName;
        System.out.print("Nhập tên điện thoại: ");
        fullName = sc.nextLine();
        return fullName;
    }

    private String enterProducer() {
        String producer;
        System.out.print("Nhập tên Nhà sản xuất: ");
        producer = sc.nextLine();
        return producer;
    }

    private String enterCountry() {
        String fullName;
        do {
            System.out.print("Nhập Quốc gia: ");
            fullName = sc.nextLine();
            if (Objects.equals(fullName, "Viet Nam")) {
                System.out.println("->Error: Khong duoc la Viet Nam ");
            } else {
                return fullName;
            }
        } while (true);
    }

    private int autoCode() {
        int max = 1;
        for (PhoneXachTay phoneXachTay : phoneXachTayRepository.getList()) {
            if (Integer.parseInt(phoneXachTay.getPhoneID()) > max) {
                max = Integer.parseInt(phoneXachTay.getPhoneID());
            }
        }
        return max + 1;
    }

    @Override
    public void delete() {
        do {
            display();
            System.out.print("--Xóa điện thoại--\nNhập ID điện thoại: ");
            String code = sc.nextLine();
            int index = findCodeInt(code);
            if (index != -1) {
                System.out.println("Bạn chắc chắn muốn xóa " +
                        "1. yes\n" +
                        "Lựa chọn: ");
                int del = Integer.parseInt(sc.nextLine());
                if (del == 1) {
                    List<PhoneXachTay> newList = phoneXachTayRepository.getList();
                    newList.remove(index);
                    phoneXachTayRepository.delete(newList);
                    System.out.println("Xóa thành công");
                }
                return;
            } else {
                System.out.println("->Lỗi: không tìm thấy phoneID\n" +
                        "Nhập 'e' để quay về: ");
                char con = sc.nextLine().charAt(0);
                if (con == ('e') || con == ('E')) {
                    return;
                }
            }
        } while (true);
    }

    private int findCodeInt(String code) {
        List<PhoneXachTay> phoneXachTayList = phoneXachTayRepository.getList();
        for (int i = 0; i < phoneXachTayList.size(); i++) {
            if (Objects.equals(phoneXachTayList.get(i).getPhoneID(), code)) {
                return i;
            }
        }
        return -1;
    }

    private PhoneXachTay findCode(String code) {
        List<PhoneXachTay> phoneXachTayList = phoneXachTayRepository.getList();
        for (PhoneXachTay phoneXachTay : phoneXachTayList) {
            if (phoneXachTay.getPhoneID().equals(code)) {
                return phoneXachTay;
            }
        }
        return null;
    }

    @Override
    public void display() {
        List<PhoneXachTay> phoneXachTays = phoneXachTayRepository.getList();
        System.out.println("--Danh sách điện thoại xách tay--");
        for (PhoneXachTay phoneXachTay : phoneXachTays) {
            System.out.println(phoneXachTay);
        }
    }

    @Override
    public void search() {
        do {
            display();
            System.out.print("--Tìm kiếm điện thoại--\nNhập ID điện thoại: ");
            String code = sc.nextLine();
            PhoneXachTay phoneXachTay = findCode(code);
            if (phoneXachTay != null) {
                System.out.println("Đã tìm thấy điện thoại");
                System.out.println(phoneXachTay);
                return;
            } else {
                System.out.println("->Lỗi: không tìm thấy phoneID");
            }
        } while (true);
    }
}
