package com.niit.dao;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;



public class JobDAO implements Job {

    // �����˵� ���� �� ���루�滻Ϊ�Լ�����������룩
    // PS: ĳЩ���������Ϊ���������䱾������İ�ȫ�ԣ��� SMTP �ͻ��������˶������루�е������Ϊ����Ȩ�롱��,
    //     ���ڿ����˶������������, ����������������ʹ������������루��Ȩ�룩��
    public static String myEmailAccount = "ranjin898@hotmail.com";
    public static String myEmailPassword = "ranJin147258..";
 
    // ����������� SMTP ��������ַ, ����׼ȷ, ��ͬ�ʼ���������ַ��ͬ, һ��(ֻ��һ��, ���Ǿ���)��ʽΪ: smtp.xxx.com
    public static String myEmailSMTPHost = "smtp-mail.outlook.com";
 
    // �ռ������䣨�滻Ϊ�Լ�֪������Ч���䣩
    public static String receiveMailAccount = "ranjin898@hotmail.com";
    public static int Days=2;
    public  void execute(JobExecutionContext context) throws JobExecutionException {
                                                                                                                                                                                        
    	
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
 
        // 2. �������ô����Ự����, ���ں��ʼ�����������
        Session session = Session.getInstance(props);
        // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log
        session.setDebug(true);
 
        // 3. ����һ���ʼ�
     
        
		try {
			MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount);
			
			

	        // 4. ���� Session ��ȡ�ʼ��������
	        Transport transport = session.getTransport();
	 
	        // 5. ʹ�� �����˺� �� ���� �����ʼ�������, ������֤����������� message �еķ���������һ��, ���򱨴�
	        //
	        //    PS_01: ������ӷ�����ʧ��, �����ڿ���̨�����Ӧʧ��ԭ���log��
	        //    ��ϸ�鿴ʧ��ԭ��, ��Щ����������᷵�ش������鿴�������͵�����,
	        //    ���ݸ����Ĵ������͵���Ӧ�ʼ��������İ�����վ�ϲ鿴����ʧ��ԭ��
	        //
	        //    PS_02: ����ʧ�ܵ�ԭ��ͨ��Ϊ���¼���, ��ϸ������:
	        //           (1) ����û�п��� SMTP ����;
	        //           (2) �����������, ����ĳЩ���俪���˶�������;
	        //           (3) ���������Ҫ�����Ҫʹ�� SSL ��ȫ����;
	        //           (4) �������Ƶ��������ԭ��, ���ʼ��������ܾ�����;
	        //           (5) ������ϼ��㶼ȷ������, ���ʼ���������վ���Ұ�����
	        //
	        transport.connect(myEmailAccount, myEmailPassword);
	 
	        // 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
	        transport.sendMessage(message, message.getAllRecipients());
	 
	        // 7. �ر�����
	        transport.close();
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
 
		
	    if(Days==0)
	    {
	    	Days=3;
	    }
	    
	    Days--;
    }
    
    
 
    /**
     * ����һ��ֻ�����ı��ļ��ʼ�
     *
     * @param session     �ͷ����������ĻỰ
     * @param sendMail    ����������
     * @param receiveMail �ռ�������
     * @return
     * @throws Exception
     */
    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
        // 1. ����һ���ʼ�
    	
    	
    	MimeMessage message = new MimeMessage(session);
 
        // 2. From: ������
        message.setFrom(new InternetAddress(sendMail, "Ⱦ�", "UTF-8"));
 
        // 3. To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail));
 
        // 4. Subject: �ʼ�����
        message.setSubject("Return Book", "UTF-8");
 
        // 5. Content: �ʼ����ģ�����ʹ��html��ǩ��
        message.setText("It's time to return book..!!!! You have "+Days+" day left!");
        
            // 6. ���÷���ʱ��
        message.setSentDate(new Date());
 
        // 7. ��������
        message.saveChanges();
       
        return message;
        
        
        
    }
    
    
}
