package stage2;

import java.util.List;

/**
 * 
 * @author hejing
 * StarDao use to insert star object into mysql table
 */

public interface StarDao {
	
	public void insertStar(List<Star> stars);

}
