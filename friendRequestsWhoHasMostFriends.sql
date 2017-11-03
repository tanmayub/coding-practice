/*
Problem-
In social network like Facebook or Twitter, people send friend requests and accept others' requests as well.
Table request_accepted holds the data of friend acceptance, while requester_id and accepter_id both are the id of a person.

| requester_id | accepter_id | accept_date|
|--------------|-------------|------------|
| 1            | 2           | 2016_06-03 |
| 1            | 3           | 2016-06-08 |
| 2            | 3           | 2016-06-08 |
| 3            | 4           | 2016-06-09 |

Write a query to find the the people who has most friends and the most friends number. 
For the sample data above, the result is:

| id | num |
|----|-----|
| 3  | 3   |

Explanation:
The person with id '3' is a friend of people '1', '2' and '4', so he has 3 friends in total, 
which is the most number than any others.

Note-
The friend request could only been accepted once, which mean there is no multiple records with the 
same requester_id and accepter_id value.
*/

CREATE TABLE req_accepted
(from_id INT, accepter_id INT);

INSERT INTO req_accepted VALUES(1, 2);
INSERT INTO req_accepted VALUES(1, 3);
INSERT INTO req_accepted VALUES(2, 3);
INSERT INTO req_accepted VALUES(3, 4);

/*friend sent or accepted a request should count as 1 friend--use union all to get ids and count as count, group by ids*/
/*to get count for each group of ids*/
/*from outer query, order by count ct in descending order and get 1st row*/
SELECT ids AS id, ct AS num FROM (
  SELECT ids, count(*) AS ct FROM(
      SELECT from_id AS ids FROM req_accepted
      UNION ALL
      SELECT accepter_id FROM req_accepted
    ) AS tb1
    GROUP BY ids
  ) AS tb2
  ORDER BY ct DESC
  LIMIT 1;