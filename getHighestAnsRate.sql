/*
Problem-
Get the highest answer rate question from a table survey_log with these columns: uid, action, question_id, 
answer_id, q_num, timestamp.

uid means user id; action has these kind of values: "show", "answer", "skip"; answer_id is not null when 
action column is "answer", while is null for "show" and "skip"; q_num is the numeral order of the 
question in current session.

Write a sql query to identify the question which has the highest answer rate.

Example:
Input:
+------+-----------+--------------+------------+-----------+------------+
| uid  | action    | question_id  | answer_id  | q_num     | timestamp  |
+------+-----------+--------------+------------+-----------+------------+
| 5    | show      | 285          | null       | 1         | 123        |
| 5    | answer    | 285          | 124124     | 1         | 124        |
| 5    | show      | 369          | null       | 2         | 125        |
| 5    | skip      | 369          | null       | 2         | 126        |
+------+-----------+--------------+------------+-----------+------------+
Output:
+-------------+
| survey_log  |
+-------------+
|    285      |
+-------------+
Explanation:
question 285 has answer rate 1/1, while question 369 has 0/1 answer rate, so output 285.
*/

/*I've ignored timestamp column as it is not important here*/
CREATE TABLE log (uid INT, action VARCHAR(10), q_id INT, ans_id INT, q_num INT);

INSERT INTO log VALUES(1, "show", 285, NULL, 1);
INSERT INTO log VALUES(1, "answer", 285, 123, 1);
INSERT INTO log VALUES(1, "show", 269, NULL, 1);
INSERT INTO log VALUES(1, "skip", 269, NULL, 1);


/*group ans by q_id, order output by count of answers(if null it is not counted) / count of action = answer*/
/*return top 1 by ordering it in desc order to get highest ans rate*/
SELECT q_id FROM log
GROUP BY q_id
ORDER BY COUNT(ans_id) / COUNT(IF(action = "answer", 1, 0)) DESC
LIMIT 1;