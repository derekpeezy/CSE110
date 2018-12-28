public class MyString {
	private int length;
	private char[] content;
	boolean isEmpty = true;

	public MyString() {
		length = 0;
	}

	public MyString(String string) {
		length = string.length();
		content = new char[length];

		for(int i=0; i < length; i++) {
			content[i] = string.charAt(i);
		}

		isEmpty = false;
	}

	boolean equals(String string) {
		char[] compare = new char[string.length()];
		boolean same = false;

		compare = string.toCharArray();
		
		if(length == string.length()) {
			for(int i = 0; i < string.length(); i++) {
				if(compare[i] == content[i]) {
					same = true;
				} else {
					same = false;
				}			
			}
		} else {
			same = false;
		}

		return same;
	}

	int indexOf(char search) {
		int pos = -1;

		for (int i =0; i < length; i++) {
			if(content[i] == search) {
				pos = i + 1;
				break;
			}
		}

		return pos;
	}
	
	//mimics the string function charAt(String, int), but for character arrays
	private boolean charAt(char[] search, char search_char, int pos) {
		boolean success = false;

		pos--;

		if(search[pos] == search_char) {
			success = true;
		}

		return success;
	}

	//only used by indexOf(String)
	private boolean isSequential(char[] search_c, int pos) {
		int len = search_c.length;
		boolean sequential = true;

		int j = 0;
		
		for(int i = pos; i < len + pos; i++) {
			if(charAt(content, search_c[j], i)) {
				//do nothing for now
			} else {
				sequential = false;
				break;
			}

			j++;		
		}

		return sequential;
	}

	int indexOf(String search) {
		int pos = -1;
		boolean isSeq = true;

		char[] search_c = new char[search.length()];
	 	search_c = search.toCharArray();

		for(int i=0; i < length; i++) {
			if(content[i] == search_c[0]) {
				pos = i + 1;
			
				//we hit the first letter -- let's see if the following ones also match
				isSeq = isSequential(search_c, pos);

				if(!isSeq) {
					pos = -1;
				} else {
					//we found what we wanted -- the first instance of the letter
					break;
				}
			}
		}

		return pos;
	}

	boolean startsWith(String search) {
		boolean atStart = false;
		int pos = -1;

		pos = indexOf(search);

		if(pos == 1) {
			atStart = true;
		} else { 
			atStart = false;
		}
		
		return atStart;

	}

	boolean endsWith(String search) {
		boolean atEnd = false;
		int pos = -1;

		pos = indexOf(search);

		if(pos == length - search.length() + 1) {
			atEnd = true;
		} else {
			atEnd = false;
		}

		return atEnd;
	}
	
	boolean contains(String search) {
		boolean doesContain = false;
		int pos = -1;

		pos = indexOf(search);
		
		if(pos != -1) {
			doesContain = true;
		} else {
			doesContain = false;
		}

		return doesContain;
	}

	String toStringCSE(char[] toString) {
		int len = toString.length;

		String cseString = "";

		for(int i = 0; i < len; i++) {
			cseString = cseString + toString[i];		
		}

		return cseString;
	}

	void setContent(String string) {
		length = string.length();
		content = new char[length];

		for(int i=0; i < length; i++) {
			content[i] = string.charAt(i);
		}
		
		isEmpty = false;
	}

	String getContent() {
		return toStringCSE(content);
	}
}
