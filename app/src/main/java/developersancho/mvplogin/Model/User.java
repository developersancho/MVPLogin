package developersancho.mvplogin.Model;

import android.text.TextUtils;
import android.util.Patterns;

import developersancho.mvplogin.Interface.IUser;

public class User implements IUser {

    String email, password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValidData() {
        if (TextUtils.isEmpty(getEmail())) {
            return 0;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()) {
            return 1;
        } else if (getPassword().length() < 6) {
            return 2;
        } else
            return -1;
        /*return !TextUtils.isEmpty(getEmail()) &&
                Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches() &&
                getPassword().length() > 6;*/
    }
}
