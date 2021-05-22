

public  class SmartCamera extends SmartObject implements MotionControl, Comparable {
    private boolean status;
    private int batteryLife;
    private boolean nightVision;

    SmartCamera(String alias, String macId, boolean nightVision, int batteryLife){
        super.setAlias(alias);
        super.setMacId(macId);
        this.nightVision=nightVision;
        this.batteryLife=batteryLife;
    }

    public void recordOn(boolean isDay){
        if(controlConnection()){
            if(isDay){
                nightVision=false;
                if(status=false){
                    status=true;
                    System.out.println("Smart Camera - "+getAlias()+" is turned on now");
                }
                else{
                    System.out.println("Smart Camera - "+getAlias()+" has been already turned on");
                }
            }
            else {
                if(nightVision=false){
                    System.out.println("Sorry! Smart Camera - "+getAlias()+" does not have night vision feature.");
                }
                if(status=false){
                    status=true;
                    System.out.println("Smart Camera - "+getAlias()+" is turned on now");
                }
                else{
                    System.out.println("Smart Camera - "+getAlias()+" has been already turned on");
                }
            }
        }
    }

    public void recordOff(){
        if(controlConnection()) {
            if (status = true) {                 //////// eksik bu
                status = false;
                System.out.println("Smart Camera - " + getAlias() + " is turned off now");
            } else {
                System.out.println("Smart Camera - " + getAlias() + " has been already turned off");
            }
        }
    }

    public boolean testObject(){
        if(controlConnection()){
            SmartObjectToString();
            System.out.println("Test is starting for SmartCamera day time");
            recordOn(true);
            System.out.println("Test is starting for SmartCamera night time");
            recordOn(false);
            System.out.println("Test completed for SmartCamera Test completed for SmartCamera");
        }
        else return false;
        return false;
    }

    public boolean shutDownObject(){
        if(shutDownObject()){
            SmartObjectToString();
            status=false;
        }
        else return false;
        return false;
    }

    public boolean controlMotion(boolean hasMotion, boolean isDay){
        if(hasMotion){
            System.out.println("Motion detected!");
            if(isDay){
                status=true;
            }
            else{
                if (nightVision){
                    status=true;
                }
                else status=false;
            }
        }
        else System.out.println("Motion not detected!");
        return false;
    }

    public int compareTo(SmartCamera smartCamera){
        if(batteryLife > smartCamera.batteryLife)
            return 1;
        else if(batteryLife == smartCamera.batteryLife)
            return 0;
        else
            return -1;
    }

    public String toString(){
        return "SmartCamera -> "+getAlias()+"'s battery life is "+batteryLife+", status is recording";
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    public boolean getNightVision() {
        return nightVision;
    }

    public void setNightVision(boolean nightVision) {
        this.nightVision = nightVision;
    }
}
