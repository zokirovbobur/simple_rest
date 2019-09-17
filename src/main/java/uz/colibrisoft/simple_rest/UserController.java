package uz.colibrisoft.simple_rest;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class UserController {
    private List<Map<String,Object>> maps = new ArrayList<>();
    private List<UserModel>userModels = new ArrayList<>();
    private List<String> noOfActions = new ArrayList<>();

    @GetMapping
    public UserModel userModel(){
        return new UserModel();
    }

    @PostMapping("user")
    public String postUser(@RequestBody Object object){
        String res;
        if (object.getClass().equals("UserModel")){
            userModels.add((UserModel)object);
            res = "correct Model";
        }else {
            maps.add((Map)object);
            res = "incorrect Model";
        }
        noOfActions.add(res);
        return res;
    }
    @PostMapping("user_param")
    public String postUser_param(@RequestParam String userName){
        String res = "userName: " + userName + " has been saved successfully";
        noOfActions.add(res);
        return res;
    }
    @GetMapping("info")
    public Map<String,Object> info(){
        Map<String,Object> info = new HashMap<>();
        info.put("maps",maps);
        info.put("userModels",userModels);
        info.put("noOfActions",noOfActions);
        return info;
    }
    @DeleteMapping("clear")
    public String clear(){
        maps.clear();
        userModels.clear();
        noOfActions.clear();
        return "done";
    }
}
