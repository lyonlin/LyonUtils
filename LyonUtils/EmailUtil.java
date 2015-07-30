/**
 * @author Lyon
 **/
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

public class EmailUtil {
        
    /**
     * <p>寄信功能</p>
     * @throws Exception
     */
    public static void sendMail(String toAddrs[], String toNames[], String subject, String message) throws Exception{
        
    	/* SMTP設定 */
        final String SMTP_HOST_NAME = "smtp.gmail.com";
        final String SMTP_PORT = "587";
    	final String SMTP_SSL_PORT = "465";
        final boolean DEGUH = false;
        
        // 寄件者
        final String fromAddr = "";
        final String fromName = "";
        final String account = "";
        final String password = "";
    	
        // 設定
        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST_NAME); 
        props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.starttls.enable", "true"); 
        props.put("mail.smtp.port", SMTP_PORT); 
        //props.put("mail.smtp.socketFactory.port", SMTP_SSL_PORT);
        //props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        //props.put("mail.smtp.socketFactory.fallback", "false");
                
        // 建立連線
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(account, password);
            }
        });
        session.setDebug(DEGUH);
        Message msg = new MimeMessage(session);
        
        // 寄件人資訊
        InternetAddress addressFrom = new InternetAddress(fromAddr,fromName,"utf-8");
        msg.setFrom(addressFrom);
        
        // 收件人資訊
        InternetAddress[] addressTo = new InternetAddress[toAddrs.length];
        for (int i = 0; i < toAddrs.length; i++) {
            addressTo[i] = new InternetAddress(toAddrs[i],toNames[i],"utf-8");
        }
        msg.setRecipients(Message.RecipientType.TO, addressTo);

        // 標題與內文SET
        msg.setSubject(MimeUtility.encodeText(subject, "utf-8", "Q"));
        msg.setContent(message, "text/html;charset=utf-8");
        msg.setSentDate(new Date());
        
        // 開始送信
        Transport.send(msg);
    
    }
    
    
    /* 寄信範例 */
    public static void main(String[] args) {        
    	String[] sendToAddr = {""};
        String[] sendToName = {""};
        String subject = "測試郵件" ;
        String msgText = "你好!!" ;        
        try {        
        	EmailModel.sendMail(sendToAddr,sendToName,subject,msgText);
            System.out.println("寄信成功囉");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
