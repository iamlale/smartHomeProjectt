import java.util.Calendar;
import  java.text.SimpleDateFormat;
import java.util.Date;

public class SmartLight extends SmartObject implements LocationControl, Programmable {
    private boolean hasLightTurned=false;
    private Calendar programTime;
    private boolean programAction=false;

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    Calendar calendar = Calendar.getInstance();

    public SmartLight(String alias, String macId){
        super.setAlias(alias);
        super.setMacId(macId);
    }

    public void turnOnLight(){
        if (controlConnection()==true){
            if (hasLightTurned=false){
                hasLightTurned=true;
                programAction=false;
                System.out.println("Smart Light - "+getAlias()+" is turned on now " +
                        "(Current time: "+sdf.format(Calendar.getInstance().getTime())+" )");
            }
            else{
               System.out.println("Smart Light - "+getAlias()+" has been already turned on");
            }
        }
    }

    public void turnOffLight(){
        if (controlConnection()==true){
            if (hasLightTurned=true){
                hasLightTurned=false;
                programAction=true;
                System.out.println("Smart Light - "+getAlias()+" is turned off now " +
                        "(Current time: "+sdf.format(Calendar.getInstance().getTime())+" )");
            }
            else{
                System.out.println("Smart Light - "+getAlias()+" has been already turned off");
            }
        }
    }

    public boolean testObject(){
        if (controlConnection()){
            SmartObjectToString();
            turnOnLight();
            turnOffLight();
            System.out.println("Test completed for SmartLight");
        }
        else return false;

        return false;    ////???????
    }

    public boolean shutDownObject(){
        if (controlConnection()){
            SmartObjectToString();
            if (hasLightTurned=true){
                hasLightTurned=false;
                programAction=true;
            }
        }
        else return false;

        return false;
    }

    public void onLeave(){
        if (controlConnection()==true){
            hasLightTurned=false;
            programAction=true;
        }
        System.out.println("On Come -> Smart Light - "+getAlias()+" Light " +
                "\n Smart Light - "+getAlias()+" Light is turned off now " +
                "(Current time: "+sdf.format(Calendar.getInstance().getTime())+" )");
    }

    public void onCome(){
        if (controlConnection()){
            hasLightTurned=true;
            programAction=false;
        }
        System.out.println("On Come -> Smart Light - "+getAlias()+" Light " +
                "\n Smart Light - "+getAlias()+" Light is turned on now " +
                "(Current time: "+sdf.format(Calendar.getInstance().getTime())+" )");
    }

    public void setTimer(int seconds){

        if (controlConnection()){

            if (hasLightTurned=true){
                programAction=false;
                System.out.println("Smart light - "+getAlias()+" will be turned off "+seconds+" seconds later! " +
                        "(Current time: "+programTime.getTime()+" )");
            }
            else {
                programAction=true;
                System.out.println("Smart light - " + getAlias() + " will be turned on " + seconds + " seconds later! " +
                        "(Current time: " + programTime.getTime() + " )");
            }
            programTime.add(Calendar.SECOND, seconds);
        }
    }

    public void cancelTimer(){
        if (controlConnection()){
            programTime=null;
        }
    }

    public void runProgram(){
        if (controlConnection()==true){
            if (calendar.getTime()==programTime.getTime()){
                if (programAction=true){
                    System.out.println("RunProgram -> Smart Light - "+getAlias()+"\n" +
                            "Smart Light - "+getAlias()+" is turned on now " +
                            "(Current time: "+sdf.format(Calendar.getInstance().getTime())+" )");

                }
                else if (programAction=false){
                    System.out.println("RunProgram -> Smart Light - "+getAlias()+"\n" +
                            "Smart Light - "+getAlias()+" is turned off now " +
                            "(Current time: "+sdf.format(Calendar.getInstance().getTime())+" )");
                }
            }
            programTime=null;
        }
    }

    public boolean getHasLightTurned() {
        return hasLightTurned;
    }

    public void setHasLightTurned(boolean hasLightTurned) {
        this.hasLightTurned = hasLightTurned;
    }

    public Calendar  getProgramTime() {
        return programTime;
    }

    public void setProgramTime(Calendar programTime) {
        this.programTime = programTime;
    }

    public boolean getProgramAction() {
        return programAction;
    }

    public void setProgramAction(boolean programAction) {
        this.programAction = programAction;
    }
}
