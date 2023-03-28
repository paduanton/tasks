/*
A palindrome is a word that is symmetric: if we write it backward, the result word is the same. 
For example, “HANNAH” is a palindrome, but “GAGA” is not. Write a short program that determines whether a word is a palindrome. 
------------------------------------------------------------------------------------------
*/
const palindrome = (word) => {
 word = word.toLowerCase();
 const wordLength = word.length;
 
 for (let i = 0; i < (wordLength / 2); i++) {
   if (word[i] !== word[wordLength - 1 - i]) {
       return false;
   }
 }

 return true;
}
