package org.example;


import java.util.List;

public class AuthService {
    private DatabaseService databaseService;

    private Logger logger;
    private  User user;
    private  Attendant attendant;
    public AuthService(DatabaseService databaseService, Logger logger) {
        this.databaseService = databaseService;
        this.logger = logger;

    }
    public void userLogin(String mail, String password) {
        User user = databaseService.getUsersByMail(mail);
        if (user != null && user.getPassword().equals(password)) {
            this.user = user;
            logger.log("User with mail " + mail + " logged in");
        }
    }

    public void attendantLogin(String mail, String password) {
        Attendant attendant = databaseService.getAttendantByMail(mail);
        if (attendant != null && attendant.getPassword().equals(password)) {
            this.attendant = attendant;
            logger.log("Attendant with mail " + mail + " logged in");
        }
    }

   public void userLogout() {
       this.user = null;
       logger.log("User logged out"+ user.getMail());

   }

    public void attendantLogout() {

        this.attendant = null;
        logger.log("Attendant logged out"+ attendant.getMail());
    }

    }
