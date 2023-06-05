package final_exam.utils;

import final_exam.model.PhoneChinhHang;
import final_exam.model.PhoneXachTay;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadAndWriteFile {
    public void writePhoneChinhHangFile(String path, PhoneChinhHang phoneCH) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            String newLine = phoneCHToStringCSV(phoneCH);
            bw.write(newLine);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("The file does not exist or an error has occurred!");
        }
    }

    public void writePhoneXachTayFile(String path, PhoneXachTay phoneXT) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            String newLine = phoneXTToStringCSV(phoneXT);
            bw.write(newLine);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("The file does not exist or an error has occurred!");
        }
    }

    public void rewritePhoneChinhHangFile(String path, List<PhoneChinhHang> phoneCHList) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
            for (PhoneChinhHang phoneCH : phoneCHList) {
                bw.write(phoneCHToStringCSV(phoneCH));
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("The file does not exist or an error has occurred!");
        }
    }

    public void rewritePhoneXachTayFile(String path, List<PhoneXachTay> phoneXTList) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
            for (PhoneXachTay phoneXT : phoneXTList) {
                bw.write(phoneXTToStringCSV(phoneXT));
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("The file does not exist or an error has occurred!");
        }
    }

    private String phoneCHToStringCSV(PhoneChinhHang phoneCH) {
        String str = "";
        str += phoneCH.getPhoneID() + ",";
        str += phoneCH.getPhoneName() + ",";
        str += phoneCH.getPhonePrice() + ",";
        str += phoneCH.getPhoneQuantity() + ",";
        str += phoneCH.getProducer() + ",";
        str += phoneCH.getSecureTime() + ",";
        str += phoneCH.getSecureType();
        return str;
    }

    private String phoneXTToStringCSV(PhoneXachTay phoneXT) {
        String str = "";
        str += phoneXT.getPhoneID() + ",";
        str += phoneXT.getPhoneName() + ",";
        str += phoneXT.getPhonePrice() + ",";
        str += phoneXT.getPhoneQuantity() + ",";
        str += phoneXT.getProducer() + ",";
        str += phoneXT.getCountry() + ",";
        str += phoneXT.getStatus();
        return str;
    }

    public List<PhoneChinhHang> readPhoneChinhHangFile(String path) {
        List<PhoneChinhHang> phoneCHList = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                phoneCHList.add(readPhoneChinhHangCsvLine(line));
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("The file does not exist or an error has occurred!");
        }
        return phoneCHList;
    }

    public List<PhoneXachTay> readPhoneXachTayFile(String path) {
        List<PhoneXachTay> phoneXTList = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                phoneXTList.add(readPhoneXachTayCsvLine(line));
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("The file does not exist or an error has occurred!");
        }
        return phoneXTList;
    }

    private PhoneChinhHang readPhoneChinhHangCsvLine(String csv) {
        String[] e = csv.split(",");
        return new PhoneChinhHang(e[0], e[1], Integer.parseInt(e[2]), Integer.parseInt(e[3]), e[4], Integer.parseInt(e[5]), e[6]);
    }

    private PhoneXachTay readPhoneXachTayCsvLine(String csv) {
        String[] e = csv.split(",");
        return new PhoneXachTay(e[0], e[1], Integer.parseInt(e[2]), Integer.parseInt(e[3]), e[4], e[5], e[6]);
    }

    public String getDateString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(date);
    }
}
