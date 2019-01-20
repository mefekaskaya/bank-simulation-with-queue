# bank-simulation-with-queue
implementation a queuing model for banking system
The bank has four type of customers, which are labelled as 0, 1, 2, 3.
Customers with label 0 has the highest priority, then 1, 2, and, 3 have the lower priorities, respectively.
Each type of customer has limitations. 
A customer with label 0 can join the queue at most 5 times in a row, label 1 can join 3 times in a row, label 2 can join 2 times in a row, and label 3 can join at once in a row.
While new customers are joining to the queue, the bank staff can process a customer in the queue.
Although there is one available slot for 1 between 0 and 2 as indicated above, label 0 has a priority over label 1, so label 1 be placed after label 0.
The system keeps the names of the customers at the same time with their priorities in the data structure.
