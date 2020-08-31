package stage2;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author hejing
 * run(String q) methods is to gain the specific results according to the sql sentences
 * 
 */

public class QueryRunner {
	
	
	public static QueryResults run(String q) {
		Result results=new Result();
	
		
		try {
			PreparedStatement preparedStatement =DbConnection.getConnection().prepareStatement(q);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				if (q.contains("planets")) {
					String name=rs.getString("name");
					results.getIDs().add(name);
				}if (q.contains("messiers")||q.contains("stars")) {
					String number=rs.getString("number");
					results.getIDs().add(number);
				}else {
					
				}

			}
			
			//get the result of the selection
			results.toString(results.getIDs());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return results;
		
		
	}	
}
