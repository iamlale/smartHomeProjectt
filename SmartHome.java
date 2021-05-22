
import java.util.ArrayList;

public class SmartHome {

    private ArrayList<SmartObject> smartObjectList=new ArrayList<SmartObject>();

    public SmartHome(){

    }

    public boolean addSmartObject(SmartObject smartObject){
        smartObjectList.add(smartObject);
        for (int i=0; i<smartObjectList.size(); i++){
           smartObjectList.get(i).getIP()="a";
        }
        smartObject.connect("10.0.0.x");
        smartObject.testObject();
        return false;
    }

    public boolean removeSmartObject(SmartObject smartObject){
        smartObjectList.remove(smartObject);
        return false;
    }

    public void controlLocation(boolean onCome){
        for (int j=0; j<smartObjectList.size(); j++){
            if (smartObjectList.get(j) ){
                if (onCome){
                    smartObjectList.get(j).onCome();
                }
            }
        }
    }

    public void controlMotion(boolean hasMotion, boolean isDay){


    }

    public void controlProgrammable(){


    }

    public void controlTimer(int seconds){



    }

    public void controlTimerRandomly(){


    }

    public void sortCameras(){


    }


    public ArrayList<SmartObject> getSmartObjectList() {
        return smartObjectList;
    }

    public void setSmartObjectList(ArrayList<SmartObject> smartObjectList) {
        this.smartObjectList = smartObjectList;
    }
}
