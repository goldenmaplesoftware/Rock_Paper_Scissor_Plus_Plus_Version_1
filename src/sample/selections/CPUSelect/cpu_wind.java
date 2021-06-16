package sample.selections.CPUSelect;

public class cpu_wind
{
private String name;
private int select;

    public cpu_wind()
    {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSelect(int select) {
        this.select = select;
    }

    public cpu_wind(String name, int selection)
    {
        this.name=name;
        this.select=6;
        System.out.println("CPU has selected Wind");
    }



}
