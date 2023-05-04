package main.lab13java.beans;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Data
@Component
@SessionScope
public class LoginBean {
    private String login;
    private String userName;
}
