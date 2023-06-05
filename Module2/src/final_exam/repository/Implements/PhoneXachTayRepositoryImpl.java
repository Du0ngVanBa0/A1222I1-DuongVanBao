package final_exam.repository.Implements;

import final_exam.model.PhoneXachTay;
import final_exam.repository.Interfaces.IPhoneXachTay;
import final_exam.utils.ReadAndWriteFile;

import java.util.List;

public class PhoneXachTayRepositoryImpl implements IPhoneXachTay {
    static final String XACH_TAY_PATH;

    static {
        XACH_TAY_PATH = "E:\\CodeGym\\A1222I1-DuongVanBao\\Module2\\src\\final_exam\\data\\phoneXT.csv";
    }

    @Override
    public List<PhoneXachTay> getList() {
        return new ReadAndWriteFile().readPhoneXachTayFile(XACH_TAY_PATH);
    }

    @Override
    public void addNew(PhoneXachTay obj) {
        new ReadAndWriteFile().writePhoneXachTayFile(XACH_TAY_PATH, obj);
    }

    @Override
    public void delete(List<PhoneXachTay> obj) {
        new ReadAndWriteFile().rewritePhoneXachTayFile(XACH_TAY_PATH, obj);
    }
}
