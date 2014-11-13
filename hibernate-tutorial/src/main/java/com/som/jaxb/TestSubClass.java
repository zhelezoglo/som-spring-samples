package com.som.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
//@XmlType(propOrder = {"subTest1"})
//@XmlType(propOrder = {"test1", "test2", "test3", "test4", "test5", "test6", "test7", "test8"})
public class TestSubClass extends TestClass {

    @XmlAttribute(name = "i")
    public String subTest1 = "subTest1";

}
