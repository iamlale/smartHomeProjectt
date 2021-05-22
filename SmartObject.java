public abstract class SmartObject {
    private String alias;
    private String macId;
    private String IP ;
    private boolean connectionStatus;

    public SmartObject(){

    }

    public boolean connect(String IP){
        this.setIP(IP);
        connectionStatus=true;
        System.out.println(alias+" connection established");
        return true;  ///////??????
    }

    public boolean disconnect(){
        this.setIP(IP);
        connectionStatus=false;
        return false;  /////////?????
    }

    public void SmartObjectToString(){
        System.out.println("This is "+alias.getClass().getName() +" device "+alias+"\n MacId : "+getMacId()
        +"\n IP : "+getIP()); //// ????
    }

    public boolean controlConnection(){
        if(connectionStatus=false){
            System.out.println("This device is not connected. "+alias.getClass().getName() +"-> "+alias);
            return false;
        }
        return false;  /////????
    }

    public abstract boolean testObject();

    public abstract boolean shutDownObject ();


    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getMacId() {
        return macId;
    }

    public void setMacId(String macId) {
        this.macId = macId;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public boolean getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(boolean connectionStatus) {
        this.connectionStatus = connectionStatus;
    }
}
