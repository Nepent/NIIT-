package com.niit.supportclasses;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailConfig {
	
	 // 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
    // PS: 某些邮箱服务器为了增加邮箱本身密码的安全性，给 SMTP 客户端设置了独立密码（有的邮箱称为“授权码”）,
    //     对于开启了独立密码的邮箱, 这里的邮箱密码必需使用这个独立密码（授权码）。
    public static String myEmailAccount = "ranjin898@hotmail.com";
    public static String myEmailPassword = "ranJin147258..";
 
    // 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般(只是一般, 绝非绝对)格式为: smtp.xxx.com
    public static String myEmailSMTPHost = "smtp-mail.outlook.com";
 
    // 收件人邮箱（替换为自己知道的有效邮箱）
    public static String receiveMailAccount = "ranjin898@hotmail.com";
    
    public static void RegisterEmailtoAdmin(String username)  {
        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();                    // 参数配置
        props.put("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.put("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.put("mail.smtp.auth", "true");            // 需要请求认证
        
        // PS: 某些邮箱服务器要求 SMTP 连接需要使用 SSL 安全认证 (为了提高安全性, 邮箱支持SSL连接, 也可以自己开启),
        //     如果无法连接邮件服务器, 仔细查看控制台打印的 log, 如果有有类似 “连接失败, 要求 SSL 安全连接” 等错误,
        //     取消下面 /* ... */ 之间的注释代码, 开启 SSL 安全连接。
        
        // SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,
        //                  需要改为对应邮箱的 SMTP 服务器的端口, 具体可查看对应邮箱服务的帮助,
        //                  QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)
        final String smtpPort = "587";
        props.put("mail.smtp.starttls.enable", "true");  //加密方式为starttls
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "true");
        props.put("mail.smtp.socketFactory.port", smtpPort);
        /*MailSSLSocketFactory sf = new MailSSLSocketFactory(); 
        sf.setTrustAllHosts(true); 
        props.put("mail.smtp.ssl.socketFactory", sf);*/
 
        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
        // 设置为debug模式, 可以查看详细的发送 log
        session.setDebug(true);
 
        // 3. 创建一封邮件
     
        
		try {
			
			MimeMessage message =new MimeMessage(session);
			
			  // 2. From: 发件人
	        message.setFrom(new InternetAddress(myEmailAccount, "染瑾", "UTF-8"));
	 
	        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
	        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount));
	 
	        // 4. Subject: 邮件主题
	        message.setSubject("Request", "UTF-8");
	 
	        // 5. Content: 邮件正文
	        message.setText(username+" have registered an account of LMS..!!!");
	 
	            // 6. 设置发件时间
	        message.setSentDate(new Date());
	 
	        // 7. 保存设置
	        message.saveChanges();
	       
			
	        // 4. 根据 Session 获取邮件传输对象
	        Transport transport = session.getTransport();
	        
	        transport.connect(myEmailAccount, myEmailPassword);
	 
	        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
	        transport.sendMessage(message, message.getAllRecipients());
	 
	        // 7. 关闭连接
	        transport.close();
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
 
    }
    
    public static void BorrowEmailtoAdmin(String username,String bookname)  {
        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();                    // 参数配置
        props.put("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.put("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.put("mail.smtp.auth", "true");            // 需要请求认证
        
        // PS: 某些邮箱服务器要求 SMTP 连接需要使用 SSL 安全认证 (为了提高安全性, 邮箱支持SSL连接, 也可以自己开启),
        //     如果无法连接邮件服务器, 仔细查看控制台打印的 log, 如果有有类似 “连接失败, 要求 SSL 安全连接” 等错误,
        //     取消下面 /* ... */ 之间的注释代码, 开启 SSL 安全连接。
        
        // SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,
        //                  需要改为对应邮箱的 SMTP 服务器的端口, 具体可查看对应邮箱服务的帮助,
        //                  QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)
        final String smtpPort = "587";
        props.put("mail.smtp.starttls.enable", "true");  //加密方式为starttls
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "true");
        props.put("mail.smtp.socketFactory.port", smtpPort);
        /*MailSSLSocketFactory sf = new MailSSLSocketFactory(); 
        sf.setTrustAllHosts(true); 
        props.put("mail.smtp.ssl.socketFactory", sf);*/
 
        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
        // 设置为debug模式, 可以查看详细的发送 log
        session.setDebug(true);
 
        // 3. 创建一封邮件
     
        
		try {
			
			MimeMessage message =new MimeMessage(session);
			
			  // 2. From: 发件人
	        message.setFrom(new InternetAddress(myEmailAccount, "染瑾", "UTF-8"));
	 
	        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
	        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount));
	 
	        // 4. Subject: 邮件主题
	        message.setSubject("Request", "UTF-8");
	 
	        // 5. Content: 邮件正文
	        message.setText(username+" wants to borrow "+bookname+" book. Please login to deal with it..!!!");
	 
	            // 6. 设置发件时间
	        message.setSentDate(new Date());
	 
	        // 7. 保存设置
	        message.saveChanges();
	       
			
	        // 4. 根据 Session 获取邮件传输对象
	        Transport transport = session.getTransport();
	        
	        transport.connect(myEmailAccount, myEmailPassword);
	 
	        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
	        transport.sendMessage(message, message.getAllRecipients());
	 
	        // 7. 关闭连接
	        transport.close();
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
 
    }
    
    public static void BorrowSuccess(String username,String bookname)  {
        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();                    // 参数配置
        props.put("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.put("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.put("mail.smtp.auth", "true");            // 需要请求认证
        
        // PS: 某些邮箱服务器要求 SMTP 连接需要使用 SSL 安全认证 (为了提高安全性, 邮箱支持SSL连接, 也可以自己开启),
        //     如果无法连接邮件服务器, 仔细查看控制台打印的 log, 如果有有类似 “连接失败, 要求 SSL 安全连接” 等错误,
        //     取消下面 /* ... */ 之间的注释代码, 开启 SSL 安全连接。
        
        // SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,
        //                  需要改为对应邮箱的 SMTP 服务器的端口, 具体可查看对应邮箱服务的帮助,
        //                  QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)
        final String smtpPort = "587";
        props.put("mail.smtp.starttls.enable", "true");  //加密方式为starttls
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "true");
        props.put("mail.smtp.socketFactory.port", smtpPort);
        /*MailSSLSocketFactory sf = new MailSSLSocketFactory(); 
        sf.setTrustAllHosts(true); 
        props.put("mail.smtp.ssl.socketFactory", sf);*/
 
        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
        // 设置为debug模式, 可以查看详细的发送 log
        session.setDebug(true);
 
        // 3. 创建一封邮件
     
        
		try {
			
			MimeMessage message =new MimeMessage(session);
			
			  // 2. From: 发件人
	        message.setFrom(new InternetAddress(myEmailAccount, "染瑾", "UTF-8"));
	 
	        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
	        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount));
	 
	        // 4. Subject: 邮件主题
	        message.setSubject("Request", "UTF-8");
	 
	        // 5. Content: 邮件正文
	        message.setText(username+" borrows "+bookname+" book successfully.");
	 
	            // 6. 设置发件时间
	        message.setSentDate(new Date());
	 
	        // 7. 保存设置
	        message.saveChanges();
	       
			
	        // 4. 根据 Session 获取邮件传输对象
	        Transport transport = session.getTransport();
	        
	        transport.connect(myEmailAccount, myEmailPassword);
	 
	        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
	        transport.sendMessage(message, message.getAllRecipients());
	 
	        // 7. 关闭连接
	        transport.close();
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
 
    }
    
    public static void ReserveEmailtoAdmin(String username,String bookname)  {
        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();                    // 参数配置
        props.put("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.put("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.put("mail.smtp.auth", "true");            // 需要请求认证
        
        // PS: 某些邮箱服务器要求 SMTP 连接需要使用 SSL 安全认证 (为了提高安全性, 邮箱支持SSL连接, 也可以自己开启),
        //     如果无法连接邮件服务器, 仔细查看控制台打印的 log, 如果有有类似 “连接失败, 要求 SSL 安全连接” 等错误,
        //     取消下面 /* ... */ 之间的注释代码, 开启 SSL 安全连接。
        
        // SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,
        //                  需要改为对应邮箱的 SMTP 服务器的端口, 具体可查看对应邮箱服务的帮助,
        //                  QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)
        final String smtpPort = "587";
        props.put("mail.smtp.starttls.enable", "true");  //加密方式为starttls
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "true");
        props.put("mail.smtp.socketFactory.port", smtpPort);
        /*MailSSLSocketFactory sf = new MailSSLSocketFactory(); 
        sf.setTrustAllHosts(true); 
        props.put("mail.smtp.ssl.socketFactory", sf);*/
 
        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
        // 设置为debug模式, 可以查看详细的发送 log
        session.setDebug(true);
 
        // 3. 创建一封邮件
     
        
		try {
			
			MimeMessage message =new MimeMessage(session);
			
			  // 2. From: 发件人
	        message.setFrom(new InternetAddress(myEmailAccount, "染瑾", "UTF-8"));
	 
	        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
	        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount));
	 
	        // 4. Subject: 邮件主题
	        message.setSubject("Request", "UTF-8");
	 
	        // 5. Content: 邮件正文
	        message.setText(username+" wants to reserve "+bookname+" book. Please login to deal with it..!!!");
	 
	            // 6. 设置发件时间
	        message.setSentDate(new Date());
	 
	        // 7. 保存设置
	        message.saveChanges();
	       
			
	        // 4. 根据 Session 获取邮件传输对象
	        Transport transport = session.getTransport();
	        
	        transport.connect(myEmailAccount, myEmailPassword);
	 
	        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
	        transport.sendMessage(message, message.getAllRecipients());
	 
	        // 7. 关闭连接
	        transport.close();
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
 
    }
    
    public static void ReserveSuccess(String username,String bookname)  {
        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();                    // 参数配置
        props.put("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.put("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.put("mail.smtp.auth", "true");            // 需要请求认证
        
        // PS: 某些邮箱服务器要求 SMTP 连接需要使用 SSL 安全认证 (为了提高安全性, 邮箱支持SSL连接, 也可以自己开启),
        //     如果无法连接邮件服务器, 仔细查看控制台打印的 log, 如果有有类似 “连接失败, 要求 SSL 安全连接” 等错误,
        //     取消下面 /* ... */ 之间的注释代码, 开启 SSL 安全连接。
        
        // SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,
        //                  需要改为对应邮箱的 SMTP 服务器的端口, 具体可查看对应邮箱服务的帮助,
        //                  QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)
        final String smtpPort = "587";
        props.put("mail.smtp.starttls.enable", "true");  //加密方式为starttls
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "true");
        props.put("mail.smtp.socketFactory.port", smtpPort);
        /*MailSSLSocketFactory sf = new MailSSLSocketFactory(); 
        sf.setTrustAllHosts(true); 
        props.put("mail.smtp.ssl.socketFactory", sf);*/
 
        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
        // 设置为debug模式, 可以查看详细的发送 log
        session.setDebug(true);
 
        // 3. 创建一封邮件
     
        
		try {
			
			MimeMessage message =new MimeMessage(session);
			
			  // 2. From: 发件人
	        message.setFrom(new InternetAddress(myEmailAccount, "染瑾", "UTF-8"));
	 
	        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
	        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount));
	 
	        // 4. Subject: 邮件主题
	        message.setSubject("Request", "UTF-8");
	 
	        // 5. Content: 邮件正文
	        message.setText(username+" reserves "+bookname+" book successfully...!!!");
	 
	            // 6. 设置发件时间
	        message.setSentDate(new Date());
	 
	        // 7. 保存设置
	        message.saveChanges();
	       
			
	        // 4. 根据 Session 获取邮件传输对象
	        Transport transport = session.getTransport();
	        
	        transport.connect(myEmailAccount, myEmailPassword);
	 
	        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
	        transport.sendMessage(message, message.getAllRecipients());
	 
	        // 7. 关闭连接
	        transport.close();
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
 
    }

    public static void ReturnEmailtoAdmin(String username,String bookname)  {
        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();                    // 参数配置
        props.put("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.put("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.put("mail.smtp.auth", "true");            // 需要请求认证
        
        // PS: 某些邮箱服务器要求 SMTP 连接需要使用 SSL 安全认证 (为了提高安全性, 邮箱支持SSL连接, 也可以自己开启),
        //     如果无法连接邮件服务器, 仔细查看控制台打印的 log, 如果有有类似 “连接失败, 要求 SSL 安全连接” 等错误,
        //     取消下面 /* ... */ 之间的注释代码, 开启 SSL 安全连接。
        
        // SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,
        //                  需要改为对应邮箱的 SMTP 服务器的端口, 具体可查看对应邮箱服务的帮助,
        //                  QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)
        final String smtpPort = "587";
        props.put("mail.smtp.starttls.enable", "true");  //加密方式为starttls
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "true");
        props.put("mail.smtp.socketFactory.port", smtpPort);
        /*MailSSLSocketFactory sf = new MailSSLSocketFactory(); 
        sf.setTrustAllHosts(true); 
        props.put("mail.smtp.ssl.socketFactory", sf);*/
 
        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
        // 设置为debug模式, 可以查看详细的发送 log
        session.setDebug(true);
 
        // 3. 创建一封邮件
     
        
		try {
			
			MimeMessage message =new MimeMessage(session);
			
			  // 2. From: 发件人
	        message.setFrom(new InternetAddress(myEmailAccount, "染瑾", "UTF-8"));
	 
	        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
	        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount));
	 
	        // 4. Subject: 邮件主题
	        message.setSubject("Request", "UTF-8");
	 
	        // 5. Content: 邮件正文
	        message.setText(username+" wants to return "+bookname+" book. Please login to deal with it..!!!");
	 
	            // 6. 设置发件时间
	        message.setSentDate(new Date());
	 
	        // 7. 保存设置
	        message.saveChanges();
	       
			
	        // 4. 根据 Session 获取邮件传输对象
	        Transport transport = session.getTransport();
	        
	        transport.connect(myEmailAccount, myEmailPassword);
	 
	        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
	        transport.sendMessage(message, message.getAllRecipients());
	 
	        // 7. 关闭连接
	        transport.close();
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
 
    }
    
    public static void ReturnSuccess(String username,String bookname)  {
        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();                    // 参数配置
        props.put("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.put("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.put("mail.smtp.auth", "true");            // 需要请求认证
        
        // PS: 某些邮箱服务器要求 SMTP 连接需要使用 SSL 安全认证 (为了提高安全性, 邮箱支持SSL连接, 也可以自己开启),
        //     如果无法连接邮件服务器, 仔细查看控制台打印的 log, 如果有有类似 “连接失败, 要求 SSL 安全连接” 等错误,
        //     取消下面 /* ... */ 之间的注释代码, 开启 SSL 安全连接。
        
        // SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,
        //                  需要改为对应邮箱的 SMTP 服务器的端口, 具体可查看对应邮箱服务的帮助,
        //                  QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)
        final String smtpPort = "587";
        props.put("mail.smtp.starttls.enable", "true");  //加密方式为starttls
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "true");
        props.put("mail.smtp.socketFactory.port", smtpPort);
        /*MailSSLSocketFactory sf = new MailSSLSocketFactory(); 
        sf.setTrustAllHosts(true); 
        props.put("mail.smtp.ssl.socketFactory", sf);*/
 
        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
        // 设置为debug模式, 可以查看详细的发送 log
        session.setDebug(true);
 
        // 3. 创建一封邮件
     
        
		try {
			
			MimeMessage message =new MimeMessage(session);
			
			  // 2. From: 发件人
	        message.setFrom(new InternetAddress(myEmailAccount, "染瑾", "UTF-8"));
	 
	        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
	        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount));
	 
	        // 4. Subject: 邮件主题
	        message.setSubject("Request", "UTF-8");
	 
	        // 5. Content: 邮件正文
	        message.setText(username+" returns "+bookname+" book successfully.");
	 
	            // 6. 设置发件时间
	        message.setSentDate(new Date());
	 
	        // 7. 保存设置
	        message.saveChanges();
	       
			
	        // 4. 根据 Session 获取邮件传输对象
	        Transport transport = session.getTransport();
	        
	        transport.connect(myEmailAccount, myEmailPassword);
	 
	        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
	        transport.sendMessage(message, message.getAllRecipients());
	 
	        // 7. 关闭连接
	        transport.close();
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
 
    }
    
    public static void RefuseEmail(String username,String bookname,String op)  {
        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();                    // 参数配置
        props.put("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.put("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.put("mail.smtp.auth", "true");            // 需要请求认证
        
        // PS: 某些邮箱服务器要求 SMTP 连接需要使用 SSL 安全认证 (为了提高安全性, 邮箱支持SSL连接, 也可以自己开启),
        //     如果无法连接邮件服务器, 仔细查看控制台打印的 log, 如果有有类似 “连接失败, 要求 SSL 安全连接” 等错误,
        //     取消下面 /* ... */ 之间的注释代码, 开启 SSL 安全连接。
        
        // SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,
        //                  需要改为对应邮箱的 SMTP 服务器的端口, 具体可查看对应邮箱服务的帮助,
        //                  QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)
        final String smtpPort = "587";
        props.put("mail.smtp.starttls.enable", "true");  //加密方式为starttls
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "true");
        props.put("mail.smtp.socketFactory.port", smtpPort);
        /*MailSSLSocketFactory sf = new MailSSLSocketFactory(); 
        sf.setTrustAllHosts(true); 
        props.put("mail.smtp.ssl.socketFactory", sf);*/
 
        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
        // 设置为debug模式, 可以查看详细的发送 log
        session.setDebug(true);
 
        // 3. 创建一封邮件
     
        
		try {
			
			MimeMessage message =new MimeMessage(session);
			
			  // 2. From: 发件人
	        message.setFrom(new InternetAddress(myEmailAccount, "染瑾", "UTF-8"));
	 
	        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
	        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount));
	 
	        // 4. Subject: 邮件主题
	        message.setSubject("Request", "UTF-8");
	 
	        // 5. Content: 邮件正文
	        message.setText(username+", Your request for "+op+"ing "+bookname+" book has been rejected.");
	 
	            // 6. 设置发件时间
	        message.setSentDate(new Date());
	 
	        // 7. 保存设置
	        message.saveChanges();
	       
			
	        // 4. 根据 Session 获取邮件传输对象
	        Transport transport = session.getTransport();
	        
	        transport.connect(myEmailAccount, myEmailPassword);
	 
	        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
	        transport.sendMessage(message, message.getAllRecipients());
	 
	        // 7. 关闭连接
	        transport.close();
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
 
    }
    
    
}
