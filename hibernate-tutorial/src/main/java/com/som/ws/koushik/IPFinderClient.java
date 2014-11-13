package com.som.ws.koushik;


import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author som
 */
public class IPFinderClient {
    public static void main(String[] args) {
        assertThat(args.length, is(1));
        String ipAddress = args[0];
        GeoIPService service = new GeoIPService();
        GeoIPServiceSoap serviceSoap = service.getGeoIPServiceSoap();
        GeoIP ip = serviceSoap.getGeoIP(ipAddress);
        System.out.println("ip.getCountryName() = " + ip.getCountryName());
    }
}
