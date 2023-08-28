package dvb.song_validate.utils;

import dvb.song_validate.entity.Song;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SongValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Song)) {
            return;
        }

        Song song = (Song) target;
        if (song.getName().trim().equals("")) {
            errors.rejectValue("name", "song.name.blank", "Tên không được phép để trống");
        } else if (song.getName().length() > 800) {
            errors.rejectValue("name", "song.name.length", "Tên không được vượt quá 800 kí tự");
        } else if (!song.getName().matches("^[a-z0-9A-Z\\s]*$")){
            errors.rejectValue("name", "song.name.specialCharacter", "Tên Không chứa các kí tự đặc biệt như @ ; , . = - + , ….");
        }

        if (song.getSinger().trim().equals("")) {
            errors.rejectValue("singer", "song.singer.blank", "Nghệ sĩ thể hiện không được phép để trống");
        } else if (song.getSinger().length() > 300) {
            errors.rejectValue("singer", "song.singer.length", "Nghệ sĩ thể hiện không được vượt quá 300 kí tự");
        } else if (!song.getSinger().matches("^[a-z0-9A-Z\\s]*$")){
            errors.rejectValue("singer", "song.singer.specialCharacter", "Nghệ sĩ thể hiện Không chứa các kí tự đặc biệt như @ ; , . = - + , ….");
        }

        if (song.getType().trim().equals("")) {
            errors.rejectValue("type", "song.type.blank", "Thể loại nhạc không được phép để trống");
        } else if (song.getType().length() > 300) {
            errors.rejectValue("type", "song.type.length", "Thể loại nhạc không được vượt quá 300 kí tự");
        } else if (!song.getType().matches("^[a-z0-9A-Z\\s,]*$")){
            errors.rejectValue("type", "song.type.specialCharacter", "Thể loại nhạc Không chứa các kí tự đặc biệt như @ ; , . = - + , …. Ngoại trừ dấu phẩy “,”");
        }
    }
}
