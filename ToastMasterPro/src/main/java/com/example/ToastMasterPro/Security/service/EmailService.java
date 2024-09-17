// package com.example.ToastMasterPro.Security.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.stereotype.Service;
// import jakarta.mail.MessagingException;
// import jakarta.mail.internet.MimeMessage;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

// @Service
// public class EmailService {

//     private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

//     @Autowired
//     private JavaMailSender mailSender;

//     public void sendEmail(String to, String username, String password, String subject, String message) {
//         try {
//             MimeMessage mimeMessage = mailSender.createMimeMessage();
//             MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//             helper.setTo(to);
//             helper.setSubject(subject);
//             helper.setText(buildEmailBody(username, password, message), true);
//             mailSender.send(mimeMessage);
//             logger.info("Email sent successfully to {}", to);
//         } catch (MessagingException e) {
//             logger.error("Failed to send email to {}: {}", to, e.getMessage());
//             // Handle exception or rethrow if necessary
//         }
//     }

//     private String buildEmailBody(String username, String password, String message) {
//         return "<html><body>"
//                 + "<h1>" + message + "</h1>"
//                 + "<p><b>Username:</b> " + username + "</p>"
//                 + "<p><b>Password:</b> " + password + "</p>"
//                 + "</body></html>";
//     }
// }
