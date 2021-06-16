package sample.selections.CPUSelect;

public class cpu_water
{
private String name;
private int select;

    public cpu_water()
    {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSelect(int select) {
        this.select = select;
    }

    public cpu_water(String name, int selection)
    {
        this.name=name;
        this.select=5;
        System.out.println("CPU has selected Water");
    }



}
