package sample.selections.CPUSelect;

import java.util.Objects;

public class cpu_rock
{
private String name="Rock";
private int select=1;

    public cpu_rock()
    {

    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSelect(int select) {
        this.select = select;
    }

    public cpu_rock(String name, int selection)
    {
        this.name=name;
        System.out.println("CPU has selected Rock");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        cpu_rock cpu_rock = (cpu_rock) o;
        return select == cpu_rock.select && Objects.equals(name, cpu_rock.name);
    }

    @Override
    public String toString() {
        return "cpu_rock{" +
                "name='" + name + '\'' +
                ", select=" + select +
                '}';
    }

    public void setSelect()
    {
    }
}
