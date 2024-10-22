public class DataPresenter {
    private DataModel model;
    private ConsoleView view;

    public DataPresenter(DataModel model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        view.displayData(model.getData());

        String newData = view.gatherInput("Enter new data: ");
        model.updateData(newData);
        view.displayData("Data updated to: " + model.getData());

        String moreData = view.gatherInput("Enter another piece of data: ");
        model.combineData(moreData);
        view.displayData("Final combined data: " + model.getData());
    }
}
