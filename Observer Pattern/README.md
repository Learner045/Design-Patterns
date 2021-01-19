# CSX42: Assignment 2
**Name:**
Shreya Vinay Desai
-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on your project.


Note: build.xml is present in [studentskills/src](./studentskills/src/) folder.

## Instruction to clean:

```commandline
ant -buildfile studentskills/src/build.xml clean
```

Description: It cleans up all the .class files that were generated when you
compiled your code.

## Instructions to compile:

```commandline
ant -buildfile studentskills/src/build.xml all
```
The above command compiles your code and generates .class files inside the BUILD folder.

## Instructions to run:

```commandline
ant -buildfile studentskills/src/build.xml run -Dinput="input.txt" -Dmodify="modify.txt" -Dout1="output1.txt" -Dout2="output2.txt" -Dout3="output3.txt" -Derror="error.txt" -Ddebug="debug.txt"
```
Note: Arguments accept the absolute path of the files.


## Description: 
The program is a Replica System for Student Records which makes use of Binary Search Tree datastructure
to store nodes consisting of student records.
We use BST as it keeps data in sorted order according to BNumber for easy access and querying.
Also, for BST runtime complexity for insert, search and delete is O(logn) assuming tree is not very highly skewed
in which case it would be O(n).
We have used Observer pattern on nodes of the tree to keep all the replicas in sync.

##IMP
USED 1 Slack Day

##Reference:
https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/


## Academic Honesty statement:

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [7/11/2020]


