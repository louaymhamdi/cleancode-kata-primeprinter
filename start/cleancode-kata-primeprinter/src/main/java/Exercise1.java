import java.time.LocalDate;

public class Exercise1 {
    private LocalDate expirationDate;
    private boolean approvedForConsumption;
    private int inspectorId;

    public Exercise1(LocalDate expirationDate, boolean approvedForConsumption, int inspectorId) {
        this.expirationDate = expirationDate;
        this.approvedForConsumption = approvedForConsumption;
        this.inspectorId = inspectorId;
    }

    public boolean isEdible() {
        return expirationDate.isAfter(LocalDate.now()) && approvedForConsumption;
    }
}