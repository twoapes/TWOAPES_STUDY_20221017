# Spring JDBC &#45; who does what?

Action|Spring|You
--|--|--
Define connection parameters.||X
Open the connection.|X|
Specify the SQL statement.||X
Declare parameters and provide parameter values||X
Prepare and run the statement.|X|
Set up the loop to iterate through the results (if any).|X|
Do the work for each iteration.||X
Process any exception.|X|
Handle transactions.|X|
Close the connection, the statement, and the resultset.|X|
