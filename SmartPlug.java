import java.util.Calendar;
import java.text.SimpleDateFormat;

public class SmartPlug extends SmartObject implements Programmable{
    private boolean status=false;
    private Calendar programTime;
    private boolean programAction=true;

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    Calendar calendar=Calendar.getInstance();

    public SmartPlug(String alias, String macId){
        super.setAlias(alias);
        super.setMacId(macId);
    }

    public void turnOn(){
        if (controlConnection()){
            if (status=false){
                status=true;
                programAction=false;
                System.out.println("Smart Plug - "+getAlias()+" is turned on now " +
                        "(Current time: "+sdf.format(Calendar.getInstance().getTime())+" )");
            }
            else {
                programAction=false;
                System.out.println("Smart Plug - "+getAlias()+" has been already turned on");
            }
        }
    }

    public void turnOff() {
        if (controlConnection() ) {
            if (status = true){
                status=false;
                programAction=true;
                System.out.println("Smart Plug - "+getAlias()+" is turned off now " +
                        "(Current time: "+sdf.format(Calendar.getInstance().getTime())+" )");
            }
            else{
                programAction=true;
                System.out.println("Smart Plug - "+getAlias()+" has been already turned off");
            }
        }
    }

    public boolean testObject(){
        if(controlConnection()){
            SmartObjectToString();
            turnOn();
            turnOff();
            System.out.println("Test completed for SmartLight");
        }
        else return false;
        return false;
    }

    public boolean shutDownObject(){
        if(controlConnection()){
            SmartObjectToString();
            if(status=true){
                status=false;
                programAction=true;
            }
        }
        else return false;
        return false;
    }

    public void setTimer(int seconds){
        if (controlConnection()){
            if (status=true){
                programAction=false;
                System.out.println("Smart Plug - "+getAlias()+" will be turned off "+seconds+" seconds later! " +
                        "(Current time: "+programTime.getTime()+" )");
            }
            else {
                programAction=true;
                System.out.println("Smart Plug - " + getAlias() + " will be turned on " + seconds + " seconds later! " +
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
        if (controlConnection()){
            if (calendar.getTime()==programTime.getTime()){
                if (programAction=true){
                    System.out.println("RunProgram -> Smart Plug - "+getAlias()+"\n" +
                            "Smart Plug - "+getAlias()+" is turned on now " +
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


    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Calendar getProgramTime() {
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
