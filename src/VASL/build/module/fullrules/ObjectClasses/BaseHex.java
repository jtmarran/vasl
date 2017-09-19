package VASL.build.module.fullrules.ObjectClasses;

import VASL.build.module.fullrules.Constantvalues;
import VASL.build.module.fullrules.MapDataClasses.MapDataC;

import java.util.LinkedList;

public class BaseHex {
    private String prhexnamevalue; // readonly
    private int prHexIDvalue;  // readonly
    private Constantvalues.Location prHextertypevalue;
    private String prControlvalue;
    private boolean prStaircasevalue;
    private Constantvalues.Hexside prhexside1value;  // readonly
    private Constantvalues.Hexside prhexside2value;// // readonly
    private Constantvalues.Hexside prhexside3value;  // readonly
    private Constantvalues.Hexside prhexside4value;  // readonly
    private Constantvalues.Hexside prhexside5value;   // readonly
    private Constantvalues.Hexside prhexside6value;   // readonly
    private double prHexBaseLevelValue;  // readonly
    private int prlocindex;   // readonly
    private LinkedList<SmokeHolder> prSmokeList;   // readonly
    private Constantvalues.Feature prOBA;   // readonly

    public BaseHex(String PassHexname, int PassHexID, Constantvalues.Location PasshexTerrtype, Constantvalues.Hexside PassHexside1, Constantvalues.Hexside PassHexside2, Constantvalues.Hexside PassHexside3,
                   Constantvalues.Hexside PassHexside4, Constantvalues.Hexside PassHexside5, Constantvalues.Hexside PassHexside6, boolean Passstaircase, double PassBaselevel, String Passcontrol,
                   LinkedList<SmokeHolder> PassSmokeList, Constantvalues.Feature PassOBA) {
        prhexnamevalue = PassHexname;
        prHexIDvalue = PassHexID;
        prHextertypevalue = PasshexTerrtype;
        prhexside1value = PassHexside1;
        prhexside2value = PassHexside2;
        prhexside3value = PassHexside3;
        prhexside4value = PassHexside4;
        prhexside5value = PassHexside5;
        prhexside6value = PassHexside6;
        prStaircasevalue = Passstaircase;
        prControlvalue = Passcontrol;
        prHexBaseLevelValue = PassBaselevel;
        MapDataC Maptables = MapDataC.GetInstance("", 0);  // use null values for parameters when sure instance exists
        //Dim LocationCol As IQueryable (Of MapDataClassLibrary.GameLocation) =Maptables.LocationCol
        //GetALocationFromMap Getlocs = new GetALocationFromMap(LocationCol);
        //GameLocation LocToUse = Getlocs.RetrieveLocationfromMaptable(PassHexID, PasshexTerrtype);
        //prlocindex = LocToUse.LocIndex;
        prSmokeList = PassSmokeList;
        prOBA = PassOBA;
    }
    // thread version
    public BaseHex(String PassHexname, int PassHexID, Constantvalues.Location PasshexTerrtype, Constantvalues.Hexside PassHexside1, Constantvalues.Hexside PassHexside2, Constantvalues.Hexside PassHexside3,
                   Constantvalues.Hexside PassHexside4, Constantvalues.Hexside PassHexside5, Constantvalues.Hexside PassHexside6, boolean Passstaircase, double PassBaselevel, String Passcontrol,
                   int PassThreadLOCIndex, LinkedList<SmokeHolder> PassSmokeList, Constantvalues.Feature PassOBA) {
        prhexnamevalue = PassHexname;
        prHexIDvalue = PassHexID;
        prHextertypevalue = PasshexTerrtype;
        prhexside1value = PassHexside1;
        prhexside2value = PassHexside2;
        prhexside3value = PassHexside3;
        prhexside4value = PassHexside4;
        prhexside5value = PassHexside5;
        prhexside6value = PassHexside6;
        prStaircasevalue = Passstaircase;
        prControlvalue = Passcontrol;
        prHexBaseLevelValue = PassBaselevel;
        prlocindex = PassThreadLOCIndex;
        prSmokeList = PassSmokeList;
        prOBA = PassOBA;
    }

    public  String getHexName() {return prhexnamevalue;}
    public int getHexID() {return prHexIDvalue;}
    public Constantvalues.Location getHextertype() {return prHextertypevalue;}
    public void setHextertype(Constantvalues.Location value) {prHextertypevalue=value;}
    public Constantvalues.Hexside getHexside1() {return prhexside1value;}
    public Constantvalues.Hexside getHexside2() {return prhexside2value;}
    public Constantvalues.Hexside getHexside3() {return prhexside3value;}
    public Constantvalues.Hexside getHexside4() {return prhexside4value;}
    public Constantvalues.Hexside getHexside5() {return prhexside5value;}
    public Constantvalues.Hexside getHexside6() {return prhexside6value;}
    public double getHexBaseLevel() {return prHexBaseLevelValue;}
    public String getControl() {return prControlvalue;}
    public void setControl(String value) {prControlvalue=value;}
    public boolean getStaircase() {return prStaircasevalue;}
    public void setStaircase(boolean value) {prStaircasevalue = value;}
    public int getLocIndex() {return prlocindex;}
    public LinkedList<SmokeHolder> getSmokeList() {return prSmokeList;}
    public Constantvalues.Feature getOBA() {return prOBA;}
}