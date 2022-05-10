
package objects;

public class Employee {
    
    private String name;
    private String id;
    private double pay;
    private int hours;
    
    Employee(){
        pay = 6.0;
        hours = 40;
        name = "John Doe";
        id = "0000000";
    }
    
    public void setPay(double p){
        pay = p;
    }
    
    public void setHours(int h){
        hours = h;
    }
    
    public void setName(String n){
        name = n;
    }
    
    public void setId(String i){
        id = i;
    }
    
    public double getPay(){
        return pay;
    }
    
    public int getHours(){
        return hours;
    }
    
    public String getName(){
        return name;
    }
    
    public String getId(){
        return id;
    }
    
    public double calcWage(){
       return pay*hours;
    }
            
    
}
