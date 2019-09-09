/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeapllication;

/**
 *
 * @author 17pw32
 */
public class Time {
    private int hours,minutes,seconds;
    public Time(int hours,int minutes,int seconds)
    {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    public int getHours()
    {
        return this.hours;
    }
    public int getMinutes()
    {
        return this.minutes;
    }
    public int getseconds()
    {
        return this.seconds;
    }
    public boolean incSec()
    {
        if(this.seconds%60 == 0 && this.seconds!=0)
        {
            this.seconds = 0;
            if(this.minutes%59 == 0 && this.minutes!=0 )
            {
                this.seconds = 0;
                this.minutes = 0;
                if(this.hours%23 == 0 && this.hours!=0)
                {
                    this.hours = 0;
                    this.minutes = 0;
                    this.seconds = 0;
                    
                    return true;
                }
                else
                {
                    this.hours+=1;
                }
            }
            else
            {
                this.minutes+=1;
            }
        }
        else
        {
            this.seconds+=1;
        }
        
        return false;
    }
    public String toString()
    {
        return "Time: "+this.hours+":"+this.minutes+":"+this.seconds;
    }
    
}
