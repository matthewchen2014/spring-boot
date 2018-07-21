package com.spring.model.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.time.LocalDate;

public class JaxbApplication {
    public static void main(String[] args) {
        //marshall();
        unmarshall();
    }

    private static void marshall() {
        User user = new User("陈本布衣", 2018, "超级管理员","瞎哔哔", LocalDate.of(2018,1,1));
        File file = new File("/Users/matthew/Documents/user.xml");
        try {
            JAXBContext context = JAXBContext.newInstance(User.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
            marshaller.marshal(user, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void unmarshall() {
        File file = new File("/Users/matthew/Documents/user.xml");
        try {
            JAXBContext context = JAXBContext.newInstance(User.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            User user = (User) unmarshaller.unmarshal(file);
            System.out.println(user.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
