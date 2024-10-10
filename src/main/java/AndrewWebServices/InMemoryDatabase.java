package AndrewWebServices;

import java.util.Map;
import java.util.HashMap;

/*
 * InMemoryDatabase is a fake for the AndrewWS database which is used to improve test efficiency.
 * Remember, fakes are fully functional classes with simplified implementation.
 * What is the simplest core functionality that we need for a functional database?
 * 
 * Hint: there are two methods you need to implement
 */
public class InMemoryDatabase extends Database {
    private Map<String, Integer> accountTable;

    public InMemoryDatabase() {
        accountTable = new HashMap<>();
        accountTable.put("Scotty", 17214);
    }

    @Override
    public int getPassword(String accountName) {
        return accountTable.getOrDefault(accountName, -1);
    }

    public void addAccount(String accountName, int password) {
        accountTable.put(accountName, password);
    }
}