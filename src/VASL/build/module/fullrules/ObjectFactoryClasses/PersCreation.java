package VASL.build.module.fullrules.ObjectFactoryClasses;

/*The Object Factory class library holds code to implement a number of object factories which handle the creation of objects used by the program
These objects include personnel, SW and Vehicular objectst that appear on the GUI but also Menu Item objects and other objects used by the code
All objects used by the code should be created by these factories
The objects themselves should be defined in the Object class library

AT PRESENT, THE POPUP MENU FACTORY IS A BETTER IMPLEMENTATION THAN THE PERSONNEL FACTORY - WHICH COULD PROBABLY BENEFIT FROM AN ADDITIONAL FACTORY LAYER DIVIDED BY NATIONALITY JUST AS
THE MENU FACTORY HAS A LAYER OF FACTORIES DIVIDED BY PHASE*/

import VASL.build.module.fullrules.Constantvalues;
import VASL.build.module.fullrules.DataClasses.DataC;
import VASL.build.module.fullrules.DataClasses.LineofBattle;
import VASL.build.module.fullrules.DataClasses.OrderofBattle;
import VASL.build.module.fullrules.ObjectClasses.*;
import VASL.counters.Concealment;

import java.util.List;

public class PersCreation {
    // holds code that creates persuniti objects and related property classes within Objectclasslibrary.aslxna.Persuniti
    private ScenarioCollectionsc Scencolls = ScenarioCollectionsc.getInstance();
    private DataC Linqdata = DataC.GetInstance();  // use empty variables when know that instance already exists

    // Personnel unit instances
    public PersUniti CreateExistingInstance(OrderofBattle unititem) {  //, Concealment conitem) {  // creates instance of existing unit from database
        // called by ASLXNA.Actions.UnitActionsC and PersCreation.CreateNewInstance which create new persuniti objects at startup or when new unit created during play
        // plus called by PersCreation.createtargetunitproperty when decorating leader (CAN WE AVOID THIS? July 2014)

        // takes information from database objects OrderofBattle/Concealment plus additional values and creates object of type persuniti which is returned to calling method
        // additional values are: PassClass which holds value from Enum UClass stored in LineOfBattle database table as Class; and PassUtype which hold value from Enum Utype (Squad, HS, SMC, etc) stored in LineofBattle database table as UnitType

        Constantvalues.Utype PassUtype = Constantvalues.Utype.None;
        Constantvalues.UClass PassClass = Constantvalues.UClass.NONE;
        PersUniti NewLeader;   // used in SMC creation process
        int UseLOBLink;
        // set variables
        if (unititem != null) {   // item is infantry
            UseLOBLink = (int) (unititem.getLOBLink());
            // test values
            PassUtype = Constantvalues.Utype.Squad;  // (java.lang.Integer.parseInt(Linqdata.GetLOBData(Constantvalues.LOBItem.UNITTYPE, UseLOBLink)));
            PassClass = Constantvalues.UClass.FIRSTLINE; //(java.lang.Integer.parseInt(Linqdata.GetLOBData(Constantvalues.LOBItem.UNITCLASS, UseLOBLink)));
        } else { // item is concealment
            UseLOBLink = 0; // conitem.getNationality() + 2000;
        }
        switch (UseLOBLink) {
            case 1:
            case 2:
                return new German838c(unititem.getHexname(), unititem.getScenario(), (int) unititem.gethexnum(), unititem.gethexlocation(), unititem.getPosition(), unititem.getLevelinHex(), unititem.getLocIndex(), unititem.getCX(), (int) unititem.getELR(),
                        (int) unititem.getTurnArrives(), unititem.getNationality(), unititem.getCon_ID(), unititem.getOBUnit_ID(), Constantvalues.Typetype.Personnel, (int) unititem.getFirstSWLink(), (int) unititem.getSecondSWlink(), unititem.getHexEnteredSideCrossedLastMove(), 0, unititem.getOBName(), 2, unititem.getCombatStatus(),
                        unititem.getVisibilityStatus(), unititem.getFortitudeStatus(), unititem.getOrderStatus(), unititem.getMovementStatus(), unititem.getPinned(), (int) unititem.getSW(), PassClass, unititem.getCharacterStatus(), PassUtype, unititem.getRoleStatus());

            /*case 4:
            return new
            ObjectClassLibrary.ASLXNA.German548c(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                    CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 4, CInt(unititem.CombatStatus),
                    CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))*/
            case 5:
                return new German467c(unititem.getHexname(), unititem.getScenario(), (int) unititem.gethexnum(), unititem.gethexlocation(), unititem.getPosition(), unititem.getLevelinHex(), unititem.getLocIndex(), unititem.getCX(), (int) unititem.getELR(),
                        (int) unititem.getTurnArrives(), unititem.getNationality(), unititem.getCon_ID(), unititem.getOBUnit_ID(), Constantvalues.Typetype.Personnel, (int) unititem.getFirstSWLink(), (int) unititem.getSecondSWlink(), unititem.getHexEnteredSideCrossedLastMove(), 0, unititem.getOBName(), 5, unititem.getCombatStatus(),
                        unititem.getVisibilityStatus(), unititem.getFortitudeStatus(), unititem.getOrderStatus(), unititem.getMovementStatus(), unititem.getPinned(), (int) unititem.getSW(), PassClass, unititem.getCharacterStatus(), PassUtype, unititem.getRoleStatus());

            /*case 9
            return new
            ObjectClassLibrary.ASLXNA.German338c(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                    CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 9, CInt(unititem.CombatStatus),
                    CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))
            case 11:
            return new
            ObjectClassLibrary.ASLXNA.German238c(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                    CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 11, CInt(unititem.CombatStatus),
                    CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))
            case 12:
            return new
            ObjectClassLibrary.ASLXNA.German247c(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                    CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 12, CInt(unititem.CombatStatus),
                    CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))
            case 13:
            return new
            ObjectClassLibrary.ASLXNA.German237c(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                    CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 13, CInt(unititem.CombatStatus),
                    CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))
            case 25:
            return new
            ObjectClassLibrary.ASLXNA.Russian628c(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                    CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 25, CInt(unititem.CombatStatus),
                    CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))
            case 26:
            return new
            ObjectClassLibrary.ASLXNA.Russian458c(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                    CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 26, CInt(unititem.CombatStatus),
                    CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))
            */
            case 27:             return new Russian447c(unititem.getHexname(), unititem.getScenario(), (int) unititem.gethexnum(), unititem.gethexlocation(), unititem.getPosition(), unititem.getLevelinHex(), unititem.getLocIndex(), unititem.getCX(), (int) unititem.getELR(),
                    (int) unititem.getTurnArrives(), unititem.getNationality(), unititem.getCon_ID(), unititem.getOBUnit_ID(), Constantvalues.Typetype.Personnel, (int) unititem.getFirstSWLink(), (int) unititem.getSecondSWlink(), unititem.getHexEnteredSideCrossedLastMove(), 0, unititem.getOBName(), 27, unititem.getCombatStatus(),
                    unititem.getVisibilityStatus(), unititem.getFortitudeStatus(), unititem.getOrderStatus(), unititem.getMovementStatus(), unititem.getPinned(), (int) unititem.getSW(), PassClass, unititem.getCharacterStatus(), PassUtype, unititem.getRoleStatus());
/*case 28
            return new
            ObjectClassLibrary.ASLXNA.Russian527c(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                    CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 28, CInt(unititem.CombatStatus),
                    CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))
            case 29
            return new
            ObjectClassLibrary.ASLXNA.Russian426c(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                    CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 29, CInt(unititem.CombatStatus),
                    CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))
            case 31:
            return new
            ObjectClassLibrary.ASLXNA.Russian248c(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                    CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 31, CInt(unititem.CombatStatus),
                    CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))
            case 32:
            return new
            ObjectClassLibrary.ASLXNA.Russian237c(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                    CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 32, CInt(unititem.CombatStatus),
                    CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))
            case 33
            return new
            ObjectClassLibrary.ASLXNA.Russian227c(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                    CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 33, CInt(unititem.CombatStatus),
                    CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))
            case 34:
            return new
            ObjectClassLibrary.ASLXNA.Russian226c(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                    CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 34, CInt(unititem.CombatStatus),
                    CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))
            case 136:
            return new
            ObjectClassLibrary.ASLXNA.PrisonerSquadc(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                    CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 136, CInt(unititem.CombatStatus),
                    CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))
            case 137:
            return new
            ObjectClassLibrary.ASLXNA.PrisonerHSquadc(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                    CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 137, CInt(unititem.CombatStatus),
                    CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))
            case 138:
            return new
            ObjectClassLibrary.ASLXNA.PrisonerSMCc(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                    CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 138, CInt(unititem.CombatStatus),
                    CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))
            case 202:
            return new
            ObjectClassLibrary.ASLXNA.RussianDummyc(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                    CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 202, CInt(unititem.CombatStatus),
                    CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))
            case 203:
            return new
            ObjectClassLibrary.ASLXNA.GermanDummyc(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                    CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 203, CInt(unititem.CombatStatus),
                    CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))
            'where case is above 1000, creating SMC and must differentiate again by Nationality - better structure?
            case 1004:
            switch (unititem.Nationality) {
                case ConstantClassLibrary.ASLXNA.Nationality.Germans
                        NewLeader = new
                ObjectClassLibrary.ASLXNA.German8_1c(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                        CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 1004, CInt(unititem.CombatStatus),
                        CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))
                case ConstantClassLibrary.ASLXNA.Nationality.Russians
                        NewLeader = new
                ObjectClassLibrary.ASLXNA.Russian8_1c(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                        CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 1004, CInt(unititem.CombatStatus),
                        CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))
            }
            If Not IsNothing(NewLeader) Then return NewLeader Else return Nothing
            case 1101:
            switch unititem.Nationality
            case ConstantClassLibrary.ASLXNA.Nationality.Russians:
            return new
            ObjectClassLibrary.ASLXNA.Russian138c(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                    CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 1101, CInt(unititem.CombatStatus),
                    CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))
            End Select
            case 1102:
            switch unititem.Nationality
            case ConstantClassLibrary.ASLXNA.Nationality.Russians:
            return new
            ObjectClassLibrary.ASLXNA.Russian149c(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                    CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 1102, CInt(unititem.CombatStatus),
                    CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))
            End Select
            case 1124:
            switch unititem.Nationality
            case ConstantClassLibrary.ASLXNA.Nationality.Germans:
                    NewLeader = new
            ObjectClassLibrary.ASLXNA.German8_1c(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                    CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 1004, CInt(unititem.CombatStatus),
                    CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))
            case ConstantClassLibrary.ASLXNA.Nationality.Russians:
                    NewLeader = new
            ObjectClassLibrary.ASLXNA.Russian8_1c(unititem.Hexname, CInt(unititem.Scenario), CInt(unititem.hexnum), CInt(unititem.hexlocation), CInt(unititem.Position), CSng(unititem.LevelinHex), CInt(unititem.LocIndex), unititem.CX, CInt(unititem.ELR),
                    CInt(unititem.TurnArrives), CInt(unititem.Nationality), unititem.Con_ID, unititem.OBUnit_ID, ConstantClassLibrary.ASLXNA.Typetype.Personnel, CInt(unititem.FirstSWLink), CInt(unititem.SecondSWlink), CInt(unititem.HexEnteredSideCrossedLastMove), 0, unititem.OBName, 1004, CInt(unititem.CombatStatus),
                    CInt(unititem.VisibilityStatus), CInt(unititem.FortitudeStatus), CInt(unititem.OrderStatus), CInt(unititem.MovementStatus), unititem.Pinned, CInt(unititem.SW), PassClass, CInt(unititem.CharacterStatus), PassUtype, CInt(unititem.RoleStatus))
            End Select
            If IsNothing (NewLeader) Then return Nothing
            'now must decorate it
            Dim DecNewLeader As ObjectClassLibrary.ASLXNA.PersunitDecoratori
                    DecNewLeader = new ObjectClassLibrary.ASLXNA.PersunitHeroicldrc(NewLeader)
            If Not IsNothing(NewLeader.BasePersUnit) Then DecNewLeader.BasePersUnit = new
            ObjectClassLibrary.ASLXNA.BaseHeroicLdrc(NewLeader.BasePersUnit)
            return DecNewLeader
            case 4002:
            return new
            ObjectClassLibrary.ASLXNA.RussianConc(conitem.Hexname, conitem.Scenario, conitem.hexnum, conitem.Hexlocation, conitem.Position, CSng(conitem.LevelinHex), conitem.LocIndex, CBool(conitem.CX), 0, 0, ConstantClassLibrary.ASLXNA.Nationality.Russians,
                    0, CInt(conitem.Con_ID), ConstantClassLibrary.ASLXNA.Typetype.Concealment, 0, 0, CInt(conitem.HexEnteredSideCrossedLastMove), 0, conitem.Concounter, ConstantClassLibrary.ASLXNA.Nationality.Russians + 2000, 0, ConstantClassLibrary.ASLXNA.VisibilityStatus.Concealed, conitem.FortitudeStatus, 0, CInt(conitem.MovementStatus), False, 0, PassClass, 0, 0, 0)
            case 4003:
            return new
            ObjectClassLibrary.ASLXNA.GermanConc(conitem.Hexname, conitem.Scenario, conitem.hexnum, conitem.Hexlocation, conitem.Position, CSng(conitem.LevelinHex), conitem.LocIndex, CBool(conitem.CX), 0, 0, ConstantClassLibrary.ASLXNA.Nationality.Germans,
                    0, CInt(conitem.Con_ID), ConstantClassLibrary.ASLXNA.Typetype.Concealment, 0, 0, CInt(conitem.HexEnteredSideCrossedLastMove), 0, conitem.Concounter, ConstantClassLibrary.ASLXNA.Nationality.Germans + 2000, 0, ConstantClassLibrary.ASLXNA.VisibilityStatus.Concealed, conitem.FortitudeStatus, 0, CInt(conitem.MovementStatus), False, 0, PassClass, 0, 0, 0)*/
        }
        return null;
    }
    public PersUniti CreateNewInstance(int TypeToCreate, String NewName, PersUniti BirthingUnit) {
        // called in ObjectChange.Objectchange classes when creating a new unit during game play (due to combat results such as Casualty Reduction and ELR Replacment or HOB results such as Battle Hardening)

        // creates new instance of a unit type, adds it to the database and then calls CreateExistingInstance to create persuniti object which is returned to calling method
        //PersunitDecoratori DecNewLeader;  // used if need to decorate the new persuniti
        //'Need to create database object for the new unit
        Constantvalues.CharacterStatus PassCharacterStatus = BirthingUnit.getbaseunit().getCharacterStatus();
        Constantvalues.CombatStatus PassCombatStatus = BirthingUnit.getbaseunit().getCombatStatus();
        int PassConID = BirthingUnit.getbaseunit().getCon_ID();
        boolean PassCX  = false;
        int PassELR = 0;
        int PassFirstSWLink = 0;
        Constantvalues.FortitudeStatus PassFortitudeStatus = Constantvalues.FortitudeStatus.Normal;
        int PassHexEnteredSideCrossedLastMove = 0;
        Constantvalues.Location PassHexlocation = Constantvalues.Location.OpenGround;
        String Passhexname  = "";
        int Passhexnum  = 0;
        int PassLevelInHex = 0;
        int PassLobLink  = TypeToCreate;
        int PassLocIndex  = 0;
        Constantvalues.MovementStatus PassMovementStatus  = Constantvalues.MovementStatus.NotMoving;
        Constantvalues.Nationality Passnationality = BirthingUnit.getbaseunit().getNationality();
        String PassOBname = NewName;
        Constantvalues.OrderStatus PassOrderStatus = BirthingUnit.getbaseunit().getOrderStatus();
        boolean Passpinned = false;
        Constantvalues.AltPos Passhexposition = Constantvalues.AltPos.None;
        Constantvalues.RoleStatus PassRoleStatus = Constantvalues.RoleStatus.None;
        int PassScenario = BirthingUnit.getbaseunit().getScenario();
        int passsecondswlink = 0;
        int PassSW  = 0;
        int PassTurnArrives  = BirthingUnit.getbaseunit().getTurnArrives();
        Constantvalues.VisibilityStatus PassVisibilityStatus = Constantvalues.VisibilityStatus.Visible;
        PersUniti NewUnit= null;

        // temporary while debugging UNDO
        /*if (TypeToCreate < 4000) {   // is not new concealment
            // pass values for new OrderofBattle object to Linqdata to create object and add to database table and update Linqdata.Unitcol
            OrderofBattle NewDBobj = Linqdata.CreateNewUnitinDB(PassCharacterStatus, PassCombatStatus, PassConID, PassCX, PassELR, PassFirstSWLink, PassFortitudeStatus,
                    PassHexEnteredSideCrossedLastMove, PassHexlocation, Passhexname, Passhexnum, PassLevelInHex, PassLobLink,
                    PassLocIndex, PassMovementStatus, Passnationality, PassOBname, PassOrderStatus, Passpinned, Passhexposition,
                    PassRoleStatus, PassScenario, passsecondswlink, PassSW, PassTurnArrives, PassVisibilityStatus);
            // now create new persuniti object
            NewUnit = CreateExistingInstance(NewDBobj);
        } else {
            // pass values for new OrderofBattle object to Linqdata to create object and add to database table and update Linqdata.Unitcol
            Concealment NewDBobj = Linqdata.CreateNewConinDB(PassCX, PassFortitudeStatus,
                    PassHexEnteredSideCrossedLastMove, PassHexlocation, Passhexname, Passhexnum, PassLevelInHex,
                    PassLocIndex, PassMovementStatus, Passnationality, PassOBname, Passhexposition,
                    PassScenario);
            // now create new persuniti object
            NewUnit = CreateExistingInstance(, NewDBobj);
        }

        // check if need to decorate
        if (IsHeroic(NewUnit.getbaseunit().getFortitudeStatus())) {
            // need to decorate leader
            PersunitHeroicldrc DecNewLeader = new PersunitHeroicldrc(NewUnit);
            if (NewUnit.getbaseunit() != null) {
            PersunitDecoratori  DecNewLeader.getbaseunit() = new BaseHeroicLdrc(NewUnit.getbaseunit());
            }
            NewUnit = DecNewLeader;
        }*/
        return NewUnit;

    }
    public boolean IsHeroic(Constantvalues.FortitudeStatus FortitudeStatus) {
        // called by CreateExistingInstance
        // determines if leader is heroic and therefore persuniti needs to be decorated
        if (FortitudeStatus == Constantvalues.FortitudeStatus.Heroic &&
            FortitudeStatus == Constantvalues.FortitudeStatus.HeroicEnc_Wnd) {
            return true;
        } else {
            return false;
        }
    }

    /*    'Moving Unit property
    public Function CreateMovingUnit(ByVal ObjectTypeId As Integer, ByVal ObjectID As Integer, ByRef TempMovementStack As List(Of ObjectClassLibrary.ASLXNA.PersUniti)) As Boolean
            'called by movementc.AddToStackAttempt and movementc.RedoMovementStack
    Dim TypeCheck = new UtilClassLibrary.ASLXNA.TypeUtil
            'creates a new persuniti movement property class in a persuniti object and updates revised stack ready for decoration which is available to calling method through ByRef parameter
    Dim MoveUnit As ObjectClassLibrary.ASLXNA.PersUniti
            'locate existing persuniti and add a movement class property to it
    If TypeCheck.IsThingATypeOf(ConstantClassLibrary.ASLXNA.Typetype.Personnel, ObjectTypeId) Then  'item is infantry
    Dim PassUnit As DataClassLibrary.OrderofBattle = Linqdata.GetUnitfromCol(ObjectID)
    MoveUnit = (From SelTest As ObjectClassLibrary.ASLXNA.PersUniti In Scencolls.Unitcol Where SelTest.BasePersUnit.Unit_ID = ObjectID AndAlso SelTest.BasePersUnit.LOBLink = ObjectTypeId Select SelTest).First
                'set Moving Unit property of persuniti
    MoveUnit.MovingPersUnit = createmovingunitproperty(MoveUnit, PassUnit, Nothing)
    Else
    Dim PassUnit As DataClassLibrary.Concealment = Linqdata.GetConcealmentfromCol(ObjectID)
    MoveUnit = (From SelTest As ObjectClassLibrary.ASLXNA.PersUniti In Scencolls.Unitcol Where SelTest.BasePersUnit.Unit_ID = ObjectID AndAlso SelTest.BasePersUnit.LOBLink = ObjectTypeId Select SelTest).First
                'set Moving Unit property of persuniti
    MoveUnit.MovingPersUnit = createmovingunitproperty(MoveUnit, Nothing, PassUnit)
    End If
            'updated list available to calling method as passed ByRef
                    TempMovementStack.Add(MoveUnit)
    return True
    End Function
    public Function createmovingunitproperty(ByVal MovingUnit As ObjectClassLibrary.ASLXNA.PersUniti, Optional ByVal PassPers As DataClassLibrary.OrderofBattle = Nothing, Optional ByVal PassCon As DataClassLibrary.Concealment = Nothing) As ObjectClassLibrary.ASLXNA.MovingPersuniti
            'called by PersCreation.CreateMovingUnit
                    'also called by ASLXNA.Movement.EnterNewHex.MoveUpdate - add to all movement classes

                    'creates and returns a moving unit class to be added as property of a peruniti object
                    'set variables to pass
    Dim PassOBname As String : Dim PassOBUnitID As Integer : Dim PassConID As Integer : Dim Passhexnum As Integer : Dim Passhexlocation As Integer
    Dim PassPosition As Integer : Dim PassLocIndex As Integer : Dim PassVisibilityStatus As Integer : Dim PasshexEnteredSideCrossedLastMove As Integer
    Dim PassNationality As Integer
    If Not IsNothing(PassPers) Then 'passing OrderofBattle unit
    Passhexnum = CInt(PassPers.hexnum)
    Passhexlocation = CInt(PassPers.hexlocation)
    PassPosition = CInt(PassPers.Position)
    PassLocIndex = CInt(PassPers.LocIndex)
    PassVisibilityStatus = CInt(PassPers.VisibilityStatus)
    PasshexEnteredSideCrossedLastMove = CInt(PassPers.HexEnteredSideCrossedLastMove)
    PassOBname = PassPers.OBName
            PassOBUnitID = PassPers.OBUnit_ID
    PassConID = PassPers.Con_ID
            PassNationality = CInt(PassPers.Nationality)
    Else  'passing Concealment unit
    Passhexnum = CInt(PassCon.hexnum)
    Passhexlocation = CInt(PassCon.Hexlocation)
    PassPosition = CInt(PassCon.Position)
    PassLocIndex = CInt(PassCon.LocIndex)
    PassVisibilityStatus = ConstantClassLibrary.ASLXNA.VisibilityStatus.Concealed
            PasshexEnteredSideCrossedLastMove = CInt(PassCon.HexEnteredSideCrossedLastMove)
    PassOBname = PassCon.Concounter
            PassOBUnitID = CInt(PassCon.Con_ID)
    PassConID = 0
    PassNationality = PassCon.Nationality
    End If
            'select item to create
    switch MovingUnit.BasePersUnit.LOBLink
    case 1
    case 2
    return new ObjectClassLibrary.ASLXNA.German838Movec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    case 4:
    return new ObjectClassLibrary.ASLXNA.German548Movec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    case 5
    return new ObjectClassLibrary.ASLXNA.German467Movec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    case 9
    return new ObjectClassLibrary.ASLXNA.German338Movec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    case 11
    return new ObjectClassLibrary.ASLXNA.German238Movec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    case 12
    return new ObjectClassLibrary.ASLXNA.German247Movec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    case 13
    return new ObjectClassLibrary.ASLXNA.German237Movec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    case 25
    return new ObjectClassLibrary.ASLXNA.Russian628Movec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    case 26
    return new ObjectClassLibrary.ASLXNA.Russian458Movec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    case 27
    return new ObjectClassLibrary.ASLXNA.Russian447Movec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    case 28
    return new ObjectClassLibrary.ASLXNA.Russian527Movec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    case 31
    return new ObjectClassLibrary.ASLXNA.Russian248Movec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    case 32
    return new ObjectClassLibrary.ASLXNA.Russian237Movec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    case 33
    return new ObjectClassLibrary.ASLXNA.Russian227Movec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    case 34
    return new ObjectClassLibrary.ASLXNA.Russian226Movec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    case 136
    return new ObjectClassLibrary.ASLXNA.PrisonerSquadMovec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    case 137
    return new ObjectClassLibrary.ASLXNA.PrisonerHalfSquadMovec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    case 138
    return new ObjectClassLibrary.ASLXNA.PrisonerSMCMovec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    case 202
    return new ObjectClassLibrary.ASLXNA.RussianDummyMovec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    case 203
    return new ObjectClassLibrary.ASLXNA.GermanDummyMovec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
            'where case is above 1000, creating SMC and must differentiate again by Nationality - better structure?
    case 1004
    switch PassNationality
    case ConstantClassLibrary.ASLXNA.Nationality.Germans
    return new ObjectClassLibrary.ASLXNA.German8_1Movec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    case ConstantClassLibrary.ASLXNA.Nationality.Russians
    return new ObjectClassLibrary.ASLXNA.Russian8_1Movec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    End Select
    case 1101
    switch PassNationality
    case ConstantClassLibrary.ASLXNA.Nationality.Germans
                            'return new ObjectClassLibrary.ASLXNA.German138Movec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    case ConstantClassLibrary.ASLXNA.Nationality.Russians
    return new ObjectClassLibrary.ASLXNA.Russian138Movec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    End Select
    case 1102
    switch PassNationality
    case ConstantClassLibrary.ASLXNA.Nationality.Germans
                            'return new ObjectClassLibrary.ASLXNA.German149Movec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    case ConstantClassLibrary.ASLXNA.Nationality.Russians
    return new ObjectClassLibrary.ASLXNA.Russian149Movec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    End Select
    case 4002
    return new ObjectClassLibrary.ASLXNA.RussianConMovec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    case 4003
    return new ObjectClassLibrary.ASLXNA.GermanConMovec(PassOBname, Passhexnum, Passhexlocation, PassPosition, PassLocIndex, PassOBUnitID, PassVisibilityStatus, PassConID, PasshexEnteredSideCrossedLastMove)
    End Select
    End Function

*/
    // Firing Unit property

    public PersUniti CreatefiringUnitandProperty(PersUniti Unititem) {
        // called by IFTC.AddtoTempFireGroup, DFFMVCP.EnemyValuesConcreteC.AddToTempFG, ObjectChange.UnitUpdateNewOldc.new
        // creates a new persuniti firing property class in a persuniti object and returns updated persuniti to calling method

        if (Constantvalues.Typetype.Personnel == Unititem.getbaseunit().getTypeType_ID()) {  // item is infantry
            OrderofBattle PassUnit = Linqdata.GetUnitfromCol(Unititem.getbaseunit().getUnit_ID());
            // set Firing Unit property of persuniti object
            Unititem.setFiringunit(createfiringunitproperty(PassUnit, Unititem));
        }
        return Unititem;
    }

    private FiringPersUniti createfiringunitproperty(OrderofBattle passunit, PersUniti FiringUnit) {
        // called by PersCreation.CreateFiringUnitandProperty

        boolean PassIsCX = passunit.getCX();
        boolean PassIsPinned = passunit.getPinned();
        boolean PassHasMG = passunit.UnitHasMG();
        boolean PassUsingInherentFP = false;
        boolean PassUsingfirstMG = false;
        boolean PassUsingsecondMG = false;

        switch (FiringUnit.getbaseunit().getLOBLink()) {
            case 1:
            case 2:
                //return new German838Firec(PassIsCX, PassIsPinned, PassHasMG, PassUsingInherentFP, PassUsingfirstMG, PassUsingsecondMG, FiringUnit);
            case 4:
                //return new German548Firec(PassIsCX, PassIsPinned, PassHasMG, PassUsingInherentFP, PassUsingfirstMG, PassUsingsecondMG, FiringUnit);
            case 5:
                return new German467Firec(PassIsCX, PassIsPinned, PassHasMG, PassUsingInherentFP, PassUsingfirstMG, PassUsingsecondMG, FiringUnit);
            case 9:
                //return new German338Firec(PassIsCX, PassIsPinned, PassHasMG, PassUsingInherentFP, PassUsingfirstMG, PassUsingsecondMG, FiringUnit);
            case 11:
                //return new German238Firec(PassIsCX, PassIsPinned, PassHasMG, PassUsingInherentFP, PassUsingfirstMG, PassUsingsecondMG, FiringUnit);
            case 12:
                //return new German247Firec(PassIsCX, PassIsPinned, PassHasMG, PassUsingInherentFP, PassUsingfirstMG, PassUsingsecondMG, FiringUnit);
            case 13:
                //return new German237Firec(PassIsCX, PassIsPinned, PassHasMG, PassUsingInherentFP, PassUsingfirstMG, PassUsingsecondMG, FiringUnit);
            case 25:
                //return new Russian628Firec(PassIsCX, PassIsPinned, PassHasMG, PassUsingInherentFP, PassUsingfirstMG, PassUsingsecondMG, FiringUnit);
            case 26:
                //return new Russian458Firec(PassIsCX, PassIsPinned, PassHasMG, PassUsingInherentFP, PassUsingfirstMG, PassUsingsecondMG, FiringUnit);
            case 27:
                return new Russian447Firec(PassIsCX, PassIsPinned, PassHasMG, PassUsingInherentFP, PassUsingfirstMG, PassUsingsecondMG, FiringUnit);
            case 28:
                //return new Russian527Firec(PassIsCX, PassIsPinned, PassHasMG, PassUsingInherentFP, PassUsingfirstMG, PassUsingsecondMG, FiringUnit);
            case 29:
                //return new Russian426Firec(PassIsCX, PassIsPinned, PassHasMG, PassUsingInherentFP, PassUsingfirstMG, PassUsingsecondMG, FiringUnit);
            case 31:
                //return new Russian248Firec(PassIsCX, PassIsPinned, PassHasMG, PassUsingInherentFP, PassUsingfirstMG, PassUsingsecondMG, FiringUnit);
            case 32:
                //return new Russian237Firec(PassIsCX, PassIsPinned, PassHasMG, PassUsingInherentFP, PassUsingfirstMG, PassUsingsecondMG, FiringUnit);
            case 33:
                //return new Russian227Firec(PassIsCX, PassIsPinned, PassHasMG, PassUsingInherentFP, PassUsingfirstMG, PassUsingsecondMG, FiringUnit);
            case 34:
                //return new Russian226Firec(PassIsCX, PassIsPinned, PassHasMG, PassUsingInherentFP, PassUsingfirstMG, PassUsingsecondMG, FiringUnit);
                // where case is above 1000, creating SMC and must differentiate again by Nationality - better structure?
            case 1004:
                switch (FiringUnit.getbaseunit().getNationality()) {
                    case Germans:
                        //return new German8_1Firec(PassIsCX, PassIsPinned, PassHasMG, PassUsingInherentFP, PassUsingfirstMG, PassUsingsecondMG, FiringUnit);
                    case Russians:
                        //return new Russian8_1Firec(PassIsCX, PassIsPinned, PassHasMG, PassUsingInherentFP, PassUsingfirstMG, PassUsingsecondMG, FiringUnit);
                }
            case 1101:
                switch (FiringUnit.getbaseunit().getNationality()) {
                    case Germans:
                        // return new German8_1Firec(PassIsCX, PassIsPinned, PassHasMG, PassUsingInherentFP, PassUsingfirstMG, PassUsingsecondMG, FiringUnit)
                    case Russians:
                        //return new Russian138Firec(PassIsCX, PassIsPinned, PassHasMG, PassUsingInherentFP, PassUsingfirstMG, PassUsingsecondMG, FiringUnit);
                }
            case 1102:
                switch (FiringUnit.getbaseunit().getNationality()) {
                    case Germans:

                    case Russians:
                        //return new Russian149Firec(PassIsCX, PassIsPinned, PassHasMG, PassUsingInherentFP, PassUsingfirstMG, PassUsingsecondMG, FiringUnit);
                }
            case 1124:
                switch (FiringUnit.getbaseunit().getNationality()) {
                    case Germans:

                    case Russians:
                        // create FiringUnit property for base unit then decorate it
                        // get base unit
                        OrderofBattle BaseOBUnit = Linqdata.GetUnitfromCol(FiringUnit.getbaseunit().getUnit_ID());
                        // Constantvalues.UClass PassClass = (Linqdata.GetLOBData(Constantvalues.LOBItem.UNITCLASS, (int) (BaseOBUnit.getLOBLink())));
                        PersUniti BaseUnit = CreateExistingInstance(BaseOBUnit);
                        BaseUnit.getbaseunit().setSolID(FiringUnit.getbaseunit().getSolID());
                        BaseUnit.setFiringunit(createfiringunitproperty(BaseOBUnit, BaseUnit));
                        //return new FiringHeroicLdrc(PassIsCX, PassIsPinned, PassHasMG, PassUsingInherentFP, PassUsingfirstMG, PassUsingsecondMG, BaseUnit);
                }
        }
        return null;
    }

    // Target Unit property

    public PersUniti CreateTargetUnitandProperty(PersUniti Unititem, int firersan) {
        // called by IFTC.AddToTempTarget, IFTMVC.EnemyValuesConcreteC.AddToTempTargGroup, ObjectChange.UnitRevealConUnitbySniperc.RevealUnit, ObjectChange.UnitUpdateNewOldc.new, Sniper.SniperC.AttackResolution
        // adds target unit property to selected persuniti and returns updated object

        // set Target Unit property
        Unititem.setTargetunit(createtargetunitproperty(Unititem, firersan));
        return Unititem;
    }

    public TargetPersUniti createtargetunitproperty(PersUniti TargetUnit, int PassFirerSan) {
        // called by PersCreation.CreateTargetUnitandProperty
        // creates a Target Unit class and returns it to be added as a property to an existing Persuniti instance
        // set variables with default values
        Constantvalues.IFTResult PassIFTResult = Constantvalues.IFTResult.NR;
        int TargStackLdrdrm = 0;
        int PassAttackedbydrm = 0;
        int PassAttackedbyFP = 0;
        boolean PassELR5 = false;

        if (TargetUnit.getbaseunit().getLOBLink() < 100) {
            LineofBattle LOBRecord = Linqdata.GetLOBRecord(TargetUnit.getbaseunit().getLOBLink());
            PassELR5 = LOBRecord.getELR5();
        }
        boolean PassIsConceal = false;
        if (TargetUnit.getbaseunit().getVisibilityStatus() == Constantvalues.VisibilityStatus.Concealed) {
            PassIsConceal = true;
        }
        boolean PassIsDummy = false;
        boolean PassPinned = TargetUnit.getbaseunit().getPinned();
        int PassQualityStatus = 0;  // WHAT IS THIS MEANT TO BE?
        int PassRandomSelected = 0;
        int PassSmoke = 0;
    /*List<PersUniti> PassConUnits;
    List<PersUniti> ConUnits  // = From selunit As ObjectClassLibrary.ASLXNA.PersUniti In Scencolls.Unitcol Where selunit.BasePersUnit.Con_ID = TargetUnit.BasePersUnit.Unit_ID Select selunit
    if (ConUnits != null) {
        for (PersUniti ConUnit : ConUnits) {
            PassConUnits.add(ConUnit);
        }
    }*/
        if (TargetUnit.getbaseunit().getLOBLink() < 100) {
            PassSmoke = Integer.parseInt(Linqdata.GetLOBData(Constantvalues.LOBItem.SMOKE, TargetUnit.getbaseunit().getLOBLink()));
        }
        // now select which unit to create
        switch (TargetUnit.getbaseunit().getLOBLink()) {
            case 1:
            case 2:
            /*return new German838Targc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                PassSmoke, TargetUnit);*/
            case 4:
            /*return new German548Targc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                PassSmoke, TargetUnit);*/
            case 5:
                return new German467Targc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                        PassSmoke, TargetUnit);
            case 9:
            /*return new German338Targc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                PassSmoke, TargetUnit);*/
            case 11:
            /*return new German238Targc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                PassSmoke, TargetUnit);*/
            case 12:
            /*return new German247Targc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                PassSmoke, TargetUnit);*/
            case 13:
            /*return new German237Targc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                PassSmoke, TargetUnit);*/
            case 25:
            /*return new Russian628Targc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                PassSmoke, TargetUnit);*/
            case 26:
                //return new Russian458Targc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                //    PassSmoke, TargetUnit);
            case 27:
                return new Russian447Targc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                    PassSmoke, TargetUnit);
            case 28:
                //return new Russian527Targc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                //    PassSmoke, TargetUnit);
            case 29:
                //return new Russian426Targc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                //    PassSmoke, TargetUnit);
            case 31:
                //return new Russian248Targc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                //    PassSmoke, TargetUnit);
            case 32:
                //return new Russian237Targc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                //    PassSmoke, TargetUnit);
            case 33:
                //return new Russian227Targc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                //    PassSmoke, TargetUnit) ;
            case 34:
                //return new Russian226Targc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                //    PassSmoke, TargetUnit);
            case 136:
                //return new PrisonerSquadTargc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                //    PassSmoke, TargetUnit);
            case 137:
                //return new PrisonerHalfSquadTargc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                //    PassSmoke, TargetUnit);
            case 138:
                //return new PrisonerSMCTargc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                //    PassSmoke, TargetUnit);
            case 202:
                //return new RussianDummyTargc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, true, PassPinned, PassQualityStatus, PassRandomSelected,
                //    PassSmoke, TargetUnit);
            case 203:
                //return new GermanDummyTargc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, true, PassPinned, PassQualityStatus, PassRandomSelected,
                //    PassSmoke, TargetUnit);
                // where case is above 1000, creating SMC and must differentiate again by Nationality - better structure?
            case 1004:
                switch (TargetUnit.getbaseunit().getNationality()) {
                    case Germans:
                        //return new German8_1Targc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                        //    PassSmoke, TargetUnit);
                    case Russians:
                        //return new Russian8_1Targc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                        //    PassSmoke, TargetUnit);
                }
            case 1101:
                switch (TargetUnit.getbaseunit().getNationality()) {
                    case Germans:
                        // return new ObjectClassLibrary.ASLXNA.German138Targc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                        // PassSmoke, TargetUnit)
                    case Russians:
                        //return new Russian138Targc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                        //        PassSmoke, TargetUnit);
                }
            case 1102:
                switch (TargetUnit.getbaseunit().getNationality()) {
                    case Germans:
                        // return new ObjectClassLibrary.ASLXNA.German149Targc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                        // PassSmoke, TargetUnit)
                    case Russians:
                        //return new Russian149Targc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                        //        PassSmoke, TargetUnit);
                }
            case 1124:
                switch (TargetUnit.getbaseunit().getNationality()) {
                    case Germans:

                    case Russians:
                        // create TargetUnit property for base unit then decorate it
                        // get base unit
                        OrderofBattle BaseOBUnit = Linqdata.GetUnitfromCol(TargetUnit.getbaseunit().getUnit_ID());
                        int PassClass = Integer.parseInt(Linqdata.GetLOBData(Constantvalues.LOBItem.UNITCLASS, (int) (BaseOBUnit.getLOBLink())));
                        PersUniti BaseUnit = CreateExistingInstance(BaseOBUnit);
                        BaseUnit.setTargetunit(createtargetunitproperty(BaseUnit, PassFirerSan));
                        //return new TargetHeroicLdrc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, PassIsConceal, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                        //    PassSmoke, BaseUnit);
                }
        /*case 4002:
            return new RussianConTargc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, true, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                PassSmoke, TargetUnit, PassConUnits);
        case 4003:
            return new GermanConTargc(PassIFTResult, TargStackLdrdrm, PassFirerSan, PassAttackedbydrm, PassAttackedbyFP, PassELR5, true, PassIsDummy, PassPinned, PassQualityStatus, PassRandomSelected,
                PassSmoke, TargetUnit, PassConUnits);*/
        }
        return null;
    }


}