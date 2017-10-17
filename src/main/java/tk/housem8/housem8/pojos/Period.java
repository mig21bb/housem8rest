/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.housem8.housem8.pojos;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Administrador
 */
public class Period {

    private String period;
    private String month;
    private Integer year;
    private List<String> fullYear;

    public Period(String period) {
        this.period = period;

        this.month = writeMonth(period);
        this.year = writeYear(period);

        this.fullYear = fillFullYear(period);

    }

    public Period() {
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    private String writeMonth(String period) {

        Properties prop = new Properties();
        InputStream input = null;
        String response = "month01";

        try {

            String filename = "messages.properties";
            ClassLoader classLoader = getClass().getClassLoader();
            input = classLoader.getResourceAsStream(filename);
            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);
                return response;
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and print it out
            System.out.println(prop.getProperty("month" + period.substring(4, 6)));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response;
    }

    private Integer writeYear(String period) {
        return new Integer(period.substring(0, 4));
    }

    public LocalDate getDateFromPeriod(String period) {

        Calendar fecha = Calendar.getInstance();
        try {
            if (period != null && period.length() == 6) {
                //System.out.println("year from period: "+period.substring(0, 4));
                //System.out.println("month from period: "+new Integer(period.substring(4, 6))+1);
                fecha.set(Calendar.YEAR, new Integer(period.substring(0, 4)));
                fecha.set(Calendar.MONTH, new Integer(period.substring(4, 6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(period);
        }
        return LocalDate.of(fecha.get(Calendar.YEAR), fecha.get(Calendar.MONTH), fecha.get(Calendar.DAY_OF_MONTH));
    }

    public String getPeriodFromDate() {

        Calendar fecha = Calendar.getInstance();
        String period = null;
        try {

            String month = String.valueOf(fecha.get(Calendar.MONTH) + 1);
            period = String.valueOf(fecha.get(Calendar.YEAR)).concat(("00" + month).substring(month.length()));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(period);
        }
        return period;
    }

    public List<String> fillFullYear(String period) {

        List<String> fullYear = new ArrayList<>();
        Calendar fecha = Calendar.getInstance();
        fecha.set(Calendar.YEAR, new Integer(period.substring(0, 4)));
        fecha.set(Calendar.MONTH, new Integer(period.substring(4, 6)));
        fecha.add(Calendar.MONTH, -6);

        for (int i = 0; i < 12; i++) {
            fecha.add(Calendar.MONTH, 1);

            String month = String.valueOf(fecha.get(Calendar.MONTH) + 1);
            System.out.println("i=" + i + ", month" + month);
            
            fullYear.add(String.valueOf(fecha.get(Calendar.YEAR)).concat(("00" + month).substring(month.length())));
            if (fecha.after(Calendar.getInstance())) {
               break;
            }
        }
        return fullYear;
    }

}
