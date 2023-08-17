package flea777.picpaysimplificado.services;

import flea777.picpaysimplificado.domain.user.User;
import flea777.picpaysimplificado.dtos.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email,message);

        //ResponseEntity<String> notificationResponse =
                //restTemplate.postForEntity("http://o4d9z.mocklab.io/notify", notificationRequest, String.class);

       // if(!(notificationResponse.getStatusCode() == HttpStatus.OK)) {
           // System.out.println("error sending notification");
            //throw new Exception("Notification service is not available");
        //}

        System.out.println("Notification sended to user");
    }
}
