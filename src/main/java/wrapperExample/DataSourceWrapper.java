package wrapperExample;

public class DataSourceWrapper implements DataSource {
    private DataSource wrapper;

    public DataSourceWrapper(DataSource source) {
        this.wrapper = source;
    }

    @Override
    public void writeData(String data) {
        wrapper.writeData(data);
    }

    @Override
    public String readData() {
        return wrapper.readData();
    }
}
