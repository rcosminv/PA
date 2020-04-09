package scratch;

public class cube {

int age;
String name;
static int no=0 ;
cube()
{
    no++;
}
public int getNo()
{
    return no;
}
    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
