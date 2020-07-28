package com.example.spring4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner{

    @Autowired
    ResourceLoader resourceLoader;


    @Override //ApplicationContext의 타입에 따라 경로가 결정된다
    public void run(ApplicationArguments args) throws Exception {
        //ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("dsads.xml");//클래스패스기준으로 XML파일
//        FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("xxxx.xml");//파일 경로기준으로 가져옴
        System.out.println(resourceLoader.getClass());//ResourceLoader는 서블릿웹애플리케이션컨테스트가 나옴


//        Resource resource = resourceLoader.getResource("text.txt"); 이게 만약 클래스패스에플리케이센컨테스트면 클래스패스로 읽어옴
        Resource resource = resourceLoader.getResource("text.txt");//접두어로 붙여준다.
        //접두어를 사용하는 편이 좋다. 접두어를 붙여주지않으면 서블릿웹애플리케이션으로 나옴
//        resource = resourceLoader.getResource("file:///text.txt"); 접두어를 붙인다
        System.out.println(resource.getClass());//클래스패스 클래스로 결과가나옴
        System.out.println(resource.exists());
        System.out.println(resource.getDescription());//전체 경로 포함한 파일 이름또는 실제 URL

    }
}
