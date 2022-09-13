-General requirements

When passing invalid parameters for execution, the application should not crash.
Running without parameters displays instructions for using the program.
Parameters are passed in the order given in the job description.

- File parser

You need to write a program that will have two modes:
Count the number of occurrences of a string in a text file.
Replace a line with another one in the specified file
The program must accept input arguments at startup:
<path to file> <string to count>
<path to file> <string to search for> <string to replace>