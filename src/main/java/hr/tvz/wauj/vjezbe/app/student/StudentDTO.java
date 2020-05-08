package hr.tvz.wauj.vjezbe.app.student;

public class StudentDTO {
    
    private final String jmbag;
    private final Integer numberOfECTS;
    private final boolean tuitionShouldBePaid;

    public StudentDTO(String jmbag, Integer numberOfECTS, boolean tuitionShouldBePaid) {
        this.jmbag = jmbag;
        this.numberOfECTS = numberOfECTS;
        this.tuitionShouldBePaid = tuitionShouldBePaid;
    }

    public String getJmbag() {
        return jmbag;
    }

    public Integer getNumberOfECTS() {
        return numberOfECTS;
    }

    public boolean isTuitionShouldBePaid() {
        return tuitionShouldBePaid;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "JMBAG='" + jmbag + '\'' +
                ", numberOfECTS=" + numberOfECTS +
                ", tuitionShouldBePaid=" + tuitionShouldBePaid +
                '}';
    }
}
