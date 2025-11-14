package Model;

public class Student {
    private String name;
    private double nota;

    public Student(String name, double nota) {
        this.name = name;
        this.nota = nota;
    }

    public void setGrade(double n1, double n2, double n3 ){
        this.nota = n1+n2+n3;
    }

    public String gradeResult() {
        String result = String.format("FINAL GRADE = %.2f%n", this.nota);

        if (this.nota >= 60) {
            result += "PASS :)";
        } else {
            double missing = 60 - this.nota;
            result += String.format("FAILED%nMISSING %.2f POINT%s",
                    missing, (missing == 1 ? "" : "S"));
        }

        return result;
    }
}
