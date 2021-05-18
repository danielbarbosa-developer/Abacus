package application;

public class ApplicationRules {

    public boolean IsUsedButtonNumber(String lastValue){
        try{
            int number = Integer.parseInt(lastValue);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
