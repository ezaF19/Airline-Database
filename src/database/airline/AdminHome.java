/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.airline;

/**
 *
 * @author ezaF
 */
public class AdminHome {
    private String flightid,depa,arri,orig,desti,seatn,seatt,seatp,pln,pid,pname,padd,pcnum,transid,transt,transd,transti,fprice,routei,fdatee;
    public AdminHome(String FID, String fdate,String FDep, String FArr,String Routeid,String plid,String Fprice){//, String Origin, String Destination, String SeatNo, String SeatType,
            //String Price, String PLName, String PSID, String PSName, String PSAddress, String PSCNum, String TID,
            //String TType, String TDate, String TTime) {
        this.flightid = FID;
        this.depa = FDep;
        this.arri = FArr;
        this.routei= Routeid;
        this.fdatee = fdate;
        this.pid = plid;
        this.fprice = Fprice;
        /*this.seatn = SeatNo;
        this.seatt = SeatType;
        this.seatp = Price;
        this.pln = PLName;
        this.pid = PSID;
        this.pname = PSName;
        this.padd = PSAddress;
        this.pcnum = PSCNum;
        this.transid = TID;
        this.transt = TType;
        this.transd = TDate;
        this.transti = TTime;
        */        
    }
    public String getFID(){
        return flightid;
    }  
    public String getFDep(){
        return depa;
    }
    public String getFArr(){
        return arri;
    }
    public String getOrigin(){
        return orig;
    }
    public String getDestination(){
        return desti;
    }
    public String getFprice(){
        return fprice;
    }
    public String getRoutei(){
        return routei;
    }
    public String getPlid(){
        return pid;
    }
    public String getFdate(){
        return fdatee;
    }
    /*public String getPrice(){
        return seatp;
    }
    
    public String getPLName(){
        return pln;
    }
    
    public String getPSID(){
        return pid;
    }
    public String getPSName(){
        return pname;
    }
    public String getPSAddress(){
        return padd;
    }
    public String getPSCNum(){
        return pcnum;
    }
    public String getTID(){
        return transid;
    }
    public String getTtype(){
        return transt;
    }
    public String getTDate(){
        return transd;
    }
    public String getTTime(){
        return transti;
    }*/
    
    
}
