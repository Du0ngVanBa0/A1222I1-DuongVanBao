package final_exam.service.Implements;

import final_exam.model.PhoneChinhHang;
import final_exam.repository.Implements.PhoneChinhHangRepositoryImpl;
import final_exam.service.interfaces.IPhoneChinhHangService;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PhoneChinhHangServiceImpl implements IPhoneChinhHangService {
    PhoneChinhHangRepositoryImpl phoneChinhHangRepository = new PhoneChinhHangRepositoryImpl();
    Scanner sc = new Scanner(System.in);

    @Override
    public void add() {
        String ID = String.valueOf(autoCode());
        String name = enterName();
        int price = enterPrice();
        int quantity = enterQuantity();
        String type = enterSecureType();
        int time = enterTime();
        String producer = enterProducer();
        phoneChinhHangRepository.addNew(new PhoneChinhHang(ID, name, price, quantity, producer, time, type));
        System.out.println("Thêm thành công!");
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

    private int enterTime() {
        int time = 0;
        do {
            System.out.print("Nhập Thời gian bảo hành: ");
            try {
                time = Integer.parseInt(sc.nextLine());
                if (time <= 0 || time > 730) {
                    System.out.println("->Error: Thời gian phải lớn hơn 0 và không quá 730 ");
                } else {
                    return time;
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


    private int autoCode() {
        int max = 1;
        for (PhoneChinhHang phoneChinhHang : phoneChinhHangRepository.getList()) {
            if (Integer.parseInt(phoneChinhHang.getPhoneID()) > max) {
                max = Integer.parseInt(phoneChinhHang.getPhoneID());
            }
        }
        return max + 1;
    }

    private String enterSecureType() {
        int valid = 0;
        do {
            try {
                System.out.print("Nhập phạm vi bảo hành:\n1. Toan quoc\n2. Quoc te\nEnter number(1->2): ");
                valid = Integer.parseInt(sc.nextLine());
                if (valid != 1 && valid != 2) {
                    System.out.println("->Error: Only receive number 1->2!");
                } else {
                    switch (valid) {
                        case 1:
                            return "Toan quoc";
                        case 2:
                            return "Quoc te";
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("->Error: Please enter integer number to choose!");
            }
        } while (true);
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
                    List<PhoneChinhHang> newList = phoneChinhHangRepository.getList();
                    //bug
                    newList.remove(index);
                    phoneChinhHangRepository.delete(newList);
                    System.out.println("Xóa thành công");
                }
                return;
            } else {
                System.out.println("->Lỗi: không tìm thấy phoneID");
            }
        } while (true);
    }

    @Override
    public void display() {
        List<PhoneChinhHang> phoneChinhHangs = phoneChinhHangRepository.getList();
        System.out.println("Danh sách điện thoại chính hãng");
        for (PhoneChinhHang phoneChinhHang : phoneChinhHangs) {
            System.out.println(phoneChinhHang);
        }
    }

    private PhoneChinhHang findCode(String code) {
        List<PhoneChinhHang> phoneChinhHangList = phoneChinhHangRepository.getList();
        for (PhoneChinhHang phoneChinhHang : phoneChinhHangList) {
            if (phoneChinhHang.getPhoneID().equals(code)) {
                return phoneChinhHang;
            }
        }
        return null;
    }

    private int findCodeInt(String code) {
        List<PhoneChinhHang> phoneChinhHangList = phoneChinhHangRepository.getList();
        for (int i = 0; i < phoneChinhHangList.size(); i++) {
            if (Objects.equals(phoneChinhHangList.get(i).getPhoneID(), code)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void search() {
        do {
            display();
            System.out.print("--Tìm kiếm điện thoại--\nNhập ID điện thoại: ");
            String code = sc.nextLine();
            PhoneChinhHang phoneChinhHang = findCode(code);
            if (phoneChinhHang != null) {
                System.out.println("Đã tìm thấy điện thoại");
                System.out.println(phoneChinhHang);
                return;
            } else {
                System.out.println("->Lỗi: không tìm thấy phoneID");
            }
        } while (true);
    }
}
