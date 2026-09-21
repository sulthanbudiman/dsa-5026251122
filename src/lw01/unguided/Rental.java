package lw01.unguided;

public abstract class Rental implements Chargeable {
    private String id;
    private int days;

    protected Rental(String id, int days) {
        if (days <= 0){
            throw new IllegalArgumentException("Days must be more than 0");
        }
        this.id = id;
        this.days = days;   
    }

    String getId(){
        return this.id;
    }
    int getDays(){
        return this.days;
    }
    @Override 
    public abstract int calculateCharge();

    public int calculateCharge(int units){
        if (units <= 0) {
            throw new IllegalArgumentException("Units must be more than 0");
        }
        return units * calculateCharge();
    }
    String label(){
        return "Print";
    }
    String summary(){
        return getId() + " | " + label() + " | " + calculateCharge() ; 
    }
    String summary(int units){
        return getId() + " | " + label() + " | " + calculateCharge(units); 
    }
}


