public class DataModel {
    private String data;

    public DataModel() {
        this.data = "Initial Data";
    }

    public String getData() {
        return data;
    }

    public void updateData(String newData) {
        this.data = newData;
    }

    public void combineData(String moreData) {
        this.data += " | " + moreData;
    }
}
