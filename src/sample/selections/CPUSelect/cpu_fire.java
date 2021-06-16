package sample.selections.CPUSelect;

public class cpu_fire
{
private String name;
private int select;

    public cpu_fire()
    {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSelect(int select) {
        this.select = select;
    }

    public cpu_fire(String name, int selection)
    {
        this.name=name;
        this.select=4;
        System.out.println("CPU has selected Fire");
    }



}
