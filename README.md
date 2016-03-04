# Simple Database Challenge

This is the solution to Server(Back-end) [Simple Database challenge](https://www.thumbtack.com/challenges/simple-database) in Java.

The building block of a database is a transaction block.
The transaction block class has 2 maps:  
1. To store key-value mappings.  
2. To count the number of keys associated with a value  
Along with the maps, the transaction block has the functions as required.

The database class by default consists of a single transaction.
The database is essentially a chain/list of transactions with changes being made to the most recent transaction.
This class also implements the logic for all the operations.

Things that could be done differntly:  
1. I could have used a linked list of transactions instead of an arraylist. It could have made the implementation a tad bit faster
   because of the differences in the internal operations of the two.  
2. Currently, the implementation does not handle erroneus input. Also,it exits if incorrect file path is entered.
   Given ample amount of time,these two cases could be handled appropriately.
