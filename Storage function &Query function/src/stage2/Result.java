package stage2;

import java.util.ArrayList;

/**
 * 
 * @author hejing
 * Override the methods from QueryResults to store the results of the selection
 * and export the results
 */

public class Result implements QueryResults {
	ArrayList<String> result = new ArrayList<String>();

	@Override
	public ArrayList<String> getIDs() {

		return result;
	}

	@Override
	public void toString(ArrayList<String> result) {

		System.out.println(result);
		System.out.println();
		// TODO Auto-generated method stub

	}

}
