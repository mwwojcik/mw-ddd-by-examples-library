## Overviewin hexagonal architecture
This implementation based on a domain analysis carried out 
as part of the project https://github.com/ddd-by-examples/library .   

## [Domain Description](https://github.com/ddd-by-examples/library#domain-description) 

###General assumptions (interpretation)

1. Two main roles: Patron and Researcher Patron.
2. Access to some books may be restricted (available only for researcher patrons) 
3. Available book can be placed on hold (reserved) only by one patron at any given point in time.
4. Regular patron is limited to five holds at any moment, researcher patron hasn't any limits.
5. There are two main types of book holding:
+ open-ended - is active until the patron checks out the book
+ close-ended - can be expired (if it's not completed within a fixed number of days)
6. There is a daily sheet with expiring holds (checks at the beginning day).
7. Resercher patron can request an open-ended hold duration.
8. Any patron with more than two overdue checkouts at library branch will get a hold rejection (in this branch).
9. Any book can be checked out for up to 60 days.
10. There is a daily sheet with overdue checkouts.
11. There is a patron profile. It is used to interact with current holds and checkouts. This is a form of daily sheet
with limitation to actual patron data, and without a daily dimension.
12. Patron can see current holds (not canceled nor expired), and current checkouts (including overdue).
13. Patron can hold a book, and cancel holds. 

## Modules
![C4 Diagram Modules](doc/modules.png)