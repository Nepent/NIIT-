package com.niit.supportclasses;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailConfig {
	
	 // �����˵� ���� �� ���루�滻Ϊ�Լ�����������룩
    // PS: ĳЩ���������Ϊ���������䱾������İ�ȫ�ԣ��� SMTP �ͻ��������˶������루�е������Ϊ����Ȩ�롱��,
    //     ���ڿ����˶������������, ����������������ʹ������������루��Ȩ�룩��
    public static String myEmailAccount = "ranjin898@hotmail.com";
    public static String myEmailPassword = "ranJin147258..";
 
    // ����������� SMTP ��������ַ, ����׼ȷ, ��ͬ�ʼ���������ַ��ͬ, һ��(ֻ��һ��, ���Ǿ���)��ʽΪ: smtp.xxx.com
    public static String myEmailSMTPHost = "smtp-mail.outlook.com";
 
    // �ռ������䣨�滻Ϊ�Լ�֪������Ч���䣩
    public static String receiveMailAccount = "ranjin898@hotmail.com";
    
    public static void RegisterEmailtoAdmin(String username)  {
        // 1. ������������, ���������ʼ��������Ĳ�������
        Properties props = new Properties();                    // ��������
        props.put("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
        props.put("mail.smtp.host", myEmailSMTPHost);   // �����˵������ SMTP ��������ַ
        props.put("mail.smtp.auth", "true");            // ��Ҫ������֤
        
        // PS: ĳЩ���������Ҫ�� SMTP ������Ҫʹ�� SSL ��ȫ��֤ (Ϊ����߰�ȫ��, ����֧��SSL����, Ҳ�����Լ�����),
        //     ����޷������ʼ�������, ��ϸ�鿴����̨��ӡ�� log, ����������� ������ʧ��, Ҫ�� SSL ��ȫ���ӡ� �ȴ���,
        //     ȡ������ /* ... */ ֮���ע�ʹ���, ���� SSL ��ȫ���ӡ�
        
        // SMTP �������Ķ˿� (�� SSL ���ӵĶ˿�һ��Ĭ��Ϊ 25, ���Բ����, ��������� SSL ����,
        //                  ��Ҫ��Ϊ��Ӧ����� SMTP �������Ķ˿�, ����ɲ鿴��Ӧ�������İ���,
        //                  QQ�����SMTP(SLL)�˿�Ϊ465��587, ������������ȥ�鿴)
        final String smtpPort = "587";
        props.put("mail.smtp.starttls.enable", "true");  //���ܷ�ʽΪstarttls
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "true");
        props.put("mail.smtp.socketFactory.port", smtpPort);
        /*MailSSLSocketFactory sf = new MailSSLSocketFactory(); 
        sf.setTrustAllHosts(true); 
        props.put("mail.smtp.ssl.socketFactory", sf);*/
 
        // 2. �������ô����Ự����, ���ں��ʼ�����������
        Session session = Session.getInstance(props);
        // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log
        session.setDebug(true);
 
        // 3. ����һ���ʼ�
     
        
		try {
			
			MimeMessage message =new MimeMessage(session);
			
			  // 2. From: ������
	        message.setFrom(new InternetAddress(myEmailAccount, "Ⱦ�", "UTF-8"));
	 
	        // 3. To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
	        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount));
	 
	        // 4. Subject: �ʼ�����
	        message.setSubject("Request", "UTF-8");
	 
	        // 5. Content: �ʼ�����
	        message.setText(username+" have registered an account of LMS..!!!");
	 
	            // 6. ���÷���ʱ��
	        message.setSentDate(new Date());
	 
	        // 7. ��������
	        message.saveChanges();
	       
			
	        // 4. ���� Session ��ȡ�ʼ��������
	        Transport transport = session.getTransport();
	        
	        transport.connect(myEmailAccount, myEmailPassword);
	 
	        // 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
	        transport.sendMessage(message, message.getAllRecipients());
	 
	        // 7. �ر�����
	        transport.close();
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
 
    }
    
    public static void BorrowEmailtoAdmin(String username,String bookname)  {
        // 1. ������������, ���������ʼ��������Ĳ�������
        Properties props = new Properties();                    // ��������
        props.put("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
        props.put("mail.smtp.host", myEmailSMTPHost);   // �����˵������ SMTP ��������ַ
        props.put("mail.smtp.auth", "true");            // ��Ҫ������֤
        
        // PS: ĳЩ���������Ҫ�� SMTP ������Ҫʹ�� SSL ��ȫ��֤ (Ϊ����߰�ȫ��, ����֧��SSL����, Ҳ�����Լ�����),
        //     ����޷������ʼ�������, ��ϸ�鿴����̨��ӡ�� log, ����������� ������ʧ��, Ҫ�� SSL ��ȫ���ӡ� �ȴ���,
        //     ȡ������ /* ... */ ֮���ע�ʹ���, ���� SSL ��ȫ���ӡ�
        
        // SMTP �������Ķ˿� (�� SSL ���ӵĶ˿�һ��Ĭ��Ϊ 25, ���Բ����, ��������� SSL ����,
        //                  ��Ҫ��Ϊ��Ӧ����� SMTP �������Ķ˿�, ����ɲ鿴��Ӧ�������İ���,
        //                  QQ�����SMTP(SLL)�˿�Ϊ465��587, ������������ȥ�鿴)
        final String smtpPort = "587";
        props.put("mail.smtp.starttls.enable", "true");  //���ܷ�ʽΪstarttls
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "true");
        props.put("mail.smtp.socketFactory.port", smtpPort);
        /*MailSSLSocketFactory sf = new MailSSLSocketFactory(); 
        sf.setTrustAllHosts(true); 
        props.put("mail.smtp.ssl.socketFactory", sf);*/
 
        // 2. �������ô����Ự����, ���ں��ʼ�����������
        Session session = Session.getInstance(props);
        // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log
        session.setDebug(true);
 
        // 3. ����һ���ʼ�
     
        
		try {
			
			MimeMessage message =new MimeMessage(session);
			
			  // 2. From: ������
	        message.setFrom(new InternetAddress(myEmailAccount, "Ⱦ�", "UTF-8"));
	 
	        // 3. To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
	        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount));
	 
	        // 4. Subject: �ʼ�����
	        message.setSubject("Request", "UTF-8");
	 
	        // 5. Content: �ʼ�����
	        message.setText(username+" wants to borrow "+bookname+" book. Please login to deal with it..!!!");
	 
	            // 6. ���÷���ʱ��
	        message.setSentDate(new Date());
	 
	        // 7. ��������
	        message.saveChanges();
	       
			
	        // 4. ���� Session ��ȡ�ʼ��������
	        Transport transport = session.getTransport();
	        
	        transport.connect(myEmailAccount, myEmailPassword);
	 
	        // 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
	        transport.sendMessage(message, message.getAllRecipients());
	 
	        // 7. �ر�����
	        transport.close();
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
 
    }
    
    public static void BorrowSuccess(String username,String bookname)  {
        // 1. ������������, ���������ʼ��������Ĳ�������
        Properties props = new Properties();                    // ��������
        props.put("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
        props.put("mail.smtp.host", myEmailSMTPHost);   // �����˵������ SMTP ��������ַ
        props.put("mail.smtp.auth", "true");            // ��Ҫ������֤
        
        // PS: ĳЩ���������Ҫ�� SMTP ������Ҫʹ�� SSL ��ȫ��֤ (Ϊ����߰�ȫ��, ����֧��SSL����, Ҳ�����Լ�����),
        //     ����޷������ʼ�������, ��ϸ�鿴����̨��ӡ�� log, ����������� ������ʧ��, Ҫ�� SSL ��ȫ���ӡ� �ȴ���,
        //     ȡ������ /* ... */ ֮���ע�ʹ���, ���� SSL ��ȫ���ӡ�
        
        // SMTP �������Ķ˿� (�� SSL ���ӵĶ˿�һ��Ĭ��Ϊ 25, ���Բ����, ��������� SSL ����,
        //                  ��Ҫ��Ϊ��Ӧ����� SMTP �������Ķ˿�, ����ɲ鿴��Ӧ�������İ���,
        //                  QQ�����SMTP(SLL)�˿�Ϊ465��587, ������������ȥ�鿴)
        final String smtpPort = "587";
        props.put("mail.smtp.starttls.enable", "true");  //���ܷ�ʽΪstarttls
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "true");
        props.put("mail.smtp.socketFactory.port", smtpPort);
        /*MailSSLSocketFactory sf = new MailSSLSocketFactory(); 
        sf.setTrustAllHosts(true); 
        props.put("mail.smtp.ssl.socketFactory", sf);*/
 
        // 2. �������ô����Ự����, ���ں��ʼ�����������
        Session session = Session.getInstance(props);
        // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log
        session.setDebug(true);
 
        // 3. ����һ���ʼ�
     
        
		try {
			
			MimeMessage message =new MimeMessage(session);
			
			  // 2. From: ������
	        message.setFrom(new InternetAddress(myEmailAccount, "Ⱦ�", "UTF-8"));
	 
	        // 3. To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
	        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount));
	 
	        // 4. Subject: �ʼ�����
	        message.setSubject("Request", "UTF-8");
	 
	        // 5. Content: �ʼ�����
	        message.setText(username+" borrows "+bookname+" book successfully.");
	 
	            // 6. ���÷���ʱ��
	        message.setSentDate(new Date());
	 
	        // 7. ��������
	        message.saveChanges();
	       
			
	        // 4. ���� Session ��ȡ�ʼ��������
	        Transport transport = session.getTransport();
	        
	        transport.connect(myEmailAccount, myEmailPassword);
	 
	        // 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
	        transport.sendMessage(message, message.getAllRecipients());
	 
	        // 7. �ر�����
	        transport.close();
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
 
    }
    
    public static void ReserveEmailtoAdmin(String username,String bookname)  {
        // 1. ������������, ���������ʼ��������Ĳ�������
        Properties props = new Properties();                    // ��������
        props.put("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
        props.put("mail.smtp.host", myEmailSMTPHost);   // �����˵������ SMTP ��������ַ
        props.put("mail.smtp.auth", "true");            // ��Ҫ������֤
        
        // PS: ĳЩ���������Ҫ�� SMTP ������Ҫʹ�� SSL ��ȫ��֤ (Ϊ����߰�ȫ��, ����֧��SSL����, Ҳ�����Լ�����),
        //     ����޷������ʼ�������, ��ϸ�鿴����̨��ӡ�� log, ����������� ������ʧ��, Ҫ�� SSL ��ȫ���ӡ� �ȴ���,
        //     ȡ������ /* ... */ ֮���ע�ʹ���, ���� SSL ��ȫ���ӡ�
        
        // SMTP �������Ķ˿� (�� SSL ���ӵĶ˿�һ��Ĭ��Ϊ 25, ���Բ����, ��������� SSL ����,
        //                  ��Ҫ��Ϊ��Ӧ����� SMTP �������Ķ˿�, ����ɲ鿴��Ӧ�������İ���,
        //                  QQ�����SMTP(SLL)�˿�Ϊ465��587, ������������ȥ�鿴)
        final String smtpPort = "587";
        props.put("mail.smtp.starttls.enable", "true");  //���ܷ�ʽΪstarttls
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "true");
        props.put("mail.smtp.socketFactory.port", smtpPort);
        /*MailSSLSocketFactory sf = new MailSSLSocketFactory(); 
        sf.setTrustAllHosts(true); 
        props.put("mail.smtp.ssl.socketFactory", sf);*/
 
        // 2. �������ô����Ự����, ���ں��ʼ�����������
        Session session = Session.getInstance(props);
        // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log
        session.setDebug(true);
 
        // 3. ����һ���ʼ�
     
        
		try {
			
			MimeMessage message =new MimeMessage(session);
			
			  // 2. From: ������
	        message.setFrom(new InternetAddress(myEmailAccount, "Ⱦ�", "UTF-8"));
	 
	        // 3. To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
	        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount));
	 
	        // 4. Subject: �ʼ�����
	        message.setSubject("Request", "UTF-8");
	 
	        // 5. Content: �ʼ�����
	        message.setText(username+" wants to reserve "+bookname+" book. Please login to deal with it..!!!");
	 
	            // 6. ���÷���ʱ��
	        message.setSentDate(new Date());
	 
	        // 7. ��������
	        message.saveChanges();
	       
			
	        // 4. ���� Session ��ȡ�ʼ��������
	        Transport transport = session.getTransport();
	        
	        transport.connect(myEmailAccount, myEmailPassword);
	 
	        // 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
	        transport.sendMessage(message, message.getAllRecipients());
	 
	        // 7. �ر�����
	        transport.close();
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
 
    }
    
    public static void ReserveSuccess(String username,String bookname)  {
        // 1. ������������, ���������ʼ��������Ĳ�������
        Properties props = new Properties();                    // ��������
        props.put("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
        props.put("mail.smtp.host", myEmailSMTPHost);   // �����˵������ SMTP ��������ַ
        props.put("mail.smtp.auth", "true");            // ��Ҫ������֤
        
        // PS: ĳЩ���������Ҫ�� SMTP ������Ҫʹ�� SSL ��ȫ��֤ (Ϊ����߰�ȫ��, ����֧��SSL����, Ҳ�����Լ�����),
        //     ����޷������ʼ�������, ��ϸ�鿴����̨��ӡ�� log, ����������� ������ʧ��, Ҫ�� SSL ��ȫ���ӡ� �ȴ���,
        //     ȡ������ /* ... */ ֮���ע�ʹ���, ���� SSL ��ȫ���ӡ�
        
        // SMTP �������Ķ˿� (�� SSL ���ӵĶ˿�һ��Ĭ��Ϊ 25, ���Բ����, ��������� SSL ����,
        //                  ��Ҫ��Ϊ��Ӧ����� SMTP �������Ķ˿�, ����ɲ鿴��Ӧ�������İ���,
        //                  QQ�����SMTP(SLL)�˿�Ϊ465��587, ������������ȥ�鿴)
        final String smtpPort = "587";
        props.put("mail.smtp.starttls.enable", "true");  //���ܷ�ʽΪstarttls
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "true");
        props.put("mail.smtp.socketFactory.port", smtpPort);
        /*MailSSLSocketFactory sf = new MailSSLSocketFactory(); 
        sf.setTrustAllHosts(true); 
        props.put("mail.smtp.ssl.socketFactory", sf);*/
 
        // 2. �������ô����Ự����, ���ں��ʼ�����������
        Session session = Session.getInstance(props);
        // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log
        session.setDebug(true);
 
        // 3. ����һ���ʼ�
     
        
		try {
			
			MimeMessage message =new MimeMessage(session);
			
			  // 2. From: ������
	        message.setFrom(new InternetAddress(myEmailAccount, "Ⱦ�", "UTF-8"));
	 
	        // 3. To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
	        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount));
	 
	        // 4. Subject: �ʼ�����
	        message.setSubject("Request", "UTF-8");
	 
	        // 5. Content: �ʼ�����
	        message.setText(username+" reserves "+bookname+" book successfully...!!!");
	 
	            // 6. ���÷���ʱ��
	        message.setSentDate(new Date());
	 
	        // 7. ��������
	        message.saveChanges();
	       
			
	        // 4. ���� Session ��ȡ�ʼ��������
	        Transport transport = session.getTransport();
	        
	        transport.connect(myEmailAccount, myEmailPassword);
	 
	        // 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
	        transport.sendMessage(message, message.getAllRecipients());
	 
	        // 7. �ر�����
	        transport.close();
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
 
    }

    public static void ReturnEmailtoAdmin(String username,String bookname)  {
        // 1. ������������, ���������ʼ��������Ĳ�������
        Properties props = new Properties();                    // ��������
        props.put("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
        props.put("mail.smtp.host", myEmailSMTPHost);   // �����˵������ SMTP ��������ַ
        props.put("mail.smtp.auth", "true");            // ��Ҫ������֤
        
        // PS: ĳЩ���������Ҫ�� SMTP ������Ҫʹ�� SSL ��ȫ��֤ (Ϊ����߰�ȫ��, ����֧��SSL����, Ҳ�����Լ�����),
        //     ����޷������ʼ�������, ��ϸ�鿴����̨��ӡ�� log, ����������� ������ʧ��, Ҫ�� SSL ��ȫ���ӡ� �ȴ���,
        //     ȡ������ /* ... */ ֮���ע�ʹ���, ���� SSL ��ȫ���ӡ�
        
        // SMTP �������Ķ˿� (�� SSL ���ӵĶ˿�һ��Ĭ��Ϊ 25, ���Բ����, ��������� SSL ����,
        //                  ��Ҫ��Ϊ��Ӧ����� SMTP �������Ķ˿�, ����ɲ鿴��Ӧ�������İ���,
        //                  QQ�����SMTP(SLL)�˿�Ϊ465��587, ������������ȥ�鿴)
        final String smtpPort = "587";
        props.put("mail.smtp.starttls.enable", "true");  //���ܷ�ʽΪstarttls
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "true");
        props.put("mail.smtp.socketFactory.port", smtpPort);
        /*MailSSLSocketFactory sf = new MailSSLSocketFactory(); 
        sf.setTrustAllHosts(true); 
        props.put("mail.smtp.ssl.socketFactory", sf);*/
 
        // 2. �������ô����Ự����, ���ں��ʼ�����������
        Session session = Session.getInstance(props);
        // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log
        session.setDebug(true);
 
        // 3. ����һ���ʼ�
     
        
		try {
			
			MimeMessage message =new MimeMessage(session);
			
			  // 2. From: ������
	        message.setFrom(new InternetAddress(myEmailAccount, "Ⱦ�", "UTF-8"));
	 
	        // 3. To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
	        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount));
	 
	        // 4. Subject: �ʼ�����
	        message.setSubject("Request", "UTF-8");
	 
	        // 5. Content: �ʼ�����
	        message.setText(username+" wants to return "+bookname+" book. Please login to deal with it..!!!");
	 
	            // 6. ���÷���ʱ��
	        message.setSentDate(new Date());
	 
	        // 7. ��������
	        message.saveChanges();
	       
			
	        // 4. ���� Session ��ȡ�ʼ��������
	        Transport transport = session.getTransport();
	        
	        transport.connect(myEmailAccount, myEmailPassword);
	 
	        // 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
	        transport.sendMessage(message, message.getAllRecipients());
	 
	        // 7. �ر�����
	        transport.close();
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
 
    }
    
    public static void ReturnSuccess(String username,String bookname)  {
        // 1. ������������, ���������ʼ��������Ĳ�������
        Properties props = new Properties();                    // ��������
        props.put("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
        props.put("mail.smtp.host", myEmailSMTPHost);   // �����˵������ SMTP ��������ַ
        props.put("mail.smtp.auth", "true");            // ��Ҫ������֤
        
        // PS: ĳЩ���������Ҫ�� SMTP ������Ҫʹ�� SSL ��ȫ��֤ (Ϊ����߰�ȫ��, ����֧��SSL����, Ҳ�����Լ�����),
        //     ����޷������ʼ�������, ��ϸ�鿴����̨��ӡ�� log, ����������� ������ʧ��, Ҫ�� SSL ��ȫ���ӡ� �ȴ���,
        //     ȡ������ /* ... */ ֮���ע�ʹ���, ���� SSL ��ȫ���ӡ�
        
        // SMTP �������Ķ˿� (�� SSL ���ӵĶ˿�һ��Ĭ��Ϊ 25, ���Բ����, ��������� SSL ����,
        //                  ��Ҫ��Ϊ��Ӧ����� SMTP �������Ķ˿�, ����ɲ鿴��Ӧ�������İ���,
        //                  QQ�����SMTP(SLL)�˿�Ϊ465��587, ������������ȥ�鿴)
        final String smtpPort = "587";
        props.put("mail.smtp.starttls.enable", "true");  //���ܷ�ʽΪstarttls
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "true");
        props.put("mail.smtp.socketFactory.port", smtpPort);
        /*MailSSLSocketFactory sf = new MailSSLSocketFactory(); 
        sf.setTrustAllHosts(true); 
        props.put("mail.smtp.ssl.socketFactory", sf);*/
 
        // 2. �������ô����Ự����, ���ں��ʼ�����������
        Session session = Session.getInstance(props);
        // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log
        session.setDebug(true);
 
        // 3. ����һ���ʼ�
     
        
		try {
			
			MimeMessage message =new MimeMessage(session);
			
			  // 2. From: ������
	        message.setFrom(new InternetAddress(myEmailAccount, "Ⱦ�", "UTF-8"));
	 
	        // 3. To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
	        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount));
	 
	        // 4. Subject: �ʼ�����
	        message.setSubject("Request", "UTF-8");
	 
	        // 5. Content: �ʼ�����
	        message.setText(username+" returns "+bookname+" book successfully.");
	 
	            // 6. ���÷���ʱ��
	        message.setSentDate(new Date());
	 
	        // 7. ��������
	        message.saveChanges();
	       
			
	        // 4. ���� Session ��ȡ�ʼ��������
	        Transport transport = session.getTransport();
	        
	        transport.connect(myEmailAccount, myEmailPassword);
	 
	        // 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
	        transport.sendMessage(message, message.getAllRecipients());
	 
	        // 7. �ر�����
	        transport.close();
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
 
    }
    
    public static void RefuseEmail(String username,String bookname,String op)  {
        // 1. ������������, ���������ʼ��������Ĳ�������
        Properties props = new Properties();                    // ��������
        props.put("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
        props.put("mail.smtp.host", myEmailSMTPHost);   // �����˵������ SMTP ��������ַ
        props.put("mail.smtp.auth", "true");            // ��Ҫ������֤
        
        // PS: ĳЩ���������Ҫ�� SMTP ������Ҫʹ�� SSL ��ȫ��֤ (Ϊ����߰�ȫ��, ����֧��SSL����, Ҳ�����Լ�����),
        //     ����޷������ʼ�������, ��ϸ�鿴����̨��ӡ�� log, ����������� ������ʧ��, Ҫ�� SSL ��ȫ���ӡ� �ȴ���,
        //     ȡ������ /* ... */ ֮���ע�ʹ���, ���� SSL ��ȫ���ӡ�
        
        // SMTP �������Ķ˿� (�� SSL ���ӵĶ˿�һ��Ĭ��Ϊ 25, ���Բ����, ��������� SSL ����,
        //                  ��Ҫ��Ϊ��Ӧ����� SMTP �������Ķ˿�, ����ɲ鿴��Ӧ�������İ���,
        //                  QQ�����SMTP(SLL)�˿�Ϊ465��587, ������������ȥ�鿴)
        final String smtpPort = "587";
        props.put("mail.smtp.starttls.enable", "true");  //���ܷ�ʽΪstarttls
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "true");
        props.put("mail.smtp.socketFactory.port", smtpPort);
        /*MailSSLSocketFactory sf = new MailSSLSocketFactory(); 
        sf.setTrustAllHosts(true); 
        props.put("mail.smtp.ssl.socketFactory", sf);*/
 
        // 2. �������ô����Ự����, ���ں��ʼ�����������
        Session session = Session.getInstance(props);
        // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log
        session.setDebug(true);
 
        // 3. ����һ���ʼ�
     
        
		try {
			
			MimeMessage message =new MimeMessage(session);
			
			  // 2. From: ������
	        message.setFrom(new InternetAddress(myEmailAccount, "Ⱦ�", "UTF-8"));
	 
	        // 3. To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
	        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount));
	 
	        // 4. Subject: �ʼ�����
	        message.setSubject("Request", "UTF-8");
	 
	        // 5. Content: �ʼ�����
	        message.setText(username+", Your request for "+op+"ing "+bookname+" book has been rejected.");
	 
	            // 6. ���÷���ʱ��
	        message.setSentDate(new Date());
	 
	        // 7. ��������
	        message.saveChanges();
	       
			
	        // 4. ���� Session ��ȡ�ʼ��������
	        Transport transport = session.getTransport();
	        
	        transport.connect(myEmailAccount, myEmailPassword);
	 
	        // 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
	        transport.sendMessage(message, message.getAllRecipients());
	 
	        // 7. �ر�����
	        transport.close();
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
 
    }
    
    
}
