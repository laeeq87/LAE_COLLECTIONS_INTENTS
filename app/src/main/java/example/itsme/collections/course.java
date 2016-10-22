package example.itsme.collections;

/**
 * Created by itsme on 9/29/2016.
 */
public class course {
    private int Course_Num;
    private String title;
    private String Description;
    private double Cridet;
    public course(int Course_Num,String title,String Description,double Cridet){

        this.Course_Num = Course_Num;
        this.title=title;
        this.Description=Description;
        this.Cridet=Cridet;

      }

    public int getCourse_Num() {
        return Course_Num;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return Description;
    }

    public double getCridet() {
        return Cridet;
    }

    @Override
    public String toString() {
        return title;


    }


}


