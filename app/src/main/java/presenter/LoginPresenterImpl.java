package presenter;

import model.User;
import view.ILoginView;

/**
 * Created by www on 2016/9/1.
 */
public class LoginPresenterImpl implements ILoginPresenter {
    private ILoginView iLoginView;
    private User user;

    public LoginPresenterImpl(ILoginView iLoginView){
        this.iLoginView=iLoginView;
        user=new User("zhangshan","123456");
    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLogin(String name, String pwd) {
        if (name.equals(user.getName())&&pwd.equals(user.getPwd())){
            iLoginView.onLoginResult(true,200);
        }else{
            iLoginView.onLoginResult(false,202);
        }
    }
}
