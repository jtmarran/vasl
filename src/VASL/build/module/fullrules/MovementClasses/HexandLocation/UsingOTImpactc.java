package VASL.build.module.fullrules.MovementClasses.HexandLocation;

import VASL.LOS.Map.Hex;
import VASL.LOS.Map.Location;
import VASL.LOS.Map.Terrain;
import VASL.build.module.fullrules.Constantvalues;
import VASL.build.module.fullrules.DataClasses.ScenarioTerrain;

import java.util.LinkedList;

public class UsingOTImpactc implements HexDecoratori {

    private Locationi basehex;
    private Constantvalues.UMove moveoptionclicked;
    private Double hexsideMFcost;
    // constructor for decorator
    public UsingOTImpactc (Locationi PassBaseHex, Constantvalues.UMove MovementOptionClicked) {
        basehex = PassBaseHex;
        moveoptionclicked = MovementOptionClicked;
    }

    public double gethexsideentrycost() {return hexsideMFcost;}
    public Location getvasllocation() {return basehex.getvasllocation();}
    public Hex getvaslhex() {return basehex.getvaslhex();}
    public Terrain getvaslterrain () {return basehex.getvaslterrain();}
    public String gethexname() {return basehex.gethexname();}
    public Terrain getvaslotherterrain() {return basehex.getvaslotherterrain();}
    public LinkedList<ScenarioTerrain> getScenTerraininhex() {return basehex.getScenTerraininhex();}
    public boolean HasWire() {return basehex.HasWire();}
    public int getAPMines() {return basehex.getAPMines();}
    public void setAPMines (int value){basehex.setAPMines(value);}
    public boolean IsPillbox() {return basehex.IsPillbox();}
    public Constantvalues.Location getLocationtype() {return basehex.getLocationtype();}
    public double getlocationentrycost(Hex Currenthex) {

        double AddtoCost = basehex.getvaslotherterrain().getMF();
        return basehex.getlocationentrycost(Currenthex) + AddtoCost;
    }
}
