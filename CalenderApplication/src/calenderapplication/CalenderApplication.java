/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calenderapplication;
import dateapplication.Date;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import timeapllication.Time;

/**
 *
 * @author 17pw32
 */
class Timer implements Runnable{
    Calender c;
    
    Timer(Calender c1)
    {
        this.c = c1;
    }
    @Override
    public void run()
    {
        while(true)
        {
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
        }
            c.tick();
            //System.out.println(c);
        }
    }
}
class DisplayCalender implements Runnable{
    Calender c;
    
    DisplayCalender(Calender c)
    {
        this.c = c;
    }
    @Override
    public void run()
    {
        while(true)
        {
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(DisplayCalender.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(c);
        }
    }
    
}
class Calender{
    Date date;
    Time time;
    Calender(Time time , Date date)
    {
        this.time = time;
        this.date = date;
    }
    public synchronized void tick()
    {
        boolean res =time.incSec();
        if(res)
        {
           date.incDate();
        }
    }  
    public synchronized String toString()
    {
        System.out.println(this.time+"\t"+this.date);
        
        return " ";
    }
    
}
public class CalenderApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        
        Time t = new Time(23,59,50);
        Date d = new Date(9,9,2019);
        
        Calender c = new Calender(t,d);
        
        Thread t1 = new Thread(new Timer(c));
        Thread t2 = new Thread(new DisplayCalender(c));
        t2.start();
        t1.start();

        
        
    }
    
}
