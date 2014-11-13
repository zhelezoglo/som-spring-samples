package com.som.hib.validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public interface ICar {

    @NotNull
//    @Pattern(regexp = "\\t{0}\\r{0}\\n{0}\\f{0}\\e{0}\\c{0}")
    @Pattern(regexp = "[a-z[A-Z[0-9[-[_]]]]]*")
//    @Pattern(regexp = "[a-z],!")
    String getManufacturer();
}
