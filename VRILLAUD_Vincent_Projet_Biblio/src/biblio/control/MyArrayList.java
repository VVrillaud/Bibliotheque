package biblio.control;

import java.util.ArrayList;

@SuppressWarnings("hiding")
public class MyArrayList<Object> extends ArrayList<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String MaListeObjets = "";

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#toString()
	 */
	@Override
	public String toString() {
		for (int i = 0; i < this.size(); i++) {
			MaListeObjets = MaListeObjets + "\t" + "-" + this.get(i) + "\n";
		}
		return MaListeObjets;
	}
}