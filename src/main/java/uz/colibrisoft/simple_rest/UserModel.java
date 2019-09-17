package uz.colibrisoft.simple_rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private long userId;
    private String userName,lName,fName,mName,eMail,phone,password;

}
