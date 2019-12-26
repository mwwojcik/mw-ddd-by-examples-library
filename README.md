# Overviewin hexagonal architecture
This repo is an example of hexagonal multimodule architecture .
I try to use techniques connected with DDD, ane Event Driven Architecture.

# Domain
We want to create DVD rental manegement system.
It should realize  the following functionalities:

1. DVD catalogue managing (employee should (add/remove/delete) movies from the catalogue).
2. Some of them can be marked as "special offer". Promoted  movies are rented for 
a longer period (x2) and at a special price (30%). The promotional offer is available only to VIP customers.
3. Every customer  can make a reservation two movies for 3 days (VIP for 5 days), after this time, reservations expired.
4. Reservation can be reject if the user has any video with a refund date exceeded. 
5. Customer can post a review to movie. This is awarded with bonus points. When user reaches 100 points, he gets VIP status.
6. The rental price depends on type of the filme, and the number of bonus points owned by the user.
7. Customer 