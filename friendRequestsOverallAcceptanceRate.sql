/*
Problem-
In social network like Facebook or Twitter, people send friend requests and accept others’ requests as well. 
Now given two tables as below:

Table: friend_request
| sender_id | send_to_id |request_date|
|-----------|------------|------------|
| 1         | 2          | 2016_06-01 |
| 1         | 3          | 2016_06-01 |
| 1         | 4          | 2016_06-01 |
| 2         | 3          | 2016_06-02 |
| 3         | 4          | 2016-06-09 |

Table: request_accepted
| requester_id | accepter_id |accept_date |
|--------------|-------------|------------|
| 1            | 2           | 2016_06-03 |
| 1            | 3           | 2016-06-08 |
| 2            | 3           | 2016-06-08 |
| 3            | 4           | 2016-06-09 |
| 3            | 4           | 2016-06-10 |

Write a query to find the overall acceptance rate of requests rounded to 2 decimals, which is the number of 
acceptance divide the number of requests.
For the sample data above, your query should return the following result.

|accept_rate|
|-----------|
|       0.80|
*/

/*I've ignored date columns for both tables*/
CREATE TABLE friend_req 
(from_id INT, to_id INT);

CREATE TABLE req_accepted
(from_id INT, accepter_id INT);

INSERT INTO friend_req VALUES(1, 2);
INSERT INTO friend_req VALUES(1, 3);
INSERT INTO friend_req VALUES(1, 4);
INSERT INTO friend_req VALUES(2, 3);
INSERT INTO friend_req VALUES(3, 4);

INSERT INTO req_accepted VALUES(1, 2);
INSERT INTO req_accepted VALUES(1, 3);
INSERT INTO req_accepted VALUES(2, 3);
INSERT INTO req_accepted VALUES(3, 4);
INSERT INTO req_accepted VALUES(3, 4);

/*find distinct count of accepted requests / distinct count of requests made*/
/*if division is null return 0 -- round to 2 decimal places*/
SELECT ROUND 
  (IFNULL
   ((SELECT COUNT(*) FROM (SELECT DISTINCT from_id, accepter_id FROM req_accepted) AS A) 
    / 
    (SELECT COUNT(*) FROM (SELECT DISTINCT from_id, to_id FROM friend_req) AS B)
    , 0)
   , 2) AS accept_rate;