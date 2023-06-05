package final_exam.repository.Implements;

import final_exam.model.PhoneChinhHang;
import final_exam.repository.Interfaces.IPhoneChinhHang;
import final_exam.utils.ReadAndWriteFile;

import java.util.List;

public class PhoneChinhHangRepositoryImpl implements IPhoneChinhHang {
    static final String CHINH_HANG_PATH;

    static {
        CHINH_HANG_PATH = "E:\\CodeGym\\A1222I1-DuongVanBao\\Module2\\src\\final_exam\\data\\phoneCH.csv";
    }

    @Override
    public List<PhoneChinhHang> getList() {
        return new ReadAndWriteFile().readPhoneChinhHangFile(CHINH_HANG_PATH);
    }

    @Override
    public void addNew(PhoneChinhHang obj) {
        new ReadAndWriteFile().writePhoneChinhHangFile(CHINH_HANG_PATH, obj);
    }

    @Override
    public void delete(List<PhoneChinhHang> obj) {
        new ReadAndWriteFile().rewritePhoneChinhHangFile(CHINH_HANG_PATH, obj);
    }


}
