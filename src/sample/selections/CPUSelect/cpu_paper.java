package sample.selections.CPUSelect;

public class cpu_paper
{
private String name="paper";
private int select=2;

    public cpu_paper()
    {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSelect(int select) {
        this.select = select;
    }

    public cpu_paper(String name, int selection)
    {
        this.name=name;
        System.out.println("CPU has selected Paper");
    }

    @Override
    public String toString() {
        return "cpu_paper{" +
                "name='" + name + '\'' +
                ", select=" + select +
                '}';
    }
}
