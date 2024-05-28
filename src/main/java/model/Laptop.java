package model;


public class Laptop {

    private String price;
    private String display;
    private String model;
    private String processor;
    private String storage_drive;
    private String RAM;

    public Laptop(String price,String display, String model,String processor, String storage_drive,String RAM){
        this.display=display;
        this.price=price;
        this.RAM=RAM;
        this.model=model;
        this.processor=processor;
        this.storage_drive=storage_drive;
    }
    public  String getPrice(){
        return price;
    }

    public String getDisplay(){
        return display;
    }
    public String getRAM(){
        return RAM;
    }
    public String getModel(){
        return model;
    }
    public String getProcessor(){
        return processor;
    }
    public String getStorage_drive(){
        return storage_drive;
    }
}
