package leap.api.controller;

import leap.core.exception.RecordNotSavedException;
import leap.demo.model.User;
import leap.orm.query.CriteriaQuery;
import leap.web.annotation.http.GET;
import leap.web.annotation.http.POST;
import leap.web.api.mvc.ApiController;

import java.util.List;

/**
 * Created by liqiang on 2017/5/3.
 */
public class UserModelController extends ApiController {
    @POST
    public User create(String name, Integer age, String loginId, String password) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setLoginId(loginId);
        user.setPassword(password);

        try {
            user.create();
            return user;
        } catch (RecordNotSavedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    public List<User> query(String name, Integer age, String loginId){
        if(name == null && age == null && loginId == null){
            return User.all();
        }
        if(name == null){
            name = "";
        }
        if(loginId == null){
            loginId = "";
        }
        CriteriaQuery<User> cq = User.<User>query();
        cq.where("name like ? and age like ? and loginId like ?",
                "%"+name+"%",age==null?"%%":"%"+age+"%","%"+loginId+"%");
        return cq.list();
    }
}
