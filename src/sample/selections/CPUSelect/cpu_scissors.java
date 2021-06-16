package sample.selections.CPUSelect;

public class cpu_scissors
{
private String name;
private int select;

    public cpu_scissors()
    {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSelect(int select) {
        this.select = select;
    }

    public cpu_scissors(String name, int selection)
    {
        this.name=name;
        this.select=3;
        System.out.println("CPU has selected Scissors");
    }



}
