package stage2;

import java.util.ArrayList;

/**
 * 
 * @author hejing
 * 
 * Two methods in QueryResults interface 
 * getIDs() is to save the results of queries 
 * toString() is for the output
 */
public interface QueryResults {

	public ArrayList<String> getIDs();

	public void toString(ArrayList<String> result);

}