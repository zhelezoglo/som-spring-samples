package com.som.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement()
//@XmlType(propOrder = {"test2", "test3", "test4", "test1", "test5", "test7", "test6", "test8"})
@XmlType(propOrder = {"test1", "test2", "test3", "test4", "test5", "test6", "test7", "test8"})
public class TestClass {
    @XmlAttribute(name = "a")
    String test1 = "test1";

    @XmlAttribute(name = "b")
    String test2 = "test2";

    @XmlAttribute(name = "c")
    String test3 = "test3";

    @XmlAttribute(name = "d")
    String test4 = "test4";

    @XmlAttribute(name = "e")
    String test5 = "test5";

    @XmlAttribute(name = "f")
    String test7 = "test7";

    @XmlAttribute(name = "g")
    String test6 = "test6";

    @XmlAttribute(name = "h")
    String test8 = "test8";
//    private String test1 = "test1&_text";
//    private String test3 = "test3\"_text";
//    private String test2 = "test2_text";
//    private String test4 = "test4_text";
//    private String test5 = "test5&_text";
//    private String test7 = "test7\"_text";
//    private String test6 = "test6_text";
//    private String test8 = "test8_text";
//@XmlType(propOrder = { "test2", "test3", "test4", "test1", "test5", "test7", "test6", "test8" })


}