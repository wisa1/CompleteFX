package logic;

public class DataManagerFactory {
	DataManagerFactory instance;
	public static DataManager getInstance() {
		return MockDataManager.getInstance();
	}
}
