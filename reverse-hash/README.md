# reverse-hash

Find an 8 letter string of characters that contains only letters from
acdeghilmnoprstuwz such that the iHash(le_string) is 56721274917700
if iHash is defined by the following pseudo-code:

	function iHash(le_string){ 
		t =7;
		letters = 'acdeghilmnoprstuwz';
			
		for(i = 0; i < le_string.length; i++) {
			t = t * 41 + letters.indexOf(le_string[i]);
		}
		return t;  
	}
