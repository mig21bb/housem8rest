/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.housem8.housem8.delegates;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrador
 */
@Component
public class WebDelegate {

    public LocalDate getDateFromPeriod(String period) {
        
        Calendar fecha = Calendar.getInstance();
        try{
        if(period!=null && period.length()==6){
            System.out.println("year from period: "+period.substring(0, 4));
            System.out.println("month from period: "+new Integer(period.substring(4, 6))+1);
            fecha.set(Calendar.YEAR, new Integer(period.substring(0, 4)));
            fecha.set(Calendar.MONTH,new Integer(period.substring(4, 6)));
        }
        }catch(Exception e){
            e.printStackTrace();
            System.out.print(period);
        }
        return LocalDate.of(fecha.get(Calendar.YEAR),fecha.get(Calendar.MONTH),fecha.get(Calendar.DAY_OF_MONTH));
    }

    
    
    
    
}
