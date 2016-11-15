# Java Questions
This repo contains several questions one can practice for coding interviews. The questions are mostly solved in Java, but the principles would apply to other languages for the most part.

# Prepare for Interview
Use the following resources to prepare for SWE interviews. Note that this is not an exhaustive list, and does not replace real life experience :-)
- Book - **Cracking the coding Interview** [At minimum, go over Ch. 2 (Linked List), 4 (Trees & Graphs), 6 (Math & Logic Puzzles),
    8 (Recursion & Dynamic Programming), and 9 (System Design & Scalability)].

- Book - **Elements of Programming Interviews** [At minimum, go over Ch. 16 (Recursion), 17 (Dynamic Programming),
    20 (Parallel Computing), 21 (Design Problems), 25 (Honors Class)].

- Coding Site - **Leetcode.com** [Solve all problems]

- Coding Site - **ideserve.co.in** [Solve problems from areas where you think you need more practice]

- Coding Site - **GeeksForGeeks.org** [Solve problems from areas where you think you need more practice]

- Coding Site - **CareerCup.com** [Go over recent questions from company you are interviewing with]

- Learn more about company culture & interview format - **Glassdoor.com**


# Topic-Specific Resources:
- Design Questions:
  + https://github.com/checkcheckzz/system-design-interview
  + http://www.HiredInTech.com

- Dynamic Programming:
  + https://www.quora.com/Are-there-any-good-resources-or-tutorials-for-dynamic-programming-besides-the-TopCoder-tutorial
  + http://20bits.com/article/introduction-to-dynamic-programming
  + https://www.quora.com/How-do-I-figure-out-how-to-iterate-over-the-parameters-and-write-bottom-up-solutions-to-dynamic-programming-related-problems/
  + https://www.quora.com/What-are-the-top-10-most-popular-dynamic-programming-problems-among-interviewers
  + https://people.cs.clemson.edu/~bcdean/dp_practice/
  + In general, if you arrive at an exponential run-time naive solution, DP could be a possible solution to reduce the complexity by trading with space

- Recursion:
  + Start with Programming Interviews Exposed book
  + Go over leetcode.com questions

- Java Concurrency Primer:
  + http://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/

- Graphs:

# Few Tips:
- For questions with recursive solution, practice the iterative solution too. This is a common Interview variation
- Calculate the Big-O notation for space & time complexity for all questions.
- Practice questions in IDE, whiteboard, as well as in online tools such as coderpad.
- Remember the .length() vs .size() vs .length vs .count vs .count() variations in common structures.
    + String: s.length()
    + Array: arr.length
    + HashSet: s.size()
    + HashMap: m.size()
    + List: l.size()
    + LinkedList: l.size()
- Remember Common Data Structure functions:
    + String:
      - .length() : int
      - .charAt(index) : char
      - .toCharArray() : char[]
    + HashMap:
      - .put(key, value) : void
      - .get(key) : T value
      - .containsKey(key) : boolean
      - .size() : int
    + HashSet:
      - .add(key):  void
      - .contains(key) : boolean
    + Array:
      - .length : int
    + List:
      - .size() : int
      - .add(T) : boolean
      - .remove(T) : boolean
      - .contains(T) : boolean
      - .indexOf(T) : int
      - .isEmpty() : boolean

# Final Practice Questions
- Design a Stack data structure that support O(1) operations for push, pop, peek, peekMax, and popMax
- Design a Stack data structure that support O(1) operations for push, pop, and peekMiddle, and popMiddle
- Write a program to find length of longest palindromic sub-sequence in array. Example if the array is [1, 2, 3, 3, 4, 2, 8, 1], the longest subsequence is of length 6 (1,2,3,3,2,1).
- Return all representations of a phone number in character. Example, given "12", you must return ["1a", "1b", "1c", "12"]
- Intersection and union of a sorted Linked List

# Non-Technical Questions
- Tell me about your background, experience, and what brings you here?
- Tell me why you want to leave your current company?
- Can't you find something similar at your current company in a different team?
- What other places are you interviewing at?
- Go in-depth with one of your recent projects.
- What do you like about this company?
- Tell me about your most significant accomplishment.
- Did you have to deal with conflicts where there was dis-agreement with another senior engineer? How did you deal with it?
- What do you want to do 5 years from now?
- What are you looking for in the new role? Or what would be an ideal role for you?
- Why did you switch between Developer/Test roles?

