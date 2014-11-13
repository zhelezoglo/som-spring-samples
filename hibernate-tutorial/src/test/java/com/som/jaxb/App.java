package com.som.jaxb;

import javax.xml.bind.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class App {

    private static final String TEST_XML = "./test-jaxb.xml";

    public static void main(String[] args) throws PropertyException, JAXBException, IOException {
//        TestClass tc = new TestClass();
        TestSubClass tc = new TestSubClass();

        JAXBContext context = JAXBContext.newInstance(TestSubClass.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(tc, System.out);

        Writer w = null;
        try {
            w = new FileWriter(TEST_XML);
            m.marshal(tc, w);
        } finally {
            try {
                w.close();
            } catch (Exception e) {
                System.out.println("Exception!!!");
            }
        }

// get variables from our xml file, created before
        System.out.println();
        System.out.println("Output from our XML File: ");
        Unmarshaller um = context.createUnmarshaller();
        TestSubClass tc2 = (TestSubClass) um.unmarshal(new FileReader(TEST_XML));

        System.out.println("tc2.test1 = " + tc2.test1);
        System.out.println("tc2.test2 = " + tc2.test2);
        System.out.println("tc2.test3 = " + tc2.test3);
        System.out.println("tc2.test4 = " + tc2.test4);
        System.out.println("tc2.test5 = " + tc2.test5);
        System.out.println("tc2.test6 = " + tc2.test6);
        System.out.println("tc2.test7 = " + tc2.test7);
        System.out.println("tc2.test8 = " + tc2.test8);
        System.out.println("tc2.subTest = " + tc2.subTest1);

    }
}