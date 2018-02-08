package sql;

import sql.MySQLAccess;

public class Main {
	public static void main(String[] args) throws Exception {
		MySQLAccess db = new MySQLAccess();
		db.readDataBase();
	}
} 
