# CSX42: Assignment 1
## Name: Shreya Vinay Desai

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in wordPlay/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile wordPlay/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile wordPlay/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile wordPlay/src/build.xml run -Dinput="input.txt" -Doutput="output.txt" -Dmetrics="metrics.txt"

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description: 

This is a word rotator program that reads words from an input file and rotates it by its position in the input file.
It calculates metrics information on the input file.
Choice of DataStructures : We have use a Link list of Link list to store our rotated words results.
We store each rotated line in a list and each such line is stored in a list.
Time and space complexity : w*l; w:number of words in a line * total number of lines.
We have also used a Metrics object that stored metrics information for easy access as it could be passed around
along different classes.

----------------------------------------------------------------------------------------------------------------------------------------------
##References:
https://www.w3schools.com/java/java_files_create.asp

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 6/10/2020


